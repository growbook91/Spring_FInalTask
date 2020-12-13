package com.mycom.batisapp.lab14;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lab14ServiceImpl implements Lab14Service{
	
	@Autowired
	Lab14DAO lab14DAO;
	
	@Override
	public int insertBoard(Lab14VO vo) {
		return lab14DAO.insertBoard(vo);
	}
	@Override
	public int deleteBoard(int seq) {
		return lab14DAO.deleteBoard(seq);
	}
	@Override
	public int updateBoard(Lab14VO vo) {
		return lab14DAO.updateBoard(vo);
	}
	@Override
	public Lab14VO getBoard(int seq) {
		return lab14DAO.getBoard(seq);
	}
	@Override
	public List<Lab14VO> getBoardList() {
		return lab14DAO.getBoardList();
	}
}
