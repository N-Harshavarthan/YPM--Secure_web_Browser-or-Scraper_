/*package com.ypm.webbrowser;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.lang.Thread;

public class ConnectToIPAddress {
    public static void main(String[] args) {
        try {


            Object i ;
            String proxy_list[] = {"62.171.189.81", "187.204.68.176","34.23.45.223","49.0.2.242","157.254.193.139","43.255.113.232","190.61.88.147"};
            int port_list[] = {80, 53281, 80, 8090, 80, 8082, 8080};



            InetAddress ipAddress = InetAddress.getByName(proxy_list[1]);


            int port = port_list[1];
            Socket socket = new Socket(ipAddress, port);

            // Do something with the socket...
            Thread.sleep(33000);

            // Close the socket when you're done
            socket.close();
        } catch (IOException | InterruptedException e) {
            // Handle any errors that occurred while connecting
            e.printStackTrace();
        }
    }
}

*/