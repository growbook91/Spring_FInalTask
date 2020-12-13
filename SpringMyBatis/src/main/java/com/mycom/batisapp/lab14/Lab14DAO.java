package com.mycom.batisapp.lab14;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Lab14DAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insertBoard(Lab14VO vo) {
		int result = sqlSession.insert("Board.insertBoard", vo);
		return result;
	}
	
	public List<Lab14VO> getBoardList() {
		List<Lab14VO> list = null;
		list = sqlSession.selectList("Board.getBoardList");
		return list;
	}
	
	public Lab14VO getBoard(int seq) {
		Lab14VO vo = null;
		vo = sqlSession.selectOne("Board.getBoard", seq);
		return vo;
	}
	
	
	public int deleteBoard(int seq) {
		int result = sqlSession.delete("Board.deleteBoard", seq);
		return result;
	}
	
	public int updateBoard(Lab14VO vo) {
		int result = sqlSession.update("Board.updateBoard", vo);
		return result;
	}
	
}
