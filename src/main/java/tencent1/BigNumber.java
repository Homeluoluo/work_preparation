package tencent1;

/**
 * @Classname BigNumber
 * @Description TODO
 * @Date 2019/4/4 21:48
 * @Created by luojia
 */
//求排列组合数
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigNumber {

    public static BigDecimal computePaiLie(int n, int m) {
        if(m > n || n < 0 || m < 0) {
            throw new IllegalArgumentException("n必须大于m!");
        }
        return computerJC(n).divide(computerJC(n - m), 1, RoundingMode.HALF_UP);
    }

    public static BigDecimal computeZuhe(int n, int m) {
        if(m > n || n < 0 || m < 0) {
            throw new IllegalArgumentException("n必须大于m!");
        }
        //=n!/m!(n-m)!

        return computerJC(n).divide((computerJC(m).multiply(computerJC(n - m)).setScale(1, RoundingMode.HALF_UP)), 1, RoundingMode.HALF_UP);
    }


    public static BigDecimal computerJC(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("n不能为负数!");
        } else if(n == 0) {
            return new BigDecimal(1);
        }
        BigDecimal bd = new BigDecimal(1.0);
        for(int i=n; i>=1; i--) {
            bd = bd.multiply(new BigDecimal(i)).setScale(1, RoundingMode.HALF_UP);
        }
        return bd;
    }

    public static void main(String[] args) {
        BigDecimal zh = computeZuhe(462, 442);
        System.out.println(zh.doubleValue());
    }

}
