package com.doArtShow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.doArtShow.dto.ExhListDto;
import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.ReviewListDto;
import com.doArtShow.dto.TagDto;

// 전시회 정보 dao
public class ExhibitionDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds){
		this.ds = ds;
	}
	// 검색어로 전시 검색 실행 메소드
	public ArrayList<ExhibitionDto> searchExhibition(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<ExhibitionDto> list =null;
		
		
		try {
			conn = ds.getConnection();
			System.out.println("일단 들어왔음");
			sql  = 	" SELECT ExhID, ExhPlaceAddr1, ExhName , ArtistName , ExhPlace,  ExhStartDate , ExhEndDate , ImageFile1 FROM artshowdb.artshow WHERE ( ExhName like ? OR ArtistName like ? OR ExhPlace like ? ) AND ActiveFlag='Y' GROUP BY ExhID ORDER BY ExhEndDate DESC ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setString(3, "%"+search+"%");
			System.out.println("sql문 세팅!");
			rs = pstmt.executeQuery();
			System.out.println("sql문 실행!!됨!");
			list = new ArrayList<ExhibitionDto>();
			ExhibitionDto dto =null;
			
			while(rs.next()){
				dto = new ExhibitionDto();
				dto.setExhID(rs.getInt("ExhID"));
				dto.setExhPlaceAddr1(rs.getString("ExhPlaceAddr1"));
				dto.setExhName(rs.getString("ExhName"));
				dto.setArtistName(rs.getString("ArtistName"));
				dto.setExhPlace(rs.getString("ExhPlace"));
				dto.setExhStartDate(rs.getString("ExhStartDate"));
				dto.setExhEndDate(rs.getString("ExhEndDate"));
				dto.setImageFile1(rs.getString("ImageFile1"));
				list.add(dto);
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
				try {if (conn != null) conn.close();} catch(Exception e) {}
			}
		
		return list;
		
	}
	
	//지도 페이지 넘어가는 처리
	public ArrayList<ExhibitionDto> searchMapExhibition() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<ExhibitionDto> lists =null;
		
		
		try {
			conn = ds.getConnection();
			sql  = 	" SELECT ExhID, ExhPlaceAddr1, ExhName , ArtistName , ExhPlace,  ExhStartDate , ExhEndDate , ImageFile1 FROM artshowdb.artshow WHERE ActiveFlag='Y' GROUP BY ExhID ORDER BY ExhEndDate DESC ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			lists = new ArrayList<ExhibitionDto>();
			ExhibitionDto dto =null;
			
			while(rs.next()){
				dto = new ExhibitionDto();
				dto.setExhID(rs.getInt("ExhID"));
				dto.setExhPlaceAddr1(rs.getString("ExhPlaceAddr1"));
				dto.setExhName(rs.getString("ExhName"));
				dto.setArtistName(rs.getString("ArtistName"));
				dto.setExhPlace(rs.getString("ExhPlace"));
				dto.setExhStartDate(rs.getString("ExhStartDate"));
				dto.setExhEndDate(rs.getString("ExhEndDate"));
				dto.setImageFile1(rs.getString("ImageFile1"));
				lists.add(dto);
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
				try {if (conn != null) conn.close();} catch(Exception e) {}
			}
		
		return lists;
		
	}
	
	
	
	
	
	//----------------------------------seran----------------------------------
		//전시목록을 출력하는 메서드(전체보기, 등록날짜 기준으로 내림차순)
		public List<ExhListDto> selectList(){
			System.out.println("##4번 ExhibitionDao실행 - selectList()");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate FROM artshowdb.artshow WHERE ActiveFlag!='N' ORDER BY registerDate DESC";
			ArrayList<ExhListDto> lists = null;
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				lists = new ArrayList<ExhListDto>();
				ExhListDto art = null;
				
				while(rs.next()) {
					art = new ExhListDto();
					
					art.setExhID(rs.getInt("exhID"));
					art.setImageFile1(rs.getString("imageFile1"));
					art.setExhName(rs.getString("exhName"));
					art.setExhPlace(rs.getString("exhPlace"));
					art.setExhStartDate(rs.getString("exhStartDate"));
					art.setExhEndDate(rs.getString("exhEndDate"));
					
					lists.add(art);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
			    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			    try {if (conn != null) conn.close();} catch(Exception e) {}
			}
			
			return lists;
			
		}//end - public List<ExhibitionDto> selectList(){
		
		//전시 총 갯수를 구하는 메서드(artShow테이블의 레코드 건수를 구함)
		public int getListCount(){
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int listCnt = 0;
			String sql = "SELECT count(*) FROM artshowdb.artshow WHERE ActiveFlag!='N'";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
						
				if(rs.next()){
					listCnt = rs.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
			    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			    try {if (conn != null) conn.close();} catch(Exception e) {}
			}
			
			return listCnt;
			
		}//end - public int getListCount(){
		
		//ajax로 정렬,더보기하여 전시목록을 가져오는 메소드
		public List<ExhListDto> selectSortList(int inputSort, int inputTag, int inputLoc, int inputGen, int inputPage){
			System.out.println("##4번 ExhibitionDao실행 - selectSortList()");
						
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String tagName = "";
			switch(inputTag){
				case 1 : tagName = "데이트"; break;
				case 2 : tagName = "인생샷"; break;
				case 3 : tagName = "친구와함께"; break;
				case 4 : tagName = "나혼자문화생활"; break;
				case 5 : tagName = "부모님과함께"; break;
				case 6 : tagName = "아이와함께"; break;
				case 7 : tagName = "교육전시"; break;
			}
			String locName = "";
			switch(inputLoc){
				case 1 : locName = "서울"; break;
				case 2 : locName = "인천/경기"; break;
				case 3 : locName = "대전/충청"; break;
				case 4 : locName = "광주/전라"; break;
				case 5 : locName = "부산/경상"; break;
				case 6 : locName = "강원"; break;
				case 7 : locName = "제주"; break;
			}
			String genName = "";
			switch(inputGen){
				case 1 : genName = "서양화"; break;
				case 2 : genName = "동양화"; break;
				case 3 : genName = "유화"; break;
				case 4 : genName = "조각"; break;
				case 5 : genName = "설치미술"; break;
				case 6 : genName = "미디어아트"; break;
				case 7 : genName = "사진"; break;
				case 8 : genName = "디자인"; break;
				case 9 : genName = "공예"; break;
			}
				
			System.out.println("tagName : " + tagName);
			System.out.println("locName : " + locName);
			System.out.println("genName : " + genName);
			
			String sql = "";
			ArrayList<ExhListDto> lists = null;

			try {
				conn = ds.getConnection();
				if(inputSort == 0){ //전체전시
					if(inputTag > 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag!='N' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=?) AS sort "
										+ "WHERE ActiveFlag!='N' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag!='N' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=?) AS sort "
										+ "WHERE ActiveFlag!='N' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}else if(inputTag == 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag!='N' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=?) AS sort "
										+ "WHERE ActiveFlag='Y' AND ActiveFlag='E' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag!='N' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow) AS sort "
										+ "WHERE ActiveFlag!='N' "
										+ "ORDER BY registerDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}
				}else if(inputSort == 1){ //진행중 전시
					if(inputTag > 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}else if(inputTag == 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhStartDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}
				}else if(inputSort == 2){ //인기전시
					if(inputTag > 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}else if(inputTag == 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow) AS sort "
										+ "WHERE DATE(exhStartDate)<=DATE(now()) AND DATE(exhEndDate)>=DATE(now()) AND ActiveFlag='Y' "
										+ "ORDER BY exhReadCount DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}
				}else if(inputSort == 3){ //곧종료전시
					if(inputTag > 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=?) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=?) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}else if(inputTag == 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=?) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun2=?) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow) AS sort "
										+ "WHERE DATE(exhEndDate)<=DATE_ADD(now(), INTERVAL +2 MONTH) AND ActiveFlag='Y' "
										+ "ORDER BY exhEndDate ASC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}
				}else if(inputSort == 4){ //종료전시
					if(inputTag > 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount FROM artshow, artshowtag, activeFlag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount FROM artshow, artshowtag, activeFlag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun4=?) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=? AND ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow, artshowtag WHERE artshow.exhID = artshowtag.exhID AND artshowtag.tagName=?) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}else if(inputTag == 0){
						if(inputLoc > 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=? AND ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun4=?) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}else if(inputLoc == 0){
							if(inputGen > 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow WHERE ExhGubun2=?) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}else if(inputGen == 0){
								sql = "SELECT exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate "
										+ "FROM (SELECT artshow.exhID, imageFile1, exhName, exhPlace, exhStartDate, exhEndDate, registerDate, exhReadCount, activeFlag FROM artshow) AS sort "
										+ "WHERE ActiveFlag='E' "
										+ "ORDER BY exhEndDate DESC "
										+ "LIMIT " + (inputPage*15) + ",15";
							}
						}
					}
				}
				
				pstmt = conn.prepareStatement(sql);
				if(inputTag != 0 && inputLoc != 0 && inputGen != 0){
					pstmt.setString(1, tagName);
					pstmt.setString(2, locName);
					pstmt.setString(3, genName);
				}else if(inputTag != 0 && inputLoc != 0 && inputGen == 0){
					pstmt.setString(1, tagName);
					pstmt.setString(2, locName);
				}else if(inputTag != 0 && inputLoc == 0 && inputGen != 0){
					pstmt.setString(1, tagName);
					pstmt.setString(2, genName);
				}else if(inputTag == 0 && inputLoc != 0 && inputGen != 0){
					pstmt.setString(1, locName);
					pstmt.setString(2, genName);
				}else if(inputTag != 0 && inputLoc == 0 && inputGen == 0){
					pstmt.setString(1, tagName);
				}else if(inputTag == 0 && inputLoc != 0 && inputGen == 0){
					pstmt.setString(1, locName);
				}else if(inputTag == 0 && inputLoc == 0 && inputGen != 0){
					pstmt.setString(1, genName);
				}
				rs = pstmt.executeQuery();
							
				lists = new ArrayList<ExhListDto>();
				ExhListDto art = null;
							
				while(rs.next()) {
					art = new ExhListDto();
								
					art.setExhID(rs.getInt("exhID"));
					art.setImageFile1(rs.getString("imageFile1"));
					art.setExhName(rs.getString("exhName"));
					art.setExhPlace(rs.getString("exhPlace"));
					art.setExhStartDate(rs.getString("exhStartDate"));
					art.setExhEndDate(rs.getString("exhEndDate"));
								
					lists.add(art);
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
				try {if (conn != null) conn.close();} catch(Exception e) {}
			}
					
			return lists;
						
		}//end - public List<ExhListDto> selectSortList(int inputSort, int inputTag, int inputLoc, int inputGen, int inputPage)
		
		
		//리스트 목록의 content를 불러오는 메서드
		public ExhibitionDto selectOne(int exhID){
			System.out.println("##4-2번 ExhibitionDao실행 - selectOne()");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ExhibitionDto content = null;
			String sql = "SELECT * FROM artshowdb.artshow WHERE exhID=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, exhID);
				
				rs = pstmt.executeQuery();
						
				if(rs.next()){
					content = new ExhibitionDto();
					
					content.setExhID(rs.getInt("exhID"));
					content.setExhGubun1(rs.getString("exhGubun1"));
					content.setExhGubun2(rs.getString("exhGubun2"));
					content.setExhGubun4(rs.getString("exhGubun4"));
					content.setExhName(rs.getString("exhName"));
					content.setExhGubun1(rs.getString("exhGubun1"));
					content.setArtistName(rs.getString("artistName"));
					content.setArtistInfo(rs.getString("artistInfo"));
					content.setExhContent(rs.getString("exhContent"));
					content.setExhPlace(rs.getString("exhPlace"));
					content.setExhUrl(rs.getString("exhUrl"));
					content.setExhGubun1(rs.getString("exhGubun1"));
					content.setExhPlaceAddr1(rs.getString("exhPlaceAddr1"));
					content.setExhStartDate(rs.getString("exhStartDate"));
					content.setExhEndDate(rs.getString("exhEndDate"));
					content.setOpTime(rs.getString("opTime"));
					content.setTel(rs.getString("tel"));
					content.setAdmFee(rs.getString("admFee"));
					content.setImageFile1(rs.getString("imageFile1"));
					content.setImageName1(rs.getString("imageName1"));
					content.setImageType1(rs.getString("imageType1"));
					content.setImageFile2(rs.getString("imageFile2"));
					content.setImageName2(rs.getString("imageName2"));
					content.setImageType2(rs.getString("imageType2"));
					//imageFile3과 4는 null값일 경우를 처리해줘야 함 -> 데이터를 뽑을 때 할것!!
					content.setImageFile3(rs.getString("imageFile3"));
					content.setImageName3(rs.getString("imageName3"));
					content.setImageType3(rs.getString("imageType3"));
					content.setImageFile4(rs.getString("imageFile4"));
					content.setImageName4(rs.getString("imageName4"));
					content.setImageType4(rs.getString("imageType4"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {if (rs != null) rs.close();} catch(Exception e) {}
			    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			    try {if (conn != null) conn.close();} catch(Exception e) {}
			}
			
			return content;
			
		}//end - public ExhibitionDto selectOne(int exhID){
		
		//조회수 증가하는 메서드
		public void updateReadCount(int exhID){
			System.out.println("##4-1번 ExhibitionDao실행 - updateReadCount()");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "UPDATE artshowdb.artshow SET exhReadCount=exhReadCount+1 WHERE exhID=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);	
				pstmt.setInt(1, exhID);
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			    try {if (conn != null) conn.close();} catch(Exception e) {}
			}
			
		}//end - public void updateReadCount(int exhID){
		
		//exhID에 해당하는 리뷰 목록
		public List<ReviewListDto> revContent(int exhID){
			System.out.println("##4-4번 ExhibitionDao실행 - revContent()");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "";
			ArrayList<ReviewListDto> revLists = null;
			
			try {
				conn = ds.getConnection();
				sql = "SELECT r.revContent, r.revDate, m.name, m.profileImg "
					+ "FROM artshow a, review r, member m "
					+ "WHERE r.email=m.email AND r.exhID=a.ExhID AND a.ExhID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, exhID);
				
				rs = pstmt.executeQuery();
				
				revLists = new ArrayList<ReviewListDto>();
				ReviewListDto rev = null;
				
				while(rs.next()) {
					rev = new ReviewListDto();
					rev.setRevContent(rs.getString("revContent"));
					rev.setRevDate(rs.getDate("revDate"));
					rev.setName(rs.getString("name"));
					rev.setProfileImg(rs.getString("profileImg"));
				
					revLists.add(rev);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
			    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			    try {if (conn != null) conn.close();} catch(Exception e) {}
			}
			
			return revLists;
		}//end - public List<ReviewListDto> revContent(int exhID)
		
		//리뷰 총 갯수를 구하는 메서드(테이블의 레코드 건수를 구함)
		public int getRevCount(int exhID){
			System.out.println("##4-3번 ExhibitionDao실행 - getRevCount()");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
				
			int RevCnt = 0;
			String sql = "SELECT count(*) FROM artshowdb.review WHERE exhID=?";
				
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, exhID);
				
				rs = pstmt.executeQuery();
							
				if(rs.next()){
					RevCnt = rs.getInt(1);
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
				try {if (conn != null) conn.close();} catch(Exception e) {}
			}
				
			return RevCnt;
				
		}//end - public int getRevCount(int exhID)
		
		//전시 상세정보를 불러오는 페이지를 로드할때, 로그인 되어있는 경우의 가고싶어요 여부 체크
		public int wishCheck(String email, int exhID) {
			System.out.println("##4-1-0번 ExhibitionDao실행 - wishCheck()");
			
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
		}//end - public int wishCheck(String email, int exhID)
		
	
		//-------------------------------------------------------------------------------------------------------------
//		programmed by Hojeong - begin
	//-------------------------------------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------------------------------------
//		public void insertExhibition(ExhibitionDto exhibition) - begin
	//  modified 20/01/10(yy/mm/dd)	
//	 	exhibition insert - 전시회 등록	
	//-------------------------------------------------------------------------------------------------------------	
		public int insertExhibition(ExhibitionDto exhibition) {
			System.out.println("insertExhibition - Dao");
			Connection 			conn 		= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet 				rs 			= null;
			int							num 		= 0;
			String 					sql 		= null;
			int cnt = 0;
			int rsCnt = 0;
			
			try {
				conn = ds.getConnection();
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("select max(exhID) from artshow");
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					num = rs.getInt(1)+1;
				}else{
					num = 1;
				}
				
				sql = "INSERT INTO artshow(	exhID, "
						+ "							memberID, "
						+ "							exhGubun1, "
						+ "							exhGubun2, "
						+ "							exhGubun4, "
						+ "							exhName, "
						+ "							artistName, "
						+ "							artistInfo, "
						+ "							exhContent, "
						+ "							exhPlace, "
						+ "						  	exhPlaceZip, "
						+ "							exhPlaceAddr1, "
						+ "							exhPlaceAddr2, "
						+ "							exhUrl, "
						+ "							exhStartDate, "
						+ "							exhEndDate, "
						+ "							opTime, "
						+ "							tel, "
						+ "							admFee, "
						+ "							imageFile1, "
						+ "							imageFile2, "
						+ "                         imageName2, "
						+ "                         imageType2, "
						+ "							imageFile3, "
						+ "                         imageName3, "
						+ "                         imageType3, "
						+ "							imageFile4, "
						+ "                         imageName4, "
						+ "                         imageType4, "
						+ "							exhReadCount, "
						+ "							registerDate, "
						+ "							activeFlag) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?, "
					+ "		   ?,?,?,?,?,?,?,?,?,?, "
					+ "	       ?,?,?,?,?,?,?,?,?,?,"
					+ "		   ?,? ) ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, exhibition.getMemberID());
				pstmt.setString(3, exhibition.getExhGubun1());
				pstmt.setString(4, exhibition.getExhGubun2());
				pstmt.setString(5, exhibition.getExhGubun4());
				pstmt.setString(6, exhibition.getExhName());
				pstmt.setString(7, exhibition.getArtistName());
				pstmt.setString(8, exhibition.getArtistInfo());
				pstmt.setString(9, exhibition.getExhContent());
				pstmt.setString(10, exhibition.getExhPlace());
				//pstmt.setString(11, exhibition.getExhPlaceZip());
				pstmt.setString(12, exhibition.getExhPlaceAddr1());
				//pstmt.setString(13, exhibition.getExhPlaceAddr2());
				pstmt.setString(11, "001-001");
				//pstmt.setString(12, "addr1");
				pstmt.setString(13, "addr2");
				pstmt.setString(14, exhibition.getExhUrl());
				pstmt.setString(15, exhibition.getExhStartDate());
				pstmt.setString(16, exhibition.getExhEndDate());
				pstmt.setString(17, exhibition.getOpTime());
				pstmt.setString(18,  exhibition.getTel());
				pstmt.setString(19, exhibition.getAdmFee());
				pstmt.setString(20, exhibition.getImageFile1());
				pstmt.setString(21, exhibition.getImageFile2());	
				pstmt.setString(22, exhibition.getImageName2());	//newly added by Hojeong @200120
				pstmt.setString(23, exhibition.getImageType2());	//newly added by Hojeong @200120
				pstmt.setString(24, exhibition.getImageFile3());
				pstmt.setString(25, exhibition.getImageName3());	//newly added by Hojeong @200120
				pstmt.setString(26, exhibition.getImageType3());	//newly added by Hojeong @200120
				pstmt.setString(27, exhibition.getImageFile4());
				pstmt.setString(28, exhibition.getImageName4());	//newly added by Hojeong @200120
				pstmt.setString(29, exhibition.getImageType4());	//newly added by Hojeong @200120
				pstmt.setInt(30, 0);
				pstmt.setTimestamp(31, exhibition.getRegisterDate());
				pstmt.setString(32,  "N");
		
				cnt += pstmt.executeUpdate();
				
				sql = "INSERT INTO artshowtag ( exhid, tagname ) values ( ?,? ) ";
				for (int i=0; i<exhibition.getExhGubun3().length; i++) {
					System.out.println("dao%%% "+exhibition.getExhGubun3()[i]);
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.setString(2, exhibition.getExhGubun3()[i]);
					cnt += pstmt.executeUpdate();
				}
				
				if (cnt == 1+exhibition.getExhGubun3().length) {
					conn.commit(); 
					System.out.println("커밋됨");
					rsCnt = 1;
				}else{
					conn.rollback(); System.out.println("롤백됨");
					rsCnt = 0;
				}

			} catch (Exception e) { 
				e.printStackTrace();
			} finally {
				try {if(rs!=null)rs.close();} catch (Exception e) {}
				try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
				try {if(conn!=null)conn.close();} catch (Exception e) {}
			}
			return rsCnt;
		}
	//-------------------------------------------------------------------------------------------------------------
