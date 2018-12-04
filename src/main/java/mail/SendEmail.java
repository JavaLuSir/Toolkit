package mail;

import org.apache.commons.mail.DefaultAuthenticator;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
	
	public static void main(String[] args) throws MessagingException {
		Authenticator auth = new DefaultAuthenticator("javalusir@163.com","123123");
		Properties prop = new Properties();
		// 开启debug调试  
        prop.setProperty("mail.debug", "true"); 
        // 发送服务器需要身份验证  
        prop.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        prop.setProperty("mail.host", "smtp.163.com");  
        // 发送邮件协议名称  
        prop.setProperty("mail.transport.protocol", "smtp"); 
        Session session = Session.getInstance(prop,auth);
        Message msg = new MimeMessage(session);
        msg.setSubject("亲This is a JavaMail Test!");
        msg.setText("亲,是我发的邮件");
        msg.setFrom(new InternetAddress("javalusir@163.com"));
        Transport transport = session.getTransport();
        transport.connect("javalusir@163.com","123");
        transport.sendMessage(msg, new Address[]{new InternetAddress("641149960@qq.com")});
        transport.close();
	}

}
