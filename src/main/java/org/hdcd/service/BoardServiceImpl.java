package org.hdcd.service;

import java.util.List;

import org.hdcd.dao.BoardDao;
import org.hdcd.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;

	@Override
	public void register(Board board) throws Exception {
		dao.create(board);
	}

	@Override
	public List<Board> list() throws Exception {
		
		return dao.list();
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(boardNo);
	}

	@Override
	public void remove(int boardNo) {
		dao.remove(boardNo);
	}

	@Override
	public void modify(Board board) {
		dao.modify(board);
	}

}
