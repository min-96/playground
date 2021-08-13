package org.hdcd.repository;

import java.util.List;

import org.hdcd.domain.Board;
import org.hdcd.domain.QBoard;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

public class BoardRepositoryImpl extends QuerydslRepositorySupport implements CustomerBoardRepository{

	public BoardRepositoryImpl() {
		super(Board.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Board> listAll() {
		QBoard board =QBoard.board;
		JPQLQuery<Board> query = from(board);
		query.where(board.boardNo.gt(0L));
		query.orderBy(board.boardNo.desc());
		return query.fetch();
	}

	@Override
	public List<Board> SearchByTitle(String title) {
		QBoard board= QBoard.board;
		JPQLQuery<Board> query = from(board);
		query.where(board.title.like("%"+title+"%"));
		query.orderBy(board.boardNo.desc());
		return query.fetch();
	}

	@Override
	public List<Board> SearchByWriter(String writer) {
		QBoard board= QBoard.board;
		JPQLQuery<Board> query = from(board);
		query.where(board.writer.like("%"+writer+"%"));
		query.orderBy(board.boardNo.desc());
		return query.fetch();
	}

	@Override
	public List<Board> SearchByContent(String content) {
		QBoard board= QBoard.board;
		JPQLQuery<Board> query = from(board);
		query.where(board.content.like("%"+content+"%"));
		query.orderBy(board.boardNo.desc());
		return query.fetch();
	}

	@Override
	public List<Board> SearchByTitleOrContent(String title, String content) {
		QBoard board= QBoard.board;
		JPQLQuery<Board> query = from(board);
		query.where(board.title.like("%"+title+"%").or(board.content.like("%"+content+"%")));
		query.orderBy(board.boardNo.desc());
		return query.fetch();
	}

	@Override
	public List<Board> searchByTitleOrWriterOrContnet(String title, String writer, String content) {
		QBoard board= QBoard.board;
		JPQLQuery<Board> query = from(board);
		query.where(board.title.like("%"+title+"%").or(board.content.like("%"+content+"%").or(board.writer.like("%"+writer+"%"))));
		query.orderBy(board.boardNo.desc());
		return query.fetch();
	}

}
