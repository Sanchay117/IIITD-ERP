// Seperate class as some aspects of a course that a prof needs are useless for everbody else and besides courses.java was already having too many attributes
public class ProfessorCourse extends Course {
    private int enrollmentLimit; // -1 for no limit
    private String officeHours;
    private String syllabus;

    public ProfessorCourse(Course course,int enrollmentLimits,String officeHours,String syllabus){
        super(course.getCourseCode(), course.getCourseName(), course.getInstructor(), course.getPrerequisites(), course.getTimings(), course.getSemester(), course.getCredits(),course.getLocation());
        this.enrollmentLimit = enrollmentLimits;
        this.officeHours = officeHours;
        this.syllabus = syllabus;
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }
}
