package com.doArtShow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.MemberDto;

// 관리자 정보 dao
public class ManagerDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds){
		this.ds = ds;
	}
	
	
	
	
	public int checkManager(String managerId, String managerPwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPwd = "";
		int rtnVal = -1;

		try {
			conn = ds.getConnection();
			
			String sql = "select managerPasswd from manager where managerId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, managerId);
			rs = pstmt.executeQuery();
				
			if (rs.next()) {	// 아이디 정보 일치
				dbPwd = rs.getString("managerPasswd");
				
				if (dbPwd.equals(managerPwd)) {	// 비밀번호 일치
					rtnVal = 1;
				} else {	// 비밀번호 오류
					rtnVal = 0;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rtnVal;
	}

	public List<MemberDto> getMembers() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MemberDto> list = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				list = new ArrayList<MemberDto>();
				
				do {
					list.add(new MemberDto(rs.getString("email"), rs.getString("name"),rs.getString("birth"),rs.getString("gender"), rs.getString("pw"), rs.getString("profileImg"), rs.getString("kakaoId"), rs.getString("naverId")));	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int getMemberCnt() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int memberCnt = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select count(*) from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				//System.out.println("rs.next() >>> " + rs.getInt(1));
				memberCnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberCnt;
	}

	public int getNewExhListCnt() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int newExhListCnt = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select count(*) from artshow where ActiveFlag = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "N");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//System.out.println("rs.next() >>> " + rs.getInt(1));
				newExhListCnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return newExhListCnt;
	}

	public List<ExhibitionDto> getAllExhLists() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<ExhibitionDto> list = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select * from artshow";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				list = new ArrayList<ExhibitionDto>();
				
				do {
					list.add(new ExhibitionDto(rs.getInt("exhID"), rs.getString("memberID"), rs.getString("exhGubun1"), rs.getString("exhGubun2"), rs.getString("exhGubun4"), rs.getString("exhName"), rs.getString("artistName"), rs.getString("artistInfo"), rs.getString("exhContent"), rs.getString("exhPlace"), rs.getString("exhPlaceZip"), rs.getString("exhPlaceAddr1"), rs.getString("exhPlaceAddr2"), rs.getString("exhUrl"), rs.getString("exhStartDate"), rs.getString("exhEndDate"), rs.getString("opTime"), rs.getString("tel"), rs.getString("admFee"), rs.getString("imageFile1"), rs.getString("imageFile2"), rs.getString("imageFile3"), rs.getString("imageFile4"), rs.getInt("exhReadCount"), rs.getTimestamp("registerDate"), rs.getString("activeFlag")));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public List<ExhibitionDto> getNewExhLists() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ExhibitionDto> list = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select * from artshow where ActiveFlag = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "N");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				list = new ArrayList<ExhibitionDto>();
				
				do {
					list.add(new ExhibitionDto(rs.getInt("exhID"), rs.getString("memberID"), rs.getString("exhGubun1"), rs.getString("exhGubun2"), rs.getString("exhGubun4"), rs.getString("exhName"), rs.getString("artistName"), rs.getString("artistInfo"), rs.getString("exhContent"), rs.getString("exhPlace"), rs.getString("exhPlaceZip"), rs.getString("exhPlaceAddr1"), rs.getString("exhPlaceAddr2"), rs.getString("exhUrl"), rs.getString("exhStartDate"), rs.getString("exhEndDate"), rs.getString("opTime"), rs.getString("tel"), rs.getString("admFee"), rs.getString("imageFile1"), rs.getString("imageFile2"), rs.getString("imageFile3"), rs.getString("imageFile4"), rs.getInt("exhReadCount"), rs.getTimestamp("registerDate"), rs.getString("activeFlag")));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public void updateActiveFlagTrue(String exhID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "update artshow set ActiveFlag = ? where ExhID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Y");
			pstmt.setString(2, exhID);
			
			int res = pstmt.executeUpdate();
			
			if (res > 0) {
				System.out.println("Update ActiveFlagTrue Success!");
			} else {
				System.out.println("Update ActiveFlagTrue Fail...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateActiveFlagFalse(String exhID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "update artshow set ActiveFlag = ? where ExhID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "N");
			pstmt.setString(2, exhID);
			
			int res = pstmt.executeUpdate();
			
			if (res > 0) {
				System.out.println("Update ActiveFlagFalse Success!");
			} else {
				System.out.println("Update ActiveFlagFalse Fail...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<ExhibitionDto> getEndExhLists() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<ExhibitionDto> list = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select * from artshow where exhenddate < date(sysdate())";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				list = new ArrayList<ExhibitionDto>();
				
				do {
					list.add(new ExhibitionDto(rs.getInt("exhID"), rs.getString("memberID"), rs.getString("exhGubun1"), rs.getString("exhGubun2"), rs.getString("exhGubun4"), rs.getString("exhName"), rs.getString("artistName"), rs.getString("artistInfo"), rs.getString("exhContent"), rs.getString("exhPlace"), rs.getString("exhPlaceZip"), rs.getString("exhPlaceAddr1"), rs.getString("exhPlaceAddr2"), rs.getString("exhUrl"), rs.getString("exhStartDate"), rs.getString("exhEndDate"), rs.getString("opTime"), rs.getString("tel"), rs.getString("admFee"), rs.getString("imageFile1"), rs.getString("imageFile2"), rs.getString("imageFile3"), rs.getString("imageFile4"), rs.getInt("exhReadCount"), rs.getTimestamp("registerDate"), rs.getString("activeFlag")));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return list;
	}

	public void updateActiveFlagEnd(String exhID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "update artshow set ActiveFlag = ? where ExhID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "E");
			pstmt.setString(2, exhID);
			
			int res = pstmt.executeUpdate();
			
			if (res > 0) {
				System.out.println("Update ActiveFlagEnd Success!");
			} else {
				System.out.println("Update ActiveFlagEnd Fail...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ExhibitionDto getExhibition(int exhID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ExhibitionDto exhDto = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select * from artshow where ExhID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exhID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				exhDto = new ExhibitionDto(rs.getInt("exhID"), rs.getString("memberID"), rs.getString("exhGubun1"), rs.getString("exhGubun2"), rs.getString("exhGubun4"), rs.getString("exhName"), rs.getString("artistName"), rs.getString("artistInfo"), rs.getString("exhContent"), rs.getString("exhPlace"), rs.getString("exhPlaceZip"), rs.getString("exhPlaceAddr1"), rs.getString("exhPlaceAddr2"), rs.getString("exhUrl"), rs.getString("exhStartDate"), rs.getString("exhEndDate"), rs.getString("opTime"), rs.getString("tel"), rs.getString("admFee"), rs.getString("imageFile1"), rs.getString("imageFile2"), rs.getString("imageFile3"), rs.getString("imageFile4"), rs.getInt("exhReadCount"), rs.getTimestamp("registerDate"), rs.getString("activeFlag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return exhDto;
	}

	public List<String> getExhListTags(int exhID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<String> list = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select * from artshowtag where exhid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exhID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				list = new ArrayList<>();
				
				do {
					list.add(rs.getString(2));
				} while (rs.next());
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int deleteExhListTags(int exhID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "delete from artshowtag where exhid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exhID);
			
			res = pstmt.executeUpdate();
			
			if (res > 0) {
				System.out.println("Delete ArtShowTag Success!");
			} else {
				System.out.println("Delete ArtShowTag Fail...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public int updateExhListTags(int exhID, String tag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "insert artshowtag set exhid = ?, tagname = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exhID);
			pstmt.setString(2, tag);
			
			res = pstmt.executeUpdate();
			
			if (res > 0) {
				System.out.println("Update ArtShowTag Success!");
			} else {
				System.out.println("Update ArtShowTag Fail...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public int updateExhContent(ExhibitionDto modifyExhibitionDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "update artshow set MemberID = ?, ExhGubun1 = ?, ExhGubun2 = ?, ExhGubun4 = ?, ExhName = ?, ArtistName = ?, ArtistInfo = ?, ExhContent = ?, ExhPlace = ?, ExhPlaceZip = ?, ExhPlaceAddr1 = ?, ExhPlaceAddr2 = ?, ExhUrl = ?, exhstartdate = ?, exhenddate = ?, OpTime = ?, Tel = ?, AdmFee = ? where ExhID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifyExhibitionDto.getMemberID());
			pstmt.setString(2, modifyExhibitionDto.getExhGubun1());
			pstmt.setString(3, modifyExhibitionDto.getExhGubun2());
			pstmt.setString(4, modifyExhibitionDto.getExhGubun4());
			pstmt.setString(5, modifyExhibitionDto.getExhName());
			pstmt.setString(6, modifyExhibitionDto.getArtistName());
			pstmt.setString(7, modifyExhibitionDto.getArtistInfo());
			pstmt.setString(8, modifyExhibitionDto.getExhContent());
			pstmt.setString(9, modifyExhibitionDto.getExhPlace());
			pstmt.setString(10, modifyExhibitionDto.getExhPlaceZip());
			pstmt.setString(11, modifyExhibitionDto.getExhPlaceAddr1());
			pstmt.setString(12, modifyExhibitionDto.getExhPlaceAddr2());
			pstmt.setString(13, modifyExhibitionDto.getExhUrl());
			pstmt.setString(14, modifyExhibitionDto.getExhStartDate());
			pstmt.setString(15, modifyExhibitionDto.getExhEndDate());
			pstmt.setString(16, modifyExhibitionDto.getOpTime());
			pstmt.setString(17, modifyExhibitionDto.getTel());
			pstmt.setString(18, modifyExhibitionDto.getAdmFee());
			pstmt.setInt(19, modifyExhibitionDto.getExhID());
			
			res = pstmt.executeUpdate();
			
			if (res > 0) {
				System.out.println("Update ArtShow without ImageFile Success!");
			} else {
				System.out.println("Update ArtShow without ImageFile Fail...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public int updateImageFile(ExhibitionDto modifyExhibitionDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		try {
			conn = ds.getConnection();
			
			if (modifyExhibitionDto.getImageFile1() != null) {
				String sql = "update artshow set ImageFile1 = ? where ExhID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, modifyExhibitionDto.getImageFile1());
				pstmt.setInt(2, modifyExhibitionDto.getExhID());
				
				int res1 = pstmt.executeUpdate();
				
				if (res1 > 0) {
					System.out.println("Update ArtShow ImageFile1 Success!");
				} else {
					System.out.println("Update ArtShow ImageFile1 Fail...");
				}
				
				res = res1;
				pstmt.close();
			}

			if (modifyExhibitionDto.getImageFile2() != null) {
				String sql = "update artshow set ImageFile2 = ? where ExhID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, modifyExhibitionDto.getImageFile2());
				pstmt.setInt(2, modifyExhibitionDto.getExhID());
				
				int res2 = pstmt.executeUpdate();
				
				if (res2 > 0) {
					System.out.println("Update ArtShow ImageFile2 Success!");
				} else {
					System.out.println("Update ArtShow ImageFile2 Fail...");
				}
				
				res = res2;
				pstmt.close();
			}
			
			if (modifyExhibitionDto.getImageFile3() != null) {
				String sql = "update artshow set ImageFile3 = ? where ExhID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, modifyExhibitionDto.getImageFile3());
				pstmt.setInt(2, modifyExhibitionDto.getExhID());
				
				int res3 = pstmt.executeUpdate();
				
				if (res3 > 0) {
					System.out.println("Update ArtShow ImageFile3 Success!");
				} else {
					System.out.println("Update ArtShow ImageFile3 Fail...");
				}
				
				res = res3;
				pstmt.close();
			}

			if (modifyExhibitionDto.getImageFile4() != null) {
				String sql = "update artshow set ImageFile4 = ? where ExhID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, modifyExhibitionDto.getImageFile4());
				pstmt.setInt(2, modifyExhibitionDto.getExhID());
				
				int res4 = pstmt.executeUpdate();
				
				if (res4 > 0) {
					System.out.println("Update ArtShow ImageFile4 Success!");
				} else {
					System.out.println("Update ArtShow ImageFile4 Fail...");
				}
				
				res = res4;
			} else {
				System.out.println("이미지 변동사항 없음..!!");	
				res = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return res;
	}




	public int deleteExhContent(int exhID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "delete from artshow where ExhID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exhID);
			
			res = pstmt.executeUpdate();
			

			if (res > 0) {
				System.out.println("Delete ArtShow Success!");
				
				pstmt.close();
				
				String sql2 = "delete from artshowtag where ExhID = ?";
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, exhID);
				
				int res2 = pstmt.executeUpdate();
				
				if (res2 > 0) {
					System.out.println("Delete ArtShowTag Success!");
				} else {
					System.out.println("Delete ArtShowTag Fail...");
				}
				
				res = res2;
			} else {
				System.out.println("Delete ArtShow Fail...");
				
				return res;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}




	public String[] getImageFile(int exhID) {
		Connection conn	= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int	count = 0;
		String[] imageFile = new String[4];
		
		try {
			conn = ds.getConnection();
			
			String sql = "select imageFile1, imageFile2, imageFile3, imageFile4 from artshow where exhID=?";
			
			pstmt =	conn.prepareStatement(sql);
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

	public void setVisitDate() {
		Connection conn	= null;
		Statement stmt = null;
		
		int res = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "insert into visitPage values(sysdate())";
			
			stmt = conn.createStatement();
			
			res = stmt.executeUpdate(sql);
			
			if (res > 0) {
				System.out.println("Insert visitDate Success!");
			} else {
				System.out.println("Insert visitDate Fail...");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int getTodayVisitCnt() {
		Connection conn	= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int res = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select count(*) from visitPage where visitDate = date(sysdate())";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public int getWeekVisitCnt(String weekValue) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int weekVisitCnt = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select count(*) from visitPage where visitDate = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, weekValue);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				weekVisitCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return weekVisitCnt;
	}

	public int getMonthVisitCnt(String year, String monthValue) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int monthVisitCnt = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select count(*) from visitPage where year(visitDate) = ? and month(visitDate) = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, year);
			pstmt.setString(2, monthValue);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				monthVisitCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return monthVisitCnt;
	}

	public int getAgeCnt(int startYear, int lastYear) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int memberAgeCnt = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select count(*) from member where left(birth, 4) >= ? and left(birth, 4) <= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startYear);
			pstmt.setInt(2, lastYear);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				memberAgeCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberAgeCnt;
	}
	
	
}
