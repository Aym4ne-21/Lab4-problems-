package student;

public class Student extends Person {
    private static final Major DEFAULT_MAJOR  = new Major("23","Computer Science");
    private String cne;
    private Major major;


    public Student(){
        this("","","","","",DEFAULT_MAJOR);
    }
    public Student(String nom, String prenom, String telephone, String email, String cne) {
        this(nom , prenom, telephone , email ,cne ,DEFAULT_MAJOR);
    }
    public Student(String nom, String prenom, String telephone,
                   String email, String cne, Major major) {
        super(prenom, nom, telephone, email);
        this.cne = cne;
        this.major = null;

        Major selectedMajor = (major == null) ? DEFAULT_MAJOR : major;
        selectedMajor.addStudent(this);
    }
     //Getters

    public String getCne() {
        return cne;
    }

    public Major getMajor() {
        return major;
    }

    public static Major getDefaultMajor(){
        return DEFAULT_MAJOR;
    }

    //Setters


    public void setCne(String cne) {
        this.cne = cne;
    }


    public void setMajor(Major major) {
        if (major == this.major) {
            return;
        }

        if (major == null) {
            if (this.major != null) {
                this.major.removeStudent(cne);
            }
        } else {
            major.addStudent(this);
        }
    }

    void assignMajor(Major major) {
        this.major = major;
    }

    public String getFullNameFormatted(){
        return String.format("%s, %s" , secondName.toUpperCase(), firstName );
    }

    @Override
    public String toString() {
        return "Student{" +
                "cne= " + cne +
                ", major=" + major +
                " , full name=" + getFullNameFormatted() +
                '}';
    }
}

