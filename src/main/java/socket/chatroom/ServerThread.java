package socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Classname ServerThread
 * @Description TODO
 * @Date 2019/3/22 17:49
 * @Created by luojia
 */
public class ServerThread implements Runnable{
    // 定义当前线程所处理的socket
    Socket socket=null;
    //定义该线程处理的输入流
    BufferedReader inputbr = null;
    public ServerThread(Socket s) throws IOException {
        this.socket=s;
        //初始化输入流
        inputbr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run(){
        String content=null;
        //采用循环不断地从Socket中读取客户端发来的数据
        while((content=readFromClient()) != null){
            //遍历socketList中的每个socket，把收到的数据发送给每个客户端
            for (Socket s:MyServer.socketList){
                try {
                    //包装输出流
                    PrintStream printStream = new PrintStream(socket.getOutputStream());
                    printStream.println(content);
                    System.out.println(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取客户端数据
    private String readFromClient(){
        try {
            return inputbr.readLine();
        } catch (IOException e) {
            //捕获到异常时，表明对应socket的客户端已经关闭
            e.printStackTrace();
            MyServer.socketList.remove(socket);
        }
        return null;
    }
}
