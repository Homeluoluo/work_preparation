package crazy.codes.test.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Classname TimerTest
 * @Description TODO
 * @Date 2019/4/18 21:53
 * @Created by luojia
 */
public class TimerTest {
    public static void main(String[] args) throws ParseException {
        Timer timer=new Timer();
//        指定定时任务 任务  开始时间  间隔
        timer.schedule(new LogTimerTask(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss").parse("2019-04-18 21:57:55 000"),5*1000);
    }
}
class LogTimerTask extends TimerTask{
    @Override
    public void run() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss").format(new Date()));
    }
}
