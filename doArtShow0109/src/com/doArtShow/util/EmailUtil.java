package com.doArtShow.util;

import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
	//임시비밀번호가 담긴 이메일 발신
	public static void sendMail(String email, String subject, String msg) throws Exception{
		//smtp 서버
		String charset 		= "utf-8";
		String hostSMTP 	= "smtp.naver.com";
		String hostSMTPid 	= "do_art_show";
		String hostSMTPpw	= "itwill1111";
		
		//발신인 정보
		String senderEmail	= "do_art_show@naver.com";
		String senderName 	= "전시:해";
		
		try {
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(true);
			mail.setCharset(charset);
			mail.setSSLOnConnect(true);
			mail.setHostName(hostSMTP);
			mail.setSmtpPort(587);
			
			mail.setAuthentication(hostSMTPid, hostSMTPpw);
			mail.setStartTLSEnabled(true);
			mail.addTo(email);
			mail.setFrom(senderEmail, senderName, charset);
			mail.setSubject(subject);
			mail.setHtmlMsg(msg);
			mail.send();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
