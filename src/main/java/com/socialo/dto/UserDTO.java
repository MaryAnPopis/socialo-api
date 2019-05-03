package com.socialo.dto;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private boolean status;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="user" )
    private List<PostDTO> posts;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST
            })
    @JoinTable(name = "users_tags",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<TagDTO> tags;

    public UserDTO() {
    }

    public UserDTO(String nickname) {
        this.nickname = nickname;
    }

    public UserDTO(String nickname, boolean status) {
        this.nickname = nickname;
        this.status = status;
    }


    public UserDTO(String nickname, boolean status, List<PostDTO> posts, Set<TagDTO> tags) {
        this.nickname = nickname;
        this.status = status;
        this.posts = posts;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public List<PostDTO> getPosts() {
        return posts;
   }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }


    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }


}
