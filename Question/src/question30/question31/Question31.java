package question30.question31;

import java.io.FileReader;
import java.util.Stack;
import java.util.jar.JarEntry;

public class Question31 {
    public static boolean isPopOrder(int[] pushOrder,int[] popOrder,int length){
        if (pushOrder==null||popOrder==null) return false;
        Stack<Integer> stack=new Stack<>();
        int indexInPushOrder=0;
        for (int i = 0; i < length; i++) {
            if (i==0){
                for (int l = indexInPushOrder; l <=length; l++) {
                    if (l==length) return false;
                    if (pushOrder[l]!=popOrder[i]) stack.push(pushOrder[l]);                                 else {
                        indexInPushOrder=l;
                        break;
                    }
                }
                continue;
            }

            if (popOrder[i]!=stack.peek()){
              if (afterIndexOrder(indexInPushOrder,pushOrder,popOrder[i])){
                  for (int l = indexInPushOrder+1; l <=length; l++) {
                      if (l==length) return false;
                      if (pushOrder[l]!=popOrder[i]) stack.push(pushOrder[l]);                                 else {
                          indexInPushOrder=l;
                          break;
                      }
                  }
                  continue;
              }
              else return false;
            }
            stack.pop();
        }
        return true;
    }

    private static boolean afterIndexOrder(int indexInPushOrder, int[] pushOrder, int item) {
        for (int i = 0; i < indexInPushOrder; i++) {
            if (pushOrder[i]==item) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] t1={1,2,3,4,5};
        int[] t2={6,5,4,3,2};
        boolean popOrder = isPopOrder(t1, t2, t1.length);
        System.out.println(popOrder);
    }

}
