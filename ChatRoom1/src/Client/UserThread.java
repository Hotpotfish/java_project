package Client;

import java.awt.*;
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;

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
    Applet1 applet=null;

    public UserThread(Applet1 applet,Socket connSock) throws IOException
    {
        connectionSocket=connSock;
        this.applet=applet;
        inStream=new DataInputStream(connSock.getInputStream());
    }

    protected void closeConnection()
    {
        try
        {
            connectionSocket.close();
        }
        catch(Exception oops)
        {}
        stop();
    }

    public void run()
    {
        while(true)
        {
            try
            {
                String str=inStream.readUTF();
                if(str.equals("quit"))
                {
                    applet.textArea1.append("\n �Բ����㱻����Ա�߳����ˣ������µ�½��\n");
                    applet.login=false;
                    applet.label1.setText("�û�����");
                    applet.button1.setLabel("��½");
                }
                else
                {
                    StringTokenizer st=new StringTokenizer(str,":%");
                    applet.textArea1.append(st.nextToken()+" ˵��"+st.nextToken()+"\n");
                }
            }
            catch(Exception oops)
            {}
        }//end of while
    }//end of Run()
}//end of class
