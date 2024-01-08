package foodCourt.repository;

import foodCourt.domain.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AdminRepository {
    private SessionFactory sessionFactory;

    public AdminRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Admin> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Admin> departmentQuery = session.createQuery("from Admin", Admin.class);
        return departmentQuery.getResultList();
    }

    public boolean create(Admin Admin) {
        Session session = sessionFactory.getCurrentSession();
        session.save(Admin);
        return true;
    }

    public Admin get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Admin.class, id);
    }

    public boolean update(Admin Admin) {
        Session session = sessionFactory.getCurrentSession();
        session.update(Admin);
        return true;
    }

    public boolean delete(Admin Admin) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(Admin);
        return true;
    }
}
