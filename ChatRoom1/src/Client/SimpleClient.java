package Client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import com.borland.jbcl.layout.*;
import com.borland.jbcl.control.*;

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
public class SimpleClient extends Object implements Runnable
{
    protected Socket serverSock;
    protected DataOutputStream outStream;
    protected Thread clientThread;
    protected UserThread reader;

    public SimpleClient(Applet1 applet,String hostName,
                        int portNumber)throws IOException
    {
        Socket serverSock=new Socket(hostName,portNumber);
        outStream =new DataOutputStream(serverSock.getOutputStream());
        reader=new UserThread(applet,serverSock);
        reader.start();
    }

    public void start()
    {
        run();
    }

    public void stop()
    {
        clientThread.stop();
        clientThread=null;
    }

    public synchronized void sendString(String str)throws IOException
    {
        outStream.writeUTF(str);
    }

    public void run()
    {
        try
        {
            sendString("");
        }
        catch(Exception oops)
        {
            oops.printStackTrace();
            disconnect();
            stop();
        }
    }

    public void disconnect()
    {
        try
        {
            reader.closeConnection();
        }
        catch(Exception badclose)
        {}
    }
}
