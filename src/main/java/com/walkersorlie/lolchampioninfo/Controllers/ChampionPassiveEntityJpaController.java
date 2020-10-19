
package com.walkersorlie.lolchampioninfo.Controllers;

import com.walkersorlie.lolchampioninfo.Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.walkersorlie.lolchampioninfo.Entities.ChampionEntity;
import com.walkersorlie.lolchampioninfo.Entities.ChampionPassiveEntity;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionPassiveEntityJpaController implements Serializable {

    public ChampionPassiveEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ChampionPassiveEntity championPassiveEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionEntity champion = championPassiveEntity.getChampion();
            if (champion != null) {
                champion = em.getReference(champion.getClass(), champion.getKey());
                championPassiveEntity.setChampion(champion);
            }
            em.persist(championPassiveEntity);
            if (champion != null) {
                ChampionPassiveEntity oldPassiveOfChampion = champion.getPassive();
                if (oldPassiveOfChampion != null) {
                    oldPassiveOfChampion.setChampion(null);
                    oldPassiveOfChampion = em.merge(oldPassiveOfChampion);
                }
                champion.setPassive(championPassiveEntity);
                champion = em.merge(champion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ChampionPassiveEntity championPassiveEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionPassiveEntity persistentChampionPassiveEntity = em.find(ChampionPassiveEntity.class, championPassiveEntity.getId());
            ChampionEntity championOld = persistentChampionPassiveEntity.getChampion();
            ChampionEntity championNew = championPassiveEntity.getChampion();
            if (championNew != null) {
                championNew = em.getReference(championNew.getClass(), championNew.getKey());
                championPassiveEntity.setChampion(championNew);
            }
            championPassiveEntity = em.merge(championPassiveEntity);
            if (championOld != null && !championOld.equals(championNew)) {
                championOld.setPassive(null);
                championOld = em.merge(championOld);
            }
            if (championNew != null && !championNew.equals(championOld)) {
                ChampionPassiveEntity oldPassiveOfChampion = championNew.getPassive();
                if (oldPassiveOfChampion != null) {
                    oldPassiveOfChampion.setChampion(null);
                    oldPassiveOfChampion = em.merge(oldPassiveOfChampion);
                }
                championNew.setPassive(championPassiveEntity);
                championNew = em.merge(championNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = championPassiveEntity.getId();
                if (findChampionPassiveEntity(id) == null) {
                    throw new NonexistentEntityException("The championPassiveEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionPassiveEntity championPassiveEntity;
            try {
                championPassiveEntity = em.getReference(ChampionPassiveEntity.class, id);
                championPassiveEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The championPassiveEntity with id " + id + " no longer exists.", enfe);
            }
            ChampionEntity champion = championPassiveEntity.getChampion();
            if (champion != null) {
                champion.setPassive(null);
                champion = em.merge(champion);
            }
            em.remove(championPassiveEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ChampionPassiveEntity> findChampionPassiveEntityEntities() {
        return findChampionPassiveEntityEntities(true, -1, -1);
    }

    public List<ChampionPassiveEntity> findChampionPassiveEntityEntities(int maxResults, int firstResult) {
        return findChampionPassiveEntityEntities(false, maxResults, firstResult);
    }

    private List<ChampionPassiveEntity> findChampionPassiveEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ChampionPassiveEntity.class));
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

    public ChampionPassiveEntity findChampionPassiveEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ChampionPassiveEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getChampionPassiveEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ChampionPassiveEntity> rt = cq.from(ChampionPassiveEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Optional<ChampionPassiveEntity> findChampionPassiveEntity(ChampionEntity championEntity) {
        EntityManager em = getEntityManager();
        ChampionPassiveEntity passive;
        Long key = championEntity.getKey();
        try {
            passive = em.createQuery("SELECT passive FROM ChampionPassiveEntity passive JOIN passive.champion champion WHERE champion.key = :key", ChampionPassiveEntity.class)
                    .setParameter("key", key)
                    .getSingleResult();
                    
            return Optional.of(passive);
        } finally {
            em.close();
        }
    }

}
