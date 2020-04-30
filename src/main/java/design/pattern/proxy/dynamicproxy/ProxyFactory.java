package design.pattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  1、维护一个目标对象
 *  2、构造器初始化目标对象
 *  3、给目标对象生成一个代理对象
* */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target=target;
    }

    public Object getProxyInstance(){
        /*
        * public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        * loader  指定当前目标对象使用的类加载器
        * interfaces  目标对象实现的接口类型，使用泛型方法确认类型
        * h  事情处理，指定目标对象的方法时会触发事情处理器方法，会把当前执行的目标对象方法作为一个参数
        * */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理开始");
                Object returnVal = method.invoke(target,args);
                System.out.println("JDK代理结束");
                return returnVal;
            }
        });
    }
}
