package ma.ensias.projetjee2_0.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
public class Topic {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private String iconUrl;
    private String coverUrl;

    @OneToMany(mappedBy = "topicId",cascade= CascadeType.ALL)
    private Set<Member> members = new HashSet<>();

    public Topic(){ }

    public Topic(String title, String description, String iconUrl, String coverUrl,Member... members)
    {

        this.title = title;
        this.description = description;
        this.iconUrl = iconUrl;
        this.coverUrl = coverUrl;
        for(Member member : members) member.setTopicId(this);
        this.members = Stream.of(members).collect(Collectors.toSet());

    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getIconUrl() {
        return iconUrl;
    }
    public void setIconUrl(String iconUrl)
    {
        this.iconUrl = iconUrl;
    }
    public String getCoverUrl()
    {
        return coverUrl;
    }
    public void setCoverUrl(String coverUrl)
    {
        this.coverUrl = coverUrl;
    }



}