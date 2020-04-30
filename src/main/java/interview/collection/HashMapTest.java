package interview.collection;

import java.util.HashMap;

/**
 * @Classname HashMapTest
 * @Description TODO
 * @Date 2019/9/26 23:31
 * @Created by luojia
 */
class Student{
   private String id;
   private String name;

   public Student(){}

   public Student(String id,String name){
       this.id=id;
       this.name=name;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
       return 0;
    }
}
public class HashMapTest {
    public static void main(String[] args) {
        test1();
//        test2();
    }

    //测试将对象作为hashMap的key
    public static void test1(){
        HashMap<Student,Integer> map=new HashMap<>();
        Student stu=new Student("1","罗家");
        Student stu2=new Student("1","罗家");
        map.put(stu,1);
//        map.put(stu2,1);
        System.out.println(map.size());
        System.out.println(map.get(stu));
        System.out.println(map.get(stu2));
    }

    //测试hashMap的key是否可以为null
    public static void test2(){
        HashMap<String,String> map=new HashMap<>();
        map.put(null,"s");
        map.put(null,null);
        System.out.println(map.size());
    }
}
