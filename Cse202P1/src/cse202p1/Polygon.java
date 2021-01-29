/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse202p1;

import java.util.Stack;

/**
 *
 * @author yunus
 */
public class Polygon {

    Point first;
    Point last;
    int pointNumber;

    public Polygon() {
        first = null;
        last = null;
        pointNumber=0;
    }

    public void addPoint(Point po) {//Yunus
        if (!isClosed()) {
            if (first == null) {
                first = po;
                last = po;
            } else {
                last.setNext(po);
                last = po;
                if (po.equals(first)) {
                    System.out.println("THE POLYGON İS CLOSED.");
                }
            }
        } else {
            System.out.println("The Polygon is already CLOSED. SO You can't add more point.");
        }
    }
    
    public void addQueue(Queue a){//Yunus
       if(!this.isClosed()){
           int counter =0;
        while(!a.isEmpty()){
            Point temp =first;
            while(temp.getNext()!=null){
                if(temp.equals(a.dequeue())){
                    System.out.println("This point is alredy exist in Polygon :" + a.dequeue().toString());
                }else{
                this.addPoint(a.dequeue());
            counter++;
            }
                temp = temp.getNext();
            }
        }
        this.pointNumber += counter;
       }
    }
    
    public void addStack(Stack a){ //Yunus
        if(!this.isClosed()){
            int counter =0;
        while(!a.isEmpty()){
            Point temp =first;
            while(temp.getNext()!=null){
                if(temp.equals(a.pop())){
                    System.out.println("This point is alredy exist in Polygon :" + a.pop().toString());
                }else{
                this.addPoint((Point) a.pop());
            counter++;
            }
                temp = temp.getNext();
            }
        }
        this.pointNumber +=counter;
        }
    }

    public void closeYourself() {//Yunus
        if(!isClosed()){
                last.setNext(first);
        }else{
            System.out.println("The Polygon is Already CLOSED");
        }
    }

    public boolean isClosed() { //MERGE DE DE KULLAN
        if(last.getNext() != null &&  last.getNext().equals(first)) {
            return true;
        }
        
        return false;
    }

    public Polygon Merge(Polygon p) { // BERKAN
        Polygon tmp;
            tmp = new Polygon();
        if (this.isClosed() && p.isClosed()) {
            System.err.println("Polygon is Closed");
        }else{
        if(this.first==null){
            return p;
        }
        if(p.first==null){
            return this;
        }
        tmp.first = this.first;
        tmp.last = p.last;
        this.last.setNext(p.first);
        }
        return tmp;
    }

    public double calculateArea() {// Yunus
        double area = 0;
        if (!isClosed()) {
            Point temp =first;
            while(temp.getNext()!=first){
               area +=(( temp.getX()*temp.getNext().getY() ) - ( temp.getY()*temp.getNext().getX() ) ) / 2;
            }
            return Math.abs(area);
        }
        System.out.println("Polygon is not CLOSED!");
        return -1;
    }

    @Override
    public String toString() { 
        if(!isEmpty()){
        return "first : " + first.toString() + "\nLast: " + last.toString() + "\nNumber of points : " + numberOfPoints();
        }else{
            return "The Polygon is empty!";
        }
    }

    public boolean isEmpty() {
        return first == null;
    }
    
    public Polygon reverse(){ // REVERSE THE POLYGON
        Stack a = new Stack();
        Point temp = first;
        while(temp.getNext() != null || temp.getNext().equals(first)){
            a.push(temp);
            temp = temp.getNext();
        }
        Polygon b =new Polygon();
        b.addStack(a);        
        return b;       
    }

    public int numberOfPoints() { 
        if (!this.isEmpty()) {
            int counter = 1;
            Point temp = first;
            while (temp.getNext() != null) {
                counter++;
                temp = temp.getNext();
            }
            return counter;
        }
        return 0;
    }
    
    public Point[] polygonİntoArray(){
        int counter =0;
        Point temp = first;
        while(temp.getNext()!=null){
            counter++;
            temp.setNext(temp.getNext());
        }
        Point[] pointArray = new Point[counter];
        
        temp = first;
        counter =0;
        while(temp.getNext()!=null){
            pointArray[counter]=temp;
            temp.setNext(temp.getNext());
            counter++;
        }
        return pointArray;
    }
    
    public double calculateTotalLength(){
        double totalDistance=0;
        Point temp =first;
        while(temp.getNext()!=null){
            totalDistance += temp.measureDistance(temp.getNext());
        }
        return totalDistance;
    }
    
     public void insertFirst(Point p) {  
         if(!this.isClosed()){
            if (first == null && last == null) {
            first = p;
            last = p;
            return;
            }           
            Point temp =first;
            while(temp.getNext()!=null){
                if(temp.equals(p)){
                    System.out.println("This point is alredy exist in Polygon :" + p.toString());
                }else{
                p.setNext(first);
                first = p;
                pointNumber++;
                }
            }   
        }else{
            System.out.println("Polygon is CLOSED!");
        }
        
        }
            public void insertLast(Point p) {
        if(!this.isClosed()){
            if (first == null && last == null) {
            first = p;
            last = p;
            return;
        } Point temp =first;
            while(temp.getNext()!=null){
                if(temp.equals(p)){
                    System.out.println("This point is alredy exist in Polygon :" + p.toString());
                }else{
                last.setNext(p);
                last = p;
                pointNumber++;
                }
            }   
        }else{
            System.out.println("Polygon is CLOSED!");
        }
        
        
    }
            public void deletePoint(Point p){
            Point temp = first;
            while(temp.getNext()!=null || !temp.getNext().equals(first)){
                if(temp.getNext().equals(p)){
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setNext(null);
                    pointNumber--;
                }
            }
        }
}
