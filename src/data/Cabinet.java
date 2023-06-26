package data;
import exception.*;
import util.MyUtil;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Cabinet {
    List<Employee>list;
    List<Certificate> listCer;
    public Cabinet(List<Employee> list, List<Certificate> listCer){
        this.listCer = listCer;
        this.list = list;
    }
    public void addAnExperiancer()  {
        String id;
        String fullName;
        String birthDay;
        String phoneNumber;
        int employeeType;
        int yearEx;
        String proSkill;
        String email;
        id = MyUtil.getAString("Please, enter Experiencer's Id with format SXXXXX, X represent for " +
                "digit numbers", "InputMissMatch and Try again", "^[D]\\d{5}$");
        fullName = MyUtil.getString("Please, enter Experiencer's name: ",
                "InputMissMatch and Try again");
        birthDay =  MyUtil.getAString("Please, enter Experiencer's birthDay with format yyyy-mm-dd: ",
                "InputMissMatch and Try again","^[12]\\d{3}-(1[0-2]|0\\d{1})-(3[01]|[12]\\d{1})$");
        phoneNumber = MyUtil.getAString("Pleas, enter Experiencer's phoneNumber with format 10 digits number" +
                "0XYYYYYYYY","InputMissMatch and Try again","^[0][35789]{1}\\d{8}$");
        email = MyUtil.getAString("Please, enter Experiencer's Email with format XXX...XXX@gmail.com",
                "InputMissMatch and Try again", "^(.+)@(\\S+)$");
        employeeType = MyUtil.getAnInteger("Please, enter the employeetype of the experience staff: ",
                "InputMissMatch and Try again" );
        yearEx = MyUtil.getAnInteger("Please, enter number of years experience of the staff: ",
                "InputMissMatch and Try again ");
        proSkill = MyUtil.getString("Please, enter the proSkill of the experience staff: ",
                "InputMissMatch and Try again ");
        Experience experience = new Experience(yearEx, proSkill, id, fullName, birthDay, phoneNumber, email, employeeType);
        try {
            this.checkInput(experience);
        } catch (BirthDayException | FullnameException | EmailException | PhoneException e) {
            System.out.println(e.getMessage());
            addAnExperiancer();
        }
        list.add(experience);
        System.out.println("Staff number: "+ Employee.getEmployeeCount());
        System.out.println("Added successfully");
    }
    public void addAFresher() {
        String id;
        String fullName;
        String birthDay;
        String phoneNumber;
        int employeeType;
        String email;
        String graduationTime;
        String education;

        id = MyUtil.getAString("Please, enter Fresher's Id with format SXXXXX, X represent for " +
                "digit numbers", "InputMissMatch and Try again", "^[D]\\d{5}$");
        fullName = MyUtil.getString("Please, enter Fresher's name:",
                "InputMissMatch and Try again");
        birthDay =  MyUtil.getAString("Please, enter Fresher's birthDay with format yyyy-mm-dd: ",
                "InputMissMatch and Try again","^[12]\\d{3}-(1[0-2]|0\\d{1})\\-(3[01]|[12]\\d{1})$");
        phoneNumber = MyUtil.getAString("Pleas, enter Fresher's phoneNumber with format 0XYYYYYYYY: ",
                "InputMissMatch and Try again","^[84|0][35789]\\d{8}$");
        email = MyUtil.getAString("Please, enter Fresher's Email with format XXX...XXX@gmail.com",
                "InputMissMatch and Try again", "^(.+)@(\\S+)$");
        employeeType = MyUtil.getAnInteger("Please, enter the employeetype of the Fresher staff: ",
                "InputMissMatch and Try again" );
        graduationTime = MyUtil.getAString("Please, enter the time that The Fresher have graduated with format yyyy-mm",
                "InputMissMatch and Try again", "^[12]\\d{3}\\-(1[0-2]|0\\d{1})$");
        education = MyUtil.getAString("Please, enter Fresher's university that have graduated",
                "InputMissMatch and Try again", "^.+$");
        Fresher fresher = new Fresher(graduationTime, education, id, fullName, birthDay, phoneNumber, email, employeeType);
        try {
            this.checkInput(fresher);
        } catch (BirthDayException | PhoneException | EmailException | FullnameException e) {
            System.out.println(e.getMessage());
            addAFresher();
        }
        list.add(fresher);
        System.out.println("Staff number: "+ Employee.getEmployeeCount());
        System.out.println("Added successfully");
    }
    public void addAnIntern(){
        String id;
        String fullName;
        String birthDay;
        String phoneNumber;
        int employeeType;
        String email;
        String major;
        int semester;
        String education;
        id = MyUtil.getAString("Please, enter Intern's Id with format SXXXXX, X represent for " +
                "digit numbers", "InputMissMatch and Try again", "^[D]\\d{5}$");
        fullName = MyUtil.getString("Please, enter Intern's name:",
                "InputMissMatch and Try again");
        birthDay =  MyUtil.getAString("Please, enter Intern's birthDay with format yyyy-mm-dd: ",
                "InputMissMatch and Try again","^[12]\\d{3}-(1[0-2]|0\\d{1})\\-(3[01]|[12]\\d{1})$");
        phoneNumber = MyUtil.getAString("Pleas, enter Intern's phoneNumber with format 0XYYYYYYYY: ",
                "InputMissMatch and Try again","^[0][35789]\\d{8}$");
        email = MyUtil.getAString("Please, enter Intern's Email with format XXX...XXX@gmail.com",
                "InputMissMatch and Try again", "^(.+)@(\\S+)$");
        employeeType = MyUtil.getAnInteger("Please, enter the employeeType of the Intern staff: ",
                "InputMissMatch and Try again" );
        major = MyUtil.getString("Please, enter Intern's major: ", "InputInvalid and Try again");
        semester = MyUtil.getAnInteger("Please, enter Intern's semester: ", "InputMissMatch and Try again");
        education = MyUtil.getAString("Please, enter Intern's university learning",
                "InputMissMatch and Try again", "^.+$");
        Intern intern = new Intern(major, semester, education, id, fullName, birthDay, phoneNumber, email,employeeType);
        try {
            this.checkInput(intern);
        } catch (BirthDayException | PhoneException | EmailException | FullnameException e) {
            System.out.println(e.getMessage());
            addAnIntern();
        }
        list.add(intern);
        System.out.println("Staff number: "+ Employee.getEmployeeCount());
        System.out.println("Added successfully");
    }
    public void removeAStaff(String id){
        Employee employee = list.stream().filter(e->e.getiD().equals(id)).findFirst().orElse(null);
        if(employee == null){
            System.out.println("The employee was not existed, check id again");
        }
        else {
            list.remove(employee);
            System.out.println("Remove successfully");
        }
    }
    public void updateAStaff(String id){
        if(list.isEmpty()){
            System.out.println("Nothing to update");

        }
        else {
            list = list.stream().filter(e->e.getiD().equalsIgnoreCase(id)).map(e->{
                if(e instanceof Experience){
                    System.out.println("Update Experience staff: ");
                    e.setFullName(MyUtil.getString("Please, enter Experiencer's name: ",
                            "InputMissMatch and Try again"));
                    e.setBirthDay(MyUtil.getAString("Please, enter your birthDay with format yyyy-mm-dd: ",
                            "InputMissMatch and Try again","^[12]\\d{3}-(1[0-2]|0\\d{1})\\-(3[01]|[12]\\d{1})$"));
                    e.setPhoneNumber(MyUtil.getAString("Pleas, enter your phoneNumber with format 0XYYYYYYYY",
                            "InputMissMatch and Try again","^[0][35789]\\d{8}$"));
                    e.setEmail(MyUtil.getAString("Please, enter your Email with format XXX...XXX@gmail.com",
                            "InputMissMatch and Try again", "^(.+)@(\\S+)$"));
                    ((Experience) e).setExplnYear(MyUtil.getAnInteger("Please, enter number of years experience of the staff: ",
                            "InputMissMatch and Try again "));
                    ((Experience) e).setProSkill(MyUtil.getString("Please, enter the proSkill of the experience staff: ",
                            "InputMissMatch and Try again "));
                    System.out.println("Update successfully");
                }
                else if(e instanceof Fresher){
                    System.out.println("update fresher's information: ");
                    e.setFullName(MyUtil.getString("Please, enter Fresher's name:",
                            "InputMissMatch and Try again"));
                    e.setBirthDay(MyUtil.getAString("Please, enter fresher's birthDay with format yyyy-mm-dd: ",
                            "InputMissMatch and Try again","^[12]\\d{3}-(1[0-2]|0\\d{1})\\-(3[01]|[12]\\d{1})$"));
                    e.setPhoneNumber(MyUtil.getAString("Pleas, enter fresher's phoneNumber with format 0XYYYYYYYY: "
                            ,"InputMissMatch and Try again","^[84|0][35789]\\d{8}$"));
                    e.setEmail(MyUtil.getAString("Please, enter fresher's Email with format XXX...XXX@gmail.com",
                            "InputMissMatch and Try again", "^(.+)@(\\S+)$"));
                    ((Fresher) e).setGraduationTime(MyUtil.getAString("Please, enter the time that The Fresher have graduated with format yyyy-mm",
                            "InputMissMatch and Try again", "^[12]\\d{3}\\-(1[0-2]|0\\d{1})$"));
                    ((Fresher) e).setEducation(MyUtil.getAString("Please, enter fresher's university that you have graduated",
                            "InputMissMatch and Try again", "^.*$"));
                    System.out.println("Update successfully");
                }
                else if(e instanceof Intern){
                    System.out.println("update Intern's information");
                    e.setFullName(MyUtil.getString("Please, enter Intern's name:",
                            "InputMissMatch and Try again"));
                    e.setBirthDay(MyUtil.getAString("Please, enter your birthDay with format yyyy-mm-dd: ",
                            "InputMissMatch and Try again","^[12]\\d{3}-(1[0-2]|0\\d{1})\\-(3[01]|[12]\\d{1})$"));
                    e.setPhoneNumber(MyUtil.getAString("Pleas, enter your phoneNumber with format 0XYYYYYYYY",
                            "InputMissMatch and Try again","^[84|0][35789]\\d{8}$"));
                    e.setEmail(MyUtil.getAString("Please, enter your Email with format XXX...XXX@gmail.com",
                            "InputMissMatch and Try again", "^(.+)@(\\S+)$"));
                    ((Intern) e).setNameOfUniversity(MyUtil.getAString("Please, enter Intern's university learning",
                            "InputMissMatch and Try again", "^.+$"));
                    ((Intern) e).setSemester(MyUtil.getAnInteger("Please, enter Intern's semester: ",
                            "InputMissMatch and Try again"));
                    ((Intern) e).setMajor(MyUtil.getString("Please, enter Intern's major: ",
                            "InputInvalid and Try again"));
                    System.out.println("Update successfully");
                }
                return e;
            }).collect(Collectors.toList());
        }
    }
    public List<Employee> getAllEmployee(int Type){
        if(list.isEmpty()){
            System.out.println("List have any employee");
            return null;
        }
        return list.stream().filter(e->{
            if(Type == 1) {
                return e instanceof Experience;
            }
            else if (Type == 2) {
                return e instanceof Fresher;
            } else if (Type == 3) {
                return e instanceof Intern;
            }
            return false;
        }).collect(Collectors.toList());
    }
    public void addCertificateById(String id, int n){
        if(list.isEmpty()){
            System.out.println("The id does not Exist");
        } else {
            for (Employee employee : list) {
                if (employee.getiD().equalsIgnoreCase(id)) {
                    for (int i = 0; i < n; i++){
                        String certificateId;
                        String certificateName;
                        int certificateRank;
                        String certificateDate;
                        certificateId = MyUtil.getAString("Please, enter ID of Certification",
                                "InputMissMatch and Try again", "^.*$");
                        certificateName = MyUtil.getString("please, enter Certification's name: ", "InputInvalid and Try again");
                        certificateDate = MyUtil.getAString("Please, enter the time that have the Certificate with format yyyy-mm",
                                "InputMissMatch and Try again", "^[12]\\d{3}\\-(1[0-2]|0\\d{1})$");
                        certificateRank = MyUtil.getAnInteger("Please, enter the Certificate's Rank: ",
                                "InputInvalid and Try again");
                        listCer.add(new Certificate(id, certificateId, certificateName, certificateRank, certificateDate));
                        System.out.println("Add successfully");
                    }
                }
            }
        }

    }
    public List<Certificate> getCertificationById(String iD){
        if(listCer.isEmpty()) return null;
        return listCer.stream().filter(e->e.getiD().equals(iD)).collect(Collectors.toList());
    }
    public List<Employee> getList() {
        return list;
    }
    public void checkInput(Employee employee) throws BirthDayException, PhoneException, EmailException, FullnameException{
        ValidService.checkBirthDay(employee.getBirthDay());
        ValidService.checkPhoneNumber(employee.getPhoneNumber());
        ValidService.checkEmail(employee.getEmail());
        ValidService.checkFullNam(employee.getFullName());
    }



}
