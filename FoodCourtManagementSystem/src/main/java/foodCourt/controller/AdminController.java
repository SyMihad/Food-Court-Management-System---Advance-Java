package foodCourt.controller;

import foodCourt.domain.Admin;
import foodCourt.domain.Manager;
import foodCourt.dto.AdminDto;
import foodCourt.dto.RestaurantManagerDto;
import foodCourt.service.*;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;
    private CustomerService customerService;
    private FoodItemService foodItemService;
    private ManagerService managerService;
    private OrderService orderService;
    private RestaurantService restaurantService;
    private UserService userService;

    public AdminController(AdminService adminService, CustomerService customerService, FoodItemService foodItemService, ManagerService managerService, OrderService orderService, RestaurantService restaurantService, UserService userService) {
        this.adminService = adminService;
        this.customerService = customerService;
        this.foodItemService = foodItemService;
        this.managerService = managerService;
        this.orderService = orderService;
        this.restaurantService = restaurantService;
        this.userService = userService;
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

    @RequestMapping("/home")
    public String home(Model model){
        return "admin/home";
    }

    @RequestMapping("/create-admin")
    public String createAdmin(Model model){
        model.addAttribute("adminDto", new AdminDto());
        return "admin/create-admin";
    }

    @RequestMapping("/store-admin")
    public String storeAdmin(@Valid @ModelAttribute("adminDto") AdminDto adminDto, Model model, BindingResult bindingResult) throws SQLException{
        if(bindingResult.hasErrors()){
            return "admin/create-admin";
        }

        adminService.create(adminDto);
        return "admin/home";
    }

    @RequestMapping("/create-RestaurantManager")
    public String createRestaurantManager(Model model){
        model.addAttribute("restaurantManagerDto", new RestaurantManagerDto());
        return "admin/create-restaurantManager";
    }

    @RequestMapping("/store-restaurantManager")
    public String storeRestaurantManager(@Valid @ModelAttribute("restaurantManagerDto") RestaurantManagerDto restaurantManagerDto, Model model, BindingResult bindingResult) throws SQLException{
        if(bindingResult.hasErrors()){
            return "admin/create-restaurantManager";
        }
        adminService.create(restaurantManagerDto);
        return "admin/home";
    }

    @RequestMapping("admin-list")
    public String showAllAdmin(Model model){
        model.addAttribute("admins", adminService.list());
        return "admin/admin-list";
    }
    @RequestMapping("manager-list")
    public String showAllManager(Model model){
        model.addAttribute("managers", managerService.list());
        return "admin/manager-list";
    }
    @RequestMapping("customer-list")
    public String showAllCustomer(Model model){
        model.addAttribute("customers", customerService.list());
        return "admin/customer-list";
    }



    @RequestMapping("/edit-admin")
    public String editAdmin(@RequestParam("adminId") Long adminId, Model model) throws SQLException {
        model.addAttribute("admin", adminService.get(adminId));
        return "admin/edit-admin";
    }

    @RequestMapping("/update-admin")
    public String updateAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "admin/edit-admin";
        }
        adminService.update(admin);
        return "redirect:/admin/admin-list";
    }

    @RequestMapping("/delete-admin")
    public String deleteAdmin(@RequestParam("adminId") Long adminId) {
        adminService.delete(adminId);
        return "redirect:/admin/admin-list";
    }


    @RequestMapping("/edit-manager")
    public String editManager(@RequestParam("managerId") Long managerId, Model model) throws SQLException {
        model.addAttribute("manager", managerService.get(managerId));
        return "admin/edit-manager";
    }
    @RequestMapping("/update-manager")
    public String updateManager(@Valid @ModelAttribute("manager") Manager manager, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "admin/edit-manager";
        }
        managerService.update(manager);
        return "redirect:/admin/manager-list";
    }
    @RequestMapping("/delete-manager")
    public String deleteManager(@RequestParam("managerId") Long manager) {
        managerService.delete(manager);
        return "redirect:/admin/manager-list";
    }

    @RequestMapping("/restaurant-list")
    public String restaurantList(Model model){
        model.addAttribute("restaurants", restaurantService.list());
        return "admin/restaurant-list";
    }



}
