package com.blue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 15:36 2018/1/2
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

public class ServerSocketTools {
    public static void main(String[] args) throws IOException {
        final List<Socket> list = new ArrayList<Socket>();
        ServerSocket server = new ServerSocket(Integer.valueOf(args[0]));
        while(true){
            final Socket socket = server.accept();
            list.add(socket);
            new Thread(){
                @Override
                public void run() {
                    try {
                        while (true) {
                            InputStream in = socket.getInputStream();
                            InputStreamReader isr = new InputStreamReader(in);
                            BufferedReader br = new BufferedReader(isr);
                            String result = br.readLine();
                            if(null==result){
                                break;
                            }
                            System.out.println(result);
                        }
                    }catch (Exception e){

                    }finally {
                        list.remove(socket);
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
//                    super.run();
                }
            }.start();
        }
    }
}
