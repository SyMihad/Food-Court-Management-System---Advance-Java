package foodCourt.controller;

import foodCourt.dto.CustomerDto;
import foodCourt.service.CustomerService;
import foodCourt.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
//@RequestMapping("/user")
public class CustomerSignupController {
    private CustomerService customerService;

    public CustomerSignupController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                setValue(localDate);
            }
        });
    }
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("customerDto", new CustomerDto());
        return "signupCustomer";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, Model model, BindingResult bindingResult) throws SQLException{
        if(bindingResult.hasErrors()){
            return "signupCustomer";
        }

        customerService.create(customerDto);
        return "redirect:/";
    }
}
