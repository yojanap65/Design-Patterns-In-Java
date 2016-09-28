/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

/**
 *
 * @author asatia
 */
class Insert implements ExecuteQuery{
    
    private NoSQLDatabase database;
    String key;
    Object value;
    
    public Insert(NoSQLDatabase database,String key,Object value) {
        this.database=database;
        this.key=key;
        this.value=value;
    }
    @Override
    public void execute() {
            database.put(key, value);
    }  
}
