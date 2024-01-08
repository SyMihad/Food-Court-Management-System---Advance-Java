package foodCourt.service;

import foodCourt.domain.Authority;
import foodCourt.domain.Customer;
import foodCourt.domain.User;
import foodCourt.dto.CustomerDto;
import foodCourt.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CustomerService {
//    Logger logger = Logger.getLogger(CustomerService.class.getName());

    private CustomerRepository customerRepository;
    private UserService userService;

    private AuthorityService authorityService;

    public CustomerService(CustomerRepository customerRepository, UserService userService, AuthorityService authorityService) {
        this.customerRepository = customerRepository;
        this.userService = userService;
        this.authorityService = authorityService;
    }

    public List<Customer> list(){
        return customerRepository.list();
    }

    public Customer get(Long id){
        return customerRepository.get(id);
    }

    public Customer getFromUserId(Long id){
        return customerRepository.getFromUserId(id);
    }

    public boolean create(CustomerDto customerDto){
        User user = new User();
        user.setFirstName(customerDto.getFirstName());
        user.setLastName(customerDto.getLastName());
        user.setUsername(customerDto.getUsername());
        user.setEmail(customerDto.getEmail());
        user.setGender(customerDto.getGender());
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());
        user.setPassword(customerDto.getPassword());
        userService.create(user);

        Authority authority = new Authority();
        authority.setName("ROLE_CUSTOMER");
        authority.setUser(user);
        authorityService.create(authority);

        Customer customer = new Customer();
        customer.setPhoneNo(customerDto.getPhoneNo());
        customer.setUser(user);
        customerRepository.create(customer);

        return true;
    }

    public boolean create(Customer customer){
        return customerRepository.create(customer);
    }

    public boolean update(Customer customer){
        return customerRepository.update(customer);
    }

    public boolean delete(Long id){
        return customerRepository.delete(get(id));
    }
}
