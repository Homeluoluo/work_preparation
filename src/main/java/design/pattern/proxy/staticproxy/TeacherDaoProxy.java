package design.pattern.proxy.staticproxy;

//代理对象，静态代理
public class TeacherDaoProxy implements  ITeacherDao{

    //目标对象，通过接口引用
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target){
        this.target=target;
    }



    @Override
    public void teach() {
        System.out.println("开始代理。。。");
        System.out.println("授课前准备");
        target.teach();
        System.out.println("授课后布置作业");
        System.out.println("代理结束");
    }
}
