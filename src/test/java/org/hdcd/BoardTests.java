package org.hdcd;

import org.hdcd.domain.Board;
import org.hdcd.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTests {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void testRegister() {
		for(int i=0; i<30; i++) {
			long userNo=i+1;
			Board board= new Board();
			board.setTitle("게시글"+userNo);
			board.setWriter("미뇽"+userNo);
			board.setContent("내용"+userNo);
			
			boardRepository.save(board);
		}
	}
	
//	@Test
//	public void testRemove() {
//		boardRepository.deleteAll();
//	}
}
