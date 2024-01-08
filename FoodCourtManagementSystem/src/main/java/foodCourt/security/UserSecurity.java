package foodCourt.security;

import foodCourt.domain.User;
import foodCourt.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity implements UserDetailsService {

    private UserService userService;

    public UserSecurity(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.get(username);
        if (user == null) {
            return null;
        }
        else {
            org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
            return user1;
        }
    }
}
