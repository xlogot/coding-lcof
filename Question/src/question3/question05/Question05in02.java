package question3.question05;
/*
有两个排序的数组a1a2内存，在a1的尾部有足够多的空余空间容纳a2，请实现一个函数，把a2中的所有数字插入a1中，并且所有的数字是排序的。
 */
public class Question05in02 {
    public static int[] mergeArrays(int[] a,int[] b){
        if (a==null||b==null) return null;
        if (a.length<b.length) return null;
        int aLenght=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=0) aLenght++;
            else break;
        }
        int c=aLenght+b.length-1;
        int bIndex=b.length-1;
        int aIndex=aLenght-1;
        while (aIndex>=0&&bIndex>=0){
            if (b[bIndex]>a[aIndex]) a[c]=b[bIndex--];
            else  a[c]=a[aIndex--];
            c--;
        }
        //把剩下的数合并进a中。
        while (bIndex>=0){
            a[bIndex]=b[bIndex--];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={3,5,7,0,0,0,0,0,0,0};
        int[] b={2,6,8,10,11};
        int[] c=mergeArrays(a,b);

    }
}
