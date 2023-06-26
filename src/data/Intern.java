package data;

import java.util.List;

public class Intern extends Employee{
    private String major;
    private Integer semester;
    private String nameOfUniversity;
    public Intern(String major, Integer semester, String nameOfUniversity, String iD, String fullName, String birthDay, String phoneNumber,
                  String email, Integer employeeType ){
        super(iD, fullName, birthDay, phoneNumber, email, employeeType);
        this.major = major;
        this.semester = semester;
        this.nameOfUniversity = nameOfUniversity;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    @Override
    public void showInfo(){

    }
}
