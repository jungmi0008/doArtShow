package com.doArtShow.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UploadUtil {
	//--------------------------------------------------------------------------------------------------
	// begin: fileUpload(String saveFolder, int fileSize, HttpServletRequest request) - 단일 파일을 업로드하는 메소드  
	// programmed by Hojeong 20.01.02
	//--------------------------------------------------------------------------------------------------
	// newly added by Hojeong 20/01/03(yy/mm/dd)
	public static MultipartRequest multi;				// MultipartRequest for fileUpload static 변수 선언
	public static String fileUpload(String saveFolder, int fileSize, HttpServletRequest request) {
		String realFolder = "";															 
		ServletContext context = request.getServletContext();					 
		realFolder = context.getRealPath(saveFolder);								 
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();	 
		String filename = null;
		
		try {				
				// 전송을 담당할 컴포넌트를 생성하고 파일을 전송한다.
			// 전송할 파일명을 가지고 있는 객체, 서버상의 절대경로, 최대업로드될 파일크기, 문자코드, 기본보안적용
			multi = new MultipartRequest(request, realFolder, 					
					fileSize, "UTF-8", new DefaultFileRenamePolicy());
			// 전송한 파일 정보를 가져와 출력한다.

			Enumeration<?> files = multi.getFileNames();

			// 파일정보가 있다면,
			while (files.hasMoreElements()) {
				// input 태그의 속성이 files인 태그의 name 속성값: 파라메터 이름
				String name = (String) files.nextElement();
					if(multi.getFilesystemName(name)!=null){
					// 서버에 저장된 파일 이름
					filename = multi.getFilesystemName(name);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}
	//--------------------------------------------------------------------------------------------------
	// End: fileUpload(String saveFolder, int fileSize, HttpServletRequest request) - 단일 파일을 업로드하기위한 메소드  
	// programmed by Hojeong 20.01.02
	//--------------------------------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------------------------------
	// begin: filesUpload(String saveFolder, int fileSize, HttpServletRequest request) - 다중 파일을 업로드하기위한 메소드 
	// programmed by Hojeong 20.01.02
	//--------------------------------------------------------------------------------------------------
	public static String[] filesUpload(String saveFolder, int fileSize, HttpServletRequest request) {
		String realFolder = "";															 
		ServletContext context = request.getServletContext();					 
		realFolder = context.getRealPath(saveFolder);								 
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();	 
		String[] filename = new String[4];	
		
		try {				
			System.out.println("$$$filesupload");
			// 전송을 담당할 컴포넌트를 생성하고 파일을 전송한다.
			// 전송할 파일명을 가지고 있는 객체, 서버상의 절대경로, 최대업로드될 파일크기, 문자코드, 기본보안적용
			multi = new MultipartRequest(request, realFolder, 					
					fileSize, "UTF-8", new DefaultFileRenamePolicy());
			// 전송한 파일 정보를 가져와 출력한다.

			Enumeration<?> files = multi.getFileNames();

			// 파일정보가 있다면,
			int k = 0;
			while (files.hasMoreElements()) {
				// input 태그의 속성이 files인 태그의 name 속성값: 파라메터 이름
				String name = (String) files.nextElement();
				System.out.println("filename#" + k + ":" + multi.getFilesystemName(name));
				if(multi.getFilesystemName(name)!=null){
					// 서버에 저장된 파일 이름
					filename[k] = multi.getFilesystemName(name);
					// filename = multi.getFilesystemName(name);
					System.out.println("filename*" + k + ":" + filename[k]);
				} else {							// modified by Hojeong 20/01/08(yy/mm/dd)
					filename[k] = "Nothing.png";	// modified by Hojeong 20/01/08(yy/mm/dd)
				}									// modified by Hojeong 20/01/08(yy/mm/dd)
				k++;								// modified by Hojeong 20/01/08(yy/mm/dd)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}
	//--------------------------------------------------------------------------------------------------
	// end: filesUpload(String saveFolder, int fileSize, HttpServletRequest request) - 다중 파일을 업로드하는 메소드  
	// programmed by Hojeong 20.01.02
	//--------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------
	// begin: filesUpload(String saveFolder, int fileSize, HttpServletRequest request) - 다중 파일을 업로드하기위한 메소드 
	// programmed by Hojeong 20.01.02
	//--------------------------------------------------------------------------------------------------
	public static String[] filesUpload_Rename(String saveFolder, int fileSize, HttpServletRequest request) {
		String realFolder = "";                                              
		ServletContext context = request.getServletContext();                
		realFolder = context.getRealPath(saveFolder);                         
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();    
		String[] filename = new String[4];   
	  
		try {            
			System.out.println("$$$filesupload");
			// 전송을 담당할 컴포넌트를 생성하고 파일을 전송한다.
			// 전송할 파일명을 가지고 있는 객체, 서버상의 절대경로, 최대업로드될 파일크기, 문자코드, 기본보안적용
			multi = new MultipartRequest(request, realFolder,                
				fileSize, "UTF-8", new DefaultFileRenamePolicy());
			// 전송한 파일 정보를 가져와 출력한다.
	
			Enumeration<?> files = multi.getFileNames();
			/*
	 		String fileName = "원본파일명";    //확장자포함한다.
			String newFileName = "원하는파일명.확장자";
			String saveDir = "C:/UploadFiles';
			
			if(!fileName.equals("")) {
			     // 원본이 업로드된 절대경로와 파일명를 구한다.
			     fullFileName = saveDir + "/" + fileNAme;
			     java.io.File f1 = new java.io.File(fullFileName);
			     if(f1.exists()) {     // 업로드된 파일명이 존재하면 Rename한다.
			          java.io.File newFile = java.io.File(saveDir + "/" + newFileName);
			          f1.renameTo(newFile);   // rename...
			     }
			 }*/
	
			// 파일정보가 있다면,
			int k = 0;
			while (files.hasMoreElements()) {
				// input 태그의 속성이 files인 태그의 name 속성값: 파라메터 이름
				String name = (String) files.nextElement();
				String oldFileName = multi.getFilesystemName(name);                  
				System.out.println("uploadUtil_name:" + oldFileName);
				System.out.println("filename#" + k + ":" + multi.getFilesystemName(name));
				if(multi.getFilesystemName(name)!=null){
					// 서버에 저장된 파일 이름
					String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //현재시간
					int i = -1;
					i = oldFileName.lastIndexOf("."); // 파일 확장자 위치 
					System.out.println("oldFileName.lastIndexOf: " + i);
					String newFileName = now + oldFileName.substring(i, oldFileName.length());  //현재시간과 확장자 합치기
					System.out.println("oldFileName.substring(i, name.length(): " + oldFileName.substring(i, name.length()));
					String fullFileName=realFolder+"/"+oldFileName;
					File f1 = new File(fullFileName);
					if(f1.exists()) { //업로드된 파일명이 존재하면 Rename한다. 
						File newFile = new File(realFolder+"/"+newFileName);
						f1.renameTo(newFile); //rename
						filename[k] = newFile.getName();
						// filename = multi.getFilesystemName(name);
						System.out.println("filename*" + k + ":" + filename[k]);
					}
				} else {                     		// modified by Hojeong 20/01/08(yy/mm/dd)
					filename[k] = "Nothing.png";   	// modified by Hojeong 20/01/08(yy/mm/dd)
				}                           		// modified by Hojeong 20/01/08(yy/mm/dd)
				k++;                        		// modified by Hojeong 20/01/08(yy/mm/dd)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}
	//--------------------------------------------------------------------------------------------------
	// end: filesUpload(String saveFolder, int fileSize, HttpServletRequest request) - 다중 파일을 업로드하는 메소드  
	// programmed by Hojeong 20.01.02
	//--------------------------------------------------------------------------------------------------
	
}
