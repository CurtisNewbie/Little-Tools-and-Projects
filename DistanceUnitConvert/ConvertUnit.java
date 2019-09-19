import java.util.*;

public class ConvertUnit {

    // ratio
    static final double MILE_TO_METER = 1609.34;

    static final double INCH_TO_CM = 2.54;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(
                "------------------------------------------\nSelect the option by typing the number in the [ ] and value that you want to convert to the selected unit:\nMILE TO METER[0]\nINCH TO CM[1]\n\nE.g., \"0 150\"\n------------------------------------------\n");
        int resp = sc.nextInt();
        double value = sc.nextDouble();
        switch (resp) {
        case 0:
            System.out.printf("Mile:\"%f\" to Meter:\"%.3f\"", value, value * ConvertUnit.MILE_TO_METER);
            break;
        case 1:
            System.out.printf("Inch:\"%f\" to Centimeter:\"%.3f\"", value, value * ConvertUnit.INCH_TO_CM);
        default:
            System.out.println("You should provide a response of either value of 0 or 1.\nExisting...");
            break;
        }

    }
}