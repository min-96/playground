package org.hdcd.repository;

import java.util.List;

import org.hdcd.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	//검색 쿼리 JPA
	
	public List<Board>
	findByBoardNoGreaterThanOrderByBoardNoDesc(Long boardNo);

	public List<Board>
	findByTitleContainingOrderByBoardNoDesc(String title);
	
	public List<Board>
	findByWriterContainingOrderByBoardNoDesc(String writer);
	
	public List<Board>
	findByContentContainingOrderByBoardNoDesc(String content);
	
	public List<Board>
	findByTitleContainingOrContentContainingOrderByBoardNoDesc(String title,String content);
	
	public List<Board>
	findByAllContainingOrderByDesc(String title, String writer,String content);
	
}
