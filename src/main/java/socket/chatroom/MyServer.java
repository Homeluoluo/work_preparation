package socket.chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname MyServer
 * @Description TODO
 * @Date 2019/3/22 17:44
 * @Created by luojia
 */
public class MyServer {
//    定义保存所有socket的list,属于类成员。
    public static List<Socket> socketList= Collections.synchronizedList(new ArrayList<Socket>());
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(30000);
        while (true){
            //此行代码会阻塞，一直等待别人连接
            Socket s= serverSocket.accept();
            socketList.add(s);
//            每当客户端连接后启动一个服务端线程为客户端服务
            new Thread(new ServerThread(s)).start();
        }
    }
}
