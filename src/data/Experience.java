package data;

import java.util.List;

public class Experience extends Employee{
    private Integer YearEx;
    private String proSkill;
    public Experience(Integer explnYear, String proSkill,String iD, String fullName, String birthDay, String phoneNumber,
                      String email, Integer employeeType){
        super(iD,fullName, birthDay, phoneNumber, email, employeeType);
        this.YearEx = explnYear;
        this.proSkill = proSkill;
    }
    @Override
    public void showInfo(){

    }

    public int getExplnYear() {
        return YearEx;
    }

    public void setExplnYear(int explnYear) {
        this.YearEx = explnYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
