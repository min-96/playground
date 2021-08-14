package org.hdcd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hdcd.constant.Gender;
import org.hdcd.domain.Address;
import org.hdcd.domain.Member;
import org.hdcd.domain.QMember;
import org.hdcd.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;



@SpringBootTest
public class MemberTests {
	
	@Autowired
	MemberRepository memberRepository;



//	
//	@Test
//	public void testList() {
////		System.out.println("###_1 findAll before");
//		Iterable<Member> memberList = memberRepository.findAll();
////		System.out.println("###_1 fineAll after");
//		
//		for(Member member:memberList) {
//			System.out.println(member);
//		}
		
//		List<Long> idList = new ArrayList<>();
//		idList.add(2L);
//		idList.add(3L);
//		
//		Iterable<Member> memberList= memberRepository.findAllById(idList);
//		
//		for(Member member:memberList) {
//			System.out.println(member);
//		}
//	}
	
	
//	@Test
//	public void testList01() {
//		List<Member> memberList = memberRepository.findByUserId("user7");
//		
//		for(Member member : memberList) {
//			System.out.println(member);
//		}
//	}
//	
//	
//	@Test
//	public void testList02() {
//		Pageable pageRequest = PageRequest.of(0, 10,Sort.Direction.DESC,"userNo");
//		
//		Page<Member> page = memberRepository.findByUserNoGreaterThan(0L,pageRequest);
//		
//		int totalPages = page.getTotalPages();
//		
//		System.out.println(page);
//		System.out.println("totalPages:"+totalPages);
//		
//		Pageable pageable = page.getPageable();
//		
//		int pageNumber = pageable.getPageNumber();
//		int pageSize = pageable.getPageSize();
//	
//		System.out.println(pageable);
//		System.out.println("pageNumber"+pageNumber);
//		System.out.println("pageSize"+pageSize);
//		
//		List<Member> memberList = page.getContent();
//		for(Member member : memberList) {
//			System.out.println(member);
//		}
//	}
	
	
//	@Test
//	public void testList03() {
//		List<Member> memberList = memberRepository.findByUserIdAndfindByPassword("user7", "pw7");
//		for(Member member : memberList) {
//			System.out.println(member);
//		}
//	
//	}
//	@Test
//	public void testModify() {
//		Optional<Member> memberOptional = memberRepository.findById(2L);
//		
//		if(memberOptional.isPresent()) {
//			Member member = memberOptional.get();
//		member.setUserName("alexsanedress");
//		memberRepository.save(member);
//		}
//	}
	
	
	
//	
//	@Test
//	public void testRead() {
//		System.out.println("###_1 findById before");
//		Optional<Member> memberOtional= memberRepository.findById(2L);
//		System.out.println("###_1 findById after");
//		
//		if(memberOtional.isPresent()) {
//			Member member = memberOtional.get();
//			System.out.println(member);
//		}
//	}
//	
//	@Test
//	public void testModify() {
//		System.out.println("###_1 findById before");
//		Optional<Member> memberOtional = memberRepository.findById(3L);
//		System.out.println("###_1 findById after");
//		
//		if(memberOtional.isPresent()) {
//			Member member =memberOtional.get();
//			member.setUserName("nikey");
//			
//			memberRepository.save(member);
//			System.out.println(member);
//		}
//	}
//	
//	@Test
//	public void testDelete() {
//		memberRepository.deleteById(2L);
//		Iterable<Member> memberList = memberRepository.findAll();
//		for(Member member : memberList) {
//			System.out.println(member);
//			
//		}
//	}
//	
	

//	@Test
//	public void JPQLtest01() {
//		List<Member> memberList = memberRepository.getList01("user3");
//		
//		for(Member m : memberList) {
//			System.out.println(m);
//		}
//	}
////	
//	
//	@Test
//	public void JPQLtest02() {
//		List<Member> memberList = memberRepository.getList02("pw8");
//		for(Member m :memberList) {
//			System.out.println(m);
//		}
//		
//	}
//	
//	@Test
//	public void JPQLtest03() {
//		List<Member> memberList = memberRepository.getList03("min5");
//		for(Member m:memberList) {
//			System.out.println(m);
//		}
//	}
//	
//	@Test
//	public void JPQLtest04() {
//		Pageable pageRequest= PageRequest.of(0, 10,Sort.Direction.DESC,"userNo");
//		
//		List<Member> memberList=memberRepository.getList04(pageRequest);
//		
//		for(Member m : memberList) {
//			System.out.println(m);
//		}
//	}
//	
//	@Transactional
//	@Test
//	public void JPQLtest05() {
//		String userId="user1";
//		String newuserName = "roasd";
//		int count = memberRepository.updateMemberNameById(userId, newuserName);
//		System.out.println("count"+count);
//	}
//	
//	
	
	
//	
//	-------------------------------------------------
	
//	@Test
//	public void testRegister() {
//		for(int i=0; i<10; i++) {
//			long userNo=i+1;
//			Member member = new Member();
//			member.setUserId("user"+userNo);
//			member.setPassword("pw"+userNo);
//			member.setUserName("min"+userNo);
//			
//			memberRepository.save(member);
//		}
//	}
	//// Querydsl--------------------------------------------
//	@Test
//	public void testList01() {
//		//쿼리의 조건 설정인 where뒤의 조건을 생성해주는 것이라고 생각하면 된다.
//		BooleanBuilder builder = new BooleanBuilder();
//		QMember member = QMember.member;
//		//사용자 아이디 검색
//		builder.and(member.userId.eq("user7"));
//		
//		Iterable<Member> memberList = memberRepository.findAll(builder);
//		
//		for(Member m : memberList) {
//			System.out.println(m);
//		}
//	}
//	
//	@Test
//	public void testList02() {
//		BooleanBuilder builder = new BooleanBuilder();
//		QMember member = QMember.member;
//		builder.and(member.password.eq("pw8"));
//		Iterable<Member> memberList = memberRepository.findAll(builder);
//		for(Member m : memberList) {
//			System.out.println(m);
//		}
//	}
//	
//	
//	@Test
//	public void testList03() {
//		BooleanBuilder builder = new BooleanBuilder();
//		QMember member = QMember.member;
//		
//		builder.and(member.userName.like("%min%"));
//		Iterable<Member> memberList = memberRepository.findAll(builder);
//		for(Member m : memberList) {
//			System.out.println(m);
//		}
//	}
//	@Test
//	public void testList04() {
//		BooleanBuilder builder = new BooleanBuilder();
//		QMember member = QMember.member;
//		//userNo>5
//		builder.and(member.userNo.gt(5));
//		Iterable<Member> memberList =memberRepository.findAll(builder);
//		for(Member m : memberList) {
//			System.out.println(m);
//		}
//	}
//	
//	@Test
//	public void testList05() {
//		BooleanBuilder builder = new BooleanBuilder();
//		QMember member = QMember.member;
//		
//		builder.and(member.userNo.gt(0));
//		Pageable pageable = PageRequest.of(0, 10);
//		Page<Member> result = memberRepository.findAll(builder, pageable);
//		
//		List<Member> memberList = result.getContent();
//		for(Member m : memberList) {
//			System.out.println(m);
//		}
//	}	

//	@Test
//	public void testRegister() {
//		Member member1 = new Member();
//		member1.setUserId("jihyen");
//		member1.setPassword("1234");
//		memberRepository.save(member1);
//		
//		Member member2 = new Member();
//		member2.setUserId("mm");
//		member2.setPassword("0000");
//		memberRepository.save(member2);
//	}

	
	@Test
	public void testRegisterWithAddress() {
		//Member member = new Member();
		Optional<Member> memberOtional = memberRepository.findById(1L);
		
		if(memberOtional.isPresent()) {
			Member member = memberOtional.get();
			Address address = new Address("130-151","seoul");
			member.setAddress(address);
			memberRepository.save(member);
		}
		
	}
	
	@Test
	public void testRegisterWithAddress1() {
		Optional<Member> memberOptional = memberRepository.findById(2L);
		
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			Address address = new Address("758-11","Daejeon");
			member.setAddress(address);
			memberRepository.save(member);
		}
		
	}
}