//		public void insertExhibition(ExhibitionDto exhibition) - end
	//-------------------------------------------------------------------------------------------------------------		
	//-------------------------------------------------------------------------------------------------------------
//		public void updateExhibition(ExhibitionDto exhibition) - begin
	//  modified 20/01/10(yy/mm/dd)	
//		exhibition update - 내가 등록한 전시회 수정	
	//-------------------------------------------------------------------------------------------------------------			
		public int updateExhibition(ExhibitionDto exhibition) {
			System.out.println("updateExhibition - Dao");
			Connection 			conn 		= null;
			PreparedStatement 	pstmt 	= null;
			ResultSet 				rs 			= null;
			int							num 		= 0;
			String 					sql 		= null;
			int cnt = 0;
			int rsCnt = 0;
			
			try {
				conn = ds.getConnection();
				conn.setAutoCommit(false);
				sql = "UPDATE artshow set	 	exhGubun1 	=?, "
						+ "							exhGubun2 	=?, "
						+ "							exhGubun4 	=?, "
						+ "							exhName 		=?, "
						+ "							artistName 		=?, "
						+ "							artistInfo 		=?, "
						+ "							exhContent 	=?, "
						+ "							exhPlace 		=?, "
						+ "						  	exhPlaceZip 	=?, "
						+ " 							exhPlaceAddr1 =?, "
						+ "							exhPlaceAddr2 =?, "
						+ "							exhUrl 			=?, "
						+ "							exhStartDate 	=?, "
						+ "							exhEndDate 	=?, "
						+ "							opTime 			=?, "
						+ "							tel 				=?, "
						+ "							admFee 			=?, "
						+ "							imageFile1 		=?, "
						+ "							imageFile2 		=?, "		// modified by Hojeong (20/01/03) ; 맨끝에 쉼표 추가함
						+ "							imageFile3 		=?, "
						+ "							imageFile4 		=?, "
						+ "							imageName2 		=?, "
						+ "							imageName3 		=?, "
						+ "							imageName4 		=?, "
						+ "							imageType2 		=?, "
						+ "							imageType3 		=?, "
						+ "							imageType4 		=? "
						+ "							WHERE exhID 	=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, exhibition.getExhGubun1());
				pstmt.setString(2, exhibition.getExhGubun2());
				pstmt.setString(3, exhibition.getExhGubun4());
				pstmt.setString(4, exhibition.getExhName());
				pstmt.setString(5, exhibition.getArtistName());
				pstmt.setString(6, exhibition.getArtistInfo());
				pstmt.setString(7, exhibition.getExhContent());
				pstmt.setString(8, exhibition.getExhPlace());
				pstmt.setString(9, "001-001");
				//pstmt.setString(9, exhibition.getExhPlaceZip());
				pstmt.setString(10, exhibition.getExhPlaceAddr1());
				//pstmt.setString(10, "addr1");
				//pstmt.setString(11, exhibition.getExhPlaceAddr2());
				pstmt.setString(11, "addr2");
				pstmt.setString(12, exhibition.getExhUrl());
				pstmt.setString(13, exhibition.getExhStartDate());
				pstmt.setString(14, exhibition.getExhEndDate());
				pstmt.setString(15, exhibition.getOpTime());
				pstmt.setString(16,  exhibition.getTel());
				pstmt.setString(17, exhibition.getAdmFee());
				pstmt.setString(18, exhibition.getImageFile1());
				pstmt.setString(19, exhibition.getImageFile2());
				pstmt.setString(20, exhibition.getImageFile3());
				pstmt.setString(21, exhibition.getImageFile4());
				pstmt.setString(22, exhibition.getImageName2());
				pstmt.setString(23, exhibition.getImageName3());
				pstmt.setString(24, exhibition.getImageName4());
				pstmt.setString(25, exhibition.getImageType2());
				pstmt.setString(26, exhibition.getImageType3());
				pstmt.setString(27, exhibition.getImageType4());
				pstmt.setInt(28, exhibition.getExhID());
				cnt += pstmt.executeUpdate();
				System.out.println("#cnt1"+cnt);
				
				pstmt = conn.prepareStatement( " DELETE FROM artshowtag WHERE exhID = ? ");
				pstmt.setInt(1, exhibition.getExhID());
				cnt += pstmt.executeUpdate();
				System.out.println("#cnt2"+cnt);
				
				sql = "INSERT INTO artshowtag ( exhid, tagname ) values ( ?,? ) ";
				for (int i=0; i<exhibition.getExhGubun3().length; i++) {
					System.out.println("dao%%% "+exhibition.getExhGubun3()[i]);
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, exhibition.getExhID());
					pstmt.setString(2, exhibition.getExhGubun3()[i]);
					cnt += pstmt.executeUpdate();
				}
				System.out.println("#cnt3"+cnt);
				
				if (cnt == 1+(exhibition.getExhGubun3().length+getTagCount(exhibition.getExhID()))) { 	//modified @20/01/20(yy/MM/dd)
					conn.commit(); 
					System.out.println("커밋됨");
					rsCnt = 1;
				}else{
					conn.rollback(); System.out.println("롤백됨");
					rsCnt = 0;
				}
				
			} catch (Exception e) {
					e.printStackTrace();
			} finally {
					try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
					try {if(conn!=null)conn.close();} catch (Exception e) {}
			}
			return rsCnt;
		}
	//-------------------------------------------------------------------------------------------------------------
