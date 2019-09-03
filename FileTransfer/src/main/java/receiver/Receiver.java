package receiver;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class Receiver {

    private int port;
    private String file_path;
    private ServerSocket serverSocket;

    public Receiver(int port, String path) {

	this.port = port;
	this.file_path = path;
    }

    public boolean init() {

	try {
	    serverSocket = new ServerSocket(port);
	    return true;
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return false;
	}
    }

    public void waitConnection() throws IOException {

	var socket = serverSocket.accept();

	try (DataInputStream in = new DataInputStream(socket.getInputStream())) {

	    try (FileOutputStream out = new FileOutputStream(file_path)) {

		// get and output the data
		int count;
		byte[] buffer = new byte[8192]; // or 4096, or more
		while ((count = in.read(buffer)) > 0) {
		    out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		serverSocket.close();
	    }
	}
    }

}
