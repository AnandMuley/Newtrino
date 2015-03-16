package newtrino.beans;

public class Contact {

    private String emailId;
    private String mobileNo;

    public Contact() {
    }

    public Contact(String emailId) {
        this.emailId = emailId;
    }

    public Contact(String emailId, String mobileNo) {
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "emailId='" + emailId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
