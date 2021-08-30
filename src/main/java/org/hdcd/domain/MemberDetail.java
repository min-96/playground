package org.hdcd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Entity
@Table(name="member_detail")
public class MemberDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_detail_no")
    private Long memberDetailNo;
    private String userName;
    private String email;
    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    private LocalDateTime upDate;


    //일대일 단방향2정
//    @Column(name = "user_no")
//    private Long userNo;
//    //일대일 단방향
//
//    //오ㅣ래키
//    @OneToOne
//    @JoinColumn(name="user_no")
//    private Member member;
}
