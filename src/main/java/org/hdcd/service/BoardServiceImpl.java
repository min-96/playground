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
	public List<Board> list(PageRequestVO pageRequestVO) throws Exception {
		//return repository.findAll(Sort.by(Direction.DESC, "boardNo"));
		//검색
				String searchType=pageRequestVO.getSearchType();
				String keyword = pageRequestVO.getKeyword();
				
				List<Board> list = null;
				if(searchType!=null &&searchType.length()>0) {
					if(searchType.equals("t")) {
					list=repository.findByTitleContainingOrderByBoardNoDesc(keyword);
				}
					else if(searchType.equals("c")) {
						list=repository.findByContentContainingOrderByBoardNoDesc(keyword);			
					}
					else if(searchType.equals("w")) {
						list=repository.findByWriterContainingOrderByBoardNoDesc(keyword);
					}
					else if(searchType.equals("tc")) {
						list= repository.findByTitleContainingOrContentContainingOrderByBoardNoDesc(keyword, keyword);
					}
					else if(searchType.equals("twc")) {
						list=repository.findByAllContainingOrderByDesc(keyword, keyword, keyword);
					}
					else {
						list= repository.listAll();
					}
				}
				else {
					list=repository.listAll();
				}
				return list;
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
	public Page<Board> Plist(PageRequestVO pageRequestVO) {
		int pageNumber =pageRequestVO.getPage()-1;
		
		int sizePerPage = pageRequestVO.getSizePerPage();
		//정렬방향과 속성이 적용된 pageRequest를 생성한다
		Pageable pageRequest = PageRequest.of(pageNumber,sizePerPage,Sort.Direction.DESC,"boardNo");
		Page<Board> page = repository.findAll(pageRequest);
		
		
		
		return page;
	}

}
