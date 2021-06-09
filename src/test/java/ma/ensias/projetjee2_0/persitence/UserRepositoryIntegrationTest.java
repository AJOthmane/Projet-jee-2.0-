package ma.ensias.projetjee2_0.persitence;

import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByUsername_thenReturnUser() {
        // given
        User alex = new User("alex","alex","alex@gmail.com");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        User found = userRepository.findByUsernameEquals(alex.getUsername());

        // then
        assertThat(found.getUsername())
                .isEqualTo(alex.getUsername());
    }
}
