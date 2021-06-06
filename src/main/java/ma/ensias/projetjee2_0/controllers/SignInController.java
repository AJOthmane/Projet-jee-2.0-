package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.SignInResponse;
import ma.ensias.projetjee2_0.Services.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {

    @Autowired
    public SignInService signInService;

    @PostMapping(value="/signin")
    public SignInResponse SignIn(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
        return signInService.signIn(username,password);
    }
}
