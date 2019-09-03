package sender;

import java.io.IOException;
import java.util.Scanner;

import parseconfig.Parse;

/**
 * Send file to receiver
 */
public class Send {

    public static final String CONFIG_PATH = "config.txt";

    public static void main(String[] args) {

	String[] config = null;
	try {
	    // parse configuration
	    config = Parse.parseConfigSender(CONFIG_PATH);

	} catch (IOException e) {
	    System.out.println(e.getMessage() + "Failed to read configuration file");
	}

	if (config == null) {
	    System.out.println("Configuration not verified. Exiting...");
	    System.exit(0);
	} else {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Configuration verified. Do you want to start sending file to the receiver?[y/n]");

	    if (sc.hasNext()) {
		String resp = sc.next();

		// response is no
		if (!resp.equalsIgnoreCase("y")) {
		    System.out.println("Cancelled. Exiting...");
		    System.exit(0);
		} else {
		    // initialise sender, connecting to receiver
		    Sender sender = new Sender(config[1], Integer.parseInt(config[2]), config[3]);

		    if (!sender.init()) {
			System.out.println("Failed to initialise sender, please make sure the configuration file "
				+ "is correct (e.g., ip).");
		    }

		    // send file
		    try {
			sender.sendFile();
			System.out.println("File sent");
		    } catch (IOException e) {
			System.out.println(e.getMessage());
		    }

		    sc.close();

		}
	    }
	}
    }
}