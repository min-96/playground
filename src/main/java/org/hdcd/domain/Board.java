package org.hdcd.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
//@Table(name="board")
//@NoArgsConstructor //인자가 없는 기본 생성자를 생성
//@AllArgsConstructor //모든 인자로 갖는 생성자 생성
//@RequiredArgsConstructor //nonnull이 적용된 필드값이나 final로 선언된 필드값만 인자로 받는 생성자 생성
//@EqualsAndHashCode(of="boardNo")
@ToString
//@ToString(exclude="regDate") // regDate 제외한 toString 메소드 생성
public class Board {
	//키본 키 자동생성전략
	//기본키를 이용해 데이터베이스에 위임
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="board_no")
	private Long boardNo;
	//@NonNull
	//@NotBlank
	//@Column(name="title")
	@NotBlank
	private String title;
	//@NonNull
	//@Column(name="content")
	@Lob
	private String content;
	
	//@Column(name="writer")
	@Size(max=3)
	private String writer;
	
	//@Column(name="reg_date")
	//@CreationTimestamp
	@CreationTimestamp
	private LocalDateTime regDate;
	@UpdateTimestamp
	private LocalDateTime upDate; 

}
