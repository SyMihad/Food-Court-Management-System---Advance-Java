package foodCourt.controller;

import foodCourt.domain.User;
import foodCourt.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/home")
    public String login(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authorityName = new String();
        if (authentication != null && authentication.isAuthenticated()) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                authorityName = authority.getAuthority();
            }
        }
        if(authorityName.equals("ROLE_CUSTOMER")){
            logger.log(Level.SEVERE, "Redirected to Customer");
            return "redirect:/customer/home";
        }
        else if(authorityName.equals("ROLE_ADMIN")){
            logger.log(Level.SEVERE, "Redirected to Admin");
            return "redirect:/admin/home";
        }
        else if(authorityName.equals("ROLE_MANAGER")){
            logger.log(Level.SEVERE, "Redirected to Manager");
            return "redirect:/manager/home";
        }

        return "redirect:/";
    }
}
