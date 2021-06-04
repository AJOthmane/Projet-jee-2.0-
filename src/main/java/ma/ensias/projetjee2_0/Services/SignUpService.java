package ma.ensias.projetjee2_0.Services;

import ma.ensias.projetjee2_0.Responses.SignUpResponse;
import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.UserRepository;

import java.math.BigInteger;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class SignUpService {

    public String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // todo : check email form , insert into database , id_session
    public SignUpResponse SignUp(HashMap<String,String> user,UserRepository userRepositoryArg)
    {
        UserRepository userRepository = userRepositoryArg;
        String username = user.get("username"), password = user.get("password"), email = user.get("email");
        boolean success = true;
        String errors = null;
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        User userFoundByEmail = userRepository.findByEmailEquals(email);
        User userFoundByUsername = userRepository.findByUsernameEquals(username);
        if(userFoundByUsername != null && userFoundByEmail == null   )
        {
            success = false;
            errors = "Username already in use ";
        }
        else if(userFoundByUsername == null && userFoundByEmail != null )
        {
            success = false;
            errors = "Email already in use ";
        }
        else if(userFoundByUsername != null && userFoundByEmail != null)
        {
            success = false;
            errors = "Email & Username  already in use ";
        }
        else if(!email.matches(regex))
        {
            success = false;
            errors = "Email form invalid";
        }

        if(success)
        {
           userRepository.save(new User(username,getMd5(password),email));

        }
        return  new SignUpResponse(success,errors);
    }




}
