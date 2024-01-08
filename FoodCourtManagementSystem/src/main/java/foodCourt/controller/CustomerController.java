package foodCourt.controller;

import foodCourt.domain.Customer;
import foodCourt.domain.FoodItem;
import foodCourt.domain.Order;
import foodCourt.domain.User;
import foodCourt.service.*;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private FoodItemService foodItemService;
    private CustomerService customerService;
    private OrderService orderService;
    private RestaurantService restaurantService;
    private UserService userService;

    public CustomerController(FoodItemService foodItemService, CustomerService customerService, OrderService orderService, RestaurantService restaurantService, UserService userService) {
        this.foodItemService = foodItemService;
        this.customerService = customerService;
        this.orderService = orderService;
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        webDataBinder.registerCustomEditor(FoodItem.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                 FoodItem foodItem = foodItemService.get(Long.parseLong(text));
                setValue(foodItem);
            }
        });
    }

    @RequestMapping("/home")
    public String customerHome(Model model){
        return "customer/home";
    }

    @RequestMapping("/restaurantList")
    public String viewRestaurant(Model model){
        model.addAttribute("restaurants", restaurantService.list());
        return "customer/restaurantList";
    }

    @RequestMapping("/selectFoodItem")
    public String selectFoodItem(@RequestParam("restaurantId") Long restaurantId, Model model) throws SQLException{
        model.addAttribute("order", new Order());
        model.addAttribute("foodItems", foodItemService.list(restaurantId));
        return "customer/selectFoodItem";
    }

    @RequestMapping("/placeOrder")
    public String placeOrder(@RequestParam("foodId") Long foodId, Model model){
        Order order = new Order();
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        order.setCustomer(customerService.getFromUserId(user.getId()));
        FoodItem foodItem = foodItemService.get(foodId);
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(foodItem);
        order.setFoodItems(foodItems);
        model.addAttribute("order", order);
        return "customer/placeOrder";
    }

    @RequestMapping("/storeOrder")
    public String storeOrder(@Valid @ModelAttribute("order") Order order, Model model, BindingResult bindingResult) throws SQLException{
        if (bindingResult.hasErrors()){
            return "customer/restaurantList";
        }
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        order.setCustomer(customerService.getFromUserId(user.getId()));
        order.setDelivered(false);
        orderService.create(order);
        return "redirect:/customer/home";
    }

    @RequestMapping("/showProfile")
    public String showProfile(Model model){
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        model.addAttribute("customer", customerService.getFromUserId(user.getId()));
        return "customer/showProfile";
    }

    @RequestMapping("/editProfile")
    public String editProfile(Model model){
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        model.addAttribute("customer", customerService.getFromUserId(user.getId()));
        return "customer/editProfile";
    }

    @RequestMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) throws  SQLException{
        if (bindingResult.hasErrors()){
            return "customer/editProfile";
        }
        customerService.update(customer);
        return "redirect:/customer/home";
    }

    @RequestMapping("/viewOrders")
    public String viewOrders(Model model){
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        Customer customer = customerService.getFromUserId(user.getId());
        model.addAttribute("orders", orderService.listCustomer(customer.getId()));
        return "customer/viewOrders";
    }


}
