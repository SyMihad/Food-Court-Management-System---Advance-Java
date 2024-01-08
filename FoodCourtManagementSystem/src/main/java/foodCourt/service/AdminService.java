package foodCourt.service;

import foodCourt.domain.*;
import foodCourt.dto.AdminDto;
import foodCourt.dto.RestaurantManagerDto;
import foodCourt.repository.AdminRepository;
import foodCourt.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class AdminService {

//     private Logger logger = Logger.getLogger(AdminService.class.getName());

    private AdminRepository adminRepository;

    private UserService userService;
    private AuthorityService authorityService;
    private ManagerService managerService;
    private RestaurantService restaurantService;

    private ManagerRepository managerRepository;

    public AdminService(AdminRepository adminRepository, UserService userService, AuthorityService authorityService, ManagerService managerService, RestaurantService restaurantService, ManagerRepository managerRepository) {
        this.adminRepository = adminRepository;
        this.userService = userService;
        this.authorityService = authorityService;
        this.managerService = managerService;
        this.restaurantService = restaurantService;
        this.managerRepository = managerRepository;
    }

    public List<Admin> list() {
        return adminRepository.list();
    }

    public Admin get(Long id) {
        return adminRepository.get(id);
    }

    public boolean create(Admin admin) {
        return adminRepository.create(admin);
    }

    public boolean create(AdminDto adminDto){
        User user = new User();
        user.setFirstName(adminDto.getFirstName());
        user.setLastName(adminDto.getLastName());
        user.setUsername(adminDto.getUsername());
        user.setEmail(adminDto.getEmail());
        user.setGender(adminDto.getGender());
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());
        user.setPassword(adminDto.getPassword());
        userService.create(user);

        Authority authority = new Authority();
        authority.setName("ROLE_ADMIN");
        authority.setUser(user);
        authorityService.create(authority);

        Admin admin = new Admin();
        admin.setNidNo(adminDto.getNidNo());
        admin.setUser(user);
        adminRepository.create(admin);

        return true;
    }

    public boolean create(RestaurantManagerDto restaurantManagerDto){
        User user = new User();
        user.setFirstName(restaurantManagerDto.getFirstName());
        user.setLastName(restaurantManagerDto.getLastName());
        user.setUsername(restaurantManagerDto.getUsername());
        user.setEmail(restaurantManagerDto.getEmail());
        user.setGender(restaurantManagerDto.getGender());
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());
        user.setPassword(restaurantManagerDto.getPassword());
        userService.create(user);

        Authority authority = new Authority();
        authority.setName("ROLE_MANAGER");
        authority.setUser(user);
        authorityService.create(authority);

        Manager manager = new Manager();
        manager.setNidNo(restaurantManagerDto.getNidNo());
        manager.setUser(user);
        managerRepository.create(manager);

        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantManagerDto.getRestaurantName());
        restaurant.setManager(manager);
        restaurantService.create(restaurant);

        return true;

    }

    public boolean update(Admin admin) {
//        User user = new User();
//        user.setId(admin.getUser().getId());
//        user.setFirstName(admin.getUser().getFirstName());
//        user.setLastName(admin.getUser().getLastName());
//        user.setUserName(admin.getUser().getUserName());
//        user.setEmail(admin.getUser().getEmail());
//        user.setGender(admin.getUser().getGender());
//
//        userService.update(user);
        userService.update(admin.getUser());
        adminRepository.update(admin);
        return true;
    }

    public boolean delete(Long id) {
        Admin admin = adminRepository.get(id);
        adminRepository.delete(get(id));
        userService.delete(admin.getUser().getId());
        return true;
    }
}
