import java.util.regex.Pattern;
public class Calculator {
    int Add(String num){
        if(num.isEmpty()){
            return 0;
        }
        else{
            return Integer.parseInt(num);
        }

    }
}
