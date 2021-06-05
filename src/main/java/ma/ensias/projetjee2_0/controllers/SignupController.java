package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SignupController {


    @Autowired
    public SignUpService signUpService;

    @PostMapping(value="/signup")
    public CreationResponse SignUp(@RequestBody HashMap<String,String> user )
    {
        return signUpService.SignUp(user);
    }
}
