import java.util.regex.Pattern;
public class Calculator {
    int Add(String num){
        int sum = 0 ;
        if(num.isEmpty()){
            return 0;
        }
        else if(num.startsWith("//")){
            String del ;
            del = num.substring(2,num.indexOf("\n")).trim();
            if(del.startsWith("[") && del.endsWith("]")){
                del=del.substring(1,del.length()-1); //+][%
                //Test Multiple Delimiter Many Number String
                if(del.matches("(.*)]\\[(.*)")){
                    String newdel,newdel1,concdel = "" ;
                    newdel = del.substring(0,del.indexOf("]")); //+
                    newdel=Pattern.quote(newdel);
                    newdel1 = del.substring(del.indexOf("[")+1); //%
                    newdel1=Pattern.quote(newdel1);
                    concdel += newdel + "|" + newdel1; //+|%
                    num = num.substring(num.indexOf("\n") + 1); //1*2%3
                    sum = total(num,concdel);
                }
                //test many length delimiter
                else {
                    num = num.substring(num.indexOf("\n") + 1); //1***2***3
                    del = Pattern.quote(del);
                    sum = total(num,del);
                }
            }
            //test different delimiter
            else{
                del = num.substring(2,3);
                del= Pattern.quote(del);
                num = num.substring(num.indexOf("\n")+1); //remove string till '\n'
                sum = total(num,del);
            }
            return sum;
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