//		public void updateExhibition(ExhibitionDto exhibition) - end
	//-------------------------------------------------------------------------------------------------------------	
//-------------------------------------------------------------------------------------------------------------
//	public ExhibitionDto selectExhibition(Integer exhID) - begin
//  내가 등록한 전시회 상세 정보 	
//-------------------------------------------------------------------------------------------------------------		
	public ExhibitionDto selectExhibition(Integer exhID) {
		System.out.println("selectExhibition - Dao");
		Connection 			conn 		= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 				rs 			= null;
		int							num 		= 0;
		String 					sql 		= null;
		ExhibitionDto exhibition = null;
		
		try {
			conn = ds.getConnection();
			pstmt =	conn.prepareStatement(" select * from artshow where exhID = ? and activeFlag = 'N'");
			pstmt.setInt(1, exhID);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("rs.next()");
				exhibition = new ExhibitionDto();
				exhibition.setExhID(rs.getInt("exhID"));
				exhibition.setMemberID(rs.getString("memberID"));
				exhibition.setExhGubun1(rs.getString("exhGubun1"));
				exhibition.setExhGubun2(rs.getString("exhGubun2"));
				exhibition.setExhGubun4(rs.getString("exhGubun4"));
				exhibition.setExhName(rs.getString("exhName"));
				exhibition.setArtistName(rs.getString("artistName"));
				exhibition.setArtistInfo(rs.getString("artistInfo"));
				exhibition.setExhContent(rs.getString("exhContent"));
				exhibition.setExhPlace(rs.getString("exhPlace"));
				exhibition.setExhPlaceAddr1(rs.getString("exhPlaceAddr1"));
				exhibition.setExhUrl(rs.getString("exhUrl"));
				exhibition.setExhStartDate(rs.getString("exhStartDate"));
				exhibition.setExhEndDate(rs.getString("exhEndDate"));
				exhibition.setOpTime(rs.getString("opTime"));
				exhibition.setTel(rs.getString("tel"));
				exhibition.setAdmFee(rs.getString("admFee"));
				exhibition.setImageFile1(rs.getString("imageFile1"));
				exhibition.setImageFile2(rs.getString("imageFile2"));
				exhibition.setImageFile3(rs.getString("imageFile3"));	//added by Hojeong 20/01/03
				exhibition.setImageFile4(rs.getString("imageFile4"));	//added by Hojeong 20/01/03
				exhibition.setRegisterDate(rs.getTimestamp("registerDate"));
				exhibition.setActiveFlag(rs.getString("activeFlag"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null)rs.close();} catch (Exception e) {}
			try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
			try {if(conn!=null)conn.close();} catch (Exception e) {}
		}
		return exhibition;	
	}
