package test;

/**
 * @Classname HashCodeTest
 * @Description TODO
 * @Date 2019/4/17 21:50
 * @Created by luojia
 */
public class HashCodeTest {
    int num;
    String name;
    public HashCodeTest(String name,int num){
        this.name=name;
        this.num=num;
    }
    public int hashCode(){
        return name.hashCode();
    }
    public static void main(String[] args) {
        HashCodeTest test=new HashCodeTest("test",1);
        System.out.println(test.hashCode());
    }
}
