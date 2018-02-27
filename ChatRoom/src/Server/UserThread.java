package Server;

import java.awt.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UserThread extends Thread
{
    protected Socket connectionSocket;
    protected DataInputStream inStream;
    SimpleServer server;
    String userIP="";
    String userName="";

    public UserThread(SimpleServer server,Socket connSock)throws IOException
    {
        InetAddress inet=connSock.getInetAddress();
        userIP=inet.getHostAddress() ;
        connectionSocket=connSock;
        this.server =server;
        inStream=new DataInputStream(connSock.getInputStream());
    }

    protected void closeConnection()
    {
        try
        {
            connectionSocket.close();
        }
        catch(Exception oops){}
        stop();
    }

    public void run()
    {
        while(true)
        {
            try
            {
                String str=inStream.readUTF();
                StringTokenizer st=new StringTokenizer(str,":%:");
                String key=st.nextToken();
                if(key.equals("login"))
                {
                    userName=st.nextToken();
                    server.list1.addItem(userIP+"---"+userName);
                }
                else if(key.equals("quit"))
                {
                    server.list1.remove(userIP+"---"+userName);
                    server.removeServerConn(userIP,userName);
                    stop();
                }
                else
                    server.tellEveryone(str);
            }
            catch(Exception oops)
            {}//end of try
        }//end of while
    }//end of public
}//end of class
