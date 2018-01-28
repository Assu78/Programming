import java.io.*;
import java.net.*;


//Laajennaa ja tee semmonnen ohjalma jossa molemmat pysty lähetää viesti ja saaTCp viesti eli saaa kuitti että viesti on sappunut perille

public class YtServer{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1335);
			System.out.println("Waiting for request...");
			Socket s = ss.accept();
			System.out.println("Request accepted");



			BufferedReader br  = new BufferedReader(new InputStreamReader(s.getInputStream()));


			while(true){
				String msg = br.readLine();
				if(msg.equals("exit")== true){
					System.out.println("Connection lost");
					System.exit(1);
				}
				System.out.println("Message from client : " + msg);
			}

		}catch(IOException e){
			System.out.println("Not Found data for the socket..." + e);

		}
	}
}