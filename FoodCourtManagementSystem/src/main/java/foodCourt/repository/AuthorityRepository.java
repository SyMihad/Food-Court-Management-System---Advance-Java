package foodCourt.repository;

import foodCourt.domain.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class AuthorityRepository {
    private SessionFactory sessionFactory;

    public AuthorityRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean create(Authority authority){
        Session session = sessionFactory.getCurrentSession();
        session.save(authority);
        return true;
    }
}
