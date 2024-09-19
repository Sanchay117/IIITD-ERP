import java.util.ArrayList;

public abstract class User implements UserInterface{
    protected String email;
    protected String password;
    protected String name;
    private final int type; // 0 for student , 1 for prof , 2 for admin

    public User(String email, String password,int type) {
        this.email = email;
        this.password = password;
        this.name = this.email.split("[0-9@]")[0]; // generating name from email as the sequence of letters before the first occurrence of a number or @
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    protected static void printDashes(){
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void welcome(){
        System.out.println("Welcome: "+this.name+" !");
    }

    public abstract int interfaceGUI();

    // Student Specific Actions
    public abstract int getSemester();
    public abstract Course[] getEnrolledCourses();
    public abstract finishedCourse[] getFinishedCourses();
    public abstract int getCreditsEnrolled();
    public abstract void addCourse(Course course);
    public abstract void removeCourse(String courseCode);
    public abstract void addFinishedCourse(Course course,int grade);
    public abstract void registerForCourse(final Course[] courses);
    public abstract void addComplaint(Complaint cmp);
    public abstract float calcCG();
    public abstract void setSemester(int semester);
    public abstract void removeCourse(Course course);
    public abstract Complaint[] getComplaints();

    // Professor Specific Actions
    public abstract ArrayList<ProfessorCourse> getTeachingCourses();
    public abstract void addCourse(ProfessorCourse course);
}
