package niuke.toutiao;

import java.util.Stack;

public class RightMax {
    public static void main(String[] args) {

    }

    public static int[] rightMax(int[] a){
        int[] result = new int[a.length];
        Stack s=new Stack();
        s.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i]<=(Integer) s.peek()){
                s.push(a[i]);
            }else{
                while(a[i]>(Integer) s.peek()){
//                    result[]
                }
            }
        }
        return result;
    }
}
