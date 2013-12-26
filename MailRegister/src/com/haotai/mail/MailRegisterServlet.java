package com.haotai.mail;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Message.RecipientType;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MailRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MailRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("mail");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
//		System.out.println(mail);
//		System.out.println(nickname);
		
		String username="781345593@qq.com";
		String mailpassword="chenshexiao1991";
		
		String registerId=""+Math.random()*Math.random();
		String url="http://localhost:8080/MailRegister/MailBackServlet?registerId="+registerId;
		
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute(registerId, name);
		httpSession.setAttribute("mail",mail);
		httpSession.setAttribute("password", password);
		httpSession.setMaxInactiveInterval(600);
		
		Properties props=new Properties();
		props.setProperty("mail.stmp.host", "smtp.qq.com");
		props.setProperty("mail.stmp.auth", "true");
		
		Authenticator authenticator=new MyAuthenticator(username,mailpassword);
		javax.mail.Session session=javax.mail.Session.getDefaultInstance(props,authenticator);
		session.setDebug(true);
		
		try {
			Address from=new InternetAddress(username);
			Address to=new InternetAddress(mail);
			
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(from);
			msg.setSubject("test");
			msg.setSentDate(new Date());
			msg.setContent("µã»÷"+"<a href='" + url + "'>" + url + "</a>"+"Íê³É×¢²á", "text/html;charset=utf-8"); 
			msg.setRecipient(RecipientType.TO, to);
			
			Transport transport=session.getTransport("smtp");
			transport.connect("smtp.qq.com",username,mailpassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			
//			Transport.send(msg);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(MessagingException e){
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/sendMailSuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
