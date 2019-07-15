package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2019/3/22 0:03
 * @Created by luojia
 */
public class Client {

    public static void main(String[] args)
            throws IOException
    {
        Socket socket=new Socket("127.0.0.1",3000);
/*
//        将socket对应的输入流包装为BufferedReader
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line=br.readLine();
        System.out.println("来自服务器的数据："+line);
        br.close();
        socket.close();*/

//        10秒之后读取超时
        socket.setSoTimeout(10000);
        try {
            Scanner scanner=new Scanner(socket.getInputStream());
            while(scanner.hasNext()){
                String line=scanner.nextLine();
                System.out.println("来自服务器的数据："+line);
            }
        }catch (SocketTimeoutException e){
            e.printStackTrace();
        }
    }

}