package com.crud;

import com.crud.board.BoardVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardVO> {
    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardVO vo = new BoardVO();
        vo.setSeq(rs.getInt("no"));
        vo.setName(rs.getString("name"));
        vo.setPlace(rs.getString("place"));
        vo.setImg(rs.getString("img"));
        vo.setIngredient(rs.getString("ingredient"));
        vo.setRate(rs.getInt("rate"));
        vo.setFeature(rs.getString("feature"));
        vo.setPrice(rs.getInt("price"));

        return vo;
    }
}