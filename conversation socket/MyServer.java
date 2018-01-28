import java.io.*;
import java.net.*;

public class MyServer{
	public static void main(String[] args)throws Exception{
		ServerSocket ss = new ServerSocket(3333);

		Socket s = ss.accept();
		//InetAddress ip = new InetAddress(s.getNameByAdress());
		System.out.println("Client IP address: " + fInetAddress.getLocalHost());
		DataInputStream  iS = new DataInputStream(s.getInputStream());
		DataOutputStream oS = new DataOutputStream(s.getOutputStream());

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));


		String str1 = "";
		String str2 = "";

		while(!str1.equals("stop")){
			str1 = iS.readUTF();
			System.out.println("Client say: " + str1);
			str2 = br.readLine();
			oS.writeUTF(str2);
			oS.flush();
		}
		iS.close();
		ss.close();
		s.close();
	}
}