/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse202p1;

/**
 *
 * @author Murat HAKSEVEN
 */
public class Queue { // LINKED LIST IMPLEMENTATION

    Point ﬁrst;
    Point last;

    public Queue() {
        ﬁrst = null;
        last = null;
    }

    boolean isEmpty() {
        if (ﬁrst == null) {
            return true;
        } else {
            return false;
        }
    }

    void enqueue(Point p) {
        if (!isEmpty()) {
            last.setNext(p);
        } else {
            ﬁrst = p;
        }
        last = p;
    }

    Point dequeue() {
        Point result;
        result = ﬁrst;
        if (!isEmpty()) {
            ﬁrst = ﬁrst.getNext();
        }
        return result;
    }

}
