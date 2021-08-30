package org.hdcd.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "members")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_no")
    private Long itemNo;
    private String itemName;
    private Integer price;
    private String description;

    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    private LocalDateTime upDate;
    //다대다 양방향
    @ManyToMany(mappedBy = "items")
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        members.add(member);
        member.getItems().add(this);
    }

}
