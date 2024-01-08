package foodCourt.repository;

import foodCourt.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderRepository {
    private SessionFactory sessionFactory;

    public OrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Order> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> departmentQuery = session.createQuery("from Order", Order.class);
        return departmentQuery.getResultList();
    }

    public List<Order> listCustomer(Long id){
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> typedQuery = session.createQuery("from Order where customer_id = :customerId", Order.class);
        typedQuery.setParameter("customerId", id);
        return typedQuery.getResultList();
    }

    public boolean create(Order Order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(Order);
        return true;
    }

    public Order get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    public boolean update(Order Order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(Order);
        return true;
    }

    public boolean delete(Order Order) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(Order);
        return true;
    }
}
