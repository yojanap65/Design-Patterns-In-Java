/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author asatia
 */
class ObjectType extends Object    {
    Hashtable<String, Object> objectData=new Hashtable<>();
    public void put(String key,Object value)    {
        objectData.put(key, value);
    }
    
    public Object get(String key)  {
        return objectData.get(key);
    }
    public int getInt(String key)  throws Exception{
        if(objectData.get(key) instanceof Integer)
            return (int)objectData.get(key);
        throw new Exception("Invalid Exception");
    }
    public double getDouble(String key) throws Exception {
        if(objectData.get(key) instanceof Double)
            return (double)objectData.get(key);
        throw new Exception("Invalid T");
    }
    public String getString(String key) throws Exception  {
        if(objectData.get(key) instanceof String)
            return (String)objectData.get(key);
        throw new Exception("Invalid T");
    }
    
    public ObjectType getObject(String key) throws Exception  {
        if(objectData.get(key) instanceof ObjectType)
        return (ObjectType)objectData.get(key);
        throw new Exception("Invalid T");
    }
    public int length() {
        return objectData.size();
    }
    public Object remove(String key)    {
        return objectData.remove(key);
    }
    public String toString()    {
        JSONObject onj=new JSONObject(this.objectData);
        return onj.toString();
    }
    
    public static  ObjectType fromString(String text) throws Exception  {
        System.out.println("Convert this "+text);
        ObjectMapper mapper=new ObjectMapper();
        ObjectType obj=new ObjectType();
        obj.objectData=mapper.readValue(text, Hashtable.class);
        return obj;
    }
    
}
