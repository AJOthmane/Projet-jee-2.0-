package ma.ensias.projetjee2_0.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensias.projetjee2_0.Responses.GetHomeResponse;
import ma.ensias.projetjee2_0.Services.HomeService;

@RestController
public class HomeController {

    @Autowired
    public HomeService homeService;
    
    @GetMapping(value="/home")
    public GetHomeResponse getHomeMethod() {
        return homeService.getHome();
    }
}
