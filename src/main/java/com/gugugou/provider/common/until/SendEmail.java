package com.gugugou.provider.common.until;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 * 发送邮件的作业
 */
@Service
@Transactional
public class SendEmail {

    private String username;
    private String password;
    private String smtpServer;

    public void execute() {
        System.out.println("要发邮件了。。。");
        try {
            if(true){
                final Properties mailProps = new Properties();
                mailProps.put("mail.smtp.host", this.getSmtpServer());
                mailProps.put("mail.smtp.auth", "true");
                mailProps.put("mail.username", this.getUsername());
                mailProps.put("mail.password", this.getPassword());

                Authenticator authenticator = new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        // 用户名、密码
                        String userName = mailProps.getProperty("mail.username");
                        String password = mailProps.getProperty("mail.password");
                        return new PasswordAuthentication(userName, password);
                    }
                };
                // 使用环境属性和授权信息，创建邮件会话
                Session mailSession = Session.getInstance(mailProps, authenticator);
                for(int i=0;i<100;i++){
                    // 创建邮件消息
                    MimeMessage message = new MimeMessage(mailSession);
                    // 设置发件人
                    InternetAddress from = new InternetAddress(mailProps.getProperty("mail.username"));
                    message.setFrom(from);
                    // 设置收件人
                    InternetAddress to = new InternetAddress("xxxxx@163.com");
                    message.setRecipient(RecipientType.TO, to);
                    // 设置邮件标题
                    message.setSubject("我就是来测试一下邮件啊！！");
                    // 设置邮件的内容体
                    message.setContent("我又要发邮件给你了 哈哈！！！ 骚扰骚扰", "text/html;charset=UTF-8");
                    // 发送邮件
                    Transport.send(message);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSmtpServer() {
        return smtpServer;
    }
    public void setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
    }

}