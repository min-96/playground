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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAuthNo;

    @Column(length = 6)
    private String auth;

    private Long userNo;

}
