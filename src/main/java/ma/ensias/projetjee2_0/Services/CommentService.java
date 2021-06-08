package ma.ensias.projetjee2_0.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.entites.Comment;
import ma.ensias.projetjee2_0.entites.Post;
import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.CommentRepository;
import ma.ensias.projetjee2_0.repositories.PostRepository;

@Service
public class CommentService {
    
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    public CreationResponse insertComment(int post, String comment, User user){
        Post postObj = postRepository.findById(post);

        if(postObj == null){
            return new CreationResponse(false, "Post inexistant");
        }
        else {
            Comment commentaire = new Comment(comment, user, postObj);
            commentRepository.save(commentaire);
            return new CreationResponse(true);
        }
    } 
}
