package foodCourt.service;

import foodCourt.domain.Order;
import foodCourt.domain.Restaurant;
import foodCourt.repository.OrderRepository;
import foodCourt.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class RestaurantService {
//    Logger logger = Logger.getLogger(RestaurantService.class.getName());

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> list(){
        return restaurantRepository.list();
    }

    public Restaurant get(Long id){
        return restaurantRepository.get(id);
    }

    public Restaurant getFromManager(Long id){
        return restaurantRepository.getFromManager(id);
    }
    
    public boolean create(Restaurant restaurant){
        return restaurantRepository.create(restaurant);
    }

    public boolean update(Restaurant restaurant){
        return restaurantRepository.update(restaurant);
    }

    public boolean delete(Long id){
        return restaurantRepository.delete(get(id));
    }
}
