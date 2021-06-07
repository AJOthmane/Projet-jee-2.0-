package ma.ensias.projetjee2_0.repositories;

import ma.ensias.projetjee2_0.entites.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Integer> {

    Topic findTopicByTitleEquals(String title);


}
