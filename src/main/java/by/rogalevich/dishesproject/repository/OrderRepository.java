package by.rogalevich.dishesproject.repository;

import by.rogalevich.dishesproject.model.Dishes;
import by.rogalevich.dishesproject.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Long> {
    Orders findById(Integer id_order);
}
