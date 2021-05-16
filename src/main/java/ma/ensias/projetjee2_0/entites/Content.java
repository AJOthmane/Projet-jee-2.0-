package ma.ensias.projetjee2_0.entites;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Content {
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post", referencedColumnName = "id")
    private Post post;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
    public Post getPostId() {

        return post;
    }

    public void setPostId(Post post) {

        this.post = post;
    }
}
