package org.hdcd.domain;




import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hdcd.constant.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@NoArgsConstructor
//@RequiredArgsConstructor
@ToString
//jpa의 엔티티임을 의미
@Entity
@EqualsAndHashCode // 필드명으로 userNo equal과 hascode
public class Member {
	
	@Id // 프라이머키
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_no")
	//주키의 값을 자동생성 전략명시 DB의 identity 컬럼을 이용
	private Long userNo;
	
	//@NotBlank //입력값 검증 규칙을 지정한다
	//@Column(name="uid", length=50, nullable=false)
	private String userId;
	//@Column(name="upw", length=100, nullable=false)
	private String password;
	
	
	
	//@Embedded
	//private Address address;
	
	
	//@NotBlank
	//@Size(max=3) // 여러개의 입력값 검증 규칙을 지정할수있다
	//@Column(name="uname", length=100,nullable=false)
	//private String userName;
	
	
	//enum 이름을 db에 저장 // 문자열로
	//@Enumerated(EnumType.STRING)
	//private Gender gender;
	
	
	//private int coin;
	//@Future
	//@Past // 과거날짜인지를 검사
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private LocalDate dateOfBirth;
	
	//@Temporal(TemporalType.DATE) // 자바util date 타입을 매핑할때는 @Temporal어테테이션사용
	//@CreationTimestamp
//	private LocalDateTime joinDate;
	
	//하이버네이트가 제공하는 기능으로 엔티티가 생성되거나 업데이트되는 시점의 날짜 데이터를 기록하는 설정
	
	@CreationTimestamp // insert 자동시간
	private LocalDateTime regDate;
	
	@UpdateTimestamp // update 자동시간
	private LocalDateTime upDate;

	//일대일 단방향 2
	// 양방향 일 때 mapperBy 설정
	//주인이 아닌 Member.memberDetail 에는 mapperdBy=member 속성을 사용해서 주인아님을 설정
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_no")
	private MemberDetail memberDetail;



	
//	@Email // 이메일형식인지 검증
//	private String email;
//	
//	private String developer;
	
	
	
	//중첩된 자바빈즈의 입력값 검증 지정
//	@Valid
//	private Address address;
//	//자바빈즈 컬렉션의 입력값 검증을 지정
//	@Valid
	
	//컬렉션을 테이블로 생성하여 1:n 관계를 다룬다
	
//	@ElementCollection
//	@CollectionTable(
//	name="member_card",
//	joinColumns =  @JoinColumn(name="user_no"))
//	@OrderBy("user_no desc")
//	private List<Card> cardList;
//
//
//
//
//	public Card getCard(int i) {
//		// TODO Auto-generated method stub
//		return cardList.get(i);
//	}
	
//	private String[] carArray;
//	private List<String> carList;
//	


}
