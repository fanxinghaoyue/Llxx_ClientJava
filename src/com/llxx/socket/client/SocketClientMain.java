package com.llxx.socket.client;

public class SocketClientMain
{
    public static void main(String[] args)
    {
        RunCommand.run("adb forward tcp:8082 tcp:8082");
        System.out.println("SocketClientMain.main()-->adb forward tcp:8082 tcp:8082");
        new SocketClient().run();
    }
}
