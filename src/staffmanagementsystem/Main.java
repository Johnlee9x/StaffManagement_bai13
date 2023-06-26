package staffmanagementsystem;

import data.Cabinet;
import data.Certificate;
import data.Employee;
import ui.Menu;
import util.MyUtil;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<Certificate> listCertificate = new ArrayList<>();
        List<Employee> listEm = new ArrayList<>();
        Cabinet cabinet = new Cabinet(listEm, listCertificate);
        List<String> list = new ArrayList<>();
        Menu menu = new Menu("Welcome to the Management Application",list);
        menu.addANewOption("1. Add new Staff");
        menu.addANewOption("2. Update Staff's Information");
        menu.addANewOption("3. Delete A Staff");
        menu.addANewOption("4. Print List Staff");
        menu.addANewOption("5. Add Staff's certificationById");
        menu.addANewOption("6. Print Staff's certification");
        menu.addANewOption("7. Exit");

        int choice;
        do{
            menu.printAllOption();
            choice = menu.getChoice();
            switch (choice){
                case 1:
                    System.out.println("Press 1 to add an Experience staff: ");
                    System.out.println("Press 2 to add a Fresher staff: ");
                    System.out.println("Press 3 to add an Intern staff: ");
                    int tmp = MyUtil.getAnInteger("Please, enter the number: ",
                            "InputInvalid and Try again", 1, 3);
                    if(tmp == 1){
                        cabinet.addAnExperiancer();
                        break;
                    } else if (tmp == 2) {
                        cabinet.addAFresher();
                        break;
                    } else {
                        cabinet.addAnIntern();
                        break;
                    }
                case 2:
                    System.out.println("Enter the Id to update the Staff's information");
                    String iD = MyUtil.getAString("Please, enter Intern's Id with format DXXXXX, X represent for number digit",
                            "InputMissMatch and Try again", "^[D]\\d{5}$");
                    cabinet.updateAStaff(iD);
                    break;
                case 3:
                    System.out.println("Enter the Id to remove the a staff");
                    String Id = MyUtil.getAString("Please, enter Intern's Id with format SXXXXX, X represent for " +
                            "digit numbers", "InputMissMatch and Try again", "^[D]\\d{5}$");
                    cabinet.removeAStaff(Id);
                case 4:
                    System.out.println("Press 1 to print list of experience staff");
                    System.out.println("Press 2 to print list of fresher staff");
                    System.out.println("Press 3 to print list of intern staff");
                    System.out.println("Press 4 to print list of all staff");
                    int num = MyUtil.getAnInteger("Please, enter the number: ",
                            "InputInvalid and Try again", 1, 4);
                    if(num == 1){
                        System.out.println(cabinet.getAllEmployee(num).toString());
                        break;
                    } else if (num == 2) {
                        System.out.println(cabinet.getAllEmployee(num).toString());
                        break;
                    }else if(num == 3){
                        System.out.println(cabinet.getAllEmployee(num).toString());
                        break;
                    }
                    else{
                        System.out.println(cabinet.getList().toString());
                        break;
                    }
                case 5:
                    String id = MyUtil.getAString("Please, enter Intern's Id with format DXXXXX: ",
                            "InputMissMatch and Try again", "^[D]\\d{5}$");
                    int n = MyUtil.getAnInteger("please, enter the number of certification you want to add: ",
                            "The number is from 1 to 2",1,2);
                    cabinet.addCertificateById(id,n);
                    break;
                case 6:
                    String idOther = MyUtil.getAString("Please, enter Intern's Id with format DXXXXX to get Certification: ",
                            "InputMissMatch and Try again", "^[D]\\d{5}$");
                    System.out.println(cabinet.getCertificationById(idOther).toString());
                    break;
                case 7:
                    System.out.println("goodbye, see you next time");
                    System.exit(1);
            }
        }while(choice != 0);

    }
}
