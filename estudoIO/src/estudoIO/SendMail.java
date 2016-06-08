package estudoIO;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	String SMTP_AUTH_USER = "luan@salapp.com.br";
	String SMTP_AUTH_PWD = "lu9903123";

	public void enviaEmail() {
		try {
			String to = "luan373@gmail.com";
			String from = "luan@salapp.com.br";
			Properties props = new Properties();
			props.put("mail.smtp.from", "luan@salapp.com.br");
			props.put("mail.smtp.host", "email-ssl.com.br");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");

			Authenticator auth = new SMTPAuthenticator();
			Session sessao = Session.getDefaultInstance(props, auth);
			sessao.setDebug(true);

			MimeMessage message = new MimeMessage(sessao);
			message.setFrom(new InternetAddress(from));

			Address toAddress = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject("Oi, Jordet");

			BodyPart corpoPartes = new MimeBodyPart();
			corpoPartes.setText("Segue em anexo meu oi");

			BodyPart parteArquivo = new MimeBodyPart();
			FileDataSource source = new FileDataSource("c:\\Move\\oi.txt");
			parteArquivo.setDataHandler(new DataHandler(source));
			parteArquivo.setFileName("oi.txt");

			Multipart variasPartes = new MimeMultipart();
			variasPartes.addBodyPart(corpoPartes);
			variasPartes.addBodyPart(parteArquivo);

			message.setContent(variasPartes);
			Transport.send(message);
			System.out.println("E-mail enviado");
		} catch (MessagingException e) {
			System.out.println("Email nao pode ser enviado! " + e.getMessage());
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}
}
