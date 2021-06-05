package ma.ensias.projetjee2_0.Services;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.entites.Member;
import ma.ensias.projetjee2_0.entites.Topic;
import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.MemberRepository;
import ma.ensias.projetjee2_0.repositories.TopicRepository;
import ma.ensias.projetjee2_0.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MemberRepository memberRepository;

    public CreationResponse createTopic(HashMap<String,String> topic)
    {
        String  title = topic.get("title"),
                description = topic.get("description"),
                icon = topic.get("icon"),
                cover = topic.get("cover"),
                error=null;
        int idUser = Integer.parseInt(topic.get("idUser"));
        Boolean success = true;
        Topic topicFound = topicRepository.findTopicByTitleEquals(title);
        User userOfTheSession = userRepository.findById(idUser).orElse(null);

        if(topicFound != null )
        {
            success = false;
            error = "title already in use";
        }
        else if(userOfTheSession == null)
        {
            success = false;
            error = "No user found";
        }
        if(success)
        {
            Topic topicCreated = topicRepository.save(new Topic(title,description,icon,cover));
            Member member = new Member(userOfTheSession, topicCreated, true);
            memberRepository.save(member);
        }
        return new CreationResponse(success,error);
    }
}
