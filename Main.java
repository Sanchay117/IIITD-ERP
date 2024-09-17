import java.util.*;

public class Main {
    private static Course[] courses; // All courses offered by the University
    private static Student[] students;
    private static Professor[] professors;
    private static Admin[] admins;
    private static Student studentUser; // if logged in as student
    private static Professor professorUser;// if logged in as prof
    private static Admin adminUser; // if using as admin
    private static Complaint[] complaints;

    private static void printDashes(){
        System.out.println("----------------------------------------------------------------------------------");
    }

    private static void exit(){
        printDashes();
        System.out.println("Exiting!");
        printDashes();
        System.exit(0);
    }

    private static void addComplaint(Complaint cmp){
        Complaint[] newComplaints = new Complaint[complaints.length+1];
        System.arraycopy(complaints, 0, newComplaints, 0, complaints.length);
        newComplaints[complaints.length] = cmp;
        complaints = newComplaints;
    }

    private static void prepopulateData(){
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

        Course PandS = new Course("MTH201", "Probability And Statistics", "Sanjit Kaul", new String[]{},
                new String[]{"9:30-10:30", "16:30-17:30", "", "16:30-17:30", ""}, 2,4);

        Course IP = new Course("CSE101", "Introduction To Programming", "Shad Akhtar", new String[]{},
                new String[]{"9:30-11:00", "", "9:30-11:00", "", ""}, 1,4);

        Course HCI = new Course("DES102", "Introduction To Human Computer Interaction", "Sonal Keshwani", new String[]{},
                new String[]{"", "9:30-11:00", "", "9:30-11:00", ""}, 1,4);

        Course AP = new Course("CSE201", "Advanced Programming", "Arun Balaji Buduru", new String[]{"CSE101","CSE102"},
                new String[]{"15:00-16:30", "", "15:00-16:30", "", ""}, 3,4);

        Course OS = new Course("CSE231", "Operating Systems", "Vivek Kumar", new String[]{"CSE102"},
                new String[]{"", "15:00-16:30", "", "15:00-16:30", ""}, 3,4);

        courses = new Course[]{M4,AA1,ADA,ToC,DBMS,DSA,PandS,IP,HCI,AP,OS};

        // Adding Students
        Student s1 = new Student("sanchay23478@iiitd.ac.in","1234",4);
        Student s2 = new Student("abhinav22061@iiitd.ac.in","whyThisAssignmentSoLong",4);
        Student s3 = new Student("saksham24092@iiitd.ac.in","TookMe4Days",2);
        s1.addFinishedCourse(IP,10);
        s1.addFinishedCourse(HCI,9);
        s1.addFinishedCourse(DSA,10);
        s1.addFinishedCourse(PandS,8);
        s1.addFinishedCourse(AP,10);
        s1.addFinishedCourse(OS,10);

        s2.addFinishedCourse(IP,9);
        s2.addFinishedCourse(HCI,10);
        s2.addFinishedCourse(DSA,9);
        s2.addFinishedCourse(PandS,9);
        s2.addFinishedCourse(AP,9);
        s2.addFinishedCourse(OS,8);

        s3.addFinishedCourse(IP,6);
        s3.addFinishedCourse(HCI,7);

        students = new Student[]{s1,s2,s3};

        // Adding Professors
        Professor p1 = new Professor("vivek@iiitd.ac.in","123789");
        Professor p2 = new Professor("arun@iiitd.ac.in","arun1234");
        professors = new Professor[]{p1,p2};

        // Admin
        Admin a1 = new Admin("admin@iiitd.ac.in");
        admins = new Admin[]{a1};

        // Prepopulating Finished
    }

