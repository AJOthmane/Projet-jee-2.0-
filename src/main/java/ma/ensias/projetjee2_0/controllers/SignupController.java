package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.SignUpResponse;
import ma.ensias.projetjee2_0.Services.SignUpService;
import ma.ensias.projetjee2_0.entites.User;
import ma.ensias.projetjee2_0.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SignupController {
    @Autowired
    UserRepository userRepository;

    public SignUpService signUpService = new SignUpService();

    @PostMapping(value="/signup")
    public SignUpResponse SignUp(@RequestBody HashMap<String,String> user )
    {
        return signUpService.SignUp(user,userRepository);
    }
    @GetMapping(value="/signup")
    public String SignUp()
    {
        return "GET working well";
    }
}
