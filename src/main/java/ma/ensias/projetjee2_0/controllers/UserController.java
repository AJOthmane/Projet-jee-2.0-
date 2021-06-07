package ma.ensias.projetjee2_0.controllers;

import ma.ensias.projetjee2_0.Responses.UserResponse;
import ma.ensias.projetjee2_0.Services.SignInService;
import ma.ensias.projetjee2_0.Services.UserService;
import ma.ensias.projetjee2_0.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping(value="user")
    public UserResponse getUser(@RequestParam(value = "id") int id)
    {
        return userService.searchUser(id);
    }
}