//-------------------------------------------------------------------------------------------------------------
//	public ExhibitionDto selectExhibition(Integer exhID) - end
//-------------------------------------------------------------------------------------------------------------		
//-------------------------------------------------------------------------------------------------------------
//	public ArrayList<TagDto> getTagList(Integer exhID) - begin
//	내가 등록한 전시회 tagList 가져오기	
//-------------------------------------------------------------------------------------------------------------		
	public ArrayList<TagDto> getTagList(Integer exhID) {
		System.out.println("getTags - Dao");
		Connection 			conn 		= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 				rs 			= null;
		int							count		= 0;
		String 					sql 		= null;
		String[] tags = null;
		ExhibitionDto exhibition = new ExhibitionDto();
		ArrayList<TagDto> tagList = new ArrayList<TagDto>();
		TagDto tag = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(" select count(*) from artshow, artshowTag "
					+ " where artshow.exhID = artshowTag.exhID and artshow.exhID=? ");
			pstmt.setInt(1, exhID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) count = rs.getInt(1);
	
			pstmt =	conn.prepareStatement(" select * from artshow, artshowTag "
					+ " where artshow.exhID = artshowTag.exhID and artshow.exhID=? ");
			pstmt.setInt(1, exhID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				tag = new TagDto();
				tag.setExhID(rs.getInt("artshow.exhID"));
				tag.setExhTagName(rs.getString("tagName"));
				tagList.add(tag);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null)rs.close();} catch (Exception e) {}
			try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
			try {if(conn!=null)conn.close();} catch (Exception e) {}
		}
		
		return tagList;
	}
