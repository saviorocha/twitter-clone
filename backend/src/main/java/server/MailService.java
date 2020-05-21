package server;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import exceptions.SpringTwitterException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.NotificationEmail;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
	private final JavaMailSender mailSender;
	private final MailContentBuilder mailContentBuilder;

	public void sendMail(NotificationEmail notificationEmail) {
		MimeMessagePreparator msgPreparator = mimeMessage -> {
			MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMessage);
			msgHelper.setFrom("springTwitter@email.com");
			msgHelper.setTo(notificationEmail.getDestinatario());
			msgHelper.setSubject(notificationEmail.getAssunto());
			msgHelper.setText(notificationEmail.getCorpo());
		};
		try {
			log.info("E-mail de notificação enviado.");
		} catch (MailException e) {
			throw new SpringTwitterException("Ocorreu um erro ao tentar enviar email para " + notificationEmail.getDestinatario());
		}
	}
}
