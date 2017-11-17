package com.iag.client;

/**
 * @author weixueshan
 * @date 2017/11/17 11:00
 */
public class Client {

    public static void main(String[] args) {
        //System.out.println("0:" + args[0]);
        //System.out.println("1:" + args[1]);
        String ip = "127.0.0.1";
        int port = 8080;

        ClientThread clientThread = new ClientThread(ip, port);

        /*try {
            Socket socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fail");
        }*/
    }
}