//-------------------------------------------------------------------------------------------------------------
//	public ArrayList<TagDto> getTagList(Integer exhID) - end
//	내가 등록한 전시회 tagList 가져오기	
//-------------------------------------------------------------------------------------------------------------		
//-------------------------------------------------------------------------------------------------------------
//	public List<ExhibitionDto> selectExhibitionMyList(String id) - begin
//	마이 페이지에서 내가 등록한 전시회 리스트 보기 
//-------------------------------------------------------------------------------------------------------------
	public List<ExhibitionDto> selectExhibitionMyList(String id) {
		System.out.println("selectExhibitionMyList - Dao" + id);
		Connection 			conn 		= null;
		PreparedStatement 	pstmt 	= null;
		ResultSet 				rs 			= null;
		int							count		= 0;
		String 					sql 		= null;
		List<ExhibitionDto> exhibitionList = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(" select * from artshow where memberID=? ");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				exhibitionList = new ArrayList<ExhibitionDto>();
				do {
					ExhibitionDto exhibition = new ExhibitionDto();
					exhibition.setExhID(rs.getInt("exhID"));
					exhibition.setMemberID(rs.getString("memberID"));
					exhibition.setExhGubun1(rs.getString("exhGubun1"));
					exhibition.setExhGubun2(rs.getString("exhGubun2"));
					exhibition.setExhGubun4(rs.getString("exhGubun4"));
					exhibition.setExhName(rs.getString("exhName"));
					exhibition.setArtistName(rs.getString("artistName"));
					exhibition.setArtistInfo(rs.getString("artistInfo"));
					exhibition.setExhContent(rs.getString("exhContent"));
					exhibition.setExhPlace(rs.getString("exhPlace"));
					exhibition.setExhPlaceAddr1(rs.getString("exhPlaceAddr1"));
					exhibition.setExhUrl(rs.getString("exhUrl"));
					exhibition.setExhStartDate(rs.getString("exhStartDate"));
					exhibition.setExhEndDate(rs.getString("exhEndDate"));
					exhibition.setOpTime(rs.getString("opTime"));
					exhibition.setTel(rs.getString("tel"));
					exhibition.setAdmFee(rs.getString("admFee"));
					exhibition.setImageFile1(rs.getString("imageFile1"));
					exhibition.setImageFile2(rs.getString("imageFile2"));
					exhibition.setImageFile3(rs.getString("imageFile3"));	//added by Hojeong 20/01/03
					exhibition.setImageFile4(rs.getString("imageFile4"));	//added by Hojeong 20/01/03
					exhibition.setRegisterDate(rs.getTimestamp("registerDate"));
					exhibition.setActiveFlag(rs.getString("activeFlag"));
					//System.out.println("dao:"+exhibition.toString());		//modified by Hojeong 20/01/03
					exhibitionList.add(exhibition);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null)rs.close();} catch (Exception e) {}
			try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
			try {if(conn!=null)conn.close();} catch (Exception e) {}
		}

		return exhibitionList;
	}
