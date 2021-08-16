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
            String negArr = "" ;
            for(int j = 0 ; j < numArr.length ; j++ ){
                //chceking negative number
                if(Integer.parseInt(numArr[j])<0){
                    if(negArr.equals("")){
                        negArr = numArr[j];
                    }
                    else{
                        negArr+=(","+numArr[j]);
                    }
                }
                else if(Integer.parseInt(numArr[j]) > 1000){
                    numArr[j] = "0" ;
                    sum += Integer.parseInt(numArr[j]);
                }
                else{
                    sum += Integer.parseInt(numArr[j]);
                }

            }
            if(!negArr.equals("")){
                throw new IllegalArgumentException("Negative numbers are not allowed "+negArr);
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
