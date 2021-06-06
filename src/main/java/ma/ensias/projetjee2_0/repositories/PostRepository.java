package ma.ensias.projetjee2_0.repositories;

import ma.ensias.projetjee2_0.entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findAllByTopic_idEquals(int topic_id);
}
