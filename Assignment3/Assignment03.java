/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;



/**
 *
 * @author asatia
 */

class Assignment03  {
    public static void main(String arg[])   {
        try {
            NoSQLDatabase database=new NoSQLDatabase();
            /* database.put("1",2);
            database.put("2","Tushar");
            ObjectType obj=new ObjectType();
            obj.put("5", "Object Tushar");
            Array arr = new Array();
            arr.put(1);
            arr.put("Tushar");
            arr.put(obj);
            database.put("3",obj);
            database.put("4",arr);*/
            database.put("15","hello world");
            database.put("16","hgagkss");
            database.put("17","hgagkss");
            database.put("18","hgagkss");
            database.remove("5");
            //System.out.println("value is "+database.get("5"));
            /*Cursor cursor=database.getCursor("5");
            System.out.println(cursor.get());
            CursorObserver co=new CursorObserver();
            cursor.addObserver(co);
            database.put("5","sfsfsff");
            database.put("5", "Assignment 3");*/
            
            
        } catch (Exception ex) {
            Logger.getLogger(Assignment03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
