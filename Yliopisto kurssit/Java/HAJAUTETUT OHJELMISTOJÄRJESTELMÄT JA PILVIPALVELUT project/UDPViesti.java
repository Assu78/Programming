import java.io.*;
import java.net.*;

public class UDPViesti{

	/**UDP metodi jolla luodaan UDPviesti käyttäen datagram soketteja ja paketteja
	 * @param address viestin kohdeosoite (IP)
	 * @param message lähetettävän viestin sisältö
	 */

	public void sendUDP(String address, int port, String message)throws IOException, SocketException{
		InetAddress  osoite = InetAddress.getByName(address);

		DatagramSocket socket = new DatagramSocket();	//luodaan uusi soketti

		byte[] data = message.getBytes();

		DatagramPacket packet = new DatagramPacket(data, data.length, osoite, port);	//luodaan uusi paketti

		socket.send(packet);

		socket.close();
	}

}