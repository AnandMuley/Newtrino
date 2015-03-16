package newtrino.dtos;

public class ContactDto {

    private String emailId;
    private String mobileNo;

    public ContactDto() {
    }

    public ContactDto(String emailId) {
        this.emailId = emailId;
    }

    public ContactDto(String emailId, String mobileNo) {
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
        return "ContactDto{" +
                "emailId='" + emailId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
