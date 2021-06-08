package ma.ensias.projetjee2_0.Services;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.entites.*;
import ma.ensias.projetjee2_0.repositories.PostRepository;
import ma.ensias.projetjee2_0.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    TopicRepository topicRepository;

    Post post;
    Content content;
    public CreationResponse createInvitation(String titre, String location, String date, String description, int topic, User user) {
        Date formatedDate;
        try {
            formatedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            return new CreationResponse(false,"wrong date format");
        }
        Topic topicObject = topicRepository.findById(topic);
        if(topicObject == null)
        {
            return new CreationResponse(false,"nonexistent topic");
        }

        post = new Post(titre,topicObject,Post.INVITATION,user);
        content = new Invitation(description,formatedDate,location,post);
        post.setContent(content);


        //save content
        postRepository.save(post);
        return new CreationResponse(true);
    }

    public CreationResponse createText(String titre, String text, int topic, User user) {
        Topic topicObject = topicRepository.findById(topic);
        if(topicObject == null)
        {
            return new CreationResponse(false,"nonexistent topic");
        }
        post = new Post(titre,topicObject,Post.TEXT,user);
        content = new Text(text);
        post.setContent(content);

        // save content
        postRepository.save(post);

        return new CreationResponse(true);
    }

    public CreationResponse createImage(String titre, String url, int topic, User user) {
        Topic topicObject = topicRepository.findById(topic);
        if(topicObject == null)
        {
            return new CreationResponse(false,"nonexistent topic");
        }
        post = new Post(titre,topicObject,Post.IMAGE,user);
        content = new Image(url);
        post.setContent(content);

        // save content
        postRepository.save(post);

        return new CreationResponse(true);
    }

    public CreationResponse NoTypeOfContent() {
        return new CreationResponse(false,"Nonexistent type of content");
    }

}
