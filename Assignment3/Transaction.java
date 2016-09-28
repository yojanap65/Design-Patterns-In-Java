/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import java.util.Hashtable;

/**
 *
 * @author asatia
 */
public class Transaction {
    NoSQLDatabase database;
    Boolean status= true;
    Hashtable<String,Object>transationData=new Hashtable<>();
    public  Transaction(NoSQLDatabase database){
        this.database = database;
    }
    
     public void put(String key,Object value) throws Exception   {
         try{
            transationData.put(key,value);
        }
        catch(Exception e){
             abort();
        }
    }
    public Object remove(String key) throws Exception    {
        try{
        Object obj=transationData.remove(key);
        return obj;
        }
        catch(Exception e)
        {
            abort();
        }
        return null;
    }
    public Object get(String key)   {
        return transationData.get(key);
    }
    public int getInt(String key)   {
        return (int)transationData.get(key);
    }
    public String getString(String key)   {
        return (String)transationData.get(key);
    }
    public double getDouble(String key)   {
        return (double)transationData.get(key);
    }
    public ObjectType getObject(String key)   {
        return (ObjectType)transationData.get(key);
    }
    public Array getArray(String key)   {
        return (Array)transationData.get(key);
    }
    public void abort() throws Exception{
        if(this.status){
            this.transationData = null;
            this.status = false;
        }
        else{
            throw new Exception("Transaction is inactive");
        }
    }
    public void commit() throws Exception{
        if(this.status){
            System.out.println("Commiting all the operations");
            for(String key: transationData.keySet())
            {
                database.put(key, transationData.get(key));
            }
            
            this.status = false;
        }
        else{
            throw new Exception("Transaction is inactive");
        }
    }
    public boolean isActive(){
        return status;
    }
    
}
