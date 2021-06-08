package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SignupController {


    @Autowired
    public SignUpService signUpService;

    @PostMapping(value="/signup")
    public CreationResponse SignUp(@RequestParam(value="username") String username,
                                   @RequestParam(value="password") String password,
                                   @RequestParam(value="email") String email, HttpSession session)
    {
        return signUpService.SignUp(username,password,email,session);
    }
}
