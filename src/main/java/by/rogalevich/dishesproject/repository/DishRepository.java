package by.rogalevich.dishesproject.repository;

import by.rogalevich.dishesproject.model.Dishes;
import by.rogalevich.dishesproject.model.Userr;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<Dishes, Long> {

    List<Dishes> findByDishname(String dishname);

    Dishes findById(Integer id);
}
