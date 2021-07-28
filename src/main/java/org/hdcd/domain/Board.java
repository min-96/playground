package org.hdcd.domain;

import java.time.LocalDateTime;

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
//@NoArgsConstructor //인자가 없는 기본 생성자를 생성
//@AllArgsConstructor //모든 인자로 갖는 생성자 생성
@RequiredArgsConstructor //nonnull이 적용된 필드값이나 final로 선언된 필드값만 인자로 받는 생성자 생성
@EqualsAndHashCode(of="boardNo")
//@ToString
@ToString(exclude="regDate") // regDate 제외한 toString 메소드 생성
public class Board {
	private int boardNo;
	@NonNull
	private String title;
	@NonNull
	private String content;
	private String writer;
	private LocalDateTime regDate;
	

}
