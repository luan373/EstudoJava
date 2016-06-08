package estudoIO;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	String SMTP_HOST_NAME = "email-ssl.com.br";
	String SMTP_AUTH_USER = "luan@salapp.com.br";
	String SMTP_AUTH_PWD = "lu9903123";

    //private static final String emailMsgTxt = "Controle de Mensagens via JSP.";
    //private static final String emailSubjectTxt = "Subject da Mensagem";
    //private static final String emailFromAddress = "luan@salaapp.com.br";

    // Inserir aqui os enderecos onde a mensagem sera entregue

    //private static final String[] emailList = {"jordangrego@gmail.com"};

    public void postMail(String recipients[], String subject,
            String message, String from) throws MessagingException {
        boolean debug = true;

        //Setando o host
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);

        session.setDebug(debug);

        // Criando a mensagem
        Message msg = new MimeMessage(session);

        // Setando o endereco
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);


        //Conteudo
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
    }

    public class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}