package abhik26.food_delivery.user_info.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import abhik26.food_delivery.user_info.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
