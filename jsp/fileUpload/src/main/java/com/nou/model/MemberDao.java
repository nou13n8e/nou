package com.nou.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// MVC (model, view, controller) Design Pattern > Spring freamwork
public class MemberDao {
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String id="nou";
	private String pw="0080";
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	private void getConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public int insertMember(MemberDto memberDto) {
		int result=0;
		getConnection();
		String sql="insert into member values (?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getName());
			pstmt.setString(3, memberDto.getPassword());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setInt(5, memberDto.getZonecode());
			pstmt.setString(6, memberDto.getAddress());
			pstmt.setString(7, memberDto.getDetailAddress());
			pstmt.setString(8, memberDto.getExtraAddress());
			pstmt.setString(9, memberDto.getProfile());
			pstmt.setString(10, memberDto.getRealProfile());
			
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public MemberDto loginMember(MemberDto memberDto) {
		MemberDto loggedMemberDto=null;
		getConnection();
		String sql="select * from member where id=? and password=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				loggedMemberDto=new MemberDto();
				loggedMemberDto.setId(rs.getString("id"));
				loggedMemberDto.setName(rs.getString("name"));
				loggedMemberDto.setRealProfile(rs.getString("realProfile"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return loggedMemberDto;
	}

	public int idCheck(String userId) {
		int result=0;
		getConnection();
		String sql="select count(*) as count from member where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
		
	}

	public MemberDto getMemberInfo(String userId) {
		MemberDto infoMemberDto=null;
		getConnection();
		String sql="select * from member where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				infoMemberDto = new MemberDto();
				infoMemberDto.setId(rs.getString("id"));
				infoMemberDto.setName(rs.getString("name"));
				infoMemberDto.setEmail(rs.getString("email"));
				infoMemberDto.setAddress(rs.getString("address"));
				infoMemberDto.setZonecode(rs.getInt("zonecode"));
				infoMemberDto.setDetailAddress(rs.getString("detailAddress"));
				infoMemberDto.setExtraAddress(rs.getString("extraAddress"));
				infoMemberDto.setProfile(rs.getString("profile"));
				infoMemberDto.setRealProfile(rs.getString("profile"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return infoMemberDto;
		
	}

	public int modifyMember(MemberDto memberDto) {
		int result=0;
		getConnection();
		String sql="update member set name=?,email=?,zonecode=?,address=?,detailAddress=?,extraAddress=?, profile=?, realProfile=?  where id=? and password=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getName());
			pstmt.setString(2, memberDto.getEmail());
			pstmt.setInt(3, memberDto.getZonecode());
			pstmt.setString(4, memberDto.getAddress());
			pstmt.setString(5, memberDto.getDetailAddress());
			pstmt.setString(6, memberDto.getExtraAddress());
			pstmt.setString(7, memberDto.getProfile());
			pstmt.setString(8, memberDto.getRealProfile());
			pstmt.setString(9, memberDto.getId());
			pstmt.setString(10, memberDto.getPassword());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public int modifyPassword(ModifyPasswordDto modifyPasswordDto) {
		int result=0;
		getConnection();
		String sql="update member set password=? where id=? and password=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, modifyPasswordDto.getNewUserPw());
			pstmt.setString(2, modifyPasswordDto.getUserId());
			pstmt.setString(3, modifyPasswordDto.getUserPw());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
	}

	public int deleteMember(String userId, String userPw) {
		int result=0;
		getConnection();
		String sql="delete from member where id=? and password=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
				
		return result;
	}



}
	
	
	
	
	
	