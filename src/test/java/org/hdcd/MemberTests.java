package org.hdcd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hdcd.constant.Gender;
import org.hdcd.domain.Member;
import org.hdcd.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

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
	

	@Test
	public void JPQLtest01() {
		List<Member> memberList = memberRepository.getList01("user3");
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
//	
	
	@Test
	public void JPQLtest02() {
		List<Member> memberList = memberRepository.getList02("pw8");
		for(Member m :memberList) {
			System.out.println(m);
		}
		
	}
	
	@Test
	public void JPQLtest03() {
		List<Member> memberList = memberRepository.getList03("min5");
		for(Member m:memberList) {
			System.out.println(m);
		}
	}
	
	@Test
	public void JPQLtest04() {
		Pageable pageRequest= PageRequest.of(0, 10,Sort.Direction.DESC,"userNo");
		
		List<Member> memberList=memberRepository.getList04(pageRequest);
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	@Transactional
	@Test
	public void JPQLtest05() {
		String userId="user1";
		String newuserName = "roasd";
		int count = memberRepository.updateMemberNameById(userId, newuserName);
		System.out.println("count"+count);
	}
	
	
}
