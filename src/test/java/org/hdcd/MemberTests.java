package org.hdcd;

import java.time.LocalDateTime;
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

//	@Test
//	public void testRegister() {
//		Member member1= new Member();
//		member1.setUserId("jupiter");
//		member1.setPassword("1234");
//		member1.setUserName("Alex");
//		member1.setGender(Gender.FEMALE);
//		member1.setJoinDate(LocalDateTime.now());
//
//		System.out.println("###_1 save before");
//		memberRepository.save(member1);
//		System.out.println("###_1 save after");
//		
//		
//		Member member2 = new Member();
//		member2.setUserId("orange");
//		member2.setPassword("0000");
//		member2.setUserName("Tyler");
//		member2.setGender(Gender.MALE);
//		member2.setJoinDate(LocalDateTime.now());
//		
//		System.out.println("###_1 save before");
//		memberRepository.save(member2);
//		System.out.println("###_2 save after");
//	}
	
	@Test
	public void testList() {
		System.out.println("###_1 findAll before");
		Iterable<Member> memberList = memberRepository.findAll();
		System.out.println("###_1 fineAll after");
		
		for(Member member:memberList) {
			System.out.println(member);
		}
	}
	
	@Test
	public void testRead() {
		System.out.println("###_1 findById before");
		Optional<Member> memberOtional= memberRepository.findById(2L);
		System.out.println("###_1 findById after");
		
		if(memberOtional.isPresent()) {
			Member member = memberOtional.get();
			System.out.println(member);
		}
	}
	
	@Test
	public void testModify() {
		System.out.println("###_1 findById before");
		Optional<Member> memberOtional = memberRepository.findById(3L);
		System.out.println("###_1 findById after");
		
		if(memberOtional.isPresent()) {
			Member member =memberOtional.get();
			member.setUserName("nikey");
			
			memberRepository.save(member);
			System.out.println(member);
		}
	}
	
	@Test
	public void testDelete() {
		memberRepository.deleteById(1L);
		Iterable<Member> memberList = memberRepository.findAll();
		for(Member member : memberList) {
			System.out.println(member);
			
		}
	}
	
}
