package com.freehoon.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;



import org.springframework.stereotype.Service;

import com.freehoon.common.Pagination;
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

	

	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {

		return boardDAO.getBoardList(pagination);

	}
	
	public BoardVO getBoardContent(int bid) throws Exception{
		BoardVO boardVO = new BoardVO();

		boardDAO.updateViewCnt(bid);

		return boardVO;
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}


	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
		
	}
	
	//총 게시글 개수 확인
	@Override

	public int getBoardListCnt() throws Exception {

		return boardDAO.getBoardListCnt();

	}


}
