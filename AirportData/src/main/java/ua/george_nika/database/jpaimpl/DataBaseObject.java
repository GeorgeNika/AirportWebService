package ua.george_nika.database.jpaimpl;

import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.model.entity.NamesCompositePrimaryKey;
import ua.george_nika.model.entity.NamesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DataBaseObject {

    private EntityManager entityManager ;

    public DataBaseObject(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airports");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void close(){
        if (entityManager!=null){
            entityManager.close();
        }
    }

    public void addObject(Object object) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(object);
            //entityManager.merge(object);
            entityManager.flush();
            entityManager.refresh(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateObject(Object object) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteObject(Object object) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(entityManager.merge(object));
            entityManager.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    public AirportEntity getAirport(Long id){
        return entityManager.find(AirportEntity.class, id);
    }

    public List<AirportEntity> getAllAirports(){
        TypedQuery<AirportEntity> namedQuery = entityManager.createNamedQuery("airports.getAll", AirportEntity.class);
        return namedQuery.getResultList();
    }

    public LanguageEntity getLanguage(Long id){
        return entityManager.find(LanguageEntity.class, id);
    }

    public List<LanguageEntity> getAllLanguages() {
        TypedQuery<LanguageEntity> namedQuery = entityManager.createNamedQuery("languages.getAll", LanguageEntity.class);
        return namedQuery.getResultList();
    }

    public NamesEntity getNames(NamesCompositePrimaryKey key){
        return entityManager.find(NamesEntity.class, key);
    }

    public List<NamesEntity> getAllNames() {
        TypedQuery<NamesEntity> namedQuery = entityManager.createNamedQuery("names.getAll", NamesEntity.class);
        return namedQuery.getResultList();
    }
}
