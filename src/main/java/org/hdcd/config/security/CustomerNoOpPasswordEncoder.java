package org.hdcd.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

//비밀번호 암호화 처리기 클래스 정의
@Slf4j
public class CustomerNoOpPasswordEncoder implements PasswordEncoder {

//비밀번호 단방향
    @Override
    public String encode(CharSequence charSequence) {
        log.info("before encode : "+charSequence);
        return charSequence.toString();
    }
    //암호화 된 비밀번호와 암호화되지않은 비밀번호가 일치한지 비교
    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
      log.info("matches : "+ charSequence+":"+encodedPassword);

        return charSequence.toString().equals(encodedPassword);
    }

}
