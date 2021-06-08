package ma.ensias.projetjee2_0.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ensias.projetjee2_0.Responses.CreationResponse;
import ma.ensias.projetjee2_0.Services.CommentService;
import ma.ensias.projetjee2_0.Services.PostService;
import ma.ensias.projetjee2_0.Services.SignInService;
import ma.ensias.projetjee2_0.entites.User;

@RestController
public class CommentController {

    private static final String POST_FIELD = "post";
    private static final String COMMENT_FIELD = "comment";

    @Autowired
    public CommentService commentService;

    @PostMapping(value = "/comment")
    public CreationResponse insertComm(@RequestParam(value = POST_FIELD) int post,
            @RequestParam(value = COMMENT_FIELD) String comment, HttpSession session) {
        return commentService.insertComment(post, comment, (User)session.getAttribute(SignInService.USER_SESSION));
    }
}
