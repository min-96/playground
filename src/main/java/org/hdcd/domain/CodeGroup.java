package org.hdcd.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString(exclude = "codeDetails")
@ToString
@Entity
public class CodeGroup {
	@Id
	private String groupCode;
	private String groupName;
	private String useYn ="Y";

	@CreationTimestamp
	private LocalDateTime regDate;
	
	@UpdateTimestamp
	private LocalDateTime upDate;
	
	//Entity의 상태는 크게 4가지 종류가 있다.
//	1. Transient: 객체를 생성하고, 값을 주어도 JPA나 hibernate가 그 객체에 관해 아무것도 모르는 상태. 즉, 데이터베이스와 매핑된 것이 아무것도 없다.
//	2. Persistent: 저장을 하고나서, JPA가 아는 상태(관리하는 상태)가 된다. 그러나 .save()를 했다고 해서, 이 순간 바로 DB에 이 객체에 대한 데이터가 들어가는 것은 아니다. JPA가 persistent 상태로 관리하고 있다가, 후에 데이터를 저장한다.(1차 캐시, Dirty Checking(변경사항 감지), Write Behind(최대한 늦게, 필요한 시점에 DB에 적용) 등의 기능을 제공한다)
//	3. Detached: JPA가 더이상 관리하지 않는 상태. JPA가 제공해주는 기능들을 사용하고 싶다면, 다시 persistent 상태로 돌아가야한다.
//	4. Removed: JPA가 관리하는 상태이긴 하지만, 실제 commit이 일어날 때, 삭제가 일어난다.
//
//	cascade는 이러한 상태변화를 전이시키는 것이다.
	
	//코드그룹은 여러 코드상세를 가질 수 있다 
	//코드그룹은 코드상세에 접근가능하지만 코드상세는 코드그룹에 접근 불가능
	//mapperBy 속성은 양방향매핑일때 사용하는데 반대쪽 매핑의 필드 이름을 값으로
	//주면된다.
	@OneToMany(mappedBy = "codeGroup",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name="groupCode")
	private List<CodeDetail> codeDetails;
	//코드상세는 codeGroup 필드를 통해서 코드그룹에 접근할수있고 반대로
	//코드그룹은 codeDetail 필드를 통해서 코드상세에 접근할수있다.


	//한번에 양방향 관계를 설정하는 메서드.
	public void addCodeDetail(CodeDetail codeDetail){
		codeDetail.setCodeGroup(this);
		this.codeDetails.add(codeDetail);
	}

	

}
