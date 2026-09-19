class LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {

        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayInfo() {
        System.out.println(
            "General Member | Books Borrowed: " + booksBorrowed
        );
    }
}


class StudentMember extends LibraryMember {

    protected String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Student Member | Course: " + course +
            " | Books Borrowed: " + booksBorrowed
        );
    }
}


class HonorsStudentMember extends StudentMember {

    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit,
                               String course, int bonusLimit) {

        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Honors Student Member | Course: " + course +
            " | Bonus Limit: " + bonusLimit +
            " | Books Borrowed: " + booksBorrowed
        );
    }
}


class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(String memberId, int borrowLimit,
                         String department) {

        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Faculty Member | Department: " + department +
            " | Books Borrowed: " + booksBorrowed
        );
    }
}