package jvm.others;

/**
 * @Author luojia
 * @Description TODO
 * @Date 2019/7/23
 **/
public
class EscapeAnalysis {
    private static class Foo {
        private int x;
        private static int counter;

        public Foo() {
            x = (++counter);
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000 * 1000 * 10; ++i) {
            Foo foo = new Foo();
        }
        //返回当前时间 单位：纳秒
        long end = System.nanoTime();
        System.out.println("Time cost is " + (end - start));
    }

}
