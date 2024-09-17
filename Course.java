public class Course {
    private final String courseCode;
    private final String courseName;
    private String professor;
    private String[] prerequisites;
    private String[] timings; // (length should be 5, in case no class on a day that index of array should be empty) for every day mon,tue etc
    private final int semester;
    private int credits;
    private String location;

    public Course(String courseCode, String courseName, String professor, String[] prerequisites, String[] timings,int semester,int credits, String location) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.prerequisites = prerequisites;
        this.timings = timings;
        this.semester = semester;
        this.credits = credits;
        this.location = location;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return professor;
    }

    public String[] getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String[] prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String[] getTimings() {
        return timings;
    }

    public void setTimings(String[] timings) {
        this.timings = timings;
    }

    public int getSemester() {
        return semester;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits=credits;
    }

    public String getLocation() {
        return location;
    }
}

