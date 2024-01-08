package foodCourt.repository;

import foodCourt.domain.Customer;
import foodCourt.domain.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ManagerRepository {
    private SessionFactory sessionFactory;

    public ManagerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Manager> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Manager> departmentQuery = session.createQuery("from Manager", Manager.class);
        return departmentQuery.getResultList();
    }

    public boolean create(Manager Manager) {
        Session session = sessionFactory.getCurrentSession();
        session.save(Manager);
        return true;
    }

    public Manager get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Manager.class, id);
    }

    public Manager getFromUserId(Long id){
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Manager> typedQuery = session.createQuery("from Manager where user_id = :userId", Manager.class);
        typedQuery.setParameter("userId", id);
        return typedQuery.getSingleResult();
    }

    public boolean update(Manager Manager) {
        Session session = sessionFactory.getCurrentSession();
        session.update(Manager);
        return true;
    }

    public boolean delete(Manager Manager) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(Manager);
        return true;
    }
}
