/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai9lab11;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Bai9Lab11 {

    public static void sendmail(String userName, String password, String email2, String content, String title) throws AddressException,
            MessagingException {
        //Taọ đối tượng để thiết lập các thuộc tính cho việc gửi mail
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        // port mail thường là 587 hoặc 456
        props.put("mail.smtp.port", "587");
        // Tạo đối tượng Session (phiên làm việc với gmail)
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication
                    getPuserNameasswordAuthentication() {
                //để gửi mail qua SMTP cần có tài khoản hợp lệ của google
                return new PasswordAuthentication(userName, password);
            }
        });
        // Tạo đối tượng chứa thông điệp cần gửi mail
        Message message = new MimeMessage(session);
        // Truyền địa chỉ muốn gửi thông điệp
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email2));
        message.setSubject(content);
        message.setContent(title, "text/html");
        Transport.send(message, userName, password);
    }

    public static void main(String[] args) {
        try {
            String username1 = "truongkhoacntt";
            String pass = "Abc.1234";
            String username2 = "truongeight88@gmail.com";
            String content = "ten em la: Bui Nhu Truong; lop DHTI12A1ND; mon: Thuc tap lap trinh mang";
            String title = "mail from " + username1;
            sendmail(username1, pass, username2, title, content);
            System.out.println("gui thanh cong");
        } catch (Exception e) {
            System.out.println("gui that bai :" + e.getMessage());
            e.printStackTrace();
        }
    }

}
