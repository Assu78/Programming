import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args)throws Exception{

		Socket s = new Socket("localhost",3333);

		DataInputStream  iS= new DataInputStream(s.getInputStream());
		DataOutputStream oS  = new  DataOutputStream(s.getOutputStream());

		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));

		String str= "",str2 = "";

		while(!str.equals("stop")){

			str2 = br.readLine();
			oS.writeUTF(str2);
			oS.flush();
			str = iS.readUTF();
			System.out.println("Server say: " + str);

			
		}
		
		oS.close();
		s.close();
	}
}