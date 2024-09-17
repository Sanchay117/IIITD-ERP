public class Course {
    private final String courseCode;
    private final String courseName;
    private String professor;
    private final String[] prerequisites;
    private final String[] timings; // (length should be 5, in case no class on a day that index of array should be empty) for every day mon,tue etc
    private final int semester;
    private final int credits;

    public Course(String courseCode, String courseName, String professor, String[] prerequisites, String[] timings,int semester,int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.prerequisites = prerequisites;
        this.timings = timings;
        this.semester = semester;
        this.credits = credits;
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

    public String[] getTimings() {
        return timings;
    }

    public int getSemester() {
        return semester;
    }

    public int getCredits() {
        return credits;
    }
}

