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
class NoSQLDatabase {
    int commandCount=0;
    private final String MOMENTO_FILE_PATH="C:\\Users\\asatia\\Documents\\NetBeansProjects\\Assignment03\\src\\momento.txt";
    private final String COMMAND_FILE_PATH="C:\\Users\\asatia\\Documents\\NetBeansProjects\\Assignment03\\src\\command.txt";
    Hashtable<String,Object>data=new Hashtable<>();
    
    Hashtable<String, ArrayList<Cursor>> listOfObservers=new Hashtable<>();
    
    public NoSQLDatabase()  { 
        recover();
        
    }
    
    public NoSQLDatabase put(String key,Object value)   {
        data.put(key,value);
        snapShot("insert",key,value);
        notifyObserver(key);
        return this;
    }
    public Object remove(String key)    {
        Object obj=data.remove(key);
        snapShot("remove", key," "); 
        return obj;
    }
    public Object get(String key)   {
        return data.get(key);
    }
    public int getInt(String key)   {
        return (int)data.get(key);
    }
    public String getString(String key)   {
        return (String)data.get(key);
    }
    public double getDouble(String key)   {
        return (double)data.get(key);
    }
    public ObjectType getObject(String key)   {
        return (ObjectType)data.get(key);
    }
    public Array getArray(String key)   {
        return (Array)data.get(key);
    }
    
    public Cursor getCursor(String key) {
        Cursor cursor= new Cursor(this,key);
        addObserver(cursor,key);
        return cursor;
    }
    
    public void addObserver(Cursor cursor,String key)    {
        ArrayList<Cursor> list=listOfObservers.get(key);
        if(list==null)  {
            list=new ArrayList<Cursor>();
        }
        list.add(cursor);
        this.listOfObservers.put(key,list);
    }
    
    public void removeObserver(Cursor cursor,String key)    {
        ArrayList<Cursor> list=listOfObservers.get(key);
        if(list==null)  {
            list=new ArrayList<Cursor>();
        }
        list.remove(cursor);
        this.listOfObservers.remove(key);
    }
    
    public void notifyObserver(String key)    {
        ArrayList<Cursor> arrayOfObserver=listOfObservers.get(key);
        if(arrayOfObserver!=null)   {
        for(Cursor observer : arrayOfObserver)    {
            observer.update();
            }
        }
    }
    
    /* method by tushar*/
    public Transaction transaction(){
        return new Transaction(this);
    }
    
    
    
     public void recover()   {
       try {
                Memento memento=new Memento();
                this.data=memento.getState();
                String text=FileOperations.getInstance().readFile(COMMAND_FILE_PATH);
                if(text!=null)  {
                    JSONObject object=new JSONObject(text);
                    commandCount=object.length();
                    int index=1;
                    while(index<=commandCount) {
                        JSONObject command=object.getJSONObject(index+"");
                        String opr=command.getString("opr");
                        switch(opr) {
                            case "insert":
                                this.data.put(command.getString("key"),getObjectType(command.getString("value")));
                                break;
                            case "remove":
                                this.data.remove(command.getString("key"));
                        }
                        index++;
                    }
                System.out.println("Hash table is "+data.toString());
                }
        } catch (Exception ex) {
            System.out.println("Error in recover");
            System.out.println(ex);
        }
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
    
    public void snapShot(String opr,String key,Object value)  {
        try {
            System.out.println("In snapsjhot");
            String data=FileOperations.getInstance().readFile(COMMAND_FILE_PATH);
            JSONObject object=new JSONObject();
            int count=0;
            if(data!=null)  {
                object=new JSONObject(data);
                count=object.length();
            }
                if(count>=5) {
                    object=new JSONObject();
                    Memento memento=new Memento();
                    memento.setState(this.data);
                }
                JSONObject jsonData=new JSONObject();
                jsonData.put("opr",opr);
                jsonData.put("key",key);
                jsonData.put("value",value.toString());
                object.put(""+(count+1), jsonData);
                FileOperations.getInstance().writeToFile(COMMAND_FILE_PATH,object.toString());
        }
        catch(Exception e)  {
            System.out.println(e);
        }   
    }
}