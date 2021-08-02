package org.hdcd.domain;



import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@ToString
public class Member {
	
	@NotBlank //입력값 검증 규칙을 지정한다
	private String userId;
	private String password;
	@NotBlank
	@Size(max=3) // 여러개의 입력값 검증 규칙을 지정할수있다
	private String userName;
	private int coin;
	//@Future
	@Past // 과거날짜인지를 검사
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	@Email
	private String email;
	
	private String developer;
	//중첩된 자바빈즈의 입력값 검증 지정
	@Valid
	private Address address;
	//자바빈즈 컬렉션의 입력값 검증을 지정
	@Valid
	private List<Card> cardList;
	
	private String[] carArray;
	private List<String> carList;
	
	private String gender;

}