//-------------------------------------------------------------------------------------------------------------
//public List<ExhibitionDto> selectExhibitionMyList(String id) - end
//마이 페이지에서 내가 등록한 전시회 리스트 보기 
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//public int deleteExhibition(int exhID) - begin
//programmed by Hojeong 20/01/10(yy/mm/dd)
//myList에서 내가 등록한 전시회 삭제하기 
//-------------------------------------------------------------------------------------------------------------
public int deleteExhibition(int exhID) {
	System.out.println("deleteExhibition - Dao");
	Connection 			conn 	= null;
	PreparedStatement 	pstmt 	= null;
	String 				sql 	= null;
	int 				cnt 	= 0;
	int 				rsCnt 	= 0;
	
	try {
		conn = ds.getConnection();
		conn.setAutoCommit(false);
		sql = "delete from artshow where exhID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, exhID);
		cnt = pstmt.executeUpdate();
		
		sql = "delete from artshowtag where exhid = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, exhID);
		cnt += pstmt.executeUpdate();
	
		if (cnt == 1+getTagCount(exhID)) {			//modified @20/01/20(yy/MM/dd)
			conn.commit(); 
			System.out.println("커밋됨");
			rsCnt = 1;
		}else{
			conn.rollback(); System.out.println("롤백됨");
			rsCnt = 0;
		}
		
	} catch (Exception e) {
			e.printStackTrace();
	} finally {
			try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
			try {if(conn!=null)conn.close();} catch (Exception e) {}
	}
	return rsCnt;
	}
//-------------------------------------------------------------------------------------------------------------
//public int deleteExhibition(int exhID) - end
//programmed by Hojeong 20/01/10(yy/mm/dd)
//myList에서 내가 등록한 전시회 삭제하기  
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//public int getTagCount(Integer exhID) - begin
//ExhID에 해당하는 Tag갯수 가져오기 	
//programmed @20/01/20(yy/MM/dd)
//-------------------------------------------------------------------------------------------------------------		
public int getTagCount(Integer exhID) {
	System.out.println("getTagCount - Dao");
	Connection 			conn 		= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 				rs 			= null;
	int							count		= 0;
	String 					sql 		= null;
	int tagCount = 0;
	
	try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(" select count(*) from artshowTag "
				+ " where artshowTag.exhID=? ");
		pstmt.setInt(1, exhID);
		rs = pstmt.executeQuery();
		
		pstmt.setInt(1, exhID);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			tagCount = rs.getInt(1);
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {if(rs!=null)rs.close();} catch (Exception e) {}
		try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
		try {if(conn!=null)conn.close();} catch (Exception e) {}
	}
	
	return tagCount;
}
//-------------------------------------------------------------------------------------------------------------
//public int getTagCount(Integer exhID) - end
//ExhID에 해당하는 Tag갯수 가져오기 	
//programmed @20/01/20(yy/MM/dd)
//-------------------------------------------------------------------------------------------------------------	
//-------------------------------------------------------------------------------------------------------------
//public String[] getImageFile(int exhID) - begin
//ExhID에 해당하는 imageFile들의 파일명 가져오기(전시회 삭제시, imageFile도 삭제하기 위해서)
//programmed @20/01/21(yy/MM/dd)
//-------------------------------------------------------------------------------------------------------------
	public String[] getImageFile(int exhID) {

		System.out.println("getImageFile - Dao");
		Connection 			conn 		= null;
		PreparedStatement 	pstmt 		= null;
		ResultSet 			rs 			= null;
		int					count		= 0;
		String 				sql 		= null;
		String[] 			imageFile 	= new String[4];
		
		try {
			conn = ds.getConnection();
			pstmt =	conn.prepareStatement(" select imageFile1, imageFile2, imageFile3, imageFile4 "
					+ " from artshow "
					+ " where exhID=? ");
			pstmt.setInt(1, exhID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				imageFile[0] = rs.getString(1);
				imageFile[1] = rs.getString(2);
				imageFile[2] = rs.getString(3);
				imageFile[3] = rs.getString(4);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null)rs.close();} catch (Exception e) {}
			try {if(pstmt!=null)pstmt.close();} catch (Exception e) {}
			try {if(conn!=null)conn.close();} catch (Exception e) {}
		}
		
		return imageFile;
	}
