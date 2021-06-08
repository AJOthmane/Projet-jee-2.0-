package ma.ensias.projetjee2_0.controllers;


import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Responses.GetPostResponse;
import ma.ensias.projetjee2_0.Responses.SignInResponse;
import ma.ensias.projetjee2_0.Services.PostService;
import ma.ensias.projetjee2_0.Services.SignInService;
import ma.ensias.projetjee2_0.entites.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class PostController {
    private static final String TITLE_FIELD = "title";
    private static final String CONTENT_TYPE_FIELD = "type_content";
    private static final String TOPIC_FIELD = "topic";
    /*
     * si le post est event
     */
    private static final String LOCATION_FIELD = "location";
    private static final String DATE_FIELD = "date";
    private static final String DESCRIPTION_FIELD = "description";
    /*
     * si le post est text
     */
    private static final String TEXT_FIELD = "text";
    /*
     * si le post est image
     */
    private static final String URL_FIELD = "url";

    @Autowired
    public PostService postService;
    @PostMapping(value="/post")
    public CreationResponse SignIn(@RequestParam(value = TITLE_FIELD) String titre,
                                   @RequestParam(value = CONTENT_TYPE_FIELD) String typeOfContent,
                                   @RequestParam(value = LOCATION_FIELD, required = false) String location,
                                   @RequestParam(value = DATE_FIELD, required = false) String date,
                                   @RequestParam(value = DESCRIPTION_FIELD, required = false) String description,
                                   @RequestParam(value = TEXT_FIELD, required = false) String text,
                                   @RequestParam(value = URL_FIELD, required = false) String url,
                                   @RequestParam(value = TOPIC_FIELD) int topic,
                                   HttpSession session){
        switch (typeOfContent)
        {
            case "invitation" :
                return postService.createInvitation(titre,location,date,description,topic,(User)session.getAttribute(SignInService.USER_SESSION));
            case "text" :
                return postService.createText(titre,text,topic,(User)session.getAttribute(SignInService.USER_SESSION));
            case "image":
                return postService.createImage(titre,url,topic,(User)session.getAttribute(SignInService.USER_SESSION));
            default:
                return  postService.NoTypeOfContent();
        }
    }

    @GetMapping(value="/post")
    public GetPostResponse getPostMethod(@RequestParam int id) {
        return postService.getPost(id);
    }
    
}
