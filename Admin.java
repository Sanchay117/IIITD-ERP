import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {

    public Admin(String email) {
        super(email,"ROOT_ACCESS",2);
    }

    @Override
    public int interfaceGUI() {
        while (true){
            System.out.println("Logged In as Admin");
            System.out.println("You Can:\n1.Manage Course Catalog\n2.Manage Student Records\n3.Assign Professors to Courses\n4.Handle Complaints\n5.Logout");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5){
                System.out.println("Invalid Choice");
                continue;
            }

            return choice;
        }
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

    // These Are Dummy User Methods Which Only Professor.java uses!
    @Override
    public ArrayList<ProfessorCourse> getTeachingCourses() { throw new UnsupportedOperationException(); }
    @Override
    public void addCourse(ProfessorCourse crse) {throw new UnsupportedOperationException();}
}
