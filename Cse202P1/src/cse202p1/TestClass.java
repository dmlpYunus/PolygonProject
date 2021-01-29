/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse202p1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author yunus
 */
public class TestClass {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Polygon> polygons = new ArrayList();
    static ArrayList<Queue> queues = new ArrayList();
    static ArrayList<Stack> stacks = new ArrayList();
    static boolean quit = false;

    public static void main(String[] args) {
        Polygon hazar= new Polygon();
        Point a1 = new Point(5, 2);
        Point a2 = new Point(2, 5);
        Point a3 = new Point(1, 3);
        Point a4 = new Point(0, 7);
        Point a5 = new Point(7, 3);
        Point a6 = new Point(-1, 4);
        hazar.addPoint(a1);
        hazar.addPoint(a2);
        hazar.addPoint(a3);
        hazar.addPoint(a4);
        hazar.addPoint(a5);
        hazar.addPoint(a6);
        hazar.closeYourself();
        System.out.println(hazar.isEmpty());
        //System.out.println(hazar.isClosed());
        
        
        
        /*while (!quit) {
            printMenuDisplay();
            int choose = scan.nextInt();

            switch (choose) {
                case 1://User Creates Polygons
                    createPolygon();
                    break;
                case 2://User Makes Processes With Polygons
                    if (polygons.isEmpty()) {
                        System.out.println("--- --- ");
                        System.out.println("You must create a Polygon FİRST!");
                        System.out.println("--- --- ");
                        break;
                    }
                    displayPolygons();
                    System.out.println("");
                    System.out.println("Enter the number of Polygon which you want to make process with.");
                    int polygonNumber = scan.nextInt();
                    polygons.get(polygonNumber);
                    System.out.println("Choose your action\n"
                            + "• (Press 1) for Calculate Polygon's Area\n"
                            + "• (Press 2) for Closing the Polygon\n"
                            + "• (Press 3) for Add point inside the Polygon\n"
                            + "• (Press 4) for Add Stacks of Points inside the Polygon\n"
                            + "• (Press 5) for See the proporties of the Polygon\n");
                    int processNumber = scan.nextInt();
                    switch (processNumber) {
                        case 1://Calculating The Area
                            System.out.println("The Polygons Area : " + polygons.get(polygonNumber).calculateArea());
                            break;

                        case 2://Polygon Closes itself 
                            polygons.get(polygonNumber).closeYourself();
                            break;

                        case 3://Add points
                            System.out.println("Enter your X and Y values! (Enter x= 1111 y=1111 for exit from the loop!)");
                            int X = 1111;
                            int Y = 1111;
                            while (X != 1111 && Y != 1111) {
                                System.out.print("X = ");
                                X = scan.nextInt();
                                System.out.print("Y = ");
                                Y = scan.nextInt();
                            }
                            break;

                        case 4://Add Stack of Points ----- Asks user add a new one or existing one
                            System.out.println("-----Choose Action---- \n• (Press 1) Found a new Stack and add into polygon \n• (Press 2)Add a existing Stack into polygon");
                            int stackAction = scan.nextInt();

                            switch (stackAction) {

                                case 1://Create a new Stack then add it into polygon
                                   System.out.println("Enter your Stacks capacity");
                                            int capacity = scan.nextInt();
                                            createStack(capacity);
                                            System.out.println("Please Enter you input (Example : 21,2;2,18;44,15)");
                                            int counterStack = 0;
                                            for (int j = 0; j <= stacks.size(); j++) {
                                                counterStack = j;
                                            }
                                            String inputS = scan.nextLine();
                                            String[] pointsStack = inputS.split(";");
                                            for (int i = 0; i <= pointsStack.length - 1; i++) {
                                                String[] coordinates = pointsStack[i].split(",");
                                                Point p1 = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                                                stacks.get(counterStack).push(p1);
                                            }

                                            for (int i = 0; i <= pointsStack.length - 1; i++) {
                                                polygons.get(polygonNumber).addPoint((Point) stacks.get(counterStack).pop());
                                            }
                                    break;

                                case 2://Add an Existing Stack into the Polygon

                                    displayStacks();
                                    System.out.println("  ");
                                    System.out.println("Enter the number of the Stacks that you want to make process");
                                    int stackNumber = scan.nextInt();
                                    Point tempQueue = queues.get(stackNumber).ﬁrst;
                                    while (tempQueue.getNext() != null) {
                                        polygons.get(polygonNumber).addPoint(queues.get(stackNumber).dequeue());
                                    }

                                    break;

                                case 3://Add Queue of Points ------ Asks user add a new one or existing one
                                    System.out.println("-----Choose Action---- \n• (Press 1) Found a new Queue and add into polygon \n• (Press 2)Add a existing queue into polygon");
                                    int queueAction = scan.nextInt();

                                    switch (queueAction) {

                                        case 1://Create a new Queue then add it into Polygon                                            
                                            createQueue();
                                            System.out.println("Please Enter you input (Example : 21,2;2,18;44,15)");
                                            int counterQueue=1;
                                            for (int j = 0; j <= queues.size(); j++) {
                                                counterQueue = j;
                                            }
                                            String inputQueue = scan.nextLine();
                                            String[] pointsQueue = inputQueue.split(";");
                                            for (int i = 0; i <= pointsQueue.length - 1; i++) {
                                                String[] coordinates = pointsQueue[i].split(",");
                                                Point p1 = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                                                queues.get(counterQueue).enqueue(p1);
                                            }

                                            for (int i = 0; i <= pointsQueue.length - 1; i++) {
                                                polygons.get(polygonNumber).addPoint((Point) queues.get(counterQueue).dequeue());
                                            }
                                            break;
                                        
                                        case 2://Add an Existing Queue into the Polygon
                                            displayQueues();
                                            System.out.println("  ");
                                            System.out.println("Enter the number of the Queue that you want to make process");
                                            int queueNumber = scan.nextInt();
                                            Point tempStack = queues.get(queueNumber).ﬁrst;
                                            while (tempStack.getNext() != null) {
                                                polygons.get(polygonNumber).addPoint(queues.get(queueNumber).dequeue());
                                            }

                                            break;

                                    }
                                    break;

                            }
                        case 5://Show Polygon's Proporties
                            System.out.println(polygons.get(polygonNumber).toString());
                            break;

                    }
                case 3://quit
                    System.out.println("GoodBye!");
                    quit();
                    break;
            }
        }
    }

    private static void quit() {
        quit = true;
    }

    private static void createPolygon() {
        Polygon a = new Polygon();
        polygons.add(a);
        System.out.println("Polygon has been Created and added into polygons list!!!");
    }

    private static void createQueue() {
        Queue a = new Queue();
        queues.add(a);
    }

    private static void displayPolygons() {
        for (int i = 0; i < polygons.size(); i++) {
            if (!polygons.get(i).isEmpty()) {
                System.out.println(i + ") " + polygons.get(i).toString());
            } else {
                System.out.println(i + ") has " + polygons.get(i).numberOfPoints() + " Points inside it!  (if its -1 then, Polygon has no Points inside it!)");

            }

        }
    }

    private static void displayQueues() {
        if(stacks.isEmpty()){
            System.out.println("You haven't creates any stacks yet!");
            return;
        }
        for (int i = 0; i < queues.size(); i++) {
            System.out.println(i + "- " + queues.get(i).toString());
        }
    }

    private static void displayStacks() {
        if(stacks.isEmpty()){
            System.out.println("You haven't creates any stacks yet!");
            return;
        }
        for (int i = 0; i < stacks.size(); i++) {
            System.out.println(i + "- " + stacks.get(i).toString());
        }
    }

    private static void printMenuDisplay() {
        System.out.println("-----MAIN MENU----\n"
                + "• (Press 1) for Create a new Polygon.\n"
                + "• (Press 2) for make process in Polygons.\n"
                + "• (Press 3) for Quit");
    }

    private static void createStack(int capacity) {
        Stack a = new Stack();
        stacks.add(a);
        
        
    }
    
    public static void Berkan(Queue a, Stack b){
        int sum =0;
        a.dequeue().getX();//Aslında key olcak 
        for(int i =0;i<=a.dequeue().getX();i++){
            Point c =(Point) b.pop();
            sum+= c.getX();
        }
        Point neww = new Point(sum, sum);
        b.push(neww);
        
    }
    
    public static void deneme(int N){
        int sum = 0;
for (int i = N; i >=1; i/=2){
     for (int j = N; j >=i ; j--){
          sum++;
         System.out.println(j);
      
     }
}   
        System.out.println(         );
        System.out.println("sum = " + sum);
    */}
}
