package PQR;

import java.util.concurrent.SynchronousQueue;

public class P extends Thread{
	SynchronousQueue<Integer> c1;	
	int Tp[]; 
	int n;
    P(int Tp[], int n, SynchronousQueue<Integer> c1){ 
    	this.Tp=Tp; 
    	this.n=n;
    	this.c1=c1;
    }
    public void run() {
    	int i=0;
    	int trouve = 0;
    	while (trouve == 0) {
    		try {
    			c1.put(new Integer(Tp[i]));
    			trouve = c1.take();
    			i++;
    		}
    		catch (InterruptedException e) {e.printStackTrace();}
    	}
    	System.out.println("Resultat: " + Tp[i-1]);
    }
}
