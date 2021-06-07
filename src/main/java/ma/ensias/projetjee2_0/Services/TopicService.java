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

import javax.servlet.http.HttpSession;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MemberRepository memberRepository;

    public static final String USER_SESSION = "userSession";

    public CreationResponse createTopic(String title,
                                        String description,
                                        String icon,
                                        String cover,
                                        HttpSession session)
    {
        String error=null;
        boolean success = true;
        Topic topicFound = topicRepository.findTopicByTitleEquals(title);
        User userOfSession = (User)session.getAttribute(USER_SESSION);
        if(userOfSession == null)
        {
            error = "disconnected";
            success = false;
        }
        else
        {
            if (topicFound != null) {
                success = false;
                error = "title already in use";
            }
            else if( title.isEmpty())
            {
                success = false;
                error = "Title empty";
            }

            if (success) {
                Topic topicCreated = topicRepository.save(new Topic(title, description, icon, cover));
                Member member = new Member(userOfSession, topicCreated, true);
                memberRepository.save(member);
            }
        }
        return new CreationResponse(success,error);
    }

    public CreationResponse joinTopic(int idTopic, HttpSession session)
    {
        String error=null;
        boolean success = true;
        Topic topic = topicRepository.findById(idTopic).get();
        User userOfSession = (User)session.getAttribute(USER_SESSION);
        if(userOfSession == null)
        {
            error="Disconnected";
            success = false;
        }
        else
        {
            if (topic == null) {
                success = false;
                error = "Topic not found";
            } else {
                Member member = new Member(userOfSession, topic, true);
                memberRepository.save(member);
            }
        }
        return new CreationResponse(success,error);
    }
}
