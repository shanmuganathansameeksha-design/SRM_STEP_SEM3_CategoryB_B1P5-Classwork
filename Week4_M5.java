class FeeAccount {
    String name;

    FeeAccount(String name) {
        this.name = name;
    }
}

class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount(String name) {
        super(name);
    }
}

class PaymentProcessor {

    int hostelCount = 0;
    int dayScholarCount = 0;

    void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {

            System.out.println(
                "Paid in two installments (hostel account)"
            );

            hostelCount++;

        } else {

            System.out.println(
                "Paid in one go (day-scholar account)"
            );

            dayScholarCount++;
        }
    }

    void displayCounts() {

        System.out.println(
            "Hostel accounts processed: " + hostelCount +
            " | Day-scholar accounts processed: " +
            dayScholarCount
        );
    }
}

public class M5 {
    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount("Hostel 1"),
            new HostelFeeAccount("Hostel 2"),
            new FeeAccount("Day Scholar 1"),
            new FeeAccount("Day Scholar 2")
        };

        PaymentProcessor processor =
            new PaymentProcessor();

        for (FeeAccount account : accounts) {

            processor.processPayment(account, 60000);
        }

        processor.displayCounts();
    }
}