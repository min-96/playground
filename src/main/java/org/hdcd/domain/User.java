package org.hdcd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @Column(name = "user_name")
    private String userName;
    private String userPw;

    private String enabled;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_name")
    private List<Authoritys> authList = new ArrayList<>();
}
