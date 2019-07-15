package niuke.toutiao;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BinaryOperator;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/5/9 20:22
 * @Created by luojia
 */
public class Test {
    public static void main(String[] args) {
//        测试在矩阵中查找某个数
     /*   int[][] a=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int target=10;
        getInt(a,target);*/
//     测试分红包
        int n=10;
        int m=5;
        double min=0.01;
        double[] result=partitionMoney2(n,m,min);
        for (int i = 0; i < m; i++) {
            System.out.print(result[i]+" ");
        }

//        测试保留两位小数
//        testDecimal();
    }

    public static void getInt(int[][] array,int target) {
        int m = array.length;
        int n = array[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (target == array[i][j]) {
                System.out.println(i + "," + j);
                break;
            }
            if (target > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println("没有找到！");
    }

    //分拼手气红包，n表示红包总额，m表示人数，min表示每个红包的最小限制
    public static double[] partitionMoney(int n,int m,double min){
        double sum=new Integer(n).doubleValue();
        double[] result=new double[m];
        for (int i = 0; i < m; i++) {
            result[i]=min;
            sum=sum-min;
        }
        System.out.println(sum);
        while(sum>0){
            for (int i = 0; i < m; i++) {
                double random=Math.random();
//                double a=(double) (Math.round(random*100)/100.0);
                BigDecimal bg = new BigDecimal(random).setScale(2, RoundingMode.UP);
                double a=bg.doubleValue();
                if(sum-a<0){
                    result[i]+=sum;
                    sum=0;
                    break;
                }else{
                    result[i]+=a;
                    sum-=a;
                }
                System.out.println(sum);
            }
        }
        return result;
    }

//   分红包，使用BigDecimal进行运算避免进度丢失。
    public static double[] partitionMoney2(int n,int m,double min){
        BigDecimal sum=new BigDecimal(n);
        BigDecimal[] result=new BigDecimal[m];
        BigDecimal min_decimal=new BigDecimal(min);
        for (int i = 0; i < m; i++) {
            result[i]=min_decimal;
            sum=sum.subtract(min_decimal);
        }
        while(sum.doubleValue()>0){
            for (int i = 0; i < m; i++) {
                double random=Math.random();
                BigDecimal a = new BigDecimal(random).setScale(2, RoundingMode.UP);
                if(sum.subtract(a).doubleValue()<0){
                    result[i]=result[i].add(sum);
                    sum=sum.subtract(sum);
                    break;
                }else{
                    result[i]=result[i].add(a);
                    sum=sum.subtract(a);
                }
            }
        }
        double[] result2=new double[m];
        for (int i = 0; i < result.length; i++) {
            result2[i]=result[i].doubleValue();
        }
        return result2;
    }

    public static void testDecimal(){
        float TT = Math.round(1/(float)8);   //返回的是int型。
        System.out.println("四舍五入小数："+TT);
        System.out.println("四舍五入小数2："+Math.round(2.1546));
        double dd = (double) (Math.round(1/(float)8*100)/100.0);
        System.out.println("dd="+dd);
    }
}
