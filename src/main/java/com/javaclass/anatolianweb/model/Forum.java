package com.javaclass.anatolianweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "forum",
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE,
            targetEntity = Comment.class,
            orphanRemoval = true)
    private Set comments=new HashSet<>();





    //private List<Comment> commentList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @JoinColumn(name = "user_id")

    //@NotFound(action = NotFoundAction.IGNORE)

    public Forum(String title, User user) {
        this.title = title;
        this.user = user;
        //List<Comment> commentLis
        // this.commentList = commentList;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


}
