package com.doArtShow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.WishListDto;

// 가고 싶은 전시 dao
public class WishListDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds){
		this.ds = ds;
	}

	//가고싶어요 눌렀었는지 체크
	public int wishCheck(String email, int exhID) {
		System.out.println("##4-1번 WishListDao실행 - wishCheck()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int wishchk = 0;
		String 	sql = null;
		
		try {
			conn = ds.getConnection();
			sql	= "SELECT wishCheck FROM artshowdb.wishArt WHERE email=? AND exhID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, exhID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				wishchk = rs.getInt("wishCheck");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!= null)rs.close();} catch (SQLException e) {}
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
		
		return wishchk;
	}

	//가고싶어요
	public void updateWishCheck(String email, int exhID) {
		System.out.println("##4-3번 WishListDao실행 - updateWishCheck()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
			
		try {
			conn = ds.getConnection();
			sql = "UPDATE artshowdb.wishArt SET wishCheck=wishCheck+1 WHERE email=? AND exhID=?";
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
	

	//가고싶어요 취소
	public void deleteWishCheck(String email, int exhID) {
		System.out.println("##4-3번 WishListDao실행 - deleteWishCheck()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
			
		try {
			conn = ds.getConnection();
			sql = "UPDATE artshowdb.wishArt SET wishCheck=0 WHERE email=? AND exhID=?";
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

	//가고싶어요 등록
	public void insertWish(WishListDto wishDto) {
		System.out.println("##4-3번 WishListDao실행 - insertWish()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			conn = ds.getConnection();
			sql = "INSERT INTO artshowdb.wishArt(email, exhID, wishCheck) VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wishDto.getEmail());
			pstmt.setInt(2, wishDto.getExhID());
			pstmt.setInt(3, wishDto.getWishCheck());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
	}

	//wishArt테이블의 row확인
	public int WishRowCheck(String email, int exhID) {
		System.out.println("##4-2번 WishListDao실행 - WishRowCheck()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int wishRowchk = 0;
		String 	sql = null;
		
		try {
			conn = ds.getConnection();
			sql	= "SELECT count(*) FROM artshowdb.wishArt WHERE email=? AND exhID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, exhID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				wishRowchk = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!= null)rs.close();} catch (SQLException e) {}
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
		
		return wishRowchk;
	}
	
	
}
