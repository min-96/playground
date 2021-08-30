package org.hdcd;


import org.hdcd.domain.Member;
import org.hdcd.domain.MemberDetail;
import org.hdcd.repository.MemberDetailRepository;
import org.hdcd.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.crypto.spec.OAEPParameterSpec;
import javax.transaction.Transactional;
import java.util.Optional;

@Commit
@SpringBootTest
public class MemberDetailTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberDetailRepository memberDetailRepository;

    //등록테스트
    @Transactional
    @Test
    public void testRegisterWithDetailAtTransactional() {
        Member member1 = new Member();
        member1.setUserId("jupiter");
        member1.setPassword("1234");

        MemberDetail memberDetail = new MemberDetail();
        memberDetail.setUserName("Alex");
        memberDetail.setEmail("jupiter@naver.com");
        memberDetail.setMember(member1);
        memberRepository.save(member1);

        memberDetailRepository.save(memberDetail);

    }

    //목록조회테스트
    @Test
    public void testList(){
        Iterable<MemberDetail> memberDetails = memberDetailRepository.findAll();

        for(MemberDetail memberDetail : memberDetails){
            System.out.println(memberDetail);

            System.out.println(memberDetail.getMember());
        }
    }

    @Test
    public void testReadWithMember(){
        Optional<MemberDetail> memberDetailOptional = memberDetailRepository.findById(1L);

        if(memberDetailOptional.isPresent()){
            MemberDetail memberDetail = memberDetailOptional.get();

            System.out.println(memberDetail);
            System.out.println(memberDetail.getMember());
        }
    }
    //수정테스트
    @Test
    public void testModify(){
        Optional<MemberDetail> memberDetailOptional = memberDetailRepository.findById(1L);

        if(memberDetailOptional.isPresent()){
            MemberDetail memberDetail = memberDetailOptional.get();
            memberDetail.setUserName("Alexsandra");
            memberDetailRepository.save(memberDetail);

            Iterable<MemberDetail> memberDetails = memberDetailRepository.findAll();

            for(MemberDetail m : memberDetails){
                System.out.println(m);
            }
        }
    }
}
