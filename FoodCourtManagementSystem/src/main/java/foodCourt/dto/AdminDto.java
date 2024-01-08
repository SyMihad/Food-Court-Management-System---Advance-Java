package foodCourt.dto;

import foodCourt.domain.Gender;

public class AdminDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Gender gender;
    private int nidNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getNidNo() {
        return nidNo;
    }

    public void setNidNo(int nidNo) {
        this.nidNo = nidNo;
    }
}
