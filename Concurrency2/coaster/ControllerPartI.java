

/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class ControllerPartI {

  public static int Max = 9;
  protected NumberCanvas passengers;
  //attribute which counts the number of passenger
  private int count;

  public ControllerPartI(NumberCanvas nc) {
    passengers = nc;
    // number of passengers set to the 0 at the beginning
    count=0;
  }

  public synchronized void newPassenger() throws InterruptedException {
	  // if the number of passenger is equal or greater than then maximum of passenger 
	  while(count>Max-1){
		  wait();
	  }
	  count++;
	  passengers.setValue(count);
	  notify();
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException {
	  // If there is not enough passenger the thread is waiting
	  while(count<mcar){
		  wait();
	  }
	  //Otherwise the number of passenger in the plateform is decreased by mcar
	  count-=mcar;
	  // Display the he new value of passenger
	  passengers.setValue(count);
	  // We notify one of the threads which is waited
	  notify();
	  // return the number of passenger in the coaster car
	  return mcar;
  }
}