package ma.ensias.projetjee2_0.repositories;

import ma.ensias.projetjee2_0.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsernameEquals(String username);
    User findByEmailEquals(String username);
    User findById(int id);
}
