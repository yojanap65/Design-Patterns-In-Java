/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import java.util.ArrayList;

/**
 *
 * @author asatia
 */
public class Cursor {
    NoSQLDatabase database;
    String key;
    ArrayList<Observer> observers=new ArrayList<>();
    public Cursor(NoSQLDatabase database,String key)    {
        this.database=database;
        this.key=key;
    }
    
    public void addObserver(Observer observer)  {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer)    {
        observers.remove(observer);
    }
    public void notifyAllObservers() {
        for(Observer observer : observers)  {
            observer.update();
        }
    }
    public Object get() {
        return database.get(key);
    }
    public int getInt() {
        return database.getInt(key);
    }
    public double getDouble() {
        return database.getDouble(key);
    }
    public String getString() {
        return database.getString(key);
    }
    public Array getArray() {
        return database.getArray(key);
    }
    public ObjectType getObject() {
        return database.getObject(key);
    }
    public void update()    {
        notifyAllObservers();
    }
    /*NoSQLDatabase database;
    String key;
    Object value;
    public Cursor(NoSQLDatabase database,String key){
      this.database = database;
      this.key=key;
      this.value=this.database.get(this.key);
      this.database.addObserver(this,key);
   }
    
    @Override
    public void update() {
        System.out.println("Called update");
        this.value=database.get(key);
    }*/
}
