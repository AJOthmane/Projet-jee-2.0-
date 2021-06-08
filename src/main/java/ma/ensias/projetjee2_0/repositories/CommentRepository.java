package ma.ensias.projetjee2_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ensias.projetjee2_0.entites.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
    
}
