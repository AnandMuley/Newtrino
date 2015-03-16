package newtrino.dtos;

public class UserDto {

    private String id;
    private NameDto nameDto;
    private String username;
    private String password;
    private ContactDto contactDto;
    private String birthDate;
    private int age;

    public UserDto() {
    }

    public UserDto(String id, NameDto nameDto, String username, String password, ContactDto contactDto, String birthDate) {
        this.id = id;
        this.nameDto = nameDto;
        this.username = username;
        this.password = password;
        this.contactDto = contactDto;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NameDto getNameDto() {
        return nameDto;
    }

    public void setNameDto(NameDto nameDto) {
        this.nameDto = nameDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContactDto getContactDto() {
        return contactDto;
    }

    public void setContactDto(ContactDto contactDto) {
        this.contactDto = contactDto;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", nameDto=" + nameDto +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contactDto=" + contactDto +
                ", birthDate=" + birthDate +
                '}';
    }
}
