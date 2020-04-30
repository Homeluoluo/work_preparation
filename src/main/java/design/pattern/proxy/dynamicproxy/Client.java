package design.pattern.proxy.dynamicproxy;

public class Client {
    public static void main(String[] args) {
//    创建目标对象
        ITeacherDao target = new TeacherDao();
//      给目标对象创建代理对象，强制转换为目标对象类型
        ITeacherDao proxyInstance=(ITeacherDao)new ProxyFactory(target).getProxyInstance();
//      proxyInstance=design.pattern.proxy.dynamicproxy.TeacherDao@29453f44
//        System.out.println("proxyInstance=" + proxyInstance);
//      proxyInstance=class com.sun.proxy.$Proxy0 说明内存中生成了代理对象
//        System.out.println("proxyInstance=" + proxyInstance.getClass());
        proxyInstance.teach();
        proxyInstance.sayHello("tom");
    }
}
