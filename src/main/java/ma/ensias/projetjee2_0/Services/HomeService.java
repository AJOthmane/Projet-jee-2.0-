package ma.ensias.projetjee2_0.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensias.projetjee2_0.Responses.GetHomeResponse;
import ma.ensias.projetjee2_0.entites.Post;
import ma.ensias.projetjee2_0.repositories.PostRepository;

@Service
public class HomeService {
    @Autowired
    PostRepository postRepository;

    public GetHomeResponse getHome(){
        ArrayList<Post> listOfPosts = new ArrayList<>();

        listOfPosts = postRepository.findAll();
        return new GetHomeResponse(true, listOfPosts);
    }

}
