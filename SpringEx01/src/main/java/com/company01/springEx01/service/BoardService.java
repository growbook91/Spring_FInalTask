package com.company01.springEx01.service;

import java.util.List;
import com.company01.springEx01.logic.Board;

public interface BoardService {
	//List<Board> getBoardList();
	List getBoardList();
	int boardwrite(Board board);
	Board getBoardDetail(int id);
	void viewsUpdate(int id);
}
