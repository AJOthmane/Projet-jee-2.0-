package ma.ensias.projetjee2_0.Services;

import ma.ensias.projetjee2_0.Responses.UserResponse;
import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.PostRepository;
import ma.ensias.projetjee2_0.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;


    public UserResponse searchUser(int id) {
        User user = userRepository.findById(id);
        if(user == null)
        {
            return new UserResponse(false);
        }
        else
        {
            return new UserResponse(user,postRepository.findAllByUser_idEquals(user.getId()),true);
        }
    }
}
