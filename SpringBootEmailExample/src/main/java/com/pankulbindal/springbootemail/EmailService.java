package com.pankulbindal.springbootemail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;

	@Value("${spring.mail.username}")
	private String fromAddress;
	
	MimeMessage message = sender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(message);
	
	public void sendMail(String toEmail, String subject, String messagetoUser) {
	try {

		helper.setFrom(fromAddress);
		helper.setTo(toEmail);
		helper.setText(messagetoUser);
		helper.setSubject(subject);

	} catch (Exception e) {
		e.printStackTrace();

	}
	sender.send(message);
	}

}
