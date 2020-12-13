package com.mycom.batisapp.lab14;

import java.util.List;

public interface Lab14Service {
	public int insertBoard(Lab14VO vo);
	public int deleteBoard(int seq);
	public int updateBoard(Lab14VO vo);
	public Lab14VO getBoard(int seq);
	public List<Lab14VO> getBoardList();
}
