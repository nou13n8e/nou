package com.nou.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.nou.mybatis.MybatisConnectionFactory;

public class BoardDao {
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
	

	
	public int getMaxRegroup() {
		int result=0;
		getConnection();
		String sql="select nvl(max(regroup), 0) as regroupmax from replyBoard";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("regroupmax");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int writeBoard(BoardDto boardDto) {
		int result=0;
		int max=getMaxRegroup();
		boardDto.setRegroup(max+1);
		boardDto.setRelevel(1);
		boardDto.setRestep(1);
		SqlSession sqlSession=MybatisConnectionFactory.getSqlSession();
		result=sqlSession.insert("writeBoard", boardDto);
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
//		getConnection();
//		String sql="insert into replyBoard values(seq_replyBoard.nextval, ?, ?, ?, ?, sysdate, 0, ?, ?, ?, 1)";
//		
//		try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, boardDto.getUserId());
//			pstmt.setString(2, boardDto.getName());
//			pstmt.setString(3, boardDto.getTitle());
//			pstmt.setString(4, boardDto.getContents());
//			pstmt.setInt(5, max+1);
//			pstmt.setInt(6, 1);
//			pstmt.setInt(7, 1);
//			result=pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		return result;
	}

	public List<BoardDto> getList(HashMap<String, Integer> pageMap) {
		List<BoardDto> boardList=null;
		SqlSession sqlSession=MybatisConnectionFactory.getSqlSession();
		boardList=sqlSession.selectList("getList", pageMap);
		sqlSession.close();
		
//		getConnection();
		
//		String sql="select * from"
//				 + "(select rownum as no, b.* from"
//				 + "(select * from replyBoard order by regroup desc, relevel asc) b) where no>=? and no<=?";
		
//		try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
//			rs=pstmt.executeQuery();
//			boardList=new ArrayList<>();
//			while(rs.next()) {
//				BoardDto boardDto=new BoardDto();
//				boardDto.setId(rs.getInt("id"));
//				boardDto.setUserId(rs.getString("userId"));
//				boardDto.setName(rs.getString("name"));
//				boardDto.setTitle(rs.getString("title"));
//				boardDto.setContents(rs.getString("contents"));
//				boardDto.setRegDate(rs.getString("regDate"));
//				boardDto.setHit(rs.getInt("hit"));
//				boardDto.setRegroup(rs.getInt("regroup"));
//				boardDto.setRelevel(rs.getInt("relevel"));
//				boardDto.setRestep(rs.getInt("restep"));
//				boardDto.setAvailable(rs.getInt("available"));
//				boardList.add(boardDto);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		
		return boardList;
	}
	
	public void updateHit(int id) {
		int result=0;
		SqlSession sqlSession=MybatisConnectionFactory.getSqlSession();
		result=sqlSession.update("updateHit", id);
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
//		getConnection();
		
//		String sql="update replyBoard set hit=hit+1 where id=?";
		
//		try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
	}
	

	public BoardDto getview(int id) {
		updateHit(id);
		BoardDto boardDto=null;
		SqlSession sqlSession=MybatisConnectionFactory.getSqlSession();
		boardDto=sqlSession.selectOne("getView", id);
		sqlSession.close();
		
//		getConnection();
		
//		String sql="select * from replyBoard where id=?";
		
//		try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				boardDto=new BoardDto();
//				boardDto.setId(rs.getInt("id"));
//				boardDto.setUserId(rs.getString("userId"));
//				boardDto.setName(rs.getString("name"));
//				boardDto.setTitle(rs.getString("title"));
//				boardDto.setContents(rs.getString("contents"));
//				boardDto.setRegDate(rs.getString("regDate"));
//				boardDto.setHit(rs.getInt("hit"));
//				boardDto.setRegroup(rs.getInt("regroup"));
//				boardDto.setRelevel(rs.getInt("relevel"));
//				boardDto.setRestep(rs.getInt("restep"));
//				boardDto.setAvailable(rs.getInt("available"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		return boardDto;
	}

	public int deleteBoard(int id) {
		int result=0;
		SqlSession sqlSession=MybatisConnectionFactory.getSqlSession();
		result=sqlSession.update("deleteBoard", id);
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
//		getConnection();
//		String sql="update replyBoard set available=0 where id=?";
//		try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			result=pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		return result;
	}

	public int modifyBoard(BoardDto boardDto) {
		int result=0;
		getConnection();
		String sql="update replyBoard set title=?, name=?, contents=? where id=? and userId=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getContents());
			pstmt.setInt(4, boardDto.getId());
			pstmt.setString(5, boardDto.getUserId());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public double getTotal() {
		double total=0;
		getConnection();
		String sql="select count(*) as total from replyBoard";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				total=rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return total;
	}
	
	public int updateRelevel(BoardDto boardDto) {
		int result=0;
		getConnection();
		String sql="update replyBoard set relevel=relevel+1 where regroup=? and relevel>?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardDto.getRegroup());
			pstmt.setInt(2, boardDto.getRelevel());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int writeReply(BoardDto boardDto) {
		int result=0;
		getConnection();
		String sql="insert into replyBoard values(seq_replyBoard.nextval, ?, ?, ?, ?, sysdate, 0, ?, ?, ?, 1)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, boardDto.getRegroup());
			pstmt.setInt(6, boardDto.getRelevel());
			pstmt.setInt(7, boardDto.getRestep());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public List<BoardDto> search(String category, String searchWord) {
		List<BoardDto> searchList=null;
		SqlSession sqlSession=MybatisConnectionFactory.getSqlSession();
		HashMap<String, String> searchMap=new HashMap<>();
		searchMap.put("category", category);
		searchMap.put("searchWord", searchWord);
		searchList=sqlSession.selectList("search", searchMap);
//		getConnection();
//		
//		String sql=null;
//		if(category.equals("all")) {
//			sql="select * from replyboard where (title like '%'||?||'%') or (name like '%'||?||'%') or (contents like '%'||?||'%')";			
//		} else {
//			sql="select * from replyBoard where "+category+" like '%'||?||'%'";			
//		}
//
//		try {
//			pstmt=conn.prepareStatement(sql);
//			if(category.equals("all")) {
//				pstmt.setString(1, searchWord);
//				pstmt.setString(2, searchWord);
//				pstmt.setString(3, searchWord);
//			} else {
//				pstmt.setString(1, searchWord);
//			}
//			rs=pstmt.executeQuery();
//			searchList=new ArrayList<>();
//			while(rs.next()) {
//				BoardDto boardDto=new BoardDto();
//				boardDto.setId(rs.getInt("id"));
//				boardDto.setUserId(rs.getString("userId"));
//				boardDto.setName(rs.getString("name"));
//				boardDto.setTitle(rs.getString("title"));
//				boardDto.setContents(rs.getString("contents"));
//				boardDto.setRegDate(rs.getString("regDate"));
//				boardDto.setHit(rs.getInt("hit"));
//				boardDto.setRegroup(rs.getInt("regroup"));
//				boardDto.setRelevel(rs.getInt("relevel"));
//				boardDto.setRestep(rs.getInt("restep"));
//				boardDto.setAvailable(rs.getInt("available"));
//				searchList.add(boardDto);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		return searchList;
	}
}
