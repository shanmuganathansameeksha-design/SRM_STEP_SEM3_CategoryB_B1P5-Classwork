class LibraryMember {

    protected int borrowLimit;
    protected int booksBorrowed;

    final String memberNumber;

    private static int membersEnrolled = 0;

    public LibraryMember(int borrowLimit) {

        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        membersEnrolled++;

        memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {

        System.out.println("Genre: " + genre);

        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'R') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}