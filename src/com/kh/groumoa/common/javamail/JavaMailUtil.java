package com.kh.groumoa.common.javamail;

import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.istack.internal.logging.Logger;

public class JavaMailUtil {
	
	
	public static void sendMail (String recepient, String newPwd) throws MessagingException {
		System.out.println("Preparing to send email");
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port" , "587");
		
		String myAccountEmail = "skrt1533@gmail.com";
		String password = "";//비밀번호 적기
		
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session, myAccountEmail, recepient, newPwd);
		
		Transport.send(message);
		System.out.println("message sent successFully");
		
	}
	
	private static Message prepareMessage(Session session, String MyAccountEmail, String recepient, String newPwd) {
		
		String myAccountEmail = "skrt1533@gmail.com";
		String password = "";//내 계정 비밀번호 적기
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("그루모아 새 비밀번호");
			message.setText("당신의 새 비밀번호는 " + newPwd + "입니다.");
			return message;
		} catch (Exception ex) {
			Logger.getLogger(JavaMailUtil.class.getName(), null).log(Level.SEVERE, null, ex);
		}
		return null;
	 
		
	}
}
