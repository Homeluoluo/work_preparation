package design.pattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
 * 1、给目标对象创建代理对象
 * 2、重写intercept方法
 * */
public class ProxyFactory implements MethodInterceptor {

    //维护一个目标对象
    private Object target;

    //创建构造器，传入一个被代理对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回一个代理对象，target对象的代理对象
    public Object getProxyInstance(){
        //1、创建一个工具类
        Enhancer enhancer=new Enhancer();
        // 2、设置父类
        enhancer.setSuperclass(target.getClass());
        //3、设置回调函数
        enhancer.setCallback(this);
        //4、创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式开始");
        Object result =  method.invoke(target,args);
        System.out.println("Cglib代理模式结束");
        return result;
    }
}
