import java.io.IOException;

/**
 * This is a timer that allows you to shutdown the Windows OS after a defined
 * period of time.
 * 
 * Two Parameters -> [h/m/s] [value] <br>
 * h - hours, m - minute, s - seconds
 * 
 */
public class Shutdown {

    public static void main(String args[]) {

        // unit:
        String unit = args[0];
        int value = Integer.parseInt(args[1]);

        // count the actual seconds that needed to be timed
        int timerInSec = 0;
        switch (unit) {
        case "h":
            timerInSec = value * 60 * 60;
            System.out.println(timerInSec);
            break;
        case "m":
            timerInSec = value * 60;
            System.out.println(timerInSec);
            break;
        case "s":
            timerInSec = value;
            System.out.println(timerInSec);
            break;
        default:
            System.out.println("Please enter the right unit: h/m/s");
            System.exit(0);
        }

        if (timerInSec >= 0) {
            try {

                // setup shutdown timer for Windows OS
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("shutdown -s -t " + timerInSec);
                System.out.println("Existing in " + timerInSec + "seconds.");
            } catch (IOException e) {
                System.out.println("Command is not executed, please try again.");
            }
        }
        System.exit(0);
    }
}