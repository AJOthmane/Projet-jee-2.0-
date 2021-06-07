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

    public static final String USER_SESSION = "userSession";

    //  a changer
    public CreationResponse createTopic(HashMap<String,String> topic,User user)
    {
        String  title = topic.get("title"),
                description = topic.get("description"),
                icon = topic.get("icon"),
                cover = topic.get("cover"),
                error=null;
        boolean success = true;
        Topic topicFound = topicRepository.findTopicByTitleEquals(title);

        if(topicFound != null )
        {
            success = false;
            error = "title already in use";
        }

        if(success)
        {
            Topic topicCreated = topicRepository.save(new Topic(title,description,icon,cover));
            Member member = new Member(user, topicCreated, true);
            memberRepository.save(member);
        }
        return new CreationResponse(success,error);
    }
}
