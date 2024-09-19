import java.util.*;

public class Main {
    private static Course[] courses; // All courses offered by the University
    private static Complaint[] complaints = {};
    private static final List<User> users = new ArrayList<>(); // for login/signUp
    private static User user;
    private static final String adminPass = "ROOT_ACCESS";

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
                new String[]{"", "11:00-12:30", "", "11:00-12:30", ""}, 4,4,"LHC201");

        Course AA1 = new Course("MTH212", "Abstract Algebra-I", "Sneha Chaubey", new String[]{},
                new String[]{"", "", "9:30-11:00", "", "11:00-12:30"}, 4,4,"LHC102");

        Course ADA = new Course("CSE222", "Algorithm Design And Analysis", "Supratim Shit", new String[]{"CSE102"},
                new String[]{"15:00-16:30", "", "15:00-16:30", "", ""}, 4,4,"LHC101");

        Course ToC = new Course("CSE322", "Theory Of Computation", "Syamantak Das", new String[]{"CSE121"},
                new String[]{"", "15:00-16:30", "", "15:00-16:30", ""}, 4,4,"LHC219");

        Course DBMS = new Course("CSE202", "Fundamentals Of Database Management Systems", "Vikram Goyal", new String[]{"CSE102"},
                new String[]{"11:00-12:30", "", "11:00-12:30", "", ""}, 4,4,"C01");

        Course DSA = new Course("CSE102", "Data Structures And Algorithms", "Debarka Sengupta", new String[]{"CSE101"},
                new String[]{"", "", "9:30-11:00", "", "11:00-12:30"}, 2,4,"B003");

        Course PandS = new Course("MTH201", "Probability And Statistics", "Sanjit Kaul", new String[]{},
                new String[]{"9:30-10:30", "16:30-17:30", "", "16:30-17:30", ""}, 2,4,"A007");

        Course IP = new Course("CSE101", "Introduction To Programming", "Shad Akhtar", new String[]{},
                new String[]{"9:30-11:00", "", "9:30-11:00", "", ""}, 1,4,"LHC201");

        Course HCI = new Course("DES102", "Introduction To Human Computer Interaction", "Sonal Keshwani", new String[]{},
                new String[]{"", "9:30-11:00", "", "9:30-11:00", ""}, 1,4,"LHC201");

        Course AP = new Course("CSE201", "Advanced Programming", "Arun Balaji Buduru", new String[]{"CSE101","CSE102"},
                new String[]{"15:00-16:30", "", "15:00-16:30", "", ""}, 3,4,"LHC201");

        Course OS = new Course("CSE231", "Operating Systems", "Vivek Kumar", new String[]{"CSE102"},
                new String[]{"", "15:00-16:30", "", "15:00-16:30", ""}, 3,4,"C21");

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

        users.add(s1);
        users.add(s2);
        users.add(s3);

        // Adding Professors
        Professor p1 = new Professor("vivek@iiitd.ac.in","123789");
        Professor p2 = new Professor("arun@iiitd.ac.in","arun1234");
        p1.addCourse(new ProfessorCourse(OS,-1,"Monday:17:00-16:00","Operating System Design"));
        p2.addCourse(new ProfessorCourse(AP,-1,"Monday:17:00-16:00","OOP with Java"));
