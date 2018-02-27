/***
**** What classes need to be imported?
***/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ReadRecords implements Serializable {
  public static void main(String[] args) {
    Record record;

    try {
    	ObjectInputStream obinput = new ObjectInputStream(new FileInputStream("record.db"));
    	record = (Record)obinput.readObject();
    	System.out.print(record);
    	record = (Record)obinput.readObject();
    	System.out.print(record);
    	record = (Record)obinput.readObject();
    	System.out.print(record);
    	record = (Record)obinput.readObject();
    	System.out.print(record);
    	record = (Record)obinput.readObject();
    	System.out.print(record);
    
    	
    	obinput.close();
    	
      /***
      **** Step 1: declare and initialize the record input stream
      ***/

      /***
      **** Step 2: read the five records from the record input stream
      **** Don't forget to close the top-level stream.
      ***/

      // Handle excpetions
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}