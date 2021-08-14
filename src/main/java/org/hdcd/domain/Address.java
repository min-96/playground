package org.hdcd.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
//임베디드 타입
//엔티티에 클리스에 밸류타입 클래스를포함시킬수있음
public class Address {
	//@NotBlank
	private String postCode;
	//@NotBlank
	private String location;
}
