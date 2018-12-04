package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket demo server 
 * @author JavaLuSir
 *
 */
public class ServSocket {

	public ServSocket() {
		try {
			ServerSocket ssocket = new ServerSocket(5678);
			System.out.println("server.....");
			Socket socket=ssocket.accept();
			InputStream in =socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str=br.readLine();
			System.out.println(str);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			PrintWriter pw = new PrintWriter(bw,true);
			pw.println(str);
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ServSocket();

	}

}
