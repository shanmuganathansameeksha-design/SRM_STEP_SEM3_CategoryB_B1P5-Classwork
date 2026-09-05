import java.util.Arrays;

class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {

        this.bookingId = bookingId;

        // Defensive copy
        this.seatNumbers = Arrays.copyOf(
            seatNumbers,
            seatNumbers.length
        );
    }

    public String[] getSeatNumbers() {

        // Defensive copy
        return Arrays.copyOf(
            seatNumbers,
            seatNumbers.length
        );
    }

    public BookingReceipt withUpdatedSeat(
            int index, String newSeat) {

        String[] newSeats = getSeatNumbers();

        if (index >= 0 && index < newSeats.length) {
            newSeats[index] = newSeat;
        }

        return new BookingReceipt(
            bookingId,
            newSeats
        );
    }

    public String getBookingId() {
        return bookingId;
    }

    public static String processNightlySettlement(
            BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (BookingReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               group + " group | " +
               individual + " individual";
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}

public class BookingTest {

    public static void main(String[] args) {

        BookingReceipt b =
            new BookingReceipt(
                "CH-1001",
                new String[]{"A1", "A2"}
            );

        // Test defensive copying
        String[] seats = b.getSeatNumbers();

        seats[0] = "X";

        System.out.println(
            Arrays.toString(b.getSeatNumbers())
        );

        // Create updated receipt
        BookingReceipt updated =
            b.withUpdatedSeat(1, "A3");

        System.out.println(
            Arrays.toString(b.getSeatNumbers())
        );

        System.out.println(
            Arrays.toString(updated.getSeatNumbers())
        );

        // Nightly settlement
        BookingReceipt[] receipts = {

            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2
            ),

            null,

            new BookingReceipt(
                "CH-3003",
                new String[]{"C1"}
            )
        };

        System.out.println(
            BookingReceipt.processNightlySettlement(receipts)
        );
    }
}