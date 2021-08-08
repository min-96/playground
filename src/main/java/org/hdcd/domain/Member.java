//package org.hdcd.domain;
//
//
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.Valid;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Future;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Size;
//
//import org.hdcd.constant.Gender;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import groovy.transform.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
////@NoArgsConstructor
////@RequiredArgsConstructor
//@ToString
//@Entity
//@EqualsAndHashCode // 필드명으로 userNo equal과 hascode
//public class Member {
//	
//	@Id // 프라이머키
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	//주키의 값을 자동생성 전략명시 DB의 identity 컬럼을 이용
//	private Long userNo;
//	
//	//@NotBlank //입력값 검증 규칙을 지정한다
//	private String userId;
//	private String password;
//	//@NotBlank
//	//@Size(max=3) // 여러개의 입력값 검증 규칙을 지정할수있다
//	private String userName;
//	//enum 이름을 db에 저장 // 문자열로
//	@Enumerated(EnumType.STRING)
//	private Gender gender;
//	//private int coin;
//	//@Future
//	//@Past // 과거날짜인지를 검사
////	@DateTimeFormat(pattern="yyyy-MM-dd")
////	private LocalDate dateOfBirth;
//	
//	@Temporal(TemporalType.DATE) // db에 데이터타입과 일치
//	private LocalDateTime joinDate;
//	
//	@CreationTimestamp // insert 자동시간
//	private LocalDateTime regDate;
//	
//	@UpdateTimestamp // update 자동시간
//	private LocalDateTime upDate;
//	
//	
//	
//	
////	@Email // 이메일형식인지 검증
////	private String email;
////	
////	private String developer;
//	
//	
//	
//	//중첩된 자바빈즈의 입력값 검증 지정
////	@Valid
////	private Address address;
////	//자바빈즈 컬렉션의 입력값 검증을 지정
////	@Valid
////	private List<Card> cardList;
//	
////	private String[] carArray;
////	private List<String> carList;
////	
//
//
//}
