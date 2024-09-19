import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends User {
    private final ArrayList<ProfessorCourse> teachingCourses = new ArrayList<>();

    public Professor(String email, String password) {
        super(email, password,1);
    }

    @Override
    public int interfaceGUI() {
        int choice;
        while (true){
            printDashes();
            welcome();
            System.out.println("Press\n1.To Manage Courses\n2.View Enrolled Students\n3.Logout");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            printDashes();
            if(choice!=1 && choice!=2 && choice!=3 ){
                System.out.println("Invalid choice");
                continue;
            }
            break;
        }
        return choice;
    }

    public void addCourse(ProfessorCourse course){
        teachingCourses.add(course);
    }

    public ArrayList<ProfessorCourse> getTeachingCourses(){
        return teachingCourses;
    }

    // These Are Dummy User Methods Which Only Student.java uses!

    @Override
    public int getSemester() { throw new UnsupportedOperationException(); }
    @Override
    public void setSemester(int sem) { throw new UnsupportedOperationException(); }
    @Override
    public void removeCourse(Course course) { throw new UnsupportedOperationException(); }
    @Override
    public Course[] getEnrolledCourses() { throw new UnsupportedOperationException(); }
    @Override
    public finishedCourse[] getFinishedCourses() { throw new UnsupportedOperationException(); }
    @Override
    public int getCreditsEnrolled() { throw new UnsupportedOperationException(); }
    @Override
    public void addCourse(Course course) { throw new UnsupportedOperationException(); }
    @Override
    public void removeCourse(String courseCode) { throw new UnsupportedOperationException(); }
    @Override
    public void addFinishedCourse(Course course, int grade) { throw new UnsupportedOperationException(); }
    @Override
    public void registerForCourse(final Course[] courses) { throw new UnsupportedOperationException(); }
    @Override
    public void addComplaint(Complaint cmp) { throw new UnsupportedOperationException(); }
    @Override
    public float calcCG() { throw new UnsupportedOperationException(); }
    @Override
    public Complaint[] getComplaints() { throw new UnsupportedOperationException(); }

}
