package org.hdcd.service;

import java.util.List;



//import org.hdcd.dao.BoardDao;
import org.hdcd.domain.Board;
import org.hdcd.repository.BoardRepository;
import org.hdcd.vo.PageRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	//@Autowired
	//private BoardDao dao;

	//private final BoardDao dao;
	
	private final BoardRepository repository;
	
	@Override
	@Transactional
	public void register(Board board) throws Exception {
//		repository.save(board);
		repository.save(board);
	}

	@Override
	@Transactional(readOnly=true) // 읽기전용
	public List<Board> list() throws Exception {
		return repository.findAll(Sort.by(Direction.DESC, "boardNo"));
		
		//return dao.list();
	}

	
	
	@Override
	@Transactional(readOnly=true) // 읽기전용
	public Board read(Long boardNo) throws Exception {
		// TODO Auto-generated method stub
		return repository.getOne(boardNo);
	}

	@Override
	@Transactional
	public void remove(Long boardNo) {
		repository.deleteById(boardNo);
	}

	@Override
	@Transactional
	public void modify(Board board) {
		Board boardEntity = repository.getOne(board.getBoardNo());
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		
		//repository.modify(board);
	}

	@Override
	public Page<Board> list(PageRequestVO pageRequestVO) {
		int pageNumber =pageRequestVO.getPage()-1;
		
		int sizePerPage = pageRequestVO.getSizePerPage();
		//정렬방향과 속성이 적용된 pageRequest를 생성한다
		Pageable pageRequest = PageRequest.of(pageNumber,sizePerPage,Sort.Direction.DESC,"boardNo");
		Page<Board> page = repository.findAll(pageRequest);
		
		return page;
	}

}
