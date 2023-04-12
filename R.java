package PQR;

import java.util.concurrent.SynchronousQueue;

public class R extends Thread{
	SynchronousQueue<Integer> c2;	
	int Tr[]; 
	int n;
    R(int Tr[], int n, SynchronousQueue<Integer> c2){ 
    	this.Tr=Tr; 
    	this.n=n;
    	this.c2=c2;
    }
    int recherche(int x) {
    	int i=0;
    	while (i<n) {
    		if (Tr[i]==x)
    			return 1;
    		i++;
    	}
    	return 0;
    }
    public void run() {
    	int trouve=0;
    	int x;
    	while (trouve == 0) {
    		try {
    			x=c2.take();
    			trouve=recherche(x);
    			c2.put(new Integer(trouve));
    		}
    		catch (InterruptedException e) {e.printStackTrace();}
    	}
    }

}
