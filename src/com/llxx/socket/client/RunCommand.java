package com.llxx.socket.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RunCommand
{

    /**
     * 执行指定的命令
     * @param cmd
     */
    public static final ArrayList<String> run(String cmd)
    {
        Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
        ArrayList<String> mStrings = new ArrayList<>();
        try
        {
            Process p = run.exec(cmd);// 启动另一个进程来执行命令  
            BufferedInputStream in = new BufferedInputStream(
                    p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null)
            {
                //获得命令执行后在控制台的输出信息  
                System.out.println(lineStr);// 打印输出信息
                mStrings.add(lineStr);
            }
            //检查命令是否执行失败。  
            if (p.waitFor() != 0)
            {
                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
                {
                    // System.err.println("命令执行失败!");
                }

            }
            inBr.close();
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return mStrings;
    }
}
