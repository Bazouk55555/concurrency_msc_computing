

/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {

  public static int Max = 9;
  protected NumberCanvas passengers;

  // declarations required
  private int count;
  private Boolean go;

  public Controller(NumberCanvas nc) {
    passengers = nc;
    count=0;
    // A new boolean is added to check is the button 
    // goNow is pressed
    go=false;
  }

  public synchronized void newPassenger() throws InterruptedException {
	  // Nothing has changed in this code
	  while(count>Max-1){
		  wait();
	  }
	  count++;
	  passengers.setValue(count);
	  notify();
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException {
	  //It now also checks if the button goNow is pressed
	  while(count<mcar&&go==false){
		  wait();
	  }
	  // This integer represents the number of passenger which comes into the coaster car
	  int passenger_in_car=Math.min(mcar,count);
	  count-=passenger_in_car;
	  go=false;
	  passengers.setValue(count);
	  notify();
     return passenger_in_car; // dummy value to allow compilation
  }

  public synchronized void goNow() {
	  // If the number of passenger on the platform is not empty,
	  // the boolean go goes to true and one of the thread is awakened .
	  // It gives the possibility to the coaster car to go.
	  if (count>0){
		  go=true;
		  notify();
	  }
  }

}