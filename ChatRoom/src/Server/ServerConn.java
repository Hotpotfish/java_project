package Server;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.net.*;
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
public class ServerConn extends Object{
    protected SimpleServer server;
    protected Socket clientSock;
    protected UserThread reader;
    protected DataOutputStream outStream;

    public ServerConn(SimpleServer server,Socket clientSock)throws IOException
    {
        this.server =server;
        this.clientSock =clientSock;
        outStream=new DataOutputStream(clientSock.getOutputStream());
        reader=new UserThread(server,clientSock);
        reader.start();
    }

    public synchronized void sendString(String str)
    {
        if(str==null)
        {
            disconnection();
            return;
        }
        try
        {
            outStream.writeUTF(str);
        }
        catch(Exception writeError)
        {
            writeError.printStackTrace() ;
            disconnection();
            return;
        }
    }

    public synchronized void disconnection()
    {
        try
        {
            reader.closeConnection();
        }
        catch(Exception e)
        {
            reader.stop();
        }
    }
}
