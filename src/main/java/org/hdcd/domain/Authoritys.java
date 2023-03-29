package org.hdcd.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Authoritys {
    @Id
    @Column(name = "user_name")
    private String userName;

    private String authority;
}
