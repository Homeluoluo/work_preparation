package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname Server
 * @Description TODO
 * @Date 2019/3/22 0:02
 * @Created by luojia
 */
public class Server {

    public static void main(String[] args)
            throws IOException
    {
        ServerSocket ss=new ServerSocket(3000);
        while(true)
        {
            //每接收到一个客户端请求时返回一个与请求socket，否则，一直处于等待状态，线程也被阻塞（挂起，不消耗资源）
            Socket s=ss.accept();
            s.setSoTimeout(10000);
//            将socket对应的输出流包装为PrintStream
            PrintStream ps=new PrintStream(s.getOutputStream());
//            传给客户端的数据
            int i = 0;
            while(true){
                ps.println("您好，您收到了服务器的新年祝福"+i);
                i++;
            }
//            ps.close();
//            s.close();
        }
    }

}