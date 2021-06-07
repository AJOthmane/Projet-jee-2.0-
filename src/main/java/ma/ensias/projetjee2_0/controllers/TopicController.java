package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TopicController {


    @Autowired
    public TopicService topicService;

    @PostMapping(value="/topic")
    public CreationResponse getTopic(@RequestParam String title,
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
}
