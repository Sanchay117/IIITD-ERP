public class Professor {
    private Course[] enrolledCourses;
    private String email;
    private String password;
    private String name;

    public Professor(String email, String password) {
        this.email = email;
        this.password = password;
        this.name = this.email.split("[0-9@]")[0]; // generating name from email as the sequence of letters before the first occurrence of a number or @
    }
}
