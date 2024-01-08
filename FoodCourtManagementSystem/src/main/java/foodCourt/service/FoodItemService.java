package foodCourt.service;

import foodCourt.domain.FoodItem;
import foodCourt.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class FoodItemService {

//    private Logger logger = Logger.getLogger(FoodItemService.class.getName());

    private FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public List<FoodItem> list(Long id){
        return foodItemRepository.list(id);
    }

    public FoodItem get(Long id){
        return foodItemRepository.get(id);
    }

    public boolean create(FoodItem foodItem){
        return foodItemRepository.create(foodItem);
    }

    public boolean update(FoodItem foodItem){
        return foodItemRepository.update(foodItem);
    }

    public boolean delete(Long id){
        return foodItemRepository.delete(get(id));
    }
}
