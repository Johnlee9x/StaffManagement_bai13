package exception;

import java.util.Optional;

public class ValidService {
    public static void checkBirthDay(String birthDay) throws BirthDayException {
        if(!birthDay.matches("[12]\\d{3}-(1[0-2]|0\\d)\\-(3[01]|[12]\\d)$")){
            throw new BirthDayException("InvalidBirthDay");
        }
    }
    public static void checkFullNam(String fullName) throws FullnameException {
        if(!fullName.matches("^.*$")){
            throw new FullnameException("InvalidFullName");
        }
    }
    public static void checkEmail(String email) throws EmailException {
        if(!email.matches("^(.+)@(\\S+)$")){
            throw new EmailException("InvalidEmail");
        }
    }
    public static void checkPhoneNumber(String phoneNum) throws PhoneException {
        if(!phoneNum.matches("[0][35789]\\d{8}$")){
            throw new PhoneException("InvalidPhoneNumber");
        }
    }
}
