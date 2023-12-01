package com.crud.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.crud.BoardRowMapper;
import com.crud.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	@Autowired
	JdbcTemplate jdbcTemplate;
	private final String BOARD_INSERT = "insert into BOARD (title, writer, content) values (?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";


	public int insertBoard(BoardVO vo) {
		String sql = "insert into BOARD (name, place, img, ingredient, rate, feature, price) values ("
			+"'" + vo.getName() + "',"
			+"'" + vo.getPlace() + "',"
			+"'" + vo.getImg() + "',"
			+"'" + vo.getIngredient() + "',"
			+"'" + vo.getRate() + "',"
			+"'" + vo.getFeature() + "',"
			+"'" + vo.getPrice() + "')";
		return jdbcTemplate.update(sql);
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where no = " + seq;
		return jdbcTemplate.update(sql);
	}
	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set name='" + vo.getName() + "', "
				+ " place='" + vo.getPlace() + "', "
				+ " img='" + vo.getImg() + "', "
				+ " ingredient='" + vo.getIngredient() + "', "
				+ " rate=" + vo.getRate() + ", "
				+ " feature='" + vo.getFeature() + "', "
				+ " price=" + vo.getPrice() + " where no=" + vo.getSeq();
		return jdbcTemplate.update(sql);
	}



	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where no=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{seq}, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO data = new BoardVO();

				data.setSeq(rs.getInt("no"));
				data.setName(rs.getString("name"));
				data.setPlace(rs.getString("place"));
				data.setImg(rs.getString("img"));
				data.setIngredient(rs.getString("ingredient"));
				data.setRate(rs.getInt("rate"));
				data.setFeature(rs.getString("feature"));
				data.setPrice(rs.getInt("price"));

				return data;
			}
		});
	}


	public List<BoardVO> getBoardList(){
		String sql = "select * from BOARD order by no desc";
		List<BoardVO> list = jdbcTemplate.query(sql, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO data = new BoardVO();

				data.setSeq(rs.getInt("no"));
				data.setName(rs.getString("name"));
				data.setPlace(rs.getString("place"));
				data.setImg(rs.getString("img"));
				data.setIngredient(rs.getString("ingredient"));
				data.setRate(rs.getInt("rate"));
				data.setFeature(rs.getString("feature"));
				data.setPrice(rs.getInt("price"));

				return data;
			}
		});
		return list;
	}
}
