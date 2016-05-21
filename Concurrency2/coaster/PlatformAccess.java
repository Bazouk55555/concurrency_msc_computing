
/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {

	// This boolean check if it is possible to come into the platform
	static Boolean accessPlateform=true;

  public synchronized void arrive() throws InterruptedException {
	  // If it is not possible to come into the plateform,
	  // the thread has to wait until he is notified
	  while(accessPlateform==false){
		  wait();
	  }
	  accessPlateform=false;
  }

  public synchronized void depart() {
	  // When the coaster car leaves the plateform, 
	  // the access of the plateform is now allowed (accessPlateform=true)
	  // and one of the waiting thread is notified to warn it.
	  accessPlateform=true;
	  notify();
  }

}