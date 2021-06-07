package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Services.TopicService;
import ma.ensias.projetjee2_0.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class TopicController {


    @Autowired
    public TopicService topicService;

    @PostMapping(value="/topic")
    public CreationResponse getTopic(@RequestBody HashMap<String,String> topic, HttpSession session)
    {
        return topicService.createTopic(topic,(User)session.getAttribute(TopicService.USER_SESSION)) ;
    }

}
