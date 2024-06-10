package ru.goryacheva.springaophw.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.goryacheva.springaophw.model.TrackTimeModel;

import java.util.List;

@Repository
public class TrackTimeRepositoryImpl implements TrackTimeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(TrackTimeModel trackTimeModel) {
        entityManager.persist(trackTimeModel);
    }

    @Override
    public List<TrackTimeModel> getAll() {
        return entityManager.createQuery("select t from TrackTimeModel t", TrackTimeModel.class).getResultList();
    }
}
