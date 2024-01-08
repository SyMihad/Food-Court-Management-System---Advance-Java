package foodCourt.service;

import foodCourt.domain.Order;
import foodCourt.domain.User;
import foodCourt.repository.OrderRepository;
import foodCourt.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class UserService {
//    Logger logger = Logger.getLogger(UserService.class.getName());

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> list(){
        return userRepository.list();
    }

    public User get(Long id){
        return userRepository.get(id);
    }
    public User get(String username) { return userRepository.get(username); }

    public boolean create(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.create(user);
    }

    public boolean update(User user){
        return userRepository.update(user);
    }

    public boolean delete(Long id){
        return userRepository.delete(get(id));
    }
}
