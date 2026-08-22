class Student {

    // Instance variables
    String name;
    double attendance;

    // Static variables
    static String collegeName =
        "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Anitha", 90.0);

        System.out.println("2 Student objects created");

        Student.printCollegeInfo();
    }
}