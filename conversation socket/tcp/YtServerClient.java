import java.io.*;
import java.net.*;



//Laajennaa ja tee semmonnen ohjalma jossa molemmat pysty lähetää viesti ja saaTCp viesti eli saaa kuitti että viesti on sappunut perille


public class YtServerClient{
	public static void main(String[] args){
		System.out.println("Sending a request");

		try{
			Socket s = new Socket("localhost", 1335);
			System.out.println("connected Successfully");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			PrintStream ps = new PrintStream(s.getOutputStream());

			BufferedReader brs  = new BufferedReader(new InputStreamReader(s.getInputStream()));

			while(true){
				System.out.println("Input the data...");
				String st = br.readLine();
				ps.println(st);

				if(st.equals("exit")){
					System.exit(1);
				}
				System.out.println("Data Returned");
				System.out.println(st);
			}


		}catch(UnknownHostException e){
			System.out.println("Something went wrong with ip");
		}catch(IOException e){
			System.out.println("Not found data for the socket." + e);
		}
	}
}