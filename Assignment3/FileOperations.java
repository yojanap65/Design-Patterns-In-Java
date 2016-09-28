/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.json.JSONObject;

/**
 *
 * @author asatia
 */
class FileOperations    {
    private final String MOMENTO_FILE_PATH="C:\\Users\\asatia\\Documents\\NetBeansProjects\\Assignment03\\src\\momento.txt";
    private final String COMMAND_FILE_PATH="C:\\Users\\asatia\\Documents\\NetBeansProjects\\Assignment03\\src\\command.txt";
    static FileOperations singleInstance;
    private JSONObject data;
    private int count;
    private FileOperations()    {
        
    }
    
    public static FileOperations getInstance() {
        if(singleInstance==null)    {
            singleInstance= new FileOperations();
        }
        return singleInstance;
    }
    
    public String readFile(String path)    {
        String data=null;
        File file=new File(path);
        try {
            String sCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader(file));                                                 
            while ((sCurrentLine = br.readLine()) != null) {
                data=sCurrentLine;
            }
        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println("read from file "+data);
        return data;
    }
        
    public void writeToFile(String path,String text)   {
        try {
                File file=new File(path);
                FileWriter fr=new FileWriter(file);
                BufferedWriter writer=new BufferedWriter(fr);
                writer.write(text);
                writer.close();
                System.out.println("wrote to file "+text);
            }
            catch(Exception e)  {
                System.out.println(e);
            }
    }
}