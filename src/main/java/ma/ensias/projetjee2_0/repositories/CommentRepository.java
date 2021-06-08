package ma.ensias.projetjee2_0.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ensias.projetjee2_0.entites.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
    ArrayList<Comment> findByPost_idEquals(int post_id);
}
