import java.util.regex.Pattern;
public class Calculator {
    int Add(String num){
        int sum = 0 ;
        if(num.isEmpty()){
            return 0;
        }
        else if(num.startsWith("//")) {
            String del;
            del = num.substring(2, num.indexOf("\n")).trim();
            num = num.substring(num.indexOf("\n") + 1); //1***2***3
            del = Pattern.quote(del);
            sum = total(num, del);
        }
        else{
            String number =num.replaceAll(" ", "");
            String[] numArr = number.split(",|\n");
            for(int j = 0 ; j < numArr.length ; j++ ){
                sum += Integer.parseInt(numArr[j]);
            }
            return sum;
        }
        return sum;
    }
    int total(String num, String del){
        int sum = 0 ;
        String[] numArr = num.split(del);
        for (int j = 0; j < numArr.length; j++) {
            sum += Integer.parseInt(numArr[j]);
        }
        return sum;
    }
}
