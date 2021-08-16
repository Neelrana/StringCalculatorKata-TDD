import java.util.regex.Pattern;
public class Calculator {
    int Add(String num){
        int sum = 0 ;
        if(num.isEmpty()){
            return 0;
        }
        else{
            String number =num.replaceAll(" ", "");
            String[] numArr = number.split(",|\n");
            for(int j = 0 ; j < numArr.length ; j++ ){
                sum += Integer.parseInt(numArr[j]);
            }
            return sum;
        }

    }
}
