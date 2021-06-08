package ma.ensias.projetjee2_0.Services;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Responses.GetTopicResponse;
import ma.ensias.projetjee2_0.Responses.SearchResponse;
import ma.ensias.projetjee2_0.entites.Member;
import ma.ensias.projetjee2_0.entites.Post;
import ma.ensias.projetjee2_0.entites.Topic;
import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.MemberRepository;
import ma.ensias.projetjee2_0.repositories.PostRepository;
import ma.ensias.projetjee2_0.repositories.TopicRepository;
import ma.ensias.projetjee2_0.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostRepository postRepository;

    public static final String USER_SESSION = "userSession";

    public CreationResponse createTopic(String title,
                                        String description,
                                        String icon,
                                        String cover,
                                        HttpSession session)
    {
        Map<String,String> error=null;
        boolean success = true;
        Topic topicFound = topicRepository.findTopicByTitleEquals(title);
        User userOfSession = (User)session.getAttribute(USER_SESSION);

        if(userOfSession == null)
        {
            error = new HashMap<>();
            error.put("Login","disconnected");
            success = false;
        }
        else
        {
            if (topicFound != null)
            {
                success = false;
                error = new HashMap<>();
                error.put("title","title already in use");
            }
            else if( title.isEmpty())
            {
                success = false;
                error = new HashMap<>();
                error.put("fields","Title empty");
            }

            if (success)
            {
                Topic topicCreated = topicRepository.save(new Topic(title, description, icon, cover));
                Member member = new Member(userOfSession, topicCreated, true);
                memberRepository.save(member);
            }
        }
        return new CreationResponse(success,error);
    }

    public CreationResponse joinTopic(int idTopic, HttpSession session)
    {
        Map<String,String> error=null;
        boolean success = true;
        Topic topic = null;
        User userOfSession = (User)session.getAttribute(USER_SESSION);


        topic = topicRepository.findById(idTopic);

        if(userOfSession == null)
        {
            success = false;
            error = new HashMap<>();
            error.put("Login","Disconnected");
        }
        else
        {
            if (topic == null)
            {
                success = false;
                error = new HashMap<>();
                error.put("topic","Topic not found");
            }
            else
            {
                Member member = new Member(userOfSession, topic, true);
                try
                {
                    memberRepository.save(member);
                }
                catch (Exception e)
                {
                    success = false;
                    error = new HashMap<>();
                    error.put("topic","already exist");
                }
            }
        }
        return new CreationResponse(success,error);
    }

    public GetTopicResponse searchTopic(int id, User user) {
        Topic topic = topicRepository.findById(id);
        if(topic == null)
        {
            return new GetTopicResponse(false,"Nonexistent topic");
        }
        GetTopicResponse response = new GetTopicResponse(true,topic);
        if(user != null)
        {
            response.setJoined(memberRepository.existsByTopic_idAndUser_id(topic.getId(), user.getId()));
        }

        response.setPosts((ArrayList<Post>) postRepository.findAllByTopic_idEquals(topic.getId()));
        return response;
    }

    public SearchResponse searchTopic(String searchtop) {
        boolean success = true;
        ArrayList<Topic> topics = new ArrayList<>();

        topics = topicRepository.findTopicsByTitleContaining(searchtop);

        if (topics.size() == 0) {
            success = false;
        } 
        return new SearchResponse(success, topics);
    }
}
