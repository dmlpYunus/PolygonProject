/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse202p1;

import java.util.Scanner;

/**
 *
 * @author YUNUS
 */
public class Point {

   private int x,y;
   public Point next;
   
   

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate of x is = " + x + "\nCoordinate of Y is = " + y;
       
    }
    
    public int measureDistance(Point a){
        int distanceX= x-a.getX();
        int distanceY = y-a.getY();
        int distance = (int)Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
        return distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getNext() {
        return next;
    }

    public void setNext(Point next) {
        this.next = next;
    }
    
    
    
    
    
    
    
    
    
    
    
   
    
}
