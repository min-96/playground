package org.hdcd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//사용자 정의 인터페이스
public interface CustomMemberRepository {
	
	public Page<Object[]> getSearchPage(String type,String keyword,Pageable page);

}
