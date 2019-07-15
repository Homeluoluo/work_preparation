package socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Classname ClientThread
 * @Description TODO
 * @Date 2019/3/22 18:12
 * @Created by luojia
 */
public class ClientThread implements Runnable{
    private Socket socket;
    BufferedReader inputbr = null;
    public ClientThread(Socket socket) throws IOException {
        this.socket=socket;
        this.inputbr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    };
    public void run(){
        try {
            String content = null;
            //不断读取输入流中的内容，获取服务端发来的消息并打印出来
            while ((content=inputbr.readLine()) != null){
                System.out.println(content);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
