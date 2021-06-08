package ma.ensias.projetjee2_0.Services;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SignUpService {

    @Autowired
    UserRepository userRepository;

    private static final String USER_SESSION = "userSession";

    public static String getMd5(String input)
    {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());


            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0"+hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public CreationResponse SignUp(String username, String password, String email, HttpSession session)
    {
        boolean success = true;
        String regex = "^[\\w-_.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Map<String,String> errors = null;
        User userFoundByEmail = userRepository.findByEmailEquals(email);
        User userFoundByUsername = userRepository.findByUsernameEquals(username);
        if(userFoundByUsername != null && userFoundByEmail == null   )
        {
            success = false;
            errors = new HashMap<>();
            errors.put("username","Username already in use ");
        }
        else if(userFoundByUsername == null && userFoundByEmail != null )
        {
            success = false;
            errors = new HashMap<>();
            errors.put("email","Email already in use ");
        }
        else if(!email.matches(regex))
        {
            success = false;
            errors = new HashMap<>();
            errors.put("email","Email form invalid");
        }
        if(success)
        {
           User user = userRepository.save(new User(username,getMd5(password),email));
           session.setAttribute(USER_SESSION,user);

        }
        return  new CreationResponse(success,errors);
    }
}
