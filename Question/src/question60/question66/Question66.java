package question60.question66;

public class Question66 {
    static int[] multiply(int[] a){
        int[] b=new int[a.length];
        int[] c=new int[a.length];
        int[] d=new int[a.length];
        int length=a.length;
        c[0]=1;
        d[a.length-1]=1;
        for (int i = 1; i <= length-1; i++) {
            c[i]=c[i-1]*a[i-1];
        }
        for (int i=length-2;i>= 0;i--){
            d[i]=d[i+1]*a[i+1];
        }
        for (int i=0;i<length; i++){
            b[i]=c[i]*d[i];
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4};
        int[] multiply = multiply(a);
        for (int i : multiply) {
            System.out.println(i);
        }
    }
}
