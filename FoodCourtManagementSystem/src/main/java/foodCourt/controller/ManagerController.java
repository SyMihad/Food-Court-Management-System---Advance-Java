package foodCourt.controller;

import foodCourt.domain.FoodItem;
import foodCourt.domain.Manager;
import foodCourt.domain.Order;
import foodCourt.domain.User;
import foodCourt.service.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    ManagerService managerService;
    FoodItemService foodItemService;
    RestaurantService restaurantService;
    OrderService orderService;
    CustomerService customerService;
    UserService userService;

    public ManagerController(ManagerService managerService, FoodItemService foodItemService, RestaurantService restaurantService, OrderService orderService, CustomerService customerService, UserService userService) {
        this.managerService = managerService;
        this.foodItemService = foodItemService;
        this.restaurantService = restaurantService;
        this.orderService = orderService;
        this.customerService = customerService;
        this.userService = userService;
    }

    @RequestMapping("/home")
    public String home(Model model){
        return "manager/home";
    }

    @RequestMapping("/addFoodItem")
    public String addFoodItem(Model model){
        model.addAttribute("foodItem", new FoodItem());
        return "manager/addFoodItem";
    }

    @RequestMapping("/storeFoodItem")
    public String storeFoodItem(@Valid @ModelAttribute("foodItem") FoodItem foodItem, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "manager/addFoodItem";
        }
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        Manager manager = managerService.getFromUserId(user.getId());
        foodItem.setRestaurant(restaurantService.getFromManager(manager.getId()));
        foodItemService.create(foodItem);
        return "redirect:/manager/foodItemList";

    }

    @RequestMapping("/foodItemList")
    public String foodItemList(Model model){
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        Manager manager = managerService.getFromUserId(user.getId());
        model.addAttribute("foodItems", foodItemService.list(restaurantService.getFromManager(manager.getId()).getId()));
        return "manager/foodItemList";
    }

    @RequestMapping("/editFoodItem")
    public String editFoodItem(@RequestParam("foodId") Long foodId, Model model) throws SQLException {
        model.addAttribute("foodItem", foodItemService.get(foodId));
        return "manager/editFoodItem";
    }

    @RequestMapping("/updateFoodItem")
    public String updateFoodItem(@Valid @ModelAttribute("foodItem") FoodItem foodItem, BindingResult bindingResult) throws SQLException{
        if (bindingResult.hasErrors()){
            return "manager/editFoodItem";
        }

        foodItemService.update(foodItem);
        return "redirect:/manager/foodItemList";
    }

    @RequestMapping("/orderList")
    public String orderList(Model model){
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        Manager manager = managerService.getFromUserId(user.getId());
        model.addAttribute("foodItems", foodItemService.list(restaurantService.getFromManager(manager.getId()).getId()));
        return "manager/viewOrders";
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(@RequestParam("orderId") Long id) throws SQLException{
        Order order = orderService.get(id);
        order.setDelivered(true);
        orderService.update(order);
        return "redirect:/manager/orderList";
    }
}
