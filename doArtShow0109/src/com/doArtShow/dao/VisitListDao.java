package com.doArtShow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.json.simple.JSONObject;

import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.VisitListDto;

// 갔다온 전시 정보 dao
public class VisitListDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds){
		this.ds = ds;
	}

	//다녀왔었는지 체크
	public int visitCheck(String email, int exhID) {
		System.out.println("##4-1번 VisitListDao실행 - visitCheck()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int visitchk = 0;
		String 	sql = null;
		
		try {
			conn = ds.getConnection();
			sql	= "SELECT visitCheck FROM artshowdb.visitArt WHERE email=? AND exhID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, exhID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				visitchk = rs.getInt("visitCheck");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!= null)rs.close();} catch (SQLException e) {}
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
		
		return visitchk;
	}

	//리뷰 등록했었는지 체크
	public int reviewCheck(String email, int exhID) {
		System.out.println("##4-2번 VisitListDao실행 - reviewCheck()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int revchk = 0;
		String 	sql = null;
		
		try {
			conn = ds.getConnection();
			sql	= "SELECT revCheck FROM artshowdb.visitArt WHERE email=? AND exhID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, exhID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				revchk = rs.getInt("revCheck");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!= null)rs.close();} catch (SQLException e) {}
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
		
		return revchk;
	}

	//다녀온 전시 등록
	public void insertVisit(VisitListDto visitDto) {
		System.out.println("##4-3번 VisitListDao실행 - insertVisit()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			conn = ds.getConnection();
			sql = "INSERT INTO artshowdb.visitArt(email, exhID, revCheck) VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, visitDto.getEmail());
			pstmt.setInt(2, visitDto.getExhID());
			pstmt.setInt(3, visitDto.getRevCheck());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
	}

	//다녀왔어요 등록하면 visitCheck를 1로 바꿔줌
	public void updateVisitCheck(String email, int exhID) {
		System.out.println("##4-4번 VisitListDao실행 - updateVisitCheck()");
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
			
		try {
			conn = ds.getConnection();
			sql = "UPDATE artshowdb.visitArt SET visitCheck=visitCheck+1 WHERE email=? AND exhID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, exhID);
				
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
	}
	
}
