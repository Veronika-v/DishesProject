package by.rogalevich.dishesproject.repository;

import by.rogalevich.dishesproject.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

    List<User>findByName(String name);

}
