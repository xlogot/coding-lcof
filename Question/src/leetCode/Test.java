package leetCode;

import sun.java2d.pipe.AAShapePipe;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String[] a=new String[i*2];
        for (int j=0;j<i*2;j++){
            if (sc.hasNextLine()){
                a[j]=sc.next();
            }
        }
        printYes(i, a);
    }

    private static void printYes(int n, String[] a) {
        for (int i=0;i<n*2;i+=2){
            if (a[i].length()%2==0){
                boolean res =print1(a[i],a[i+1],0,a[i].length()-1,0,a[i].length()-1);
                System.out.println(res? "YES":"NO");
            }else {
                boolean res=print2(a[i],a[i+1]);
                System.out.println(res? "YES":"NO");
            }
        }
    }

    private static boolean print2(String s, String s1) {
        int ei=s.length()-1;
        for (int i=0;i<s.length();i++){
            if (i<(ei-i)){
                if (s.charAt(i)!=s1.charAt(ei-i)) return false;
            }else break;
        }
        return true;
    }

    private static boolean print1(String s, String s1, int si, int ei, int si1, int ei1) {
        if (si==ei&&si1==ei1){
            return s.charAt(ei)==s1.charAt(si1);
        }
        if (si>ei||si1>ei1) return false;
        int mid=(si+ei)/2;
        int mid1=(si1+ei1)/2;
        boolean res=print1(s,s1,si,mid,mid1+1,ei1);
        res=res&&print1(s,s1,mid+1,ei,si1,mid1);
        return res;
    }
}
