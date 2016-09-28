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
public class CursorObserver extends Observer {
    
    Cursor cursor;
    /*public CursorObserver(Cursor cursor) {
        this.cursor=cursor;
      //  this.cursor.addObserver(this);
    }*/
    @Override
    public void update() {
        System.out.println("Cursor changed");
    }
    
}
