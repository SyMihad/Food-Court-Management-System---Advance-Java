package foodCourt.repository;

import foodCourt.domain.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RestaurantRepository {
    private SessionFactory sessionFactory;

    public RestaurantRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Restaurant> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Restaurant> departmentQuery = session.createQuery("from Restaurant", Restaurant.class);
        return departmentQuery.getResultList();
    }

    public boolean create(Restaurant Restaurant) {
        Session session = sessionFactory.getCurrentSession();
        session.save(Restaurant);
        return true;
    }

    public Restaurant get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Restaurant.class, id);
    }

    public Restaurant getFromManager(Long id){
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Restaurant> typedQuery = session.createQuery("from Restaurant Where manager_id = :managerId", Restaurant.class);
        typedQuery.setParameter("managerId", id);
        return typedQuery.getSingleResult();
    }

    public boolean update(Restaurant Restaurant) {
        Session session = sessionFactory.getCurrentSession();
        session.update(Restaurant);
        return true;
    }

    public boolean delete(Restaurant Restaurant) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(Restaurant);
        return true;
    }
}
