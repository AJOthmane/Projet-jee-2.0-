package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Responses.GetTopicResponse;
import ma.ensias.projetjee2_0.Services.SignInService;
import ma.ensias.projetjee2_0.Services.TopicService;
import ma.ensias.projetjee2_0.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class TopicController {


    @Autowired
    public TopicService topicService;

    @PostMapping(value="/topic")
    public CreationResponse setTopic(@RequestBody HashMap<String,String> topic)
    {
        return topicService.createTopic(topic) ;
    }

    @GetMapping(value="topic")
    public GetTopicResponse getTopic(@RequestParam(value = "id") int id, HttpSession session)
    {
        return topicService.searchTopic(id,(User)session.getAttribute(SignInService.USER_SESSION));
    }
}