    public static void main(String[] args) {
        prepopulateData();

        int choice;
        while (true) {

            // Enter/Exit
            printDashes();
            System.out.println("Welcome to IIITD Course Registration System");
            System.out.println("Press:\n1.Enter The Application\n2.Exit the Application");
            printDashes();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            if(choice == 2){
                exit();
            }else if(choice != 1){
                System.out.println("Invalid Choice");
                continue;
            }

            // Student/Prof/Admin
            int choice2;
            while (true) {
                printDashes();
                System.out.println("Welcome to IIITD Course Registration System");
                System.out.println("Log In/Sign Up As:\n1.Student\n2.Professor\n3.Admin\n4.Exit");
                printDashes();
                scanner = new Scanner(System.in);
                choice2 = scanner.nextInt();
                if(choice2 != 1 && choice2 != 2 && choice2 != 3 && choice2 != 4){
                    System.out.println("Invalid Choice");
                }else if(choice2==4){
                    exit();
                }
                else{
                    break;
                }
            }


            // Student Mode
            if(choice2 == 1){
                int choice3;

                // signup
                while(true){
                    printDashes();
                    System.out.println("Press\n1. To Login\n2. To SignUp");
                    printDashes();
                    scanner = new Scanner(System.in);
                    choice3 = scanner.nextInt();
                    if(choice3!=1 && choice3!=2){
                        System.out.println("Invalid Choice");
                    }
                    else if(choice3==2){
                        // SignUp
                        printDashes();
                        System.out.print("Please Enter Your Registered Email: ");
                        scanner = new Scanner(System.in);
                        String email = scanner.nextLine();


                        boolean flagUserNotFound = true;
                        for(Student student : students){
                            if(Objects.equals(student.getEmail(), email)){
                                flagUserNotFound = false;
                                break;
                            }
                        }

                        if(!flagUserNotFound){
                            System.out.println("User With This Email Exists");
                            printDashes();
                            continue;
                        }

                        System.out.print("Please Enter Your Password: ");
                        String password = scanner.nextLine();
                        System.out.print("Please Enter Your Semester: ");
                        int semester = Integer.parseInt(scanner.nextLine());

                        Student std = new Student(email, password, semester);
                        // Adding std
                        Student[] newStds = new Student[students.length+1];
                        System.arraycopy(students, 0, newStds, 0, students.length);
                        newStds[students.length] = std;
                        students = newStds;

                        System.out.println("New User Successfully Registered! You Will Have To Login With Your Created ID");
                        printDashes();
                    }
                    else{
                        break;
                    }
                }

                //login
                while (true){
                    printDashes();
                    System.out.print("Please Enter Your Registered Email: ");
                    scanner = new Scanner(System.in);
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
                        studentUser.registerForCourse(courses);
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
                                if(!Objects.equals(course.getTimings()[i], "")){
                                    System.out.print(course.getTimings()[i]+"["+course.getCourseName()+"]"+" ");
                                    cnt++;
                                }
                            }
                            if(cnt==0) System.out.println("Yay! No Classes Today!");
                            else System.out.println();
                        }


                        printDashes();
                    }
                    else if(student_action==4){
                        // CGPA,SGPA
                        int choose;
                        while(true){
                            scanner = new Scanner(System.in);
                            System.out.println("Press:\n1.To View CGPA\n2.To View SGPA\n3.To Go Back");
                             choose = scanner.nextInt();
                            if(choose != 1 && choose != 2 && choose != 3){
                                System.out.println("Please enter a valid option");
                            }else{
                                break;
                            }
                        }
                        if(choose==3){
                            continue;
                        }

                        if(choose==1){
                            int cg = 0;
                            int cnt = 0;
                            for(finishedCourse course : studentUser.getFinishedCourses()){
                                cg+=course.getGrade();
                                cnt++;
                                System.out.println(course.getCourseName()+":"+course.getGrade());
                            }
                            float cgpa = (float) cg /cnt;
                            System.out.println("CGPA:"+cgpa);
                        }else{
                            int sem;
                            while (true){
                                scanner = new Scanner(System.in);
                                System.out.println("Please Enter The Semester:");
                                sem = scanner.nextInt();
                                if(sem>=studentUser.getSemester()) System.out.println("Invalid Semester");
                                else break;
                            }

                            int sg = 0;
                            int cnt = 0;
                            for(finishedCourse course : studentUser.getFinishedCourses()){
                                if(course.getSemester()==sem){
                                    sg+=course.getGrade();
                                    cnt++;
                                    System.out.println(course.getCourseName()+":"+course.getGrade());
                                }
                            }
                            float sgpa = (float) sg /cnt;
                            System.out.println("SGPA:"+sgpa);
                        }
                    }
                    else if(student_action==5){
                        while (true){
                            scanner = new Scanner(System.in);

                            Course[] enrolled = studentUser.getEnrolledCourses();
                            if(enrolled.length == 0) {
                                System.out.println("No Enrolled Courses");
                                break;
                            }

                            System.out.println("Your Enrolled Courses:");
                            int cnt = 0;
                            for(Course course : enrolled){
                                System.out.println(cnt+1+"."+course.getCourseCode()+"-"+course.getCourseName());
                                cnt++;
                            }

                            System.out.println("Please Enter Course Code of The Course You Want To Drop:");
                            String courseCode = scanner.nextLine();

                            boolean flagCourseExists = false;
                            for(Course course : enrolled){
                                if(Objects.equals(course.getCourseCode(), courseCode)){
                                    flagCourseExists = true;
                                }
                            }
                            if(!flagCourseExists){
                                System.out.println("Not Enrolled in This Course");
                                break;
                            }
                            studentUser.removeCourse(courseCode);
                            System.out.println("Successfully Dropped "+courseCode);
                        }
                    }
                    else if(student_action==6){
                        scanner = new Scanner(System.in);
                        System.out.println("Enter Title:");
                        String title = scanner.nextLine();
                        System.out.println("Enter Description:");
                        String description = scanner.nextLine();
                        Complaint cmp = new Complaint(false, studentUser.getEmail(), title, description);
                        studentUser.addComplaint(cmp);
                        addComplaint(cmp);
                        System.out.println("Successfully Added Complaint");
                        printDashes();
                    }
                    else if(student_action == 7){
                        printDashes();
                        System.out.println("Logged Out!");
                        printDashes();
                        break;
                    }
                }
            }else if(choice2==2){
                // Prof Mode

            }else{

            }
        }
    }
}