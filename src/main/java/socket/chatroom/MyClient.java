package socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Classname MyClient
 * @Description TODO
 * @Date 2019/3/22 18:09
 * @Created by luojia
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",30000);
        //启动线程读取服务端发来的数据
        new Thread(new ClientThread(socket)).start();
        //获取socket输出流
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        String line = null;
        //不断读取键盘输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while ((line=input.readLine()) != null){
            //将键盘输入内容写入输出流
            printStream.println(line);
        }
    }
}
