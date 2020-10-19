
package com.walkersorlie.lolchampioninfo.Controllers;

import com.walkersorlie.lolchampioninfo.Controllers.exceptions.NonexistentEntityException;
import com.walkersorlie.lolchampioninfo.Controllers.exceptions.PreexistingEntityException;
import com.walkersorlie.lolchampioninfo.Entities.ChampionEntity;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.walkersorlie.lolchampioninfo.Entities.ChampionStatsEntity;
import com.walkersorlie.lolchampioninfo.Entities.ChampionPassiveEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionEntityJpaController implements Serializable {

    public ChampionEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(ChampionEntity championEntity) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionStatsEntity stats = championEntity.getStats();
            if (stats != null) {
                stats = em.getReference(stats.getClass(), stats.getId());
                championEntity.setStats(stats);
            }
            ChampionPassiveEntity passive = championEntity.getPassive();
            if (passive != null) {
                passive = em.getReference(passive.getClass(), passive.getId());
                championEntity.setPassive(passive);
            }
            em.persist(championEntity);
            if (stats != null) {
                ChampionEntity oldChampionOfStats = stats.getChampion();
                if (oldChampionOfStats != null) {
                    oldChampionOfStats.setStats(null);
                    oldChampionOfStats = em.merge(oldChampionOfStats);
                }
                stats.setChampion(championEntity);
                stats = em.merge(stats);
            }
            if (passive != null) {
                ChampionEntity oldChampionOfPassive = passive.getChampion();
                if (oldChampionOfPassive != null) {
                    oldChampionOfPassive.setPassive(null);
                    oldChampionOfPassive = em.merge(oldChampionOfPassive);
                }
                passive.setChampion(championEntity);
                passive = em.merge(passive);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findChampionEntity(championEntity.getKey()) != null) {
                throw new PreexistingEntityException("ChampionEntity " + championEntity + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(ChampionEntity championEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionEntity persistentChampionEntity = em.find(ChampionEntity.class, championEntity.getId());
            ChampionStatsEntity statsOld = persistentChampionEntity.getStats();
            ChampionStatsEntity statsNew = championEntity.getStats();
            ChampionPassiveEntity passiveOld = persistentChampionEntity.getPassive();
            ChampionPassiveEntity passiveNew = championEntity.getPassive();
            if (statsNew != null) {
                statsNew = em.getReference(statsNew.getClass(), statsNew.getId());
                championEntity.setStats(statsNew);
            }
            if (passiveNew != null) {
                passiveNew = em.getReference(passiveNew.getClass(), passiveNew.getId());
                championEntity.setPassive(passiveNew);
            }
            championEntity = em.merge(championEntity);
            if (statsOld != null && !statsOld.equals(statsNew)) {
                statsOld.setChampion(null);
                statsOld = em.merge(statsOld);
            }
            if (statsNew != null && !statsNew.equals(statsOld)) {
                ChampionEntity oldChampionOfStats = statsNew.getChampion();
                if (oldChampionOfStats != null) {
                    oldChampionOfStats.setStats(null);
                    oldChampionOfStats = em.merge(oldChampionOfStats);
                }
                statsNew.setChampion(championEntity);
                statsNew = em.merge(statsNew);
            }
            if (passiveOld != null && !passiveOld.equals(passiveNew)) {
                passiveOld.setChampion(null);
                passiveOld = em.merge(passiveOld);
            }
            if (passiveNew != null && !passiveNew.equals(passiveOld)) {
                ChampionEntity oldChampionOfPassive = passiveNew.getChampion();
                if (oldChampionOfPassive != null) {
                    oldChampionOfPassive.setPassive(null);
                    oldChampionOfPassive = em.merge(oldChampionOfPassive);
                }
                passiveNew.setChampion(championEntity);
                passiveNew = em.merge(passiveNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long key = championEntity.getKey();
                if (findChampionEntity(key) == null) {
                    throw new NonexistentEntityException("The championEntity with id " + key + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionEntity championEntity;
            try {
                championEntity = em.getReference(ChampionEntity.class, id);
                championEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The championEntity with id " + id + " no longer exists.", enfe);
            }
            ChampionStatsEntity stats = championEntity.getStats();
            if (stats != null) {
                stats.setChampion(null);
                stats = em.merge(stats);
            }
            ChampionPassiveEntity passive = championEntity.getPassive();
            if (passive != null) {
                passive.setChampion(null);
                passive = em.merge(passive);
            }
            em.remove(championEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ChampionEntity> findChampionEntityEntities() {
        return findChampionEntityEntities(true, -1, -1);
    }

    public List<ChampionEntity> findChampionEntityEntities(int maxResults, int firstResult) {
        return findChampionEntityEntities(false, maxResults, firstResult);
    }

    private List<ChampionEntity> findChampionEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ChampionEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ChampionEntity findChampionEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ChampionEntity.class, id);
        } finally {
            em.close();
        }
    }
    
    public Optional<ChampionEntity> findChampionEntityByName(String name) {
        EntityManager em = getEntityManager();
        try {
            ChampionEntity champion = em.createQuery("SELECT champion FROM ChampionEntity champion WHERE champion.name = :name", ChampionEntity.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return champion != null ? Optional.of(champion) : Optional.empty();
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    public int getChampionEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ChampionEntity> rt = cq.from(ChampionEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
