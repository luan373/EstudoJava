package estudoIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;

public class InOut {

	public static void main(String[] args) throws IOException, MessagingException {
		String dir = "C:\\Users\\luan.almeida\\Downloads\\materialize-master\\materialize-master\\work";

		File diretorio = new File(dir);

		File fList[] = diretorio.listFiles();

		FileWriter arq = new FileWriter("C:\\Users\\luan.almeida\\Documents\\Estudo Java\\Estude aqui\\oi.txt");

		PrintWriter gravarArq = new PrintWriter(arq);

		int i = 0;
		while (i < fList.length) {

			gravarArq.printf("Nome do arquivo: " + fList[i].getName() + "%n");

			gravarArq.printf("Local do arquivo: " + fList[i].getPath() + "%n");
			gravarArq.printf("Conteúdo----------------------------%n");

			Scanner scanner = extracted(fList[i].getPath()).useDelimiter("\\||\\n");
			while (scanner.hasNext()) {
				String conteudo = scanner.next();
				gravarArq.printf(conteudo + "%n");
			}

			gravarArq.printf("Fim Conteúdo-----------------------%n");
			i++;
		}

		arq.close();

		File origem = new File("C:\\Users\\luan.almeida\\Documents\\Estudo Java\\Estude aqui\\oi.txt");
		File destino = new File("c:\\Move");
		FileUtils.copyFileToDirectory(origem, destino);
		/*
		String[] emailList = {"jordangrego@gmail.com"};
		String emailSubjectTxt = "Oi, Jordet";
		String emailMsgTxt = "Como vai, Jordet?";
		String emailFromAddress = "luan@salapp.com.br";
		
		try {
		SendMailTLS sendMailTLS = new SendMailTLS();
		
		sendMailTLS.postMail(emailList,emailSubjectTxt,emailMsgTxt,emailFromAddress );
		} catch(Exception exception) {
			exception.getStackTrace();
			System.out.println("Que merda, conecta, cacete!");
			
		}*/
		
		SendMail mail = new SendMail();
		mail.enviaEmail();

	}

	private static Scanner extracted(String dir) throws FileNotFoundException {
		return new Scanner(new FileReader(dir));
	}
}
