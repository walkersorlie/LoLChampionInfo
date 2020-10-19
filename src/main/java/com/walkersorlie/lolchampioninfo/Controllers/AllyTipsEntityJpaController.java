
package com.walkersorlie.lolchampioninfo.Controllers;

import com.walkersorlie.lolchampioninfo.Controllers.exceptions.NonexistentEntityException;
import com.walkersorlie.lolchampioninfo.Entities.AllyTipsEntity;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.walkersorlie.lolchampioninfo.Entities.ChampionEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Walker Sorlie
 */
public class AllyTipsEntityJpaController implements Serializable {

    public AllyTipsEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AllyTipsEntity allyTipsEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ChampionEntity champion = allyTipsEntity.getChampion();
            if (champion != null) {
                champion = em.getReference(champion.getClass(), champion.getKey());
                allyTipsEntity.setChampion(champion);
            }
            em.persist(allyTipsEntity);
            if (champion != null) {
                champion.getAllyTips().add(allyTipsEntity);
                champion = em.merge(champion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AllyTipsEntity allyTipsEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AllyTipsEntity persistentAllyTipsEntity = em.find(AllyTipsEntity.class, allyTipsEntity.getId());
            ChampionEntity championOld = persistentAllyTipsEntity.getChampion();
            ChampionEntity championNew = allyTipsEntity.getChampion();
            if (championNew != null) {
                championNew = em.getReference(championNew.getClass(), championNew.getKey());
                allyTipsEntity.setChampion(championNew);
            }
            allyTipsEntity = em.merge(allyTipsEntity);
            if (championOld != null && !championOld.equals(championNew)) {
                championOld.getAllyTips().remove(allyTipsEntity);
                championOld = em.merge(championOld);
            }
            if (championNew != null && !championNew.equals(championOld)) {
                championNew.getAllyTips().add(allyTipsEntity);
                championNew = em.merge(championNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = allyTipsEntity.getId();
                if (findAllyTipsEntity(id) == null) {
                    throw new NonexistentEntityException("The allyTipsEntity with id " + id + " no longer exists.");
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
            AllyTipsEntity allyTipsEntity;
            try {
                allyTipsEntity = em.getReference(AllyTipsEntity.class, id);
                allyTipsEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The allyTipsEntity with id " + id + " no longer exists.", enfe);
            }
            ChampionEntity champion = allyTipsEntity.getChampion();
            if (champion != null) {
                champion.getAllyTips().remove(allyTipsEntity);
                champion = em.merge(champion);
            }
            em.remove(allyTipsEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AllyTipsEntity> findAllyTipsEntityEntities() {
        return findAllyTipsEntityEntities(true, -1, -1);
    }

    public List<AllyTipsEntity> findAllyTipsEntityEntities(int maxResults, int firstResult) {
        return findAllyTipsEntityEntities(false, maxResults, firstResult);
    }

    private List<AllyTipsEntity> findAllyTipsEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AllyTipsEntity.class));
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

    public AllyTipsEntity findAllyTipsEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AllyTipsEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getAllyTipsEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AllyTipsEntity> rt = cq.from(AllyTipsEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
        
    public List<Optional<AllyTipsEntity>> findAllyTips(ChampionEntity championEntity) {
        EntityManager em = getEntityManager();
        List<Optional<AllyTipsEntity>> tips;
        Long key = championEntity.getKey();
        try {
            tips = em.createQuery("SELECT tip FROM AllyTipsEntity tip JOIN tip.champion champion WHERE champion.key = :key", AllyTipsEntity.class)
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
