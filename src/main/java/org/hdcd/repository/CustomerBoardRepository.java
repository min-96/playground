package org.hdcd.repository;

import java.util.List;

import org.hdcd.domain.Board;

//사용자 인터페이스
public interface CustomerBoardRepository {
	
	public List<Board> listAll();
	public List<Board>  SearchByTitle(String title);
	public List<Board> SearchByWriter(String writer);
	public List<Board> SearchByContent(String content);
	public List<Board> SearchByTitleOrContent(String title,String content);
	public List<Board> searchByTitleOrWriterOrContnet(String title,String writer,String content);


}

