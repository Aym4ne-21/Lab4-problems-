package student;

public class Test {
    public static void main(String[] args) {
        Major computerScience = Student.getDefaultMajor();
        Major engineering = new Major("24", "Engineering");

        Student amal = new Student(
                "SAFI", "Amal", "", "", "22885676", computerScience
        );

        Student samir = new Student(
                "ALAMI", "Samir", "", "", "23585976"
        );

        Student aymane = new Student(
                "RAISS", "Aymane", "", "", "24585977", engineering
        );

        System.out.println("The list of students in the computer science major is:");
        System.out.println(computerScience.getStudentListAsString());

        System.out.println("\nFormatted name: " + amal.getFullNameFormatted());

        System.out.println("Find student: " + computerScience.findStudentByCNE("22885676"));

        System.out.println("Student count: " + computerScience.getStudentCount());

        System.out.println("Computer science capacity: 50 students");
        System.out.println("Current enrollment: " + computerScience.getStudentCount() + " students");
        System.out.printf("Occupancy rate = %.1f%%%n", computerScience.getOccupancyRate());

        System.out.println("\nStudent list as a string:");
        System.out.println(computerScience.getStudentListAsString());

        System.out.println("\nRemove existing student: " + computerScience.removeStudent("22885676"));
        System.out.println("Remove nonexistent student: " + computerScience.removeStudent("00000000"));
        System.out.println("Student count after removal: " + computerScience.getStudentCount());

        System.out.println("\nEngineering students:");
        System.out.println(engineering.getStudentListAsString());

        System.out.println("\n" + aymane);
        System.out.println(engineering);
    }
}