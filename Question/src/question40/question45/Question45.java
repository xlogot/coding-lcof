package question40.question45;

import java.util.concurrent.ConcurrentMap;

public class Question45 {
    static String compare(int a,int b){
        if (a<0||b<0) return "";
        StringBuilder ab=new StringBuilder(String.valueOf(a));
        ab.append(b);
        StringBuilder ba=new StringBuilder(String.valueOf(b));
        ba.append(a);

        return compare(ab.toString().intern(),ba.toString().intern());
    }

    static String compare(String a,int b){
        if (a==null||a.equals("")||b<0) return null;
        StringBuilder ab=new StringBuilder(a);
        ab.append(b);
        StringBuilder ba=new StringBuilder(String.valueOf(b));
        ba.append(a);
        return compare(ab.toString().intern(),ba.toString().intern());
    }

    static String compare(String ab,String ba){
        for (int i = 0; i < ab.length(); i++) {
            if (ab.charAt(i)>ba.charAt(i)) return ab;
            else if (ab.charAt(i)<ba.charAt(i)) return ba;
        }
        return ab;
    }
    static String compareArray(int[] array){
        if (array==null) return "";
        if (array.length<2) return String.valueOf(array[1]);
        String compare1 = compare(array[0], array[1]);
        int i=1;
        while (i<array.length-1){
            compare1 = compare(compare1, array[i + 1]);
            i++;
        }
        return compare1;
    }
    public static void main(String[] args) {
//        int[] a={3,32,321};
        int[] a={3,30,34,5,9};
        String compare = compareArray(a);
        System.out.println(compare);
    }
}
