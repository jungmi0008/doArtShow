package com.doArtShow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.ReviewDto;

// 리뷰 정보 dao
public class ReviewDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds){
		this.ds = ds;
	}

	//리뷰 등록
	public void insertReview(ReviewDto exhreview) {
		System.out.println("##4-1번 ReviewDao실행 - insertReview()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			conn = ds.getConnection();
			sql = "INSERT INTO artshowdb.review(email, exhID, revContent, revDate) VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, exhreview.getEmail());
			pstmt.setInt(2, exhreview.getExhID());
			pstmt.setString(3, exhreview.getRevContent());
			pstmt.setDate(4, exhreview.getRevDate());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}		
	}
	
	//리뷰를 등록하면 revCheck를 1로 바꿔줌
	public void updateRevCheck(String email, int exhID) {
		System.out.println("##4-2번 ReviewDao실행 - updateRevCheck()");
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
			
		try {
			conn = ds.getConnection();
			sql = "UPDATE artshowdb.visitArt SET revCheck=revCheck+1 WHERE email=? AND exhID=?";
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
