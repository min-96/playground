package org.hdcd.repository;

import java.util.List;

import org.hdcd.domain.Member;
import org.springframework.data.repository.CrudRepository;

//엔티티 클래스로 데이터베이스에 접근하게 해주는 repository 인터페이스 생성
public interface MemberRepository extends CrudRepository<Member,Long> {
	//사용자 아이디를 동등 검색 조건으로 사용하는 쿼리
	public List<Member> findByUserId(String userId);
	public List<Member> findByPassword(String password);
	
	public List<Member> findByUserIdAndfindByPassword(String userId,String password);
	public List<Member> findByUserNameContaining(String userName);
	
}
