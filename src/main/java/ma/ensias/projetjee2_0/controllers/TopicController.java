package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Responses.GetTopicResponse;
import ma.ensias.projetjee2_0.Responses.SearchResponse;
import ma.ensias.projetjee2_0.Services.SignInService;
import ma.ensias.projetjee2_0.Services.TopicService;
import ma.ensias.projetjee2_0.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicController {


    @Autowired
    public TopicService topicService;

    @PostMapping(value="/topic")
    public CreationResponse setTopic(@RequestParam String title,
                                     @RequestParam String description,
                                     @RequestParam String icon,
                                     @RequestParam String cover,
                                                   HttpSession session)
    {
        return topicService.createTopic(title,
                                        description,
                                        icon,
                                        cover,
                                        session) ;
    }
    @PostMapping(value="/jointopic")
    public CreationResponse joinTopic(@RequestParam(value="idtopic") int idTopic, HttpSession session)
    {
        return topicService.joinTopic(idTopic, session);
    }

    @GetMapping(value="topic")
    public GetTopicResponse getTopic(@RequestParam(value = "id") int id, HttpSession session)
    {
        return topicService.searchTopic(id,(User)session.getAttribute(SignInService.USER_SESSION));
    }

    @GetMapping(value="/searchtopic")
    public SearchResponse searchTop(@RequestParam String topic) 
    {
        return topicService.searchTopic(topic);
    }
}
