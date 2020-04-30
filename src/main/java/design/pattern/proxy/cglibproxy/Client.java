package design.pattern.proxy.cglibproxy;

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDao teacherDaoProxy =(TeacherDao)new ProxyFactory(teacherDao).getProxyInstance();
        teacherDaoProxy.teach();
    }
}
