package ma.ensias.projetjee2_0.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Member> members = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<PostLike> postlike = new HashSet<>();

    public User() {}

    public User(String username,String password,String email)
    {

        this.username = username;
        this.password = password;
        this.email = email;


    }
    public int getId() {

        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {

        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
