package question20;

public class Question20_1 {
    static  boolean isNumeric(String s){
        if (s==null||s.equals("")||s.equals("e")||s.equals(".")) return false;
        s=s.trim();
        return isNumeric(s,0,0);
    }

    private static boolean isNumeric(String s, int index,int dotCount) {
        if (s==null||s.equals("")||s.equals("e")||s.equals(".")) return false;
        if (index==s.length()) return true;
        if (index>=s.length()) return false;
        char c=s.charAt(index);
        if (c=='-'||c=='+'){
            if (index==0){
               return isNumeric(s,index+1,dotCount);
            }else return false;
        }else if (c>='0'&&c<='9'){
           return isNumeric(s,index+1,dotCount);
        }else if (c=='e'||c=='E'){
            if (index>0){
                return isNumericInteger(s,index+1);
            }else {
                return false;
            }
        }else if (c=='.'){
            dotCount++;
            if (index>0){
                if (dotCount>1) return false;
                return isNumeric(s,index+1,dotCount);
            }else{
                if (index+1<s.length()&&(s.charAt(index+1)=='e'||s.charAt(index+1)=='E')){
                    return false;
                }
                return isNumeric(s,index+1,dotCount);
            }
        }else /*if(c==' ') {
            if (index>0) return isNumeric(s,index+1,dotCount);
        }*/
        return false;
    }

    private static boolean isNumericInteger(String s, int index) {
        if (index>=s.length()) return false;
        char c=s.charAt(index);
        if (c=='-'||c=='+') index+=1;
        if (index>=s.length()) return false;
        for (int i=index;i<s.length();i++){
            char c1=s.charAt(i);
            if (!(c1>='0'&&c<='9')) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean numeric = isNumeric("-.");
        System.out.println(numeric);
    }
}
