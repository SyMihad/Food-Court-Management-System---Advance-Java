package foodCourt.service;

import foodCourt.domain.Order;
import foodCourt.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class OrderService {
//    Logger logger = Logger.getLogger(OrderService.class.getName());

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> list(){
        return orderRepository.list();
    }

    public List<Order> listCustomer(Long id){
        return orderRepository.listCustomer(id);
    }

    public Order get(Long id){
        return orderRepository.get(id);
    }

    public boolean create(Order order){
        return orderRepository.create(order);
    }

    public boolean update(Order order){
        return orderRepository.update(order);
    }


    public boolean delete(Long id){
        return orderRepository.delete(get(id));
    }
}
