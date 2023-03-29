package org.hdcd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "member_auth")
public class MemberAuth{


    @Column(length = 50)
    private String auth;

    @Id
    @Column(name = "user_auth_no")
    private Long userAuthNo;

    @Column(name ="user_no")
    private Long userNo;

}
