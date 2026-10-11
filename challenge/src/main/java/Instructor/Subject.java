package Instructor;

public class Subject {
    private static int nextId = 1;

    private int id;
    private String code;
    private String title;
    private Instructor instructor;

    public Subject() {
        this("", "" , null);
    }

    public Subject(String code, String title) {
        this.id = nextId++;
        this.code = code;
        this.title = title;
        this.instructor = null;
    }

    public Subject(String code, String title, Instructor instructor) {
        this.id = nextId++;
        this.code = code;
        this.title = title;
        this.instructor = null;

        if (instructor != null) {
            instructor.addSubject(this);
        }
    }

    public int getId() {
        return id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        if (this.instructor == instructor) {
            return;
        }

        if (this.instructor != null) {
            this.instructor.removeSubject(this);
        }

        this.instructor = null;

        if (instructor != null) {
            instructor.addSubject(this);
        }
    }

    void setInstructorReference(Instructor instructor) {
        this.instructor = instructor;
    }

    public String normalizedCode() {
        return code.toUpperCase().trim();
    }

    public String properTitle() {
        String[] words = title.trim().split(" +");
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                s.append(" ");
            }
            if (!words[i].isEmpty()) {
                s.append(words[i].substring(0, 1).toUpperCase());
                s.append(words[i].substring(1).toLowerCase());
            }
        }
        return s.toString();
    }



    public boolean isIntroCourse() {
        String lowerTitle = title.toLowerCase();

        if (lowerTitle.contains("intro") || normalizedCode().startsWith("INTRO-")) {
            return true;
        }

        return false;
    }

    public String syllabusLine() {
        StringBuilder s = new StringBuilder();
        s.append(normalizedCode())
                .append(" - ")
                .append(properTitle())
                .append(" (Instructor: ")
                .append(instructor.getSecondName())
                .append(" ")
                .append(instructor.getFirstName())
                .append(")");

        return s.toString();
    }



    @Override
    public String toString() {
        return String.format(
                "Subject{id=%d, code='%s', title='%s'}",
                id, code, title
        );
    }


}
