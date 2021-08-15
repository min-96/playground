package org.hdcd.domain;

import java.time.YearMonth;

import javax.persistence.Embeddable;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Card {
	//@NotBlank
	private String no;
	//@Future // 미래날짜인지 검증
	//@DateTimeFormat(pattern="yyyy-MM")
	private String validMonth;

}
