package com.doArtShow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.MemberDto;
import com.doArtShow.dto.MyReviewDto;
import com.doArtShow.dto.ReviewDto;

// 회원 정보 dao
public class MemberDao {
   DataSource ds;
   
   public void setDataSource(DataSource ds){
      this.ds = ds;
   }
   //-------------------------------------------------------------------
   // 회원가입 시 이메일 중복확인
   //-------------------------------------------------------------------
   public int checkEmail(String email) throws Exception{
      Connection 		conn 	= null;
      PreparedStatement pstmt 	= null;
      ResultSet 		rs 		= null;
      String 			sql 	= "";
      int 				res 	= 0;
      
      try {
         conn 	= ds.getConnection();
         sql  	= "SELECT * FROM MEMBER WHERE EMAIL=?";
         pstmt 	= conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs 	= pstmt.executeQuery();
         
         if(rs.next()){
            res = 1;
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return res;
   }
   
   //-------------------------------------------------------------------
   // 회원가입(회원 추가)
   //-------------------------------------------------------------------
   public void insertMember(MemberDto member) {
      Connection		conn	= null;
      PreparedStatement pstmt   = null;
      String            sql    	= null;
      
      try {
         conn 	= ds.getConnection();
         sql 	= "INSERT INTO MEMBER(EMAIL, NAME, BIRTH, GENDER, PW) "
            + "VALUES (?,?,?,?,password(?))";
         pstmt 	= conn.prepareStatement(sql);
         pstmt.setString(1, member.getEmail());
         pstmt.setString(2, member.getName());
         pstmt.setString(3, member.getBirth());
         pstmt.setString(4, member.getGender());
         pstmt.setString(5, member.getPw());
         
         pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
         try {if(conn!=null)conn.close();} catch (SQLException e) {}
      }
   }
   
   //-------------------------------------------------------------------
   // 로그인 시 입력한 정보에 대한 회원이 있는지 확인
   //-------------------------------------------------------------------
   public MemberDto checkMember(String email, String pw) {
      Connection 		conn 	= null;
      PreparedStatement pstmt 	= null;
      ResultSet 		rs 		= null;
      String 			sql 	= null;
      
      MemberDto 		member 	= null;
      
      try {
         conn 	= ds.getConnection();
         sql 	= "SELECT * FROM MEMBER WHERE EMAIL=? AND PW=password(?) ";
         pstmt 	= conn.prepareStatement(sql);
         pstmt.setString(1, email);
         pstmt.setString(2, pw);
         
         rs 	= pstmt.executeQuery();
         
         member = new MemberDto();

         while(rs.next()){
            member.setBirth(rs.getString("birth"));
            member.setGender(rs.getString("gender"));
            member.setPw(rs.getString("pw"));
            member.setEmail(rs.getString("email"));
            member.setName(rs.getString("name"));
            member.setProfileImg(rs.getString("profileImg"));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
         try {if(rs      != null)rs.close();      } catch (SQLException e) {}
         try {if(conn    != null)conn.close();   } catch (SQLException e) {}
      }
      
      return member;
   }

   //-------------------------------------------------------------------
   // 로그인 후 해당 회원정보를 모아 session형성
   //-------------------------------------------------------------------
   public MemberDto selectInfo(String email) {
      Connection 		conn 	= null;
      PreparedStatement pstmt 	= null;
      ResultSet 		rs 		= null;
      String 			sql 	= null;
      
      MemberDto member = null;
      try {
         conn 	= ds.getConnection();
         sql 	= "SELECT * FROM MEMBER WHERE email=?";
         pstmt 	= conn.prepareStatement(sql);
         pstmt.setString(1, email);
         
         rs 	= pstmt.executeQuery();
         
         member = new MemberDto();
         
         while(rs.next()){
            member.setEmail(rs.getString("email"));
            member.setGender(rs.getString("gender"));
            member.setPw(rs.getString("pw"));
            member.setBirth(rs.getString("birth"));
            member.setName(rs.getString("name"));
            member.setProfileImg(rs.getString("profileImg"));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
         try {if(rs      != null)rs.close();      } catch (SQLException e) {}
         try {if(conn   != null)conn.close();   } catch (SQLException e) {}
      }
      
      return member;
   }
   
   //-------------------------------------------------------------------
   // 회원정보 수정(생년월일, 성별, 비밀번호)
   //-------------------------------------------------------------------
   public void updateMember(String birth, String gender, String pw, String email) {
      Connection		conn    = null;
      PreparedStatement	pstmt	= null;
      String            sql    	= null;
      
      try {
         conn 	= ds.getConnection();
         sql 	= "UPDATE MEMBER SET birth=?, gender=?, pw=password(?) WHERE email=?";
         pstmt 	= conn.prepareStatement(sql);
         pstmt.setString(1, birth);
         pstmt.setString(2, gender);
         pstmt.setString(3, pw);
         pstmt.setString(4, email);
         
         pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
         try {if(conn!=null)conn.close();} catch (SQLException e) {}
      }
   }
   
   //-------------------------------------------------------------------
   // 회원 프로필사진 수정
   //-------------------------------------------------------------------
   public void updateProfileImg(String profileImg, String email) {
      Connection        conn   = null;
      PreparedStatement	pstmt  = null;
      String            sql    = null;
      
      try {
         conn 	= ds.getConnection();
         sql 	= "UPDATE MEMBER SET profileImg=? WHERE email=?";
         pstmt 	= conn.prepareStatement(sql);
         pstmt.setString(1, profileImg);
         pstmt.setString(2, email);
         
         pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
         try {if(conn!=null)conn.close();} catch (SQLException e) {}
      }      
   }
   
   //-------------------------------------------------------------------
   // 이메일 찾기 
   //-------------------------------------------------------------------
   public String findEmail(String name, String birth) {
      Connection 		conn	= null;
      PreparedStatement pstmt 	= null;
      ResultSet 		rs 		= null;
      String 			sql 	= null;
      
      String 			email 	= null;
      
      try {
         conn 	= ds.getConnection();
         sql 	= "SELECT email FROM MEMBER WHERE name=? AND birth=?";
         pstmt 	= conn.prepareStatement(sql);
         pstmt.setString(1, name);
         pstmt.setString(2, birth);
         
         rs 	= pstmt.executeQuery();
                  
         if(rs.next()){
            email = rs.getString("email");
            System.out.println(email);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
         try {if(rs      != null)rs.close();      } catch (SQLException e) {}
         try {if(conn   != null)conn.close();   } catch (SQLException e) {}
      }
      
      return email;
   }

   //-------------------------------------------------------------------
   // 비밀번호 찾기
   //-------------------------------------------------------------------
   public String findPw(String email, String birth) {
      Connection 		conn 	= null;
      PreparedStatement pstmt 	= null;
      ResultSet 		rs 		= null;
      String 			sql 	= null;
      
      String 			pw 		= null;
      
      try {
         conn = ds.getConnection();
         sql = "SELECT pw FROM MEMBER WHERE email=? AND birth=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         pstmt.setString(2, birth);
         
         rs = pstmt.executeQuery();
                  
         while(rs.next()){
            pw = rs.getString("pw");
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
         try {if(rs      != null)rs.close();      } catch (SQLException e) {}
         try {if(conn   != null)conn.close();   } catch (SQLException e) {}
      }
      
      return pw;
   }
   
   //-------------------------------------------------------------------
   // 임시비밀번호를 생성하고 임시비밀번호로 비밀번호를 수정(회원에 의한 수정이 아님. 자동으로 이루어짐)
   //-------------------------------------------------------------------
   public void changePw(String newPw, String email, String birth) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql = null;
      
      try {
         conn = ds.getConnection();
         sql = "UPDATE MEMBER SET pw=password(?) WHERE email=? AND birth=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, newPw);
         pstmt.setString(2, email);
         pstmt.setString(3, birth);
         
         pstmt.executeUpdate();         
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
         try {if(conn   != null)conn.close();   } catch (SQLException e) {}
      }
   }
   
   //-------------------------------------------------------------------
   // 회원 탈퇴
   //-------------------------------------------------------------------
   public void deleteMember(String email) {
      Connection    	conn 	= null;
      Statement   		stmt 	= null;
      PreparedStatement pstmt 	= null;
      String 			sql1 	= null;
      String 			sql2 	= null;
      String 			sql3 	= null;
      
      try {
         conn = ds.getConnection();
         
         sql1 = "SET foreign_key_checks = 0";
         stmt = conn.createStatement();
         stmt.executeUpdate(sql1);
         
         sql2  = "DELETE FROM MEMBER WHERE email=?";
         pstmt = conn.prepareStatement(sql2);
         pstmt.setString(1, email);
         pstmt.executeUpdate();
         
         sql3  = "SET foreign_key_checks = 1";
         stmt = conn.createStatement();
         stmt.executeUpdate(sql3);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
         try {if(conn   != null)conn.close();   } catch (SQLException e) {}
      }
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp)에 쓸 가고 싶은 전시 목록을 구성
   //-------------------------------------------------------------------
   public ArrayList<ExhibitionDto> selectWishList(String email) throws Exception{
	   ExhibitionDto             	exhibitionDto;
	   ArrayList<ExhibitionDto>    	wishList		= null;

       Connection          	conn		= null;
       PreparedStatement    pstmt    	= null;
       ResultSet          	rs       	= null;
       String             	sql    		= "";
      
      try {
         conn    = ds.getConnection();
         sql     =  "SELECT  exhID, exhName, imageFile1 ";
         sql     += "FROM   artshow ";
         sql     += "WHERE    exhID   IN ( SELECT exhID ";
         sql     +=                   "FROM   wishart ";
         sql     +=                   "WHERE  email=?)";
         
         pstmt    = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs       = pstmt.executeQuery();
         
         wishList = new ArrayList<ExhibitionDto>();
         
         while(rs.next()) {
            exhibitionDto    = new ExhibitionDto();
            exhibitionDto.setExhID(rs.getInt("exhID"));
            exhibitionDto.setExhName(rs.getString("exhName"));
            exhibitionDto.setImageFile1(rs.getString("imageFile1"));
                        
            wishList.add(exhibitionDto);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return wishList;
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp) 회원이 가고 싶어 하는 전시의 개수를 찾는다.
   //-------------------------------------------------------------------
   public int countWishExh(String email) {
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
      
      int 					wishCount 	= 0;
      
      try {
         conn    = ds.getConnection();
         sql     = "SELECT  count(*) ";
         sql    += "FROM   wishart    ";
         sql    += "WHERE   email=?    ";
         
         pstmt    = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs       = pstmt.executeQuery();
         
         if(rs.next()) {
            wishCount = rs.getInt(1);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return wishCount;
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp)에 쓸 다녀온 전시 목록을 구성
   //-------------------------------------------------------------------
   public ArrayList<ExhibitionDto> selectVisitList(String email) throws Exception{
      ArrayList<ExhibitionDto>    visitList       = null;
      ExhibitionDto             exhibitionDto;
            
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
            
      try {
         conn    = ds.getConnection();
         conn    = ds.getConnection();
         sql     = "SELECT  exhID, exhName, imageFile1 ";
         sql    += "FROM   artshow ";
         sql    += "WHERE    exhID   IN ( SELECT exhID     ";
         sql    +=                   "FROM   visitart ";
         sql    +=                   "WHERE  email=?) ";
         pstmt   = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs      = pstmt.executeQuery();
         
         visitList       = new ArrayList<ExhibitionDto>();
         
         while(rs.next()) {
            exhibitionDto    = new ExhibitionDto();
            exhibitionDto.setExhID(rs.getInt("exhID"));
            exhibitionDto.setExhName(rs.getString("exhName"));
            exhibitionDto.setImageFile1(rs.getString("imageFile1"));
                        
            visitList.add(exhibitionDto);
         }
               
         } catch (Exception e) {
            e.printStackTrace();
               
         } finally {
            if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
            if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
            if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
         }
         return visitList;
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp) 다녀온 전시 개수를 찾는 메소드
   //-------------------------------------------------------------------
   public int countVisitExh(String email) {
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
      
      int visitCount = 0;
      
      try {
         conn    = ds.getConnection();
         sql     = "SELECT  count(*) ";
         sql    += "FROM   visitart ";
         sql    += "WHERE   email=?    ";
         
         pstmt    = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs       = pstmt.executeQuery();
         
         if(rs.next()) {
            visitCount = rs.getInt(1);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return visitCount;
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp)에 내가작성한 리뷰 목록와 해당 전시 정보를 구성
   //-------------------------------------------------------------------
   public ArrayList<MyReviewDto> selectReviewList(String email) throws Exception{
      ArrayList<MyReviewDto>    reviewList       = null;
      MyReviewDto          		myReview;
      
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
      
      try {
         conn    = ds.getConnection();
         sql     = "SELECT      artshow.ExhID, review.revDate, review.revContent, artshow.ImageFile1, artshow.ExhName "; 
         sql    += "FROM      review, artshow ";
         sql    += "WHERE      review.ExhID = artshow.ExhID ";
         sql    += "   AND    review.email=? "; 
         sql    += "ORDER BY   review.revDate;";
         pstmt   = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs      = pstmt.executeQuery();
         
         reviewList	= new ArrayList<MyReviewDto>();
         
         while(rs.next()) {
            myReview       = new MyReviewDto();
            myReview.setExhID(rs.getInt("ExhID"));
            myReview.setRevDate(rs.getDate("revDate"));
            myReview.setRevContent(rs.getString("revContent"));
            myReview.setImageFile1(rs.getString("ImageFile1"));
            myReview.setExhName(rs.getString("ExhName"));
            reviewList.add(myReview);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return reviewList;
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp) 작성한 리뷰의 개수를 찾는 메소드
   //-------------------------------------------------------------------
   public int countReview(String email) {
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
      
      int reviewCount = 0;
      
      try {
         conn    = ds.getConnection();
         sql     = "SELECT  count(*) ";
         sql    += "FROM   review ";
         sql    += "WHERE   email=?    ";
         
         pstmt    = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs       = pstmt.executeQuery();
         
         if(rs.next()) {
            reviewCount = rs.getInt(1);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return reviewCount;
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp)에 등록한 전시 목록
   //-------------------------------------------------------------------
   public ArrayList<ExhibitionDto> selectMyExhList(String email) throws Exception{
      ArrayList<ExhibitionDto>    	myExhList       = null;
      ExhibitionDto             	myExhibition;
      
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
      
      try {
         conn    = ds.getConnection();
         sql     =  "SELECT   exhID, exhName, imageFile1 "; 
         sql    += "FROM   artshow ";
         sql    += "WHERE   memberID=? "; 

         pstmt   = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs      = pstmt.executeQuery();
         
         myExhList       = new ArrayList<ExhibitionDto>();
         
         while(rs.next()) {
            myExhibition       = new ExhibitionDto();
            myExhibition.setExhID(rs.getInt("exhID"));
            myExhibition.setExhName(rs.getString("ExhName"));
            myExhibition.setImageFile1(rs.getString("imageFile1"));
            
            myExhList.add(myExhibition);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return myExhList;
   }
   
   //-------------------------------------------------------------------
   // 회원페이지(memberPage.jsp) 등록한 전시의 개수
   //-------------------------------------------------------------------
   public int countMyExh(String email) {
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
      
      int myExhCount = 0;
      
      try {
         conn    = ds.getConnection();
         sql     =  "SELECT  count(*) ";
         sql    += "FROM   artshow ";
         sql    += "WHERE   memberID=?    ";
         
         pstmt   = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         rs      = pstmt.executeQuery();
         
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
   
   //-------------------------------------------------------------------
   // 리뷰페이지(reviewList.jsp) 리뷰 수정 
   //-------------------------------------------------------------------
   public void updateReveiw(String email, int exhID, String revContent) {
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      String             	sql    		= null;
      
      try {
         conn = ds.getConnection();
         sql = "UPDATE review SET revContent=? WHERE email=? and exhID=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, revContent);
         pstmt.setString(2, email);
         pstmt.setInt(3, exhID);
         
         pstmt.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
         try {if(conn!=null)conn.close();} catch (SQLException e) {}
      }
   }
   //-------------------------------------------------------------------
   // 리뷰페이지(reviewList.jsp) 리뷰 삭제
   //-------------------------------------------------------------------
   public void deleteReveiw(String email, int exhID) {
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      String             	sql    		= null;
      
      try {
         conn = ds.getConnection();
         sql = "DELETE FROM review WHERE email=? and exhID=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         pstmt.setInt(2, exhID);
         
         pstmt.executeUpdate();
         
         System.out.println("1111121212");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
         try {if(conn!=null)conn.close();} catch (SQLException e) {}
      }
   }
   
   //-------------------------------------------------------------------
   // 전시 이름에 따른 전시 아이디 가져오기
   //-------------------------------------------------------------------
   public int getExhID(String exhName) {
      Connection          	conn    	= null;
      PreparedStatement    	pstmt    	= null;
      ResultSet          	rs       	= null;
      String             	sql    		= "";
      
      int exhID = 0;
      
      try {
         conn    = ds.getConnection();
         sql     =  "SELECT  exhID ";
         sql      += "FROM   artshow ";
         sql      += "WHERE   exhName=?    ";
         
         pstmt    = conn.prepareStatement(sql);
         pstmt.setString(1, exhName);
         rs       = pstmt.executeQuery();
         
         if(rs.next()) {
            exhID = rs.getInt(1);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      } finally {
         if(rs    != null) try {rs.close();   } catch(SQLException ex) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
         if(conn  != null) try {conn.close(); } catch(SQLException ex) {}
      }
      return exhID;
   }
   
   //////////////////////////////////////////////////////////////////////
   //KaKao 멤버 로그인 / 회원가입
   public MemberDto kakaoCheckMember(String email, String kakaoId, String kname, String kbirth, String kgender) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = null;
	      MemberDto member = null;
	      
	      try {
	         conn = ds.getConnection();
	         sql = "SELECT * FROM MEMBER WHERE kakaoId= ? ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, kakaoId);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()){//1. DB에 kakaoId 있음.
	        	 System.out.println("rs가 있습니다.");
	        	 //1-1. 해당 kakaoId의 email가져와서 로그인 처리 (세션 put)
	        		 member = new MemberDto();
	        		 do{
	        		 member.setBirth(rs.getString("birth"));
	        		 member.setGender(rs.getString("gender"));
	        		 member.setEmail(rs.getString("email"));
	        		 member.setName(rs.getString("name"));
	        		 member.setProfileImg(rs.getString("profileImg"));
	        		 member.setKakaoId(rs.getString("kakaoId"));
	        		 }while(rs.next());
	        		 System.out.println("email이 잘 넘어오나 테스트 memberDAO 1::"+email);
	        		 
	        	}else{//2. kakaoId에 해당하는 member 없음
	        		System.out.println("email이 잘 넘어오나 테스트 memberDAO 2::"+email);
	        		if(email.equals("nothing")){
	        			System.out.println("여긴 3::");
	        			member = new MemberDto();
	        			member.setProfileImg("회원가입필요함");
	        			return member;
	        			}
	        			//새로 가입해야 하는데 kakao에 등록된 email이 이미 사용중인지 확인해본다.
		        		try{
		        		sql=" SELECT * from member where email= ? ";
		        		pstmt = conn.prepareStatement(sql);
		        		pstmt.setString(1, email);
		        		rs = pstmt.executeQuery();
		        		
		        		}catch(SQLException e){
		        			member = new MemberDto();
		        			member.setProfileImg("에러발생");
		        			return member;
		        		}
		        		
	        		if(rs.next()){//2-1. DB에 카카오 로그인에서 사용하는 email이 이미 등록돼 있음.
	        			//컨트롤러에서 분기하기 위해서
	        			System.out.println("DB에 이메일이 중복됩니다.");
	        			member = new MemberDto();
	        			member.setProfileImg("이메일중복");
	        		}else{//2-2. DB에 kakaoId, email이 모두 새로 입력됨. 회원가입처리
		        	 System.out.println("rs는 null입니다. kakaoId("+kakaoId+")로 회원가입을 진행합니다");
		        	 member = new MemberDto();
			        	  try{ 
			        		  
			              sql = "INSERT INTO MEMBER(EMAIL, NAME, BIRTH, GENDER, kakaoId) "
			                     + "VALUES (?,?,?,?,?)";
		                  pstmt = conn.prepareStatement(sql);
		                  pstmt.setString(1, email);
		                  pstmt.setString(2, kname);
		                  pstmt.setString(3, kbirth);
		                  pstmt.setString(4, kgender);
		                  pstmt.setString(5, kakaoId);
		                  pstmt.executeUpdate();
		                  //컨트롤러로 돌아가서 분기하기 위해서
		                  member.setProfileImg("회원가입했어요!로그인해줘요");
		                  }catch(SQLException e){
		                	e.printStackTrace();
		                	member = new MemberDto();
		        			member.setProfileImg("에러발생");
		        			return member;
		        			}
	        		}
	        	}
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
	         try {if(rs      != null)rs.close();      } catch (SQLException e) {}
	         try {if(conn   != null)conn.close();   } catch (SQLException e) {}
	      }
	      
	      return member;
	   }
   
   	//////////////////////////////////////////////////////////
   //네이버 아이디 로그인 및 회원가입처리
   public MemberDto naverCheckMember(String email, String naverId, String kname, String kbirth, String kgender) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = null;
	      MemberDto member = null;
	      
	      try {
	         conn = ds.getConnection();
	         sql = "SELECT * FROM MEMBER WHERE naverId= ? ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, naverId);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()){//1. DB에 naverId 있음.
	        	 System.out.println("rs가 있습니다.");
	        	 //1-1. 해당 naverId의 email가져와서 로그인 처리 (세션 put)
	        		 member = new MemberDto();
	        		 do{
	        		 member.setBirth(rs.getString("birth"));
	        		 member.setGender(rs.getString("gender"));
	        		 member.setEmail(rs.getString("email"));
	        		 member.setName(rs.getString("name"));
	        		 member.setProfileImg(rs.getString("profileImg"));
	        		 member.setKakaoId(rs.getString("naverId"));
	        		 }while(rs.next());
	        		 System.out.println("email이 잘 넘어오나 테스트 memberDAO 1::"+email);
	        		 return member;
	        	}else{//2. naverId에 해당하는 member 없음
	        		System.out.println("email이 잘 넘어오나 테스트 memberDAO 2::"+email);
	        		/*if(email.equals("nothing")){
	        			System.out.println("여긴 3::");
	        			member = new MemberDto();
	        			member.setProfileImg("회원가입필요함");
	        			return member;
	        			}*/
	        		
	        			//새로 가입해야 하는데 naver에 등록된 email이 이미 사용중인지 확인해본다.
		        		sql=" SELECT * from member where email= ? ";
		        		pstmt = conn.prepareStatement(sql);
		        		pstmt.setString(1, email);
		        		rs = pstmt.executeQuery();
		        		
	        		if(rs.next()){//2-1. DB에 네이버 로그인에서 사용하는 email이 이미 등록돼 있음.
	        			//컨트롤러에서 분기하기 위해서
	        			System.out.println("DB에 이메일이 중복됩니다.");
	        			member = new MemberDto();
	        			member.setProfileImg("이메일중복");
	        			return member;
	        		}else{//2-2. DB에 naverId, email이 모두 새로 입력됨. 회원가입처리
		        	 System.out.println("rs는 null입니다. naverId("+naverId+")로 회원가입을 진행합니다");
		        	 member = new MemberDto();
			        	  try{ 
			        		  
			              sql = "INSERT INTO MEMBER(EMAIL, NAME, BIRTH, GENDER, naverId) "
			                     + "VALUES (?,?,?,?,?)";
		                  pstmt = conn.prepareStatement(sql);
		                  pstmt.setString(1, email);
		                  pstmt.setString(2, kname);
		                  pstmt.setString(3, kbirth);
		                  pstmt.setString(4, kgender);
		                  pstmt.setString(5, naverId);
		                  pstmt.executeUpdate();
		                  
		                  member.setEmail(email).setBirth(kbirth).setName(kname).setGender(kgender).setProfileImg("default.jpg");
		                  
		                  //컨트롤러로 돌아가서 분기하기 위해서
		                  //member.setProfileImg("회원가입했어요!로그인해줘요");
		                  return member;
		                  }catch(SQLException e){
		                	e.printStackTrace();
		                	member = new MemberDto();
		        			member.setProfileImg("에러발생");
		        			return member;
		        			}
	        		}
	        	}
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {if(pstmt   != null)pstmt.close();   } catch (SQLException e) {}
	         try {if(rs      != null)rs.close();      } catch (SQLException e) {}
	         try {if(conn   != null)conn.close();   } catch (SQLException e) {}
	      }
	      
	      return member;
	   }
   
   
}