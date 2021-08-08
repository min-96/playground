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

@SpringBootTest
public class MemberTests {
	
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void testRegister() {
		
//		List<Member> memberList = new ArrayList<>();
//		Member member1= new Member();
//		member1.setUserId("akdcnd23");
//		member1.setPassword("1234");
//		member1.setUserName("rosita");
//		member1.setGender(Gender.FEMALE);
//		
//
//		memberList.add(member1);
////		System.out.println("###_1 save before");
////		memberRepository.save(member1);
////		System.out.println("###_1 save after");
//		
//		
//		Member member2 = new Member();
//		member2.setUserId("bans23");
//		member2.setPassword("0000");
//		member2.setUserName("beronica");
//		member2.setGender(Gender.MALE);
//		
//		
//		memberList.add(member2);
//		memberRepository.saveAll(memberList);
		
		
		for(int i=0; i<10; i++) {
			long userNo = i+1;
			Member member = new Member();
			member.setUserId("user"+userNo);
			member.setPassword("pw"+userNo);
			member.setUserName("min"+userNo);
			memberRepository.save(member);
		
		}
	}
	
	@Test
	public void testList() {
//		System.out.println("###_1 findAll before");
		Iterable<Member> memberList = memberRepository.findAll();
//		System.out.println("###_1 fineAll after");
		
		for(Member member:memberList) {
			System.out.println(member);
		}
		
//		List<Long> idList = new ArrayList<>();
//		idList.add(2L);
//		idList.add(3L);
//		
//		Iterable<Member> memberList= memberRepository.findAllById(idList);
//		
//		for(Member member:memberList) {
//			System.out.println(member);
//		}
	}
	
	
	@Test
	public void testList01() {
		List<Member> memberList = memberRepository.findByUserId("user7");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	
	
	
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
	

	
}
