package git.client.utility;

import java.net.InetAddress;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import git.client.hooks.PushHookV2;

@SuppressWarnings("unused")
public class MailComposer {

	 Session session =null;
	public  void sendMail(PushHookV2 pushHook) throws NamingException{
		
		 InitialContext ic = new InitialContext();
		 session = (javax.mail.Session) ic.lookup("java:jboss/mail/Default");
		  Multipart multipart = new MimeMultipart();
		  Message message = new MimeMessage(session);
		  String fromAddress="noreply_qa@solartis.net";
		  String toAddress = "praveenkumar_s@solartis.com";
		try{
		  Address emailFromAddress = new InternetAddress(fromAddress);
		  Address toEmailAddress = new InternetAddress(toAddress);
	      message.setFrom(emailFromAddress);
	      message.setSubject("Commit Notification From GitLab");
	      InternetAddress[] addressArray = new InternetAddress[PostDriverChecker.stubList().size()];
	      for(int i=0;i<PostDriverChecker.stubList().size();i++){
	    	  addressArray[i]=(InternetAddress) PostDriverChecker.stubList().get(i);
	      }
	      message.setRecipients(RecipientType.TO,addressArray);
	      String body = "Repo Name : "+pushHook.getRepository().getName()+ " RepoURL : "+ pushHook.getProject().getGitHttpUrl();
	      BodyPart bodypart = new MimeBodyPart();
          bodypart.setContent(body, "text/html");
          multipart.addBodyPart(bodypart);
          message.setContent(multipart);
          
          Transport.send(message);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		  
	}
	
	public HashMap<Object,Object> convertToMap(PushHookV2 pushHook){
		
		return new HashMap<Object,Object>();
	}
}
