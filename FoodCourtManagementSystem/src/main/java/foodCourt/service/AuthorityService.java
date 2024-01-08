package foodCourt.service;

import foodCourt.domain.Authority;
import foodCourt.repository.AuthorityRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuthorityService {
//    private Logger logger = Logger.getLogger(AuthorityService.class);

    private AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public boolean create(Authority authority){
        return authorityRepository.create(authority);
    }
}
