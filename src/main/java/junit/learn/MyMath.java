package junit.learn;

/**
 * @Classname File
 * @Description TODO
 * @Date 2019/4/23 17:33
 * @Created by luojia
 */
public class MyMath {
    public MyMath(){};
    public  int  abs(int  n)
    {
        if (n>=0)
            return  n;
        else
            return  (-n);
    }
    public int add(int a,int b){
        return a+b;
    }
}
