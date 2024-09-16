import java.util.*;

public class Main {
    private static Course[] courses; // All courses offered by the University
    private static Student[] students;
    private static Professor[] professors;
    private static Admin[] admins;
    private static String userType;
    private static String userName;
    private static String userPassword;
    private static String userEmail;
    private static Student studentUser; // if logged in as student

    private static void printDashes(){
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void exit(){
        printDashes();
        System.out.println("Exiting!");
        printDashes();
        System.exit(0);
    }

    public static void main(String[] args) {
        // Prepopulating....

        // Adding Courses
        Course M4 = new Course("MTH204", "Differential Equations", "Ashish Kumar Pandey", new String[]{"MTH203"},
                                new String[]{"", "11:00-12:30", "", "11:00-12:30", ""}, 4,4);

        Course AA1 = new Course("MTH212", "Abstract Algebra-I", "Sneha Chaubey", new String[]{},
                                new String[]{"", "", "9:30-11:00", "", "11:00-12:30"}, 4,4);

        Course ADA = new Course("CSE222", "Algorithm Design And Analysis", "Supratim Shit", new String[]{"CSE102"},
                                new String[]{"15:00-16:30", "", "15:00-16:30", "", ""}, 4,4);

        Course ToC = new Course("CSE322", "Theory Of Computation", "Syamantak Das", new String[]{"CSE121"},
                                new String[]{"", "15:00-16:30", "", "15:00-16:30", ""}, 4,4);

        Course DBMS = new Course("CSE202", "Fundamentals Of Database Management Systems", "Vikram Goyal", new String[]{"CSE102"},
                                new String[]{"11:00-12:30", "", "11:00-12:30", "", ""}, 4,4);

        Course DSA = new Course("CSE102", "Data Structures And Algorithms", "Debarka Sengupta", new String[]{"CSE101"},
                                new String[]{"", "", "9:30-11:00", "", "11:00-12:30"}, 2,4);

        courses = new Course[]{M4,AA1,ADA,ToC,DBMS,DSA};

        // Adding Students
        Student s1 = new Student("sanchay23478@iiitd.ac.in","1234",4);
        Student s2 = new Student("abhinav22061@iiitd.ac.in","whyThisAssignmentSoLong",4);
        Student s3 = new Student("saksham24092@iiitd.ac.in","TookMe4Days",2);
        students = new Student[]{s1,s2,s3};

        // Adding Professors
        Professor p1 = new Professor("vivek@iiitd.ac.in","123789");
        Professor p2 = new Professor("arun@iiitd.ac.in","arun1234");
        professors = new Professor[]{p1,p2};

        // Admin
        Admin a1 = new Admin("admin@iiitd.ac.in");
        admins = new Admin[]{a1};

        // Prepopulating Finished
        int choice;
        while (true) {
            printDashes();
            System.out.println("Welcome to IIITD Course Registration System");
            System.out.println("Press:\n1.Enter The Application\n2.Exit the Application");
            printDashes();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            if(choice == 2){
                exit();
            }else if(choice == 1){
                break;
            }else{
                System.out.println("Invalid Choice");
            }
        }

        int choice2;
        while (true) {
            printDashes();
            System.out.println("Welcome to IIITD Course Registration System");
            System.out.println("Log In/Sign Up As:\n1.Student\n2.Professor\n3.Admin");
            printDashes();
            Scanner scanner = new Scanner(System.in);
            choice2 = scanner.nextInt();
            if(choice2 != 1 && choice2 != 2 && choice2 != 3){
                System.out.println("Invalid Choice");
            }else{
                break;
            }
        }

        if(choice2 == 1){
            // Student Mode
            int choice3;
            while(true){
                printDashes();
                System.out.println("Press\n1. To Login\n2. To SignUp");
                printDashes();
                Scanner scanner = new Scanner(System.in);
                choice3 = scanner.nextInt();
                if(choice3!=1 && choice3!=2){
                    System.out.println("Invalid Choice");
                }else{
                    break;
                }
            }

            if(choice3 == 1){
                while (true){
                    printDashes();
                    System.out.print("Please Enter Your Registered Email: ");
                    Scanner scanner = new Scanner(System.in);
                    String email = scanner.nextLine();
                    boolean flagUserNotFound = true;
                    for(Student student : students){
                        if(Objects.equals(student.getEmail(), email)){
                            flagUserNotFound = false;
                            break;
                        }
                    }
                    if(flagUserNotFound) {
                        System.out.println("No Such User Exists");
                        continue;
                    }

                    System.out.print("Please Enter Your Password: ");
                    String password = scanner.nextLine();
                    boolean flagPassword = true;
                    for(Student student : students){
                        if(Objects.equals(student.getEmail(),email)){
                            if(Objects.equals(student.getPassword(), password)){
                                flagPassword = false;
                                studentUser = student;
                            }
                            break;
                        }
                    }
                    if(flagPassword){
                        System.out.println("Incorrect Password");
                        continue;
                    }

                    break;

                }

                // Logged In As Student!
                while (true){
                    int student_action = studentUser.studentInterface();
                    if(student_action == 1){
                        printDashes();
                        studentUser.welcome();
                        System.out.println("Courses Available To You This Semester Are: ");
                        printDashes();

                        // Example: Enrolled courses for the student
                        HashSet<String> enrolledCourseCodes = new HashSet<>();
                        for (Course enrolledCourse : studentUser.getEnrolledCourses()) {
                            enrolledCourseCodes.add(enrolledCourse.getCourseCode());
                        }

                        int cntr = 1;
                        for(Course course : courses){
                            if(course.getSemester() == studentUser.getSemester() && !enrolledCourseCodes.contains(course.getCourseCode())){
                                System.out.println(cntr);
                                printDashes();
                                System.out.println("Course Code:"+course.getCourseCode());
                                System.out.println("Course Title:"+course.getCourseName());
                                System.out.println("Course Instructor:"+course.getInstructor());
                                System.out.println("Course Credits:"+course.getCredits());
                                System.out.print("Course Prerequisites:");
                                for(String prerequisite : course.getPrerequisites()){
                                    System.out.print(prerequisite+" ");
                                }
                                System.out.println();
                                System.out.println("Course Timings:");
                                int day = 0;
                                for(String timing : course.getTimings()){
                                    if(!Objects.equals(timing, "")){
                                        switch (day){
                                            case 0->System.out.println("\tMonday:"+timing);
                                            case 1->System.out.println("\tTuesday:"+timing);
                                            case 2->System.out.println("\tWednesday:"+timing);
                                            case 3->System.out.println("\tThursday:"+timing);
                                            case 4->System.out.println("\tFriday:"+timing);
                                        }
                                    }
                                    day++;
                                }
                                printDashes();
                                cntr++;
                            }
                        }
                    }
                    else if(student_action == 2){
                        while (true){
                            printDashes();
                            System.out.println("Kindly Enter The Course Code Or Enter Back To Go Back:");
                            Scanner scanner = new Scanner(System.in);
                            String courseCode = scanner.nextLine();
                            if(courseCode.equals("back") || courseCode.equals("Back") || courseCode.equals("BACK")){
                                break;
                            }
                            boolean flagCourseExists = false;
                            boolean flagEnrolled = false;
                            Course courseAdd = null;
                            for(Course course : courses){
                                if(Objects.equals(course.getCourseCode(), courseCode)){
                                    flagCourseExists = true;
                                    courseAdd = course;
                                    break;
                                }
                            }
                            for(Course course:studentUser.getEnrolledCourses()){
                                if(Objects.equals(course.getCourseCode(), courseCode)){
                                    flagEnrolled = true;
                                    break;
                                }
                            }
                            if(!flagCourseExists){
                                System.out.println("No Such Course Exists");
                                continue;
                            }
                            if(flagEnrolled){
                                System.out.println("Already Enrolled In This Course");
                                continue;
                            }

                            System.out.println("Enrolled!");
                            studentUser.addCourse(courseAdd);
                            break;

                        }
                    }
                    else if(student_action == 3){
                        printDashes();
                        System.out.println("Schedule:");
                        Course[] enrolled = studentUser.getEnrolledCourses();

                        for(int i = 0;i<=4;i++){
                            switch (i){
                                case 0-> System.out.print("\tMonday: ");
                                case 1-> System.out.print("\tTuesday: ");
                                case 2-> System.out.print("\tWednesday: ");
                                case 3-> System.out.print("\tThursday: ");
                                case 4-> System.out.print("\tFriday: ");
                            }
                            int cnt = 0;
                            for(Course course : enrolled){
                                System.out.println(course.getTimings()[i]);
                                if(Objects.equals(course.getTimings()[i], "")){
                                    System.out.print(course.getTimings()[i]+" ");
                                    cnt++;
                                }
                            }
                            if(cnt==0) System.out.println("Yay! No Classes Today!");
                            else System.out.println();
                        }


                        printDashes();
                    }
                    else if(student_action == 7){
                        exit();
                    }
                }


            }

        }
    }


}