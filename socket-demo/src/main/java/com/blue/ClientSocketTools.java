package com.blue;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 10:27 2018/1/3
 * @Modifide By:
 **/

//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

public class ClientSocketTools {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length<2){
            System.exit(-1);
        }
        Socket socket = new Socket(args[0],Integer.valueOf(args[1]));
        System.out.println(socket.getRemoteSocketAddress()+"连接成功");
        Thread.sleep(1000*Integer.valueOf(args[3]));
        socket.close();
    }
}