//-------------------------------------------------------------------------------------------------------------
//public String[] getImageFile(int exhID) - end
//ExhID에 해당하는 imageFile들의 파일명 가져오기(전시회 삭제시, imageFile도 삭제하기 위해서)
//programmed @20/01/21(yy/MM/dd)
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//programmed by Hojeong - end
//-------------------------------------------------------------------------------------------------------------

	
// 메인페이지에서 슬라이드에 전시 리스트 보냄.
	public ArrayList<ExhibitionDto> indexExhibition() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<ExhibitionDto> list =null;
		
		try {
			conn = ds.getConnection();
			//최신등록순 9개
			sql  = 	" SELECT ExhID, ExhPlaceAddr1, ExhName , ArtistName , ExhPlace,  ExhStartDate , ExhEndDate , ImageFile1 FROM artshow  where activeflag='Y' ORDER BY RegisterDate DESC LIMIT 9 ";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, "%"+search+"%");
			//pstmt.setString(2, "%"+search+"%");
			//pstmt.setString(3, "%"+search+"%");
			rs = pstmt.executeQuery();
			list = new ArrayList<ExhibitionDto>();
			ExhibitionDto dto =null;
			
			while(rs.next()){
				dto = new ExhibitionDto();
				dto.setExhID(rs.getInt("ExhID"));
				dto.setExhPlaceAddr1(rs.getString("ExhPlaceAddr1"));
				dto.setExhName(rs.getString("ExhName"));
				dto.setArtistName(rs.getString("ArtistName"));
				dto.setExhPlace(rs.getString("ExhPlace"));
				dto.setExhStartDate(rs.getString("ExhStartDate"));
				dto.setExhEndDate(rs.getString("ExhEndDate"));
				dto.setImageFile1(rs.getString("ImageFile1"));
				list.add(dto);
				}
			pstmt.close();
			rs.close();
			
			sql="";
			dto=null;
			// 인기 조회순 9개
			sql = " SELECT ExhID, ExhPlaceAddr1, ExhName , ArtistName , ExhPlace,  ExhStartDate , ExhEndDate , ImageFile1 FROM artshowdb.artshow  where activeflag='Y' ORDER BY ExhReadCount DESC LIMIT 9 ";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new ExhibitionDto();
				dto.setExhID(rs.getInt("ExhID"));
				dto.setExhPlaceAddr1(rs.getString("ExhPlaceAddr1"));
				dto.setExhName(rs.getString("ExhName"));
				dto.setArtistName(rs.getString("ArtistName"));
				dto.setExhPlace(rs.getString("ExhPlace"));
				dto.setExhStartDate(rs.getString("ExhStartDate"));
				dto.setExhEndDate(rs.getString("ExhEndDate"));
				dto.setImageFile1(rs.getString("ImageFile1"));
				list.add(dto);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if (rs != null) rs.close();} catch(Exception e) {}
				try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
				try {if (conn != null) conn.close();} catch(Exception e) {}
			}
		
		return list;
		
	}
	
	
	//by jungmi
			//-------------------------------------------------------------------
			// 회원페이지(memberPage.jsp) 등록한 전시의 개수
			//-------------------------------------------------------------------
			public int countMyExh(String email) {
				Connection 			conn 	= null;
				PreparedStatement 	pstmt 	= null;
				ResultSet 			rs 		= null;
				String 				sql 	= "";
				
				int myExhCount = 0;
				
				try {
					conn 	= ds.getConnection();
					sql  	=  "SELECT  count(*) ";
					sql		+= "FROM	artshow ";
					sql		+= "WHERE   memberID=?	 ";
					
					pstmt 	= conn.prepareStatement(sql);
					pstmt.setString(1, email);
					rs 		= pstmt.executeQuery();
					
					if(rs.next()) {
						myExhCount = rs.getInt(1);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					
				} finally {
					if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
					if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
					if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
				}
				return myExhCount;
			}
			
	
	
	
	
	
}



