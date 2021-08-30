package org.hdcd.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@IdClass(UserItemId.class) //복합키
public class UserItem {
    //다대일 연관
    @Id
    @ManyToOne
    @JoinColumn(name = "user_no")
    private Member member;

    //다대일 연관
    @Id
    @ManyToOne
    @JoinColumn(name = "item_no")
    private Item item;

    private int amount;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime upDate;

}
