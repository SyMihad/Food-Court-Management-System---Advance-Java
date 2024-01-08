package foodCourt.repository;


import foodCourt.domain.FoodItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FoodItemRepository {
    private SessionFactory sessionFactory;

    public FoodItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<FoodItem> list(Long id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<FoodItem> typedQuery = session.createQuery("from FoodItem Where restaurant_id = :restaurantId", FoodItem.class);
        typedQuery.setParameter("restaurantId", id);
        return typedQuery.getResultList();
    }

    public boolean create(FoodItem FoodItem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(FoodItem);
        return true;
    }

    public FoodItem get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(FoodItem.class, id);
    }

    public boolean update(FoodItem FoodItem) {
        Session session = sessionFactory.getCurrentSession();
        session.update(FoodItem);
        return true;
    }

    public boolean delete(FoodItem FoodItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(FoodItem);
        return true;
    }
}
