import java.util.*;
import java.util.regex.*;

/**
 * Create Company Email Account
 */
public class Email {

    private final int DEFAULT_PW_LEN = 10;
    private final String COMPANY_NAME = "Gucci";
    private final int DEFAULT_MAIL_CAPA = 1000;

    private String companyEmail;
    private String alterEmail;
    private String password;
    private String dept;
    private String firstName;
    private String lastName;
    private int mailCapa;

    /**
     * create user passing the firstname and lastname
     */
    public Email(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;

        this.dept = setDepartment();
        this.password = generatePw();
        this.companyEmail = createEmail();
        this.mailCapa = DEFAULT_MAIL_CAPA;
        this.alterEmail = null;

        // for testing
        // System.out.println("Random Password is: " + password);
    }

    /**
     * set department
     * 
     * @return selected department
     */
    private String setDepartment() {
        var keyboard = new Scanner(System.in);
        System.out.println("Which department \"" + firstName + " " + lastName
                + "\" belongs to:\n1.Sales.\n2.Research.\n3.Human Resources.\n(Please enter the corresponding number).\n");
        int response = keyboard.nextInt();

        switch (response) {
        case 1:
            return "Sales";
        case 2:
            return "Research";
        case 3:
            return "Human Resources";
        default:
            return "default";
        }
    }

    /**
     * Generate random password
     */
    private String generatePw() {

        String pwCharSet = "qwertuyiopasdfgjkQWERTYUIOPAhlzxcvbnm_12345SDFGHJKLZXCVBNM67890";
        int numOfChar = pwCharSet.length();
        StringBuilder newPW = new StringBuilder();

        for (int x = 0; x < DEFAULT_PW_LEN; x++) {
            newPW.append(pwCharSet.charAt(new Random().nextInt(numOfChar)));
        }
        return newPW.toString();
    }

    /**
     * Create email based on the staff details and the company name
     * 
     * @return company email that is created
     */
    private String createEmail() {
        return firstName + Character.toUpperCase(lastName.charAt(0)) + "@" + COMPANY_NAME + ".com";
    }

    /**
     * set new password using the current password (Dose not validate password)
     */
    public String setNewPassword(String currentPW, String newPW) {
        if (currentPW.equals(this.password)) {
            var pattern = Pattern.compile("[a-zA-Z\\d_]{" + DEFAULT_PW_LEN + "}");
            var matcher = pattern.matcher(newPW);

            if (matcher.matches()) {
                this.password = newPW;
                return "Password Updated";
            } else
                return "New Password Illegal";
        } else {
            return "Current Password Incorrect";
        }
    }

    /**
     * set mail box capacity
     */
    public void setMailCapacity(String pw, int capacity) {
        if (this.password.equals(pw))
            this.mailCapa = capacity;
    }

    /**
     * Set alternative email (email validated)
     * 
     * @return method result
     */
    public String setAlterEmail(String password, String alterEmail) {

        if (this.password.equals(password.trim())) {

            Pattern pattern = Pattern.compile("[a-zA-Z\\d]{1,15}@[a-zA-Z]{1,10}.com");
            Matcher matcher = pattern.matcher(alterEmail);

            if (matcher.matches()) {
                this.alterEmail = alterEmail;
                return "Email Updated.";
            } else {
                this.alterEmail = null;
                return "Email Illegal";
            }
        }
        return "Password Incorrect";
    }

    public String getDepartment() {
        return this.dept;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getMailCapacity() {
        return this.mailCapa;
    }

    public String getCompanyEmail() {
        return this.companyEmail;
    }

    public String getAlterEmail() {
        return this.alterEmail;
    }

}