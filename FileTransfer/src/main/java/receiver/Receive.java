package receiver;

import java.io.IOException;
import java.util.Scanner;

import parseconfig.Parse;

/**
 * Receive file from sender
 */
public class Receive {

    public static final String CONFIG_PATH = "config.txt";

    public static void main(String[] args) {

	String[] config = null;
	try {
	    // parse configuration
	    config = Parse.parseConfigReceiver(CONFIG_PATH);

	} catch (IOException e) {
	    System.out.println(e.getMessage() + "Failed to read configuration file");
	}

	if (config == null) {
	    System.out.println("Configuration not verified. Exiting...");
	    System.exit(0);
	} else {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Configuration verified. Do you want to want to start waiting for the sender?[y/n]");

	    if (sc.hasNext()) {
		String resp = sc.next();

		// response is no
		if (!resp.equalsIgnoreCase("y")) {
		    System.out.println("Cancelled. Exiting...");
		    System.exit(0);
		} else {
		    // initialise receiver, waiting for connection
		    Receiver receiver = new Receiver(Integer.parseInt(config[0]), config[1]);
		    if (!receiver.init()) {
			System.out.println("Failed to initialise receiver, please make sure the configuration file "
				+ "is correct (e.g., ip).");
		    }

		    System.out.println("Waiting for connection...");
		    try {
			receiver.waitConnection();
			System.out.println("File transferring succeeded.");
		    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
	    }
	    sc.close();
	}
    }

}
