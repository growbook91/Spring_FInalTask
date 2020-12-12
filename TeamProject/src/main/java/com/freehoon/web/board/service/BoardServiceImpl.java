package com.freehoon.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;



import org.springframework.stereotype.Service;



import com.freehoon.web.board.dao.BoardDAO;

import com.freehoon.web.board.model.BoardVO;



@Service

public class BoardServiceImpl implements BoardService{

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {

		boardDAO.insertBoard(boardVO);

	}

	@Inject

	private BoardDAO boardDAO;

	

	public List<BoardVO> getBoardList() throws Exception {

		return boardDAO.getBoardList();

	}



}
