
package com.walkersorlie.lolchampioninfo.Controllers;

import com.walkersorlie.lolchampioninfo.Entities.ChampionSpellEntity;
import com.walkersorlie.lolchampioninfo.Controllers.exceptions.NonexistentEntityException;
import com.walkersorlie.lolchampioninfo.Entities.ChampionEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionSpellEntityJpaController implements Serializable {

    public ChampionSpellEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ChampionSpellEntity championSpellEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(championSpellEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ChampionSpellEntity championSpellEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            championSpellEntity = em.merge(championSpellEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = championSpellEntity.getId();
                if (findChampionSpellEntity(id) == null) {
                    throw new NonexistentEntityException("The championSpellEntity with id " + id + " no longer exists.");
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
            ChampionSpellEntity championSpellEntity;
            try {
                championSpellEntity = em.getReference(ChampionSpellEntity.class, id);
                championSpellEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The championSpellEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(championSpellEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ChampionSpellEntity> findChampionSpellEntityEntities() {
        return findChampionSpellEntityEntities(true, -1, -1);
    }

    public List<ChampionSpellEntity> findChampionSpellEntityEntities(int maxResults, int firstResult) {
        return findChampionSpellEntityEntities(false, maxResults, firstResult);
    }

    private List<ChampionSpellEntity> findChampionSpellEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ChampionSpellEntity.class));
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

    public ChampionSpellEntity findChampionSpellEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ChampionSpellEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getChampionSpellEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ChampionSpellEntity> rt = cq.from(ChampionSpellEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Optional<ChampionSpellEntity>> findChampionSpellsEntity(ChampionEntity championEntity) {
        EntityManager em = getEntityManager();
        List<Optional<ChampionSpellEntity>> spells;
        Long key = championEntity.getKey();
        try {                
            spells = em.createQuery("SELECT spell FROM ChampionSpellEntity spell JOIN spell.champion champion WHERE champion.key = :key", ChampionSpellEntity.class)
                    .setParameter("key", key)
                    .getResultStream()
                    .map(Optional::ofNullable)
                    .collect(Collectors.toList());
            return spells;
        } finally {
            em.close();
        }
    }
}
