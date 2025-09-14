package number.RomanToInteger;

public class RomanToInteger {
    public static void main(String[] args) {

        String s ="MCMXCIV";
        System.out.println(intToRoman(s));
    }

    public static int getValue(char s){
        switch(s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int intToRoman(String s) {
        int result = 0;
        int length= s.length();
        for(int i =0;i<length; i++){
            char value = s.charAt(i);
            if((i +1)<length && getValue(value) < getValue(s.charAt(i+1))){
                result = result-getValue(value);
            }else{
                result = result + getValue(value);
            }
        }
        return result;
    }


}
