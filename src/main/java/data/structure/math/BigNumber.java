package data.structure.math;

/**
 * @Classname BigNumber
 * @Description TODO
 * @Date 2019/4/5 11:13
 * @Created by luojia
 */
//求阶乘 https://blog.csdn.net/lisp1995/article/details/52403507
public class BigNumber {
    public static void main(String[] args) {

    }

    public static int[] jieCheng(int a){
        int[] result=new int[20001];
        //temp每次的得数   digit每次得数的位数
        int temp,digit,n,i,j=0;
        result[0]=1;//从1开始乘
        digit=1;//位数从第一位开始
        for(i=2;i<a;i++){
            int num=0;
            for(j=0;j<digit;j++)
            {
                temp=result[j]*i+num;//将一个数的每一位数都分别乘以i，
                result[j]=temp%10;//将一个数的每一位数利用数组进行储存
                num=temp/10;
            }
            while(num!=0)//判断退出循环后，num的值是否为0
            {
                result[digit]=num%10;//继续储存
                num=num/10;
                digit++;
            }
            for(i=digit-1;i>=0;i--)//倒序输出每一位
                System.out.println(result[i]);
        }
        return null;
    }

//    求[a,b]的连乘积
}
