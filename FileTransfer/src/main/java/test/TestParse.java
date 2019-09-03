package test;
import java.io.IOException;

import parseconfig.Parse;

public class TestParse {

    public static void main(String[] args) throws IOException {
	String pathRec = "configReceiver.txt";
	String pathSen = "configSender.txt";
	
	String[] configRec = Parse.parseConfigReceiver(pathRec);
	String[] configSen = Parse.parseConfigSender(pathSen);
	
    }
    
}
