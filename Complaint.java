public class Complaint {
    private boolean status; // 0 for not resolved, 1 for resolved!
    private String sender;
    private String title;
    private String content;

    public Complaint(boolean status, String sender, String title, String content) {
        this.status = status;
        this.sender = sender;
        this.title = title;
        this.content = content;
    }
}
