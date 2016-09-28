/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author asatia
 */
public class Array extends Object{
    ArrayList<Object> arrayData=new ArrayList<>();
    
    public void put(Object value)   {
        arrayData.add(value);
    }
    public Object get(int index)    {
        return arrayData.get(index);
    }
    public String getString(int index) throws Exception   {
        if(arrayData.get(index) instanceof String)
            return (String)arrayData.get(index);
        throw new Exception("Invalid T");
        
    }
    public int getInt(int index)   throws Exception{
        if(arrayData.get(index) instanceof Integer)
            return (int)arrayData.get(index);
        throw new Exception("Invalid T");
        
    }
    public double getDouble(int index) throws  Exception{
        if(arrayData.get(index) instanceof Double)
            return (double)arrayData.get(index);
        throw new Exception("Invalid T");
        
    }
    public Array getArray(int index) throws Exception{
        if(arrayData.get(index) instanceof Double)
            return (Array)arrayData.get(index);
        throw new Exception("Invalid T");
        
    }
    public ObjectType getObject(int index)   throws Exception{
        if(arrayData.get(index) instanceof Double)
            return (ObjectType)arrayData.get(index);
        throw new Exception("Invalid T");
    }
    
    public int length()  {
       return arrayData.size();
    }
    public String toString()    {
        JSONArray obj=new JSONArray(this.arrayData);
        return obj.toString();
    }
    public Object remove(int index)  {
       return arrayData.remove(index);
    }
    public static  Array fromString(String text) throws Exception  {
        System.out.println("in array "+text);
        ObjectMapper mapper=new ObjectMapper();
        Array arr=new Array();
        arr.arrayData=mapper.readValue(text, ArrayList.class);
        return arr;
    }
}
