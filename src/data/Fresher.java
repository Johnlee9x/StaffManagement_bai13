package data;

import java.util.List;

public class Fresher extends Employee{
    private String graduationTime;
    private String education;
    public Fresher(String graduationTime, String education, String id, String fullName, String birthDay,
                   String phoneNumber, String email, Integer employeeType){
        super(id, fullName, birthDay, phoneNumber, email, employeeType);
        this.education = education;
        this.graduationTime = graduationTime;
    }
    @Override
    public void showInfo(){

    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
