package email;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class test {

  public static void main (String args[]) throws Exception {
    
    String host = "smtp.163.com";   //发件人使用发邮件的电子信箱服务器
    String from = "你自己的电子信箱";    //发邮件的出发地（发件人的信箱）
    String to = "收件人信箱";   //发邮件的目的地（收件人信箱）

    // Get system properties
    Properties props = System.getProperties();

    // Setup mail server
    props.put("mail.smtp.host", host);

    // Get session
    props.put("mail.smtp.auth", "true"); //这样才能通过验证

    MyAuthenticator myauth = new MyAuthenticator("13281040@bjtu.edu.cn", "020017");
    Session session = Session.getDefaultInstance(props, myauth);

//    session.setDebug(true);

    // Define message
    MimeMessage message = new MimeMessage(session);
   

    // Set the from address
    message.setFrom(new InternetAddress(from));

    // Set the to address
    message.addRecipient(Message.RecipientType.TO,
      new InternetAddress(to));

    // Set the subject
    message.setSubject("测试程序！");

    // Set the content
    message.setText("这是用java写的发送电子邮件的测试程序！");

    message.saveChanges();

      Transport.send(message);
    
  }
}