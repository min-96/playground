package org.hdcd.domain;



import java.time.LocalDate;

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

}