//        p2.addCourse(new ProfessorCourse(IP,-1,"Tuesday:17:00-16:00","Intro to CS with python"));
//        p2.addCourse(new ProfessorCourse(DSA,-1,"Wednesday:17:00-16:00","DSA with C++"));
        users.add(p1);
        users.add(p2);

        // Admin
        Admin a1 = new Admin("admin@iiitd.ac.in");
        users.add(a1);

        Complaint cmp1 = new Complaint(false,"Abhinav","Time clash","Kindly fix ASAP!");
        Complaint cmp2 = new Complaint(false,"Sanchay","Regarding New Course Registeration System","It's really cool!");
        s1.addComplaint(cmp2);
        s2.addComplaint(cmp1);
        addComplaint(cmp1);
        addComplaint(cmp2);

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
                        for(User user : users){
                            if(user.getType()==0 && Objects.equals(user.getEmail(), email)){
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
                        users.add(std);

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
                    for(User student : users){
                        if(student.getType()==0 && Objects.equals(student.getEmail(), email)){
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
                    for(User student : users){
                        if(Objects.equals(student.getEmail(),email)){
                            if(Objects.equals(student.getPassword(), password)){
                                flagPassword = false;
                                user = student;
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
                    int student_action = user.interfaceGUI();
                    if(student_action == 1){
                        printDashes();
                        user.welcome();
                        System.out.println("Courses Available To You In Semester "+  user.getSemester() + " Are: ");
                        printDashes();

                        // Example: Enrolled courses for the student
                        HashSet<String> enrolledCourseCodes = new HashSet<>();
                        for (Course enrolledCourse : user.getEnrolledCourses()) {
                            enrolledCourseCodes.add(enrolledCourse.getCourseCode());
                        }

                        int cntr = 1;
                        for(Course course : courses){
                            if(course.getSemester() == user.getSemester() && !enrolledCourseCodes.contains(course.getCourseCode())){
                                System.out.println(cntr);
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
                        user.registerForCourse(courses);
                    }
                    else if(student_action == 3){
                        printDashes();
                        System.out.println("Schedule:");
                        Course[] enrolled = user.getEnrolledCourses();

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
                                    System.out.print(course.getTimings()[i]+"["+course.getCourseName()+","+course.getInstructor()+","+course.getLocation()+"]"+" ");
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
                            for(finishedCourse course : user.getFinishedCourses()){
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
                                if(sem>=user.getSemester()) System.out.println("Invalid Semester");
                                else break;
                            }

                            int sg = 0;
                            int cnt = 0;
                            for(finishedCourse course : user.getFinishedCourses()){
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

                            Course[] enrolled = user.getEnrolledCourses();
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
                            user.removeCourse(courseCode);
                            System.out.println("Successfully Dropped "+courseCode);
                        }
                    }
                    else if(student_action==6){
                        scanner = new Scanner(System.in);
                        System.out.println("Enter Title:");
                        String title = scanner.nextLine();
                        System.out.println("Enter Description:");
                        String description = scanner.nextLine();
                        Complaint cmp = new Complaint(false, user.getEmail(), title, description);
                        user.addComplaint(cmp);
                        addComplaint(cmp);
                        System.out.println("Successfully Registered Complaint");
                        printDashes();
                    }
                    else if(student_action==7){
                        Complaint[] cmplnts = user.getComplaints();
                        for(Complaint c: cmplnts){
                            printDashes();
                            System.out.println("Status:"+c.getStatus());
                            System.out.println("Title:"+c.getTitle());
                            System.out.println("Desc:"+c.getContent());
                            if(Objects.equals(c.getStatus(), "Resolved")) System.out.println("Answer:"+c.getSolution());
                            printDashes();
                        }
                    }
                    else if(student_action == 8){
                        printDashes();
                        System.out.println("Logged Out!");
                        printDashes();
                        break;
                    }
                }
            }
            else if(choice2==2){
                // Prof Mode
                // signup
                int choice3;
                while(true) {
                    printDashes();
                    System.out.println("Press\n1. To Login\n2. To SignUp");
                    printDashes();
                    scanner = new Scanner(System.in);
                    choice3 = scanner.nextInt();
                    if (choice3 != 1 && choice3 != 2) {
                        System.out.println("Invalid Choice");
                    } else if (choice3 == 2) {
                        // SignUp
                        printDashes();
                        System.out.print("Please Enter Your Registered Email: ");
                        scanner = new Scanner(System.in);
                        String email = scanner.nextLine();


                        boolean flagUserNotFound = true;
                        for (User user : users) {
                            if (user.getType() == 1 && Objects.equals(user.getEmail(), email)) {
                                flagUserNotFound = false;
                                break;
                            }
                        }

                        if (!flagUserNotFound) {
                            System.out.println("User With This Email Exists");
                            printDashes();
                            continue;
                        }

                        System.out.print("Please Enter Your Password: ");
                        String password = scanner.nextLine();

                        Professor prf = new Professor(email, password);
                        // Adding prf
                        users.add(prf);

                        System.out.println("New User Successfully Registered! You Will Have To Login With Your Created ID");
                        printDashes();
                    } else {
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
                    for(User student : users){
                        if(student.getType()==1 && Objects.equals(student.getEmail(), email)){
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
                    for(User prof : users){
                        if(Objects.equals(prof.getEmail(),email)){
                            if(Objects.equals(prof.getPassword(), password)){
                                flagPassword = false;
                                user = prof;
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

                // logged in as prof
                while (true){
                    printDashes();
                    int prof_action = user.interfaceGUI();
                    if(prof_action==1){
                        printDashes();
                        ArrayList<ProfessorCourse> teaching = user.getTeachingCourses();
                        if(teaching.isEmpty()){
                            System.out.println("Not Teaching Any Course");
                            continue;
                        }
                        int cnt = 0;
                        for(ProfessorCourse course : teaching){
                            System.out.println(cnt+1+"."+course.getCourseCode()+"-"+course.getCourseName());
                            cnt++;
                        }
                        scanner = new Scanner(System.in);
                        System.out.println("Enter The Number Of The Course You want To View/Manage:");
                        int chosen = scanner.nextInt();
                        if(chosen > teaching.size()){
                            System.out.println("Invalid Selection");
                            continue;
                        }

                        //Display details of chosen course
                        ProfessorCourse course = teaching.get(chosen-1);
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
                        System.out.println("Syllabus:"+course.getSyllabus());
                        System.out.println("Enrollment Limit:"+course.getEnrollmentLimit());
                        System.out.println("Office Hours:"+course.getOfficeHours());
                        printDashes();

                        // Ask to update!
                        while (true){
                            printDashes();
                            System.out.println("Press\n1.Update syllabus\n2.Update Timings\n3.Update Credits\n4.Update Prerequisites\n5.Update Enrollment Limit\n6.Update Office Hours\n7.Go Back");
                            scanner = new Scanner(System.in);
                            int choice123 = scanner.nextInt();
                            if(choice123<1 || choice123>7){
                                System.out.println("Invalid Choice");
                                continue;
                            }

                            scanner = new Scanner(System.in);
                            if(choice123==1){
                                System.out.println("Enter New Syllabus:");
                                String syllabus = scanner.nextLine();
                                course.setSyllabus(syllabus);
                            }
                            else if(choice123==2){
                                String[] timings = {"","","","",""};
                                String x;

                                System.out.println("Enter New Timings (Just press enter if no class on a day):");
                                System.out.print("\tMonday:");
                                x = scanner.nextLine();
                                timings[0]=x;
                                System.out.print("\tTuesday:");
                                x = scanner.nextLine();
                                timings[1]=x;
                                System.out.print("\tWednesday:");
                                x = scanner.nextLine();
                                timings[2]=x;
                                System.out.print("\tThursday:");
                                x = scanner.nextLine();
                                timings[3]=x;
                                System.out.print("\tFriday:");
                                x = scanner.nextLine();
                                timings[4]=x;

                                course.setTimings(timings);
                            }
                            else if(choice123==3){
                                while(true){
                                    System.out.println("Enter Updated Credits:");
                                    scanner = new Scanner(System.in);
                                    int x = scanner.nextInt();
                                    if(x!=2 && x!=4){
                                        System.out.println("Invalid Credits (They can be either 2 or 4)");
                                    }else{
                                        course.setCredits(x);
                                        System.out.println("Updated!");
                                        break;
                                    }
                                }

                            }
                            else if(choice123==4){
                                scanner = new Scanner(System.in);
                                System.out.println("Enter Updated Prerequisites:");
                                String x = scanner.nextLine();
                                course.setPrerequisites(new String[]{x});
                                System.out.println("Updated!");
                            }
                            else if(choice123==5){
                                scanner = new Scanner(System.in);
                                System.out.println("Enter Updated Limit:");
                                int x = scanner.nextInt();
                                course.setEnrollmentLimit(x);
                            }else if(choice123==6){
                                scanner = new Scanner(System.in);
                                System.out.println("Enter Updated Office Hours:");
                                String x = scanner.nextLine();
                                course.setOfficeHours(x);
                            }
                            else{
                                break;
                            }
                        }

                    }
                    else if(prof_action==2){
                        printDashes();
                        HashMap<String,Integer> freqMap = new HashMap<String, Integer>();

                        for(ProfessorCourse crse : user.getTeachingCourses()){
                            freqMap.put(crse.getCourseCode(),1);
                        }

                        HashMap<String,Integer> studMap = new HashMap<String,Integer>();

                        System.out.println("Enrolled Students In Your Courses:");
                        for(User use:users){
                            if(use.getType()==0){
                                Course[] enrolled = use.getEnrolledCourses();
                                for(Course course:enrolled){
                                    if(freqMap.containsKey(course.getCourseCode()) && !studMap.containsKey(use.getEmail())){
                                        System.out.println(use.getName()+" "+use.getEmail()+" "+use.calcCG());
                                        studMap.put(use.getEmail(),1);
                                    }
                                }
                            }
                        }
                    }
                    else{
                        printDashes();
                        System.out.println("Logged Out!");
                        break;
                    }
                }
            }
            else{
                // Admin Mode
                while (true){
                    printDashes();
                    System.out.print("Enter Admin Password:");
                    scanner = new Scanner(System.in);
                    String password = scanner.nextLine();
                    if(!Objects.equals(password, adminPass)) System.out.println("Invalid Password");
                    else break;
                }

                // logged in as admin
                for(User use:users){
                    if(use.getType()==2) user=use;
                }
                while (true){
                    printDashes();
                    int adminChoice = user.interfaceGUI();
                    if(adminChoice==1){
                        while (true){
                            printDashes();
                            System.out.println("1.View Courses\n2.Add Courses\n3.Delete Courses\n4.Go Back");
                            scanner = new Scanner(System.in);
                            int choice1 = scanner.nextInt();
                            if(choice1!=1 && choice1!=2 && choice1!=3 && choice1!=4){
                                System.out.println("Invalid Choice");
                                continue;
                            }

                            if(choice1==4){
                                break;
                            }

                            if(choice1==1){
                                int cnt = 1;
                                for(Course course:courses){
                                    System.out.println(cnt+"."+course.getCourseCode()+"-"+course.getCourseName()+" [Sem:" + course.getSemester() + "]");
                                    cnt++;
                                }
                            }else if(choice1==3){
                                System.out.println("Enter CourseCode:");
                                scanner = new Scanner(System.in);
                                String courseCode = scanner.nextLine();
                                boolean found = false;
                                if(courses.length==0){
                                    System.out.println("No Courses Left In Catalog To Delete.");
                                    continue;
                                }
                                int ind = 0;
                                for(Course course:courses){
                                    if(Objects.equals(course.getCourseCode(),courseCode)){
                                        found = true;
                                        break;
                                    }
                                    ind++;
                                }
                                if(!found){
                                    System.out.println("No Such Course Found");
                                    continue;
                                }
                                System.out.println("Successfully Deleted "+ courses[ind].getCourseName());
                                Course[] newCourses = new Course[courses.length-1];
                                for(int i = 0;i<ind;i++){
                                    newCourses[i]=courses[i];
                                }
                                for(int i = ind+1;i<courses.length;i++){
                                    newCourses[i-1]=courses[i];
                                }
                                courses=newCourses;
                            }else{
                                System.out.println("Adding New Course");
                                scanner = new Scanner(System.in);
                                System.out.print("Enter CourseCode:");
                                String courseCode = scanner.nextLine();
                                System.out.print("Enter CourseName:");
                                String courseName = scanner.nextLine();
                                System.out.print("Enter CourseCredits:");
                                int credits = scanner.nextInt();
                                scanner = new Scanner(System.in);
                                System.out.print("Enter Prerequisites:");
                                String prerequisites = scanner.nextLine();
                                System.out.print("Enter Semester:");
                                int semester = scanner.nextInt();
                                scanner = new Scanner(System.in);
                                System.out.print("Enter Location:");
                                String location = scanner.nextLine();
                                System.out.print("Enter Instructor:");
                                String instructor = scanner.nextLine();

                                String[] timings = {"","","","",""};
                                String x;

                                System.out.println("Enter New Timings (Just press enter if no class on a day):");
                                System.out.print("\tMonday:");
                                x = scanner.nextLine();
                                timings[0]=x;
                                System.out.print("\tTuesday:");
                                x = scanner.nextLine();
                                timings[1]=x;
                                System.out.print("\tWednesday:");
                                x = scanner.nextLine();
                                timings[2]=x;
                                System.out.print("\tThursday:");
                                x = scanner.nextLine();
                                timings[3]=x;
                                System.out.print("\tFriday:");
                                x = scanner.nextLine();
                                timings[4]=x;

                                Course addedCourse = new Course(courseCode,courseName,instructor, new String[]{prerequisites},timings,semester,credits,location);
                                Course[] newCourses = new Course[courses.length+1];
                                for(int i = 0;i<courses.length;i++){
                                    newCourses[i]=courses[i];
                                }
                                newCourses[courses.length]=addedCourse;
                                courses=newCourses;

                                System.out.println("Successfully Added New Course");

                            }
                        }
                    }
                    else if (adminChoice == 2) {
                        printDashes();
                        scanner = new Scanner(System.in);

                        System.out.println("Enter the student's email to view or update records:");
                        String studentEmail = scanner.nextLine();

                        User studentToUpdate = null;
                        for (User user : users) {
                            if (user.getType()==0 && user.getEmail().equals(studentEmail)) {
                                studentToUpdate =  user;
                                break;
                            }
                        }

                        // If student is found
                        if (studentToUpdate != null) {
                            // Display student information
                            System.out.println("Student found:");
                            System.out.println("Name: " + studentToUpdate.getName());
                            System.out.println("Email: " + studentToUpdate.getEmail());
                            System.out.println("Semester: " + studentToUpdate.getSemester());
                            System.out.println("Credits Enrolled: " + studentToUpdate.getCreditsEnrolled());

                            // Allow admin to choose what to update
                            System.out.println("What would you like to update?");
                            System.out.println("1. Update Personal Information");
                            System.out.println("2. Update Grades");
                            int updateChoice = scanner.nextInt();
                            scanner.nextLine();  // consume newline

                            switch (updateChoice) {
                                case 1:
                                    // Update personal information
                                    System.out.println("Enter new email:");
                                    String newEmail = scanner.nextLine();
                                    System.out.println("Enter new semester:");
                                    int newSemester = scanner.nextInt();
                                    scanner.nextLine(); // consume newline

                                    studentToUpdate.setEmail(newEmail);
                                    studentToUpdate.setSemester(newSemester);
                                    System.out.println("Personal information updated successfully.");
                                    break;

                                case 2:
                                    // Update grades
                                    System.out.println("Enter the course code to update grade:");
                                    String courseCode = scanner.nextLine();

                                    boolean courseFound = false;
                                    for (Course course : studentToUpdate.getEnrolledCourses()) {
                                        if (course.getCourseCode().equals(courseCode)) {
                                            System.out.println("Enter new grade:");
                                            int newGrade = scanner.nextInt();

                                            studentToUpdate.addFinishedCourse(course,newGrade);
                                            studentToUpdate.removeCourse(course);

                                            System.out.println("Grade updated successfully.");
                                            courseFound = true;
                                            break;
                                        }
                                    }

                                    if (!courseFound) {
                                        System.out.println("Student Not Enrolled In this course");
                                    }
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                                    break;
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    else if(adminChoice==3){
                        printDashes();
                        scanner = new Scanner(System.in);
                        System.out.println("Enter the Course Code:");
                        String courseID = scanner.nextLine();

                        Course courseToAssign = null;
                        for (Course course : courses) {
                            if (course.getCourseCode().equals(courseID)) {
                                courseToAssign = course;
                                break;
                            }
                        }

                        if(courseToAssign==null){
                            System.out.println("No course found with the provided Course Code.");
                            continue;
                        }

                        System.out.println("Course found: " + courseToAssign.getCourseName());

                        System.out.println("Available Professors:");
                        List<User> availableProfessors = new ArrayList<>();
                        int counter = 1;
                        for (User user : users) {
                            if (user.getType()==1) {
                                availableProfessors.add(user);
                                System.out.println(counter + ". " + user.getName() );
                                counter++;
                            }
                        }

                        if(availableProfessors.isEmpty()){
                            System.out.println("No available professors found.");
                            continue;
                        }

                        System.out.println("Enter the number of the professor you want to assign:");
                        int professorIndex = scanner.nextInt();
                        scanner.nextLine();
                        boolean flag = false;
                        if (professorIndex > 0 && professorIndex <= availableProfessors.size()) {
                            User assignedProfessor = availableProfessors.get(professorIndex - 1);
                            for(ProfessorCourse crse:assignedProfessor.getTeachingCourses()){
                                if(crse.getCourseCode().equals(courseID)){
                                    System.out.println("Professor Already Teaching This Course");
                                    flag = true;
                                    break;
                                }
                            }

                            if(flag){
                                continue;
                            }
                            assignedProfessor.addCourse(new ProfessorCourse(courseToAssign,-1,"---","---"));
                            System.out.println("Professor " + assignedProfessor.getName() + " has been assigned to the course " + courseToAssign.getCourseName());
                        } else {
                            System.out.println("Invalid professor selection.");
                        }
                    }
                    else if(adminChoice==4){
                        printDashes();
//                        System.out.println("All Complaints:");
//                        int cnt = 1;
//                        for(Complaint complaint : complaints) {
//                            System.out.println(cnt+"."+complaint.getStatus()+" "+complaint.getTitle());
//                            System.out.println(complaint.getContent());
//                            System.out.println("-"+complaint.getSender());
//                            cnt++;
//                        }
                        while (true){
                            printDashes();
                            System.out.println("Press\n1.To Resolve Complaint\n2.To Filter By Status\n3.Go Back");
                            scanner = new Scanner(System.in);
                            int choicee = scanner.nextInt();

                            if(choicee==3) break;

                            if(choicee!=1 && choicee!=2){
                                System.out.println("Invalid option.");
                                continue;
                            }

                            if(choicee==1){
                                System.out.println("Pending Complaints:");
                                int cnt = 1;
                                List<Complaint> pendingComplaints = new ArrayList<>();
                                for(Complaint complaint : complaints) {
                                    if(Objects.equals(complaint.getStatus(), "Pending")) {
                                        System.out.println(cnt+"."+complaint.getStatus()+" "+complaint.getTitle());
                                        System.out.println(complaint.getContent());
                                        System.out.println("-"+complaint.getSender());
                                        pendingComplaints.add(complaint);
                                        cnt++;
                                    }
                                }
                                System.out.println("Enter Number Of The Complaint You Want To Resolve:");
                                scanner = new Scanner(System.in);
                                int x = scanner.nextInt();
                                if(x<1 || x>=cnt){
                                    System.out.println("Invalid option.");
                                    continue;
                                }
                                scanner.nextLine();

                                Complaint selectedComplaint = pendingComplaints.get(x-1);

                                System.out.println("Please Enter Your Reply:");
                                scanner = new Scanner(System.in);
                                String repl = scanner.nextLine();

                                selectedComplaint.resolve(repl);
                                System.out.println("Complaint Resolved!");
                            }else{
                                printDashes();
                                System.out.println("Filter By:\n1.Resolved Status\n2.Pending Status\n3.Go Back");
                                scanner = new Scanner(System.in);
                                int x = scanner.nextInt();

                                if(x==3) continue;

                                if(x!=1 && x!=2){
                                    System.out.println("Invalid option.");
                                    continue;
                                }
                                printDashes();
                                if(x==1){
                                    System.out.println("Resolved Complaints:");
                                    int cnt = 1;
                                    List<Complaint> pendingComplaints = new ArrayList<>();
                                    for(Complaint complaint : complaints) {
                                        if(Objects.equals(complaint.getStatus(), "Resolved")) {
                                            System.out.println(cnt+"."+complaint.getStatus()+" "+complaint.getTitle());
                                            System.out.println(complaint.getContent());
                                            System.out.println("-"+complaint.getSender());
                                            pendingComplaints.add(complaint);
                                            cnt++;
                                        }
                                    }
                                }else{
                                    System.out.println("Pending Complaints");
                                    int cnt = 1;
                                    List<Complaint> pendingComplaints = new ArrayList<>();
                                    for(Complaint complaint : complaints) {
                                        if(Objects.equals(complaint.getStatus(), "Pending")) {
                                            System.out.println(cnt+"."+complaint.getStatus()+" "+complaint.getTitle());
                                            System.out.println(complaint.getContent());
                                            System.out.println("-"+complaint.getSender());
                                            pendingComplaints.add(complaint);
                                            cnt++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        printDashes();
                        System.out.println("Logged Out!");
                        break;
                    }
                }

            }
        }
    }
}