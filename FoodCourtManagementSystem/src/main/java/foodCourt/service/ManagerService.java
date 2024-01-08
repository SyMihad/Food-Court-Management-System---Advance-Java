package foodCourt.service;

import foodCourt.domain.Customer;
import foodCourt.domain.Manager;
import foodCourt.repository.CustomerRepository;
import foodCourt.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class ManagerService {
//    Logger logger = Logger.getLogger(ManagerService.class.getName());

    private ManagerRepository managerRepository;
    private UserService userService;

    public ManagerService(ManagerRepository managerRepository, UserService userService) {
        this.managerRepository = managerRepository;
        this.userService = userService;
    }

    public List<Manager> list(){
        return managerRepository.list();
    }

    public Manager get(Long id){
        return managerRepository.get(id);
    }

    public Manager getFromUserId(Long id){
        return managerRepository.getFromUserId(id);
    }

    public boolean create(Manager manager){
        return managerRepository.create(manager);
    }

    public boolean update(Manager manager){
        userService.update(manager.getUser());
        managerRepository.update(manager);
        return true;
    }

    public boolean delete(Long id){
        Manager manager = managerRepository.get(id);
        managerRepository.delete(get(id));
        userService.delete(manager.getUser().getId());
        return true;
    }
}
