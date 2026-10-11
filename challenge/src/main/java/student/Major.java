package student;

public class Major {
    private static int nextId = 1;
    private int id;
    private String code;
    private String name;
    private Student[] students;
    private int studentCount;

    public Major(){
        this("","");
    }
    public Major(String code, String name) {
        this.id = nextId++;
        this.code = code ;
        this.name = name ;
        this.students = new Student[50];
        this.studentCount = 0 ;
    }


    // Method to add a student
    public void addStudent(Student s) {
        if (s == null) {
            return;
        }

        if(s.getMajor() == this ){
            return;
        }
        if(studentCount >= 50){
            System.out.println("Major is full");
            return;
        }

        Major old_major = s.getMajor();
        if(old_major != null){
            old_major.removeStudent(s.getCne());
        }

        students[studentCount++]= s;
        s.assignMajor(this);

    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Major{id=%d, code='%s', name='%s', studentCount=%d}",
                id, code, name, studentCount
        );
    }
    // Display all students in the major
    public void displayStudents() {
        System.out.println(getStudentListAsString());
    }


    public Student findStudentByCNE(String cne) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getCne().equals(cne)) {
                return students[i];
            }
        }

        return null;
    }


    public int getStudentCount() {
        return studentCount;
    }

    public boolean removeStudent(String cne){
        Student s = findStudentByCNE(cne);
        if (s == null) {
            return false;
        }

        for (int i = 0; i < studentCount; i++) {
            if (students[i] == s) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                studentCount--;
                students[studentCount] = null;
                s.assignMajor(null);
                return true;
            }
        }

        return false;
    }

    public double getOccupancyRate() {
        return studentCount * 100.0 / 50;
    }

    public String getStudentListAsString(){
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < studentCount ; i++){
            s.append(i+1).append(". ").append(students[i].getCne()).append(" ").append(students[i].getFullNameFormatted()).append("\n");
        }

        return s.toString();
    }




}
