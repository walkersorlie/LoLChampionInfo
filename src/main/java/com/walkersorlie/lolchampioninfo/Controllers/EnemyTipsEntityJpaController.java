
package com.walkersorlie.lolchampioninfo.Controllers;

import com.walkersorlie.lolchampioninfo.Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.walkersorlie.lolchampioninfo.Entities.ChampionEntity;
import com.walkersorlie.lolchampioninfo.Entities.EnemyTipsEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Walker Sorlie
 */
public class EnemyTipsEntityJpaController implements Serializable {

    public EnemyTipsEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EnemyTipsEntity enemyTipsEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionEntity champion = enemyTipsEntity.getChampion();
            if (champion != null) {
                champion = em.getReference(champion.getClass(), champion.getKey());
                enemyTipsEntity.setChampion(champion);
            }
            em.persist(enemyTipsEntity);
            if (champion != null) {
                champion.getEnemyTips().add(enemyTipsEntity);
                champion = em.merge(champion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EnemyTipsEntity enemyTipsEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EnemyTipsEntity persistentEnemyTipsEntity = em.find(EnemyTipsEntity.class, enemyTipsEntity.getId());
            ChampionEntity championOld = persistentEnemyTipsEntity.getChampion();
            ChampionEntity championNew = enemyTipsEntity.getChampion();
            if (championNew != null) {
                championNew = em.getReference(championNew.getClass(), championNew.getKey());
                enemyTipsEntity.setChampion(championNew);
            }
            enemyTipsEntity = em.merge(enemyTipsEntity);
            if (championOld != null && !championOld.equals(championNew)) {
                championOld.getEnemyTips().remove(enemyTipsEntity);
                championOld = em.merge(championOld);
            }
            if (championNew != null && !championNew.equals(championOld)) {
                championNew.getEnemyTips().add(enemyTipsEntity);
                championNew = em.merge(championNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = enemyTipsEntity.getId();
                if (findEnemyTipsEntity(id) == null) {
                    throw new NonexistentEntityException("The enemyTipsEntity with id " + id + " no longer exists.");
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
            EnemyTipsEntity enemyTipsEntity;
            try {
                enemyTipsEntity = em.getReference(EnemyTipsEntity.class, id);
                enemyTipsEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The enemyTipsEntity with id " + id + " no longer exists.", enfe);
            }
            ChampionEntity champion = enemyTipsEntity.getChampion();
            if (champion != null) {
                champion.getEnemyTips().remove(enemyTipsEntity);
                champion = em.merge(champion);
            }
            em.remove(enemyTipsEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EnemyTipsEntity> findEnemyTipsEntityEntities() {
        return findEnemyTipsEntityEntities(true, -1, -1);
    }

    public List<EnemyTipsEntity> findEnemyTipsEntityEntities(int maxResults, int firstResult) {
        return findEnemyTipsEntityEntities(false, maxResults, firstResult);
    }

    private List<EnemyTipsEntity> findEnemyTipsEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EnemyTipsEntity.class));
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

    public EnemyTipsEntity findEnemyTipsEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EnemyTipsEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnemyTipsEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EnemyTipsEntity> rt = cq.from(EnemyTipsEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Optional<EnemyTipsEntity>> findEnemyTips(ChampionEntity championEntity) {
        EntityManager em = getEntityManager();
        List<Optional<EnemyTipsEntity>> tips;
        Long key = championEntity.getKey();
        try {
            tips = em.createQuery("SELECT tips FROM EnemyTipsEntity tips JOIN tips.champion champion WHERE champion.key = :key", EnemyTipsEntity.class)
                    .setParameter("key", key)
                    .getResultStream()
                    .map(Optional::ofNullable)
                    .collect(Collectors.toList());
                    
            return tips;
        } finally {
            em.close();
        }
    }

}
