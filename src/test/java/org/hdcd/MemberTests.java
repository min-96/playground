package org.hdcd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hdcd.constant.Gender;
import org.hdcd.domain.*;
import org.hdcd.repository.MemberDetailRepository;
import org.hdcd.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import org.springframework.test.annotation.Commit;


@Commit
@SpringBootTest
public class MemberTests {
	
	@Autowired
	MemberRepository memberRepository;

	@Autowired
	MemberDetailRepository memberDetailRepository;


//	@Test
//	public void testRegister(){
//		Member member1 = new Member();
//		member1.setUserId("jupitar");
//		member1.setPassword("1234");
//		member1.setUserName("minyong");
//		member1.setRegDate(LocalDateTime.now());
//
//		memberRepository.save(member1);
//
//	}


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
//
	@Test
	public void testRegister() {
		Member member1 = new Member();
		member1.setUserId("jihyen");
		member1.setPassword("1234");
		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setUserId("mm");
		member2.setPassword("0000");
		memberRepository.save(member2);

		Member member3 = new Member();
		member3.setUserId("sdaas");
		member3.setPassword("12344");
		memberRepository.save(member3);
	}

	@Test
	@Transactional
	public void testRegisterWithDetailAtTransactional(){

		Long userNo = 1L;
		Member member1 = new Member();
		member1.setUserNo(userNo);
		member1.setUserId("jupiter");
		member1.setPassword("1234");

		MemberDetail memberDetail = new MemberDetail();
		memberDetail.setUserNo(userNo);
		memberDetail.setUserName("Alex");
		memberDetail.setEmail("ajdcnd131@naver.com");
		member1.setMemberDetail(memberDetail);

		memberRepository.save(member1);

	}

//	@Transactional
//	@Test
//	public void testRegisterWithDetailAtTransactional(){
//		Optional<Member> memberOptional= memberRepository.findById(1L);
//
//		if(memberOptional.isPresent()){
//			Member member = memberOptional.get();
//			MemberDetail memberDetail = new MemberDetail();
//			memberDetail.setUserName("Alex");
//			memberDetail.setEmail("ajdcbd1312@namver.com");
//
//			memberRepository.save(member);
//		}
//	}



//	
//	@Test
//	public void testRegisterWithAddress() {
//		//Member member = new Member();
//		Optional<Member> memberOtional = memberRepository.findById(1L);
//		
//		if(memberOtional.isPresent()) {
//			Member member = memberOtional.get();
//			Address address = new Address("130-151","seoul");
//			member.setAddress(address);
//			memberRepository.save(member);
//		}
//		
//	}
//	
//	@Test
//	public void testRegisterWithAddress1() {
//		Optional<Member> memberOptional = memberRepository.findById(2L);
//		
//		if(memberOptional.isPresent()) {
//			Member member = memberOptional.get();
//			Address address = new Address("758-11","Daejeon");
//			member.setAddress(address);//
//			memberRepository.save(member);
//		}
//		
//	}
//	@Test
//	public void testResisterCollection() {
//		Member member = new Member();
//		member.setUserId("ggnyong");
//		member.setPassword("1234");
//		
//		List<Card> cardList = new ArrayList<>();
//		//Card card = new Card();
//		cardList.add(new Card("262-124-544","202301"));
//		cardList.add(new Card("356-124-45645","202501"));
//		member.setCardList(cardList);
//		memberRepository.save(member);
//
//
//		
//	}
//	
	
	//findAll 메서드로 회원정보를 출력할때 toString() 과정에서 카드정보를
	//가져와야되는데 @elementCoolection 은 기본적으로 fetch 속성이 fetchType.Lazy라서 에러발생
	//에러가 발생하지 않게 @Teasaction으로 하나의 트랜잭션의 범위로 지정해야한다
//	@Transactional
//	@Test
//	public void testList() {
//		Iterable<Member> members = memberRepository.findAll();
//		
//		for(Member m : members) {
//			System.out.println(m);
//			List<Card> cardList = m.getCardList();
//			for(Card card : cardList) {
//				System.out.println(card);
//			}
//		}
//	}
//	@Transactional
//	@Test
//	public void testReadAtTransctional() {
//		Optional<Member> memberOptional = memberRepository.findById(1L);
//		
//		if(memberOptional.isPresent()) {
//			Member member = memberOptional.get();
//			System.out.println(member);
//		}
//	}
	
//	@Transactional
//	@Test
//	public void testModifyAtTranscational() {
//		Optional<Member> memberOptional = memberRepository.findById(1L);
//		
//		if(memberOptional.isPresent()) {
//			Member member =memberOptional.get();
//		Card card = member.getCard(0);
//		card.setValidMonth("202804");
//		memberRepository.save(member);
//		
//			
//			
//		}
//	}

//	@Transactional
//	@Test
//	public void testRegisterWithDetailAtTransactional() {
//		Member member1 = new Member();
//		member1.setUserId("jupiter");
//		member1.setPassword("1234");
//
//		MemberDetail memberDetail = new MemberDetail();
//		memberDetail.setUserName("Alex");
//		memberDetail.setEmail("jupiter@naver.com");
//		memberDetail.setMember(member1);
//		memberRepository.save(member1);
//
//		memberDetailRepository.save(memberDetail);
//
//	}

//
//
//	@Test
//	public void testRemoveWithDetail(){
//		memberDetailRepository.deleteAll();
//		memberRepository.deleteAll();
//	}


}
