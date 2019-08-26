import java.util.*;

public class Main {

    public static void main(String[] args) {
        // create new Email app user
        Email curtis = new Email("curtis", "Z");

        System.out.println("Company Email: " + curtis.getCompanyEmail());
        System.out.println("Name: " + curtis.getFirstName() + " " + curtis.getLastName());
        System.out.println("Mail Capacity: " + curtis.getMailCapacity());
        System.out.println("Department: " + curtis.getDepartment());

        // set alternative Email
        Scanner sc = new Scanner(System.in);
        System.out.println(curtis.setAlterEmail(sc.nextLine(), sc.nextLine()));
        System.out.println(curtis.getAlterEmail());

        // set new password
        System.out.println(curtis.setNewPassword(sc.nextLine(), sc.nextLine()));
        sc.close();

    }
}