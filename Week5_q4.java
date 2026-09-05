class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // No-argument constructor
    public MovieBookingProfile() {
        name = "";
        confirmed = false;
    }

    // Parameterized constructor
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for boolean
    public boolean isConfirmed() {
        return confirmed;
    }

    // Setter for boolean
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Setter for OTP
    public void setOtp(String otp) {

        if (otp != null &&
            otp.matches("\\d{4,6}")) {

            this.otp = otp;
        }
    }
}

public class MovieBookingTest {

    public static void main(String[] args) {

        MovieBookingProfile p =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(p.getName());

        p.setConfirmed(true);

        System.out.println(p.isConfirmed());

        p.setOtp("4471");

        System.out.println("OTP set successfully");
    }
}