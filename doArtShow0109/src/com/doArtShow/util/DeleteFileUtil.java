package com.doArtShow.util;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class DeleteFileUtil {
	public static void deleteFile(String saveFolder, String imageFile, HttpServletRequest request) {
		String realFolder = "";															 
		ServletContext context = request.getServletContext();					 
		realFolder = context.getRealPath(saveFolder);								
		File file = new File(realFolder+"/"+imageFile); 
		System.out.println("(((((:"+realFolder+"/"+imageFile);
		if( file.exists() ) { 
			if(file.delete()) { System.out.println("파일삭제 성공"); }
			else { System.out.println("파일삭제 실패"); } 
		} else { 
			System.out.println("파일이 존재하지 않습니다.");
		} 
	}
}
