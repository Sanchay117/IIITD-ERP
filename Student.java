import java.util.*;

public class Student extends User {
    private Course[] enrolledCourses = {};
    private finishedCourse[] finishedCourses = {};
    private int semester;
    private int creditsEnrolled;
    private Complaint[] complaints = {};

    public Student(String email, String password,int semester) {
        super(email, password,0);
        this.semester = semester;
    }

    @Override
    public int getSemester(){
        return semester;
    }

    @Override
    public Course[] getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public finishedCourse[] getFinishedCourses(){
        return finishedCourses;
    }

    @Override
    public int getCreditsEnrolled() {
        return creditsEnrolled;
    }

    @Override
    public int interfaceGUI(){
        int choice;
        while (true){
            printDashes();
            welcome();
            System.out.println("Press\n1.To View Available Courses\n2.To Register For Courses\n3.To View Schedule\n4.Track Academic Progress\n5.Drop Courses\n6.To Submit Complaints\n7.Logout");
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

    @Override
    public void addCourse(Course course){
        Course[] newCourses = new Course[enrolledCourses.length+1];
        System.arraycopy(enrolledCourses, 0, newCourses, 0, enrolledCourses.length);
        newCourses[enrolledCourses.length] = course;
        enrolledCourses = newCourses;
        creditsEnrolled+=course.getCredits();
    }

    @Override
    public void removeCourse(String courseCode){
        Course[] newCourses = new Course[enrolledCourses.length - 1];
        int index = -1;
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i].getCourseCode().equals(courseCode)){
                index = i;
                break;
            }
        }
        creditsEnrolled-=enrolledCourses[index].getCredits();
        for (int i = 0, j = 0; i < enrolledCourses.length; i++) {
            if (i != index) {
                newCourses[j++] = enrolledCourses[i];
            }
        }
        enrolledCourses = newCourses;
    }

    @Override
    public void addFinishedCourse(Course course,int grade){
        finishedCourse course_finish = new finishedCourse(course,grade);
        finishedCourse[] newFinishedCourses = new finishedCourse[finishedCourses.length+1];
        System.arraycopy(finishedCourses, 0, newFinishedCourses, 0, finishedCourses.length);
        newFinishedCourses[finishedCourses.length] = course_finish;
        finishedCourses = newFinishedCourses;
    }

    @Override
    public void removeCourse(Course course){
        int ind = -1;
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i].getCourseCode().equals(course.getCourseCode())){
                ind = i;
                break;
            }
        }
        if(ind!=-1){
            Course[] newArr = new Course[enrolledCourses.length - 1];
            for(int i = 0;i<ind;i++){
                newArr[i] = enrolledCourses[i];
            }
            for(int j = ind+1;j<enrolledCourses.length;j++){
                newArr[j-1] = enrolledCourses[j];
            }

            enrolledCourses = newArr;
        }

    }

    @Override
    public void registerForCourse(final Course[] courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the semester you want to view courses for: ");
        int semester = scanner.nextInt();

        if(semester>this.semester){
            System.out.println("Invalid semester");
            return;
        }

        HashMap<Integer, Course> availableCourses = new HashMap<>();
        int courseCounter = 1;

        // Filter and display courses that are in the selected semester and not already enrolled
        System.out.println("Courses Available for Semester " + semester + " (not already enrolled): ");
        for (Course course : courses) {
            if (course.getSemester() == semester && !isEnrolledIn(course)) {
                availableCourses.put(courseCounter, course);
                System.out.println(courseCounter + ". " + course.getCourseCode() + " - " + course.getCourseName());
                courseCounter++;
            }
        }

        if (availableCourses.isEmpty()) {
            System.out.println("No courses available for this semester.");
            return;
        }

        // Ask user to select a course by number
        System.out.print("Enter the number of the course you want to enroll in: ");
        int selectedNumber = scanner.nextInt();
        Course selectedCourse = availableCourses.get(selectedNumber);

        if (selectedCourse == null) {
            System.out.println("Invalid course selection.");
            return;
        }

        // Check prerequisites
        boolean prerequisitesMet = true;
        for (String prerequisite : selectedCourse.getPrerequisites()) {
            if (!hasFinishedCourse(prerequisite)) {
                prerequisitesMet = false;
            }
        }

        if (!prerequisitesMet) {
            System.out.println("Cannot enroll in this course as prerequisites are not met.");
            return;
        }

        if (creditsEnrolled + selectedCourse.getCredits() > 20) {
            System.out.println("Credit Overload! Can't register for new courses without dropping previous ones!");
            return;
        }

        // Enroll in course
        System.out.println("Enrolled in course: " + selectedCourse.getCourseCode());
        addCourse(selectedCourse);
    }

    // Helper method to check if student is already enrolled in a course
    private boolean isEnrolledIn(Course course) {
        for (Course enrolledCourse : enrolledCourses) {
            if (enrolledCourse.getCourseCode().equals(course.getCourseCode())) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a prerequisite has been finished
    private boolean hasFinishedCourse(String courseCode) {
        for (finishedCourse finished : finishedCourses) {
            if (finished.getCourseCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addComplaint(Complaint cmp){
        Complaint[] newComplaints = new Complaint[complaints.length+1];
        System.arraycopy(complaints, 0, newComplaints, 0, complaints.length);
        newComplaints[complaints.length] = cmp;
        complaints = newComplaints;
    }

    @Override
    public float calcCG(){
        int cg = 0;
        int cnt = 0;
        for(finishedCourse finished : finishedCourses){
            cg+=finished.getGrade();
            cnt++;
        }
        return (float) cg /cnt;
    }

    @Override
    public void setSemester(int sem){
        this.semester = sem;
    }

    // These Are Dummy User Methods Which Only Professor.java uses!
    @Override
    public ArrayList<ProfessorCourse> getTeachingCourses() { throw new UnsupportedOperationException(); }
    @Override
    public void addCourse(ProfessorCourse crse) {throw new UnsupportedOperationException();}
}
