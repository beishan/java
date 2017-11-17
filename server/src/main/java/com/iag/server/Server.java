package com.iag.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weixueshan
 * @date 2017/11/17 11:18
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket s = null;
        int port = 8000;
        try {
            s = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while(true) {
                Socket socket = null;
                try {
                    socket = s.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    new ServerThread(socket);
                } catch(IOException e) {
                    try {
                        socket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
