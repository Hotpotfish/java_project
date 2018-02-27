package Server;

import java.awt.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import com.borland.jbcl.layout.*;
import com.borland.jbcl.control.*;
import java.lang.String;





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
public class SimpleServer extends Frame {
    protected ServerConn newConn;
    protected ServerSocket listenSock;
    GroupBox groupBox1=new GroupBox();
    Button button1=new Button() ;
    Button button2=new Button() ;
    PaneLayout paneLayout1=new PaneLayout();
    java.awt.List list1=new java.awt.List();
    PaneLayout paneLayout2=new PaneLayout();
    Vector users=new Vector();


    public SimpleServer(int listenPort) throws Exception {
        listenSock=new ServerSocket(listenPort);
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void waitForClients()
    {
        while(true)
        {
            try
            {
                Socket newClient=listenSock.accept() ;
                newConn=new ServerConn(this,newClient);
                users.addElement(newConn);
            }
            catch(Exception bad)
            {
                bad.printStackTrace() ;
            }
        }
    }

    public synchronized String processString(String instr)
    {
        return instr;
    }

    public static void main(String[] args)
    {
        try
        {
            SimpleServer simpleServer=new SimpleServer(4321);
            simpleServer.setLocation(100,50);
            simpleServer.setSize(400,300);
            simpleServer.show();
            simpleServer.waitForClients() ;
        }
        catch(Exception e)
        {
            System.out.print("GotError");
            e.printStackTrace() ;
        }
    }

    public SimpleServer()
    {
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace() ;
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(paneLayout1);
        this.setSize(new Dimension(503,354));
        this.setTitle("服务器端");

        groupBox1.setLayout(paneLayout2);
        groupBox1.setLabel("在线用户");

        button1.setLabel("关闭");
        button1.addActionListener(new SimpleServer_button1_actionAdapter(this));
        button2.setLabel("踢出");
        button2.addActionListener(new SimpleServer_button2_actionAdapter(this));

        groupBox1.add(list1,new PaneConstraints("list1","list11",
        PaneConstraints.ROOT,1.0f));
        this.add(groupBox1,new PaneConstraints("groupBox1","groupBox1",
        PaneConstraints.ROOT,0.5f));
        this.add(button2,new PaneConstraints("button2","groupBox1",
        PaneConstraints.BOTTOM,0.1469534f));
        this.add(button1,new PaneConstraints("button1","button2",
        PaneConstraints.RIGHT,0.5303644f));
    }

    void tellEveryone(String str)
    {
        for(int i=0;i<=users.size();i++)
        {
            ServerConn conn=(ServerConn)users.elementAt(i);
            conn.sendString(str);
        }
    }

    void removeServerConn(String ip,String userName)
    {
        for(int i=0;i<=users.size();i++)
        {
            ServerConn conn=(ServerConn)users.elementAt(i);
           String ip1=conn.reader.userIP;
           String userName1=conn.reader.userName;
           if(ip.equals(ip1)&&userName.equals(userName1))
           users.removeElement(conn);
        }

    }

    void button2_actionPerformed(ActionEvent e)
    {
        String str=list1.getSelectedItem();
        StringTokenizer st=new StringTokenizer(str,"---");
        String userIP=st.nextToken();
        String userName=st.nextToken();
        for(int i=0;i<=users.size();i++)
       {
           ServerConn conn=(ServerConn)users.elementAt(i);
          String ip1=conn.reader.userIP;
          String userName1=conn.reader.userName;
          if(userIP.equals(ip1)&&userName.equals(userName1))
          {
             list1.remove(str);
             conn.sendString("quit");
             conn.reader.stop();
             users.removeElement(conn);
          }
       }


    }

    void button1_actionPerformed(ActionEvent e)
   {
       System.exit(0);
   }
}
class SimpleServer_button2_actionAdapter implements java.awt.event.ActionListener
{
    SimpleServer adaptee;

    SimpleServer_button2_actionAdapter(SimpleServer adaptee)
    {
        this.adaptee =adaptee;
    }

    public void actionPerformed(ActionEvent e)
    {
        adaptee.button2_actionPerformed(e);
    }
}

class SimpleServer_button1_actionAdapter implements java.awt.event.ActionListener
{
    SimpleServer adaptee;

    SimpleServer_button1_actionAdapter(SimpleServer adaptee)
    {
        this.adaptee =adaptee;
    }

    public void actionPerformed(ActionEvent e)
    {
        adaptee.button1_actionPerformed(e);
    }
}

