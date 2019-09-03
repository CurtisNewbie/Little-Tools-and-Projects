package sender;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Sender {

    private String ip;
    private int port;
    private String file_path;
    private Socket socket;

    /**
     * 
     * @param ip
     * @param port
     * @param path
     */
    public Sender(String ip, int port, String path) {
	this.ip = ip;
	this.port = port;
	this.file_path = path;
    }

    /**
     * 
     * @return success or failure of initialisation
     */
    public boolean init() {
	try {
	    socket = new Socket(ip, port);
	    return true;
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return false;
    }

    public void sendFile() throws IOException {

	try (var in = new FileInputStream(new File(file_path))) {

	    try (var out = new DataOutputStream(socket.getOutputStream())) {

		// get and output the data
		int count;
		byte[] buffer = new byte[8192]; // or 4096, or more
		while ((count = in.read(buffer)) > 0) {
		    out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	    }
	}
    }
}
