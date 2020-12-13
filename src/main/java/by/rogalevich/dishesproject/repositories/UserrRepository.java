package by.rogalevich.dishesproject.repositories;


import by.rogalevich.dishesproject.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserrRepository extends JpaRepository<Userr, Long> {
    Userr findByUsername(String username);
}
