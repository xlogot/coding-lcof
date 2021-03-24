package question10.question19;


public class Question19_ByMyself {
    static boolean match(String str,String pattern){
        if (str==null||pattern==null) return false;
        str+="\u0000";
        pattern+="\u0000";
        return matchCore(str,pattern);
    }

    private static boolean matchCore(String str, String pattern) {
        if (str.equals("\u0000")&&pattern.equals("\u0000")) return true;
        if (!str.equals("\u0000")&&pattern.equals("\u0000")) return false;
        char[] strArray = str.toCharArray();
        char[] patternArray = pattern.toCharArray();
        boolean b = patternArray[0] == strArray[0] || (patternArray[0] == '.' && strArray[0] != '\u0000');
        if (patternArray[1]=='*'){
            if (b)
                return      matchCore(str.substring(1),pattern.substring(2))
                        ||  matchCore(str.substring(1),pattern)
                        ||  matchCore(str,pattern.substring(2));
            else return matchCore(str,pattern.substring(2));
        }
        if (b)
            return matchCore(str.substring(1),pattern.substring(1));
        return false;
    }

    public static void main(String[] args) {
        String str="aaa";
        String patter=".*";
        boolean match = match(str, patter);
        System.out.println(match);
    }
}
