package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.crud.bean.MemberVO;
import com.crud.common.JDBCUtil;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	private final String M_INSERT = "insert into member (userid, password, username, email, photo, detail)"+" values (?,sha1(?),?,?,?,?)";
	private final String M_UPDATE = "update member set username=?, email=?, photo=?, detail=?"+"where sid=?";
	private final String M_DELETE = "delete from member  where sid=?";
	private final String M_GET = "select * from member  where sid=?";
	private final String M_LIST = "select * from member order by regdate desc";
	
	
	public int insertBoard(MemberVO vo) {
		int result = 0;
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(M_INSERT);
			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getUsername());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getPhoto());
			stmt.setString(6, vo.getDetail());
			
			
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void deleteBoard(MemberVO vo) {//삭제
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(M_DELETE);
			stmt.setInt(1, vo.getSid());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int updateBoard(MemberVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(M_UPDATE);
			stmt.setString(1, vo.getUsername());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getPhoto());
			stmt.setString(4, vo.getDetail());
			stmt.setInt(6, vo.getSid());
			
			
			
			System.out.println(vo.getUsername() + "-" + vo.getEmail() + "-" + vo.getPhoto() + "-" + vo.getDetail());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public MemberVO getMember(int seq) {
		MemberVO one = new MemberVO();
		System.out.println("===> JDBC로 getMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(M_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setPassword(rs.getString("password"));
				one.setEmail(rs.getString("email"));
				one.setPhoto(rs.getString("photo"));
				one.setDetail(rs.getString("detail"));
				one.setRegdate(rs.getDate("regdate"));
				
				
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(one.getUsername() + "-" + one.getEmail() + "-" + one.getPhoto() + "-" + one.getDetail());
		
		return one;
	}
	
	public ArrayList<MemberVO> getMemberList(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		System.out.println("===> JDBC로 getMemberList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(M_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MemberVO one = new MemberVO();
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setEmail(rs.getString("email"));
				one.setDetail(rs.getString("detail"));
				one.setPhoto(rs.getString("photo"));
				one.setRegdate(rs.getDate("regdate"));
				
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public String getPhotoFilename(int sid) {
		String filename = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(M_GET);///Not certain
			stmt.setInt(1, sid);
			rs = stmt.executeQuery();
			if(rs.next()) {
				filename = rs.getString("photo");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("===> JDB로 getPhotoFilename() 기능 처리");
		return filename;
	}


}
