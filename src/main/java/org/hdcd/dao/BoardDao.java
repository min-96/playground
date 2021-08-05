package org.hdcd.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hdcd.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDao {
	
	//필드기반 의존성 주입
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Board board) {
		String query ="INSERT INTO board(title,writer,content) VALUES (?,?,?)";
		jdbcTemplate.update(query,board.getTitle(),board.getWriter(),board.getContent());
	}

	public List<Board> list() {
		List<Board> results =jdbcTemplate.query("SELECT * FROM board WHERE board_no>0 ORDER BY board_no desc,reg_date DESC",
				new RowMapper<Board>() {

					@Override
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board board = new Board();
						
						board.setBoardNo(rs.getInt("board_no"));
						board.setTitle(rs.getString("title"));
						board.setWriter(rs.getString("writer"));
						board.setContent(rs.getString("content"));
						Timestamp timestamp = rs.getTimestamp("reg_date");
						board.setRegDate(timestamp.toLocalDateTime());
						return board;
					}
			
			
		});
		return results;
	}

	public Board read(Integer boardNo) {
		List<Board> results=jdbcTemplate.query("SELECT * FROM board WHERE board_no=?",new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board= new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				Timestamp timestamp = rs.getTimestamp("reg_date");
				board.setRegDate(timestamp.toLocalDateTime());
				return board;
			}
			},boardNo);
					return results.isEmpty()?null:results.get(0);
	}

	public void remove(int boardNo) {
		String query="DELETE from board where board_no=?";
		jdbcTemplate.update(query,boardNo);
	}

	public void modify(Board board) {
		String query ="UPDATE board SET title=?,content=? WHERE board_no=?";
		jdbcTemplate.update(query,board.getTitle(),board.getContent(),board.getBoardNo());

	}

}
