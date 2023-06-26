package ui;
import util.MyUtil;
import java.util.List;
import java.util.Optional;
public class Menu {
    private List<String> optionList;
    private String menuTitle;
    public Menu( String menuTitle, List<String> list){
        this.optionList = list;
        this.menuTitle = menuTitle;
    }
    public void addANewOption(String newOption){
        optionList.add(newOption);
    }

    public void printAllOption(){

        Optional optional = Optional.ofNullable(optionList);
        if(!optional.isPresent()){
            System.out.println("There is not any options");
        }
        else{
            System.out.println("Welcome to "+this.menuTitle);
            optional.ifPresent(System.out::println);
        }
    }
    public int getChoice(){
        int minOption = 1;
        int maxOption = optionList.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg =  "You are required to choose the option 1.." + maxOption;
        return MyUtil.getAnInteger(inputMsg, errorMsg, minOption, maxOption);
    }

}
