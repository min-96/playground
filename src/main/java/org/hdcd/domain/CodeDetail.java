package org.hdcd.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(exclude = "codeGroup")
@Entity
public class CodeDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeDetailNo;
	
	//private String groupCode;
	private String codeValue;
	private String codeName;
	private int sortSeq;
	private String useYn ="Y";
	@CreationTimestamp
	private LocalDateTime regDate;
	@UpdateTimestamp
	private LocalDateTime upDate;

	//다대일 단방향
	@ManyToOne
	@JoinColumn(name="group_code")
	private CodeGroup codeGroup;
}
