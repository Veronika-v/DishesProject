package by.rogalevich.dishesproject.repository;


import by.rogalevich.dishesproject.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserrRepository extends JpaRepository<Userr, Long> {
    Userr findByUsername(String username);

}
