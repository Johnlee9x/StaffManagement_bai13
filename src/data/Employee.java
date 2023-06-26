package data;

public abstract class Employee {

    protected String iD;
    protected String fullName;
    protected String birthDay;
    protected String phoneNumber;
    protected String email;
    protected Integer employeeType;
    protected static Integer employeeCount = 0;
    public Employee(String iD, String fullName, String birthDay, String phoneNumber,
                    String email, Integer employeeType){
        this.birthDay = birthDay;
        this.employeeType = employeeType;
        this.email = email;
        this.iD = iD;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        employeeCount ++;
    }

    public Employee() {

    }

    public abstract void showInfo();

    public String getiD() {
        return iD;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }


    @Override
    public String toString(){
        return "Id: "+ this.iD + ", fullName: "+this.fullName + ", birthDay: "+ this.birthDay
                +", email: "+ this.email +", EmployeeType: "+ this.employeeType;
    }

}
