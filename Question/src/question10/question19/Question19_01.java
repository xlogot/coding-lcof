package question10.question19;

public class Question19_01 {
    static boolean regx(String s,String p){
        if (s==null||p==null||p=="") return false;
        if (p.equals(".*")) return true;
        sLength=s.length();
        eLength=p.length();
        return regx(s,0,p,0);
    }
    static int sLength;
    static int eLength;
    private static boolean regx(String s, int sIndex, String ex, int exIndex) {
        if (sIndex>=sLength&&exIndex>=eLength) return true;
        if (exIndex>=eLength||sIndex>=sLength) {
            if (sIndex>=sLength){
                if (eLength-exIndex<1&&ex.charAt(exIndex+1)=='*'){
                    return regx(s,sIndex,ex,exIndex+2);
                }else if (eLength-exIndex==1){
                    return false;
                }
            }
            if (sIndex>=s.length()&&ex.charAt(exIndex+1)=='*'){
                return regx(s,sIndex,ex,exIndex+2);
            }
            return false;
        }
        char c=0;
        if (exIndex+1<ex.length()){
            c=ex.charAt(exIndex+1);
        }
        char e=ex.charAt(exIndex);
        if (c!='*'){
            if (e!='.'){
                if (s.charAt(sIndex)==e){
                    return regx(s,sIndex+1,ex,exIndex+1);
                }else return false;
            }else {

                return regx(s,sIndex+1,ex,exIndex+1);
            }
        }else{
            for (int i=sIndex;sIndex<s.length()&&s.charAt(sIndex)==e;i++,sIndex++);
            if (exIndex+2<eLength&&ex.charAt(exIndex+2)==ex.charAt(exIndex)){
                return regx(s,sIndex-1,ex,exIndex+2);
            }
            return regx(s,sIndex,ex,exIndex+2);
        }
    }

    public static void main(String[] args) {
//        boolean aaa = regx("aaaac", "a*ac");
//        boolean aaa = regx("aaaaa", "a*a*a*");
//        boolean aaa = regx("aa", "ab*c*a");
//        boolean aaa = regx("a", "ab*a");
        boolean aaa = regx("aaa", "ab*a*c*a");


        System.out.println(aaa);
    }
}
