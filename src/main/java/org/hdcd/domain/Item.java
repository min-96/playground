package org.hdcd.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@ToString(exclude = "members")
@ToString
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
//    @Column(name = "item_no")
//    private Long itemNo;
    private String itemName;
    private Integer price;
    private String description;

    //컬럼에서 제외
    //비지니스로직에선 필요하지만 굳이 데이터관리를 하지 않아도 됨
    @Transient
    private MultipartFile picture;

    private String pictureUrl;


    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    private LocalDateTime upDate;
//    //다대다 양방향
//    @ManyToMany(mappedBy = "items")
//    private List<Member> members = new ArrayList<>();

//    public void addMember(Member member){
//        members.add(member);
//        member.getItems().add(this);
//    }

}
