package Client;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
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
public class Applet1 extends Applet {
    boolean isStandalone=false;
    Button button1=new Button() ;
    Label label1=new Label() ;
    TextField textField1=new TextField();
    GroupBox groupBox1=new GroupBox();
    TextArea textArea1=new TextArea();

    PaneLayout paneLayout1=new PaneLayout();
    PaneLayout paneLayout2=new PaneLayout();

    boolean login=false;
    SimpleClient simpleClient=null;
    static String userName="";
    String hostname="182.48.104.168";

    //Construct the Applet
    public Applet1() {
    }

    //Initialize the Applet
    public void init()
    {
        try
        {
            URL url=this.getCodeBase();
            String te=url.toString();
            String temp=url.getHost();
            if(!(temp.equals("")))
                hostname=temp; //得到服务器的ip地址
            else hostname="182.48.104.168";
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Component initialization
    private void jbInit() throws Exception
    {
        this.setSize(new Dimension(444,263));
        button1.setLabel("登陆");
        label1.setAlignment(2);
        label1.setText("用户名");
        textField1.addActionListener(new Applet1_textField1_actionAdapter(this));
        groupBox1.setLayout(paneLayout1);
        groupBox1.setLabel("信息");
        button1.addActionListener(new Applet1_button1_actionAdapter(this));

        this.setLayout(paneLayout2);
        this.add(groupBox1,new PaneConstraints("groupBox1","groupBox1",
                                               PaneConstraints.ROOT,0.5f));
        groupBox1.add(textArea1,new PaneConstraints("textArea1","textArea1",
                                               PaneConstraints.ROOT,1.0f));
        this.add(label1,new PaneConstraints("label1","groupBox1",
                          PaneConstraints.BOTTOM,0.09505701f));
        this.add(textField1,new PaneConstraints("textField1","label1",
                         PaneConstraints.RIGHT,0.83229816f));
        this.add(button1,new PaneConstraints("button1","textField1",
                         PaneConstraints.RIGHT,0.30223882f));
    }

    //Get Applet information
    public String getAppletInfo()
    {
        return "Applet Information";
    }

    //Get parameter information
    public String[][] getParameterInfo()
    {
        return null;
    }

    public void destroy()
    {
        try
        {
            simpleClient.sendString("quit");
            simpleClient.stop();
        }
        catch(Exception e)
        {}
    }

    void action()
    {
        String str=textField1.getText();
        if(str.equals("")) return;
        try
        {
            if(!login)
            {
                userName=str;
                simpleClient=new SimpleClient(this,hostname,4321);
                simpleClient.sendString("login:%:"+str);
                simpleClient.start();

                login=true;
                label1.setText("消息：");
                button1.setLabel("发言");
                textField1.setText("");
            }
            else
            {
                simpleClient.sendString(userName+":%:"+str);
            }
        }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
    }

    void button1_actionPerformed(ActionEvent e)
    {
        action();
    }

    void textField1_actionPerformed(ActionEvent e)
   {
       action();
   }
}

class Applet1_button1_actionAdapter implements java.awt.event.ActionListener
{
    Applet1 adaptee;

    Applet1_button1_actionAdapter(Applet1 adaptee)
    {
        this.adaptee=adaptee;
    }

    public void actionPerformed(ActionEvent e)
    {
        adaptee.button1_actionPerformed(e);
    }
}

class Applet1_textField1_actionAdapter implements java.awt.event.ActionListener
{
    Applet1 adaptee;

    Applet1_textField1_actionAdapter(Applet1 adaptee)
    {
        this.adaptee=adaptee;
    }

    public void actionPerformed(ActionEvent e)
    {
        adaptee.textField1_actionPerformed(e);
    }
}
