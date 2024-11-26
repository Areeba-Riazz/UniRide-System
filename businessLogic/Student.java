package businessLogic;

public class Student extends Users {
    boolean paymentStatus;
    String studentID;

    public Student(String name, String email, String phoneNo, String studentId, String password, String title) {
        super(name, email, phoneNo, password, title); // Calling parent constructor
        this.paymentStatus = false;
        this.studentID = studentId;
    }
    public boolean isPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}