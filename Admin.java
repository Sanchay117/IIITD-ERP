public class Admin {
    private String email;
    private final String password = "Admin@IIITD";
    private String name;

    public Admin(String email) {
        this.email = email;
        this.name = this.email.split("[0-9@]")[0]; // generating name from email as the sequence of letters before the first occurrence of a number or @
    }
}
