package org.hdcd.domain;



import java.time.LocalDate;
import java.util.List;

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
	
	private String userId;
	private String password;
	private int coin;
	@DateTimeFormat(pattern="yyyyMMdd")
	private LocalDate dateOfBirth;
	
	private String developer;
	
	private Address address;
	
	private List<Card> cardList;
	
	private String[] carArray;
	private List<String> carList;

}
