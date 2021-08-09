package org.hdcd.repository;

import java.util.List;

import org.hdcd.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//엔티티 클래스로 데이터베이스에 접근하게 해주는 repository 인터페이스 생성
public interface MemberRepository extends CrudRepository<Member,Long>,QuerydslPredicateExecutor<Member> {
	//사용자 아이디를 동등 검색 조건으로 사용하는 쿼리
	public List<Member> findByUserId(String userId);
//	public List<Member> findByPassword(String password);
	
//	public List<Member> findByUserIdAndfindByPassword(String userId, String password);
	
//	public List<Member> findByUserNameContaining(String userName);
	
	//페이징 
	
//	public Page<Member> findByUserNoGreaterThan(Long userNo, Pageable pageable);

	//-------------------JPQL------------------------
//	@Query("SELECT m FROM Member m WHERE m.userId=?1")
//	public List<Member> getList01(String userId);
//
//	@Query("SELECT m FROM Member m WHERE m.password=:password")
//	public List<Member> getList02(@Param("password")String password);
//
//	@Query("SELECT m FROM Member m WHERE m.userName LIKE %?1%")
//	public List<Member> getList03(String userName);
//	
//	@Query("SELECT m FROM Member m WHERE m.userNo>0 ORDER BY m.userNo DESC")
//	public List<Member> getList04(Pageable pageable);
//	
//	
//	
//	@Modifying // 지정한 레파지토리 메소드를 호출하여데이터베이스의 컬럼내용을 수정
//	@Query("UPDATE FROM Member m SET m.userName=?2 WHERE m.userId=?1")
//	public int updateMemberNameById(String userId, String userName);
	
	
	
}
