package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TopicController {


    @Autowired
    public TopicService topicService;

    @PostMapping(value="/topic")
    public CreationResponse getTopic(@RequestBody HashMap<String,String> topic)
    {
        return topicService.createTopic(topic) ;
    }


}
