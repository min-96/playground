package org.hdcd.service;

import lombok.RequiredArgsConstructor;
import org.hdcd.domain.Member;
import org.hdcd.domain.MemberAuth;
import org.hdcd.repository.MemberAuthRepository;
import org.hdcd.repository.MemberRepository;
import org.hdcd.service.MemberService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    public final MemberRepository memberRepository;
    public  final MemberAuthRepository memberAuthRepository;


    //회원은 반드시 하나의 권환을 가진다는 비지니스 규칙
    //회원과 회원권한 테이블이 각각 개별로 존재하지만 회원정보를 저장할땐
    //반드시 회원권한 정보를 동시에 저장해야한다.
    @Transactional
    @Override
    public void register(Member member) throws Exception {
        Member memberEntity = new Member();
        memberEntity.setUserId(member.getUserId());
        memberEntity.setPassword(member.getPassword());
        memberEntity.setUserName(member.getUserName());

        memberRepository.save(memberEntity);

        MemberAuth memberAuthEntity = new MemberAuth();
        //회원권한값은 6이내의 길이의 문자열이다.
        //6이상이면 예외발생.
        memberAuthEntity.setAuth("User");
        memberAuthEntity.setUserNo(memberEntity.getUserNo());

        memberAuthRepository.save(memberAuthEntity);

    }
}
