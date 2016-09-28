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
class Remove  implements ExecuteQuery{
    
    private NoSQLDatabase database;
    private String key;
    
    public Remove(NoSQLDatabase database, String key) {
        this.database=database;
        this.key=key;
    }
    @Override
    public void execute() {
        database.remove(key);
    }
    
}
