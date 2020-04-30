package design.pattern.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        /*
        * 1、创建被代理对象
        * 2、创建代理对象，传递被代理对象
        * 3、通过代理对象调用代理对象的方法
        * */
        ITeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        teacherDaoProxy.teach();
    }
}
