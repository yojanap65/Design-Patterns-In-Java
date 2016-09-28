/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import org.json.JSONObject;

/**
 *
 * @author asatia
 */
class Memento{
   // Hashtable<String, Object> data=new Hashtable<>();
    private final String MOMENTO_FILE_PATH="C:\\Users\\asatia\\Documents\\NetBeansProjects\\Assignment03\\src\\momento.txt";
    public void setState(Hashtable<String, Object> data)    {
        try {
               JSONObject databaseSnapshot=new JSONObject();
                    int counter=1;
                    System.out.println("Sizeo of d b "+data.size() );
                    Enumeration en=data.keys();
                    while(en.hasMoreElements()) {
                        String currentKey=(String)en.nextElement();
                        JSONObject dataObj=new JSONObject();
                        dataObj.put("key",currentKey);
                        dataObj.put("value",data.get(currentKey).toString());
                        databaseSnapshot.put(""+counter, dataObj);
                        counter++;
                    }
                    FileOperations.getInstance().writeToFile(MOMENTO_FILE_PATH,databaseSnapshot.toString());
        }
        catch(Exception e)  {
            System.out.println(e);
        } 
    }
    
    Hashtable<String, Object> getState(){
        Hashtable<String,Object> newData=new Hashtable<>();
        try {
           System.out.println("In recover");
            String databaseContent=FileOperations.getInstance().readFile(MOMENTO_FILE_PATH);
            if(databaseContent!=null)  {
                JSONObject data=new JSONObject(databaseContent);
                int dataCount=data.length();
                int index=1;
                while(index<=dataCount) {
                    JSONObject command=data.getJSONObject(index+"");
                    Object dObject=getObjectType(command.getString("value"));
                    newData.put(command.getString("key"),dObject);
                    index++;
                }
                System.out.println("Done snapsht recover");
                return newData;
            }
        } catch (Exception ex) {
            System.out.println("Error in recover");
            System.out.println(ex);
        }
      return null;
    }
    
    public Object getObjectType(String dataStored)    {
         Object dObject;
                    try{
                        dObject=ObjectType.fromString(dataStored);
                        System.out.println(dataStored+" is Object type");
                    }
                    catch(Exception objectException)   {
                        try{
                            dObject=Array.fromString(dataStored);
                            System.out.println(dataStored+" is array");
                        }
                        catch(Exception arrayException)   {
                            try{
                                dObject=Integer.parseInt(dataStored);
                                System.out.println(dataStored+" is int type");
                            }
                            catch(Exception integerException)   {
                                try{
                                    dObject=Double.parseDouble(dataStored);
                                    System.out.println(dataStored+" is double type");
                                }
                                catch(Exception doubleException)   {
                                     dObject=dataStored;
                                     System.out.println(dataStored+" is string type");
                                }   
                            }
                        }
                    }
         return dObject;
    }
}