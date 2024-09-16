import java.util.Scanner;

public class Student {
    private Course[] enrolledCourses = {};
    private final String email;
    private final String password;
    private final String name;
    private final int semester;

    public Student(String email, String password,int semester) {
        this.email = email;
        this.password = password;
        this.semester = semester;
        this.name = this.email.split("[0-9@]")[0]; // generating name from email as the sequence of letters before the first occurrence of a number or @
    }

    private static void printDashes(){
        System.out.println("--------------------------------------------------------------------------");
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getName() {
        return name;
    }

    public int getSemester(){
        return semester;
    }

    public void welcome(){
        System.out.println("Welcome: "+name+" !");
    }

    public Course[] getEnrolledCourses() {
        return enrolledCourses;
    }

    public int studentInterface(){
        int choice;
        while (true){
            printDashes();
            welcome();
            System.out.println("Press\n1.To View Available Courses\n2.To Register For Courses\n3.To View Schedule\n4.Track Academic Progress\n5.Drop Courses\n6.To Submit Complaints\n7.Logout And Exit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            printDashes();
            if(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6 && choice!=7){
                System.out.println("Invalid choice");
                continue;
            }
            break;
        }
        return choice;
    }

    public void addCourse(Course course){
        Course[] newCourses = new Course[enrolledCourses.length+1];
        System.arraycopy(enrolledCourses, 0, newCourses, 0, enrolledCourses.length);
        newCourses[enrolledCourses.length] = course;
        enrolledCourses = newCourses;
    }
}
