package Instructor;

import student.Person;

public class Instructor extends Person {
    private String employeeNumber ;
    private Subject[] subjects;
    private int subjectCount;


    public Instructor() {
        this("", "", "", "", "", null);
    }
    public Instructor(String lastName, String firstName, String phone,String email, String employeeNumber, Subject subject) {
        super(firstName, lastName, phone, email);
        this.employeeNumber = employeeNumber;
        this.subjects = new Subject[50];
        this.subjectCount = 0;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Subject[] getSubjects() {
        Subject[] result = new Subject[subjectCount];

        for (int i = 0; i < subjectCount; i++) {
            result[i] = subjects[i];
        }

        return result;
    }

    public int getSubjectCount() {
        return subjectCount;
    }

    public void addSubject(Subject subject) {
        if (subject == null || subjectCount == subjects.length) {
            return;
        }

        if (subject.getInstructor() == this) {
            for (int i = 0; i < subjectCount; i++) {
                if (subjects[i] == subject) {
                    return;
                }
            }
        }

        Instructor oldInstructor = subject.getInstructor();

        if (oldInstructor != null && oldInstructor != this) {
            oldInstructor.removeSubject(subject);
        }

        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i] == subject) {
                subject.setInstructorReference(this);
                return;
            }
        }

        subjects[subjectCount++] = subject;
        subject.setInstructorReference(this);
    }


    void removeSubject(Subject subject) {
        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i] == subject) {
                for (int j = i; j < subjectCount - 1; j++) {
                    subjects[j] = subjects[j + 1];
                }
                subjectCount--;
                subjects[subjectCount] = null;
                return;
            }
        }
    }


    public String cleanEmployeeNumber() {
        return employeeNumber.trim().replace(" ", "");
    }


    public String summaryLine() {
        return String.format("Instructor[employeeNumber=%s, lastName=%s, firstName=%s]",cleanEmployeeNumber(), secondName,firstName);
    }


    public String toCard() {
        StringBuilder s = new StringBuilder();

        s.append("Instructor").append("\n")
        .append("----------")
        .append("\n")
        .append("Employee #: ").append(cleanEmployeeNumber())
        .append("\n")
        .append("Name : ").append(secondName).append(", ").append(firstName)
        .append("\n")
        .append("Email : ").append(email)
        .append("\n")
        .append("Phone : ").append(phone) ;

        return s.toString();
    }


    public String displayName() {
        StringBuilder s = new StringBuilder();

        if (secondName != null) {
            s.append(secondName);
        }

        if (firstName != null) {
            if (s.length() > 0) {
                s.append(" ");
            }
            s.append(firstName);
        }

        return s.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "Instructor{id=%d, employeeNumber='%s', lastName='%s', firstName='%s'}",
                id, employeeNumber, secondName, firstName
        );
    }
}
