package com.iag.server;

import java.io.*;
import java.net.Socket;

/**
 * @author weixueshan
 * @date 2017/11/17 10:50
 */
public class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerThread(Socket s)  throws IOException {
        socket  = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }
    public void run() {
        System.out.println("server init success...");
        try {
            while(true) {
                String str = in.readLine();
                if(str.equals("END")){
                    break;
                }
                System.out.println("recive message:  " + str);
                out.println(str);
            }
        } catch(IOException e) {
            System.err.println("IO Exception");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}
