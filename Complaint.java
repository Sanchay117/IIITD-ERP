public class Complaint {
    private boolean status; // 0 for not resolved, 1 for resolved!
    private String sender;
    private String title;
    private String content;
    private String solution;

    public Complaint(boolean status, String sender, String title, String content) {
        this.status = status;
        this.sender = sender;
        this.title = title;
        this.content = content;
    }

    public String getStatus() {
        if(status) return "Resolved";
        else return "Pending";
    }

    public String getSender() {
        return sender;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }

    public void resolve(String x){
        status=true;
        solution=x;
    }

    public String getSolution() {
        return solution;
    }
}

