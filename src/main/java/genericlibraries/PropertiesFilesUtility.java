package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
    
   /**
    * This class contain all reusable methods to perform options on properties
    * @author swain
    *
    */


public class PropertiesFilesUtility {
    private  Properties Property;
      
      /**
       * This method is used to initialize properties file
       * @param filepath
       */
      
      public void PropertyFileIntialization(String filepath)
      {
    	  FileInputStream fis=null;
    	  try
    	  {
    		  fis=new FileInputStream(filepath);
    	  }
    	  catch(FileNotFoundException e)
    	  {
    		  e.printStackTrace();
    	  }
    	  
    	  Property=new Properties();
    	  
    	  try
    	  {
    		  Property.load(fis);
    	  }
    	  catch(IOException e)
    	  {
    		  e.printStackTrace();
    	  }
      }
      /**
       * This method returns data from properties file based on key passed
       * @param key
       * return
       */
      public String fetchproperty(String key)
      {
    	 return Property.getProperty(key); 
      }
}
