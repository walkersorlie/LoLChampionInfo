
package com.walkersorlie.lolchampioninfo.Controllers;

import com.walkersorlie.lolchampioninfo.Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.walkersorlie.lolchampioninfo.Entities.ChampionEntity;
import com.walkersorlie.lolchampioninfo.Entities.ChampionStatsEntity;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionStatsEntityJpaController implements Serializable {

    public ChampionStatsEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ChampionStatsEntity championStatsEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionEntity champion = championStatsEntity.getChampion();
            if (champion != null) {
                champion = em.getReference(champion.getClass(), champion.getKey());
                championStatsEntity.setChampion(champion);
            }
            em.persist(championStatsEntity);
            if (champion != null) {
                ChampionStatsEntity oldStatsOfChampion = champion.getStats();
                if (oldStatsOfChampion != null) {
                    oldStatsOfChampion.setChampion(null);
                    oldStatsOfChampion = em.merge(oldStatsOfChampion);
                }
                champion.setStats(championStatsEntity);
                champion = em.merge(champion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ChampionStatsEntity championStatsEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionStatsEntity persistentChampionStatsEntity = em.find(ChampionStatsEntity.class, championStatsEntity.getId());
            ChampionEntity championOld = persistentChampionStatsEntity.getChampion();
            ChampionEntity championNew = championStatsEntity.getChampion();
            if (championNew != null) {
                championNew = em.getReference(championNew.getClass(), championNew.getKey());
                championStatsEntity.setChampion(championNew);
            }
            championStatsEntity = em.merge(championStatsEntity);
            if (championOld != null && !championOld.equals(championNew)) {
                championOld.setStats(null);
                championOld = em.merge(championOld);
            }
            if (championNew != null && !championNew.equals(championOld)) {
                ChampionStatsEntity oldStatsOfChampion = championNew.getStats();
                if (oldStatsOfChampion != null) {
                    oldStatsOfChampion.setChampion(null);
                    oldStatsOfChampion = em.merge(oldStatsOfChampion);
                }
                championNew.setStats(championStatsEntity);
                championNew = em.merge(championNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = championStatsEntity.getId();
                if (findChampionStatsEntity(id) == null) {
                    throw new NonexistentEntityException("The championStatsEntity with id " + id + " no longer exists.");
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
            ChampionStatsEntity championStatsEntity;
            try {
                championStatsEntity = em.getReference(ChampionStatsEntity.class, id);
                championStatsEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The championStatsEntity with id " + id + " no longer exists.", enfe);
            }
            ChampionEntity champion = championStatsEntity.getChampion();
            if (champion != null) {
                champion.setStats(null);
                champion = em.merge(champion);
            }
            em.remove(championStatsEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ChampionStatsEntity> findChampionStatsEntityEntities() {
        return findChampionStatsEntityEntities(true, -1, -1);
    }

    public List<ChampionStatsEntity> findChampionStatsEntityEntities(int maxResults, int firstResult) {
        return findChampionStatsEntityEntities(false, maxResults, firstResult);
    }

    private List<ChampionStatsEntity> findChampionStatsEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ChampionStatsEntity.class));
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

    public ChampionStatsEntity findChampionStatsEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ChampionStatsEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getChampionStatsEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ChampionStatsEntity> rt = cq.from(ChampionStatsEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Optional<ChampionStatsEntity> findChampionStatsEntity(ChampionEntity championEntity) {
        EntityManager em = getEntityManager();
        ChampionStatsEntity stats;
        Long key = championEntity.getKey();
        try {
            stats = em.createQuery("SELECT stats FROM ChampionStatsEntity stats JOIN stats.champion champion WHERE champion.key = :key", ChampionStatsEntity.class)
                    .setParameter("key", key)
                    .getSingleResult();
                    
            return Optional.of(stats);
        } finally {
            em.close();
        }
    }
}
