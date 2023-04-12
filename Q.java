package PQR;

import java.util.concurrent.SynchronousQueue;

public class Q extends Thread{
	SynchronousQueue<Integer> c1, c2;	
	int Tq[]; 
	int n;
    Q(int Tq[], int n, SynchronousQueue<Integer> c1, SynchronousQueue<Integer> c2){ 
    	this.Tq=Tq; 
    	this.n=n;
    	this.c1=c1;
    	this.c2=c2;
    }
    int recherche(int x) {
    	int i=0;
    	while (i<n) {
    		if (Tq[i]==x)
    			return 1;
    		i++;
    	}
    	return 0;
    }
    public void run() {
    	int trouve, b, x;
    	trouve=0;
    	while (trouve == 0) {
    		try {
    			x=c1.take();
    			b=recherche(x);
    			if (b==1) {
    				c2.put(x);
    				trouve=c2.take();
    				c1.put(new Integer (trouve));
    			}
    			else
    				c1.put(new Integer (0));
    		}
    		catch (InterruptedException e) {e.printStackTrace();}
    	}
    }

}
