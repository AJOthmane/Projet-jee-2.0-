package ma.ensias.projetjee2_0.repositories;

import ma.ensias.projetjee2_0.entites.Member;
import ma.ensias.projetjee2_0.entites.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {


}
