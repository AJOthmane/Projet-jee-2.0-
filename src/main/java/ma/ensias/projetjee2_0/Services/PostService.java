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
import java.util.HashMap;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    TopicRepository topicRepository;

    Post post;
    Content content;
    HashMap<String,String> errors = new HashMap<String,String>();

    public CreationResponse createInvitation(String titre, String location, String date, String description, int topic, User user) {
        Date formatedDate;
        try {
            formatedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            errors.put("date", "Invalid date");
            return new CreationResponse(false,errors);
        }
        Topic topicObject = topicRepository.findById(topic);
        if(topicObject == null)
        {
            errors.put("idTopic","nonexistent topic");
            return new CreationResponse(false,errors);
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
            errors.put("idTopic","nonexistent topic");
            return new CreationResponse(false,errors);
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
            errors.put("idTopic","nonexistent topic");
            return new CreationResponse(false,errors);
        }
        post = new Post(titre,topicObject,Post.IMAGE,user);
        content = new Image(url);
        post.setContent(content);

        // save content
        postRepository.save(post);

        return new CreationResponse(true);
    }

    public CreationResponse NoTypeOfContent() {
        errors.put("fields","missing type of content field value");
        return new CreationResponse(false,errors);
    }

}
