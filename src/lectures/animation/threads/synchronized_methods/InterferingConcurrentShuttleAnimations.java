package lectures.animation.threads.synchronized_methods;

import lectures.animation.loops.AShuttleAnimator;
import lectures.animation.loops.ShuttleAnimator;
import lectures.animation.threads_commands.ConcurrentShuttleLaunchAnimation;
import lectures.animation.threads_commands.ThreadSupport;
import lectures.composite.objects_shapes.PlottedShuttle;
import lectures.mvc.properties.AnObservablePlottedShuttle;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
/// THREADS CHANGING THE SAME OBJECT CONCURRENTLY
//In the previous example, we had two shuttles, two animators, and two threads, which operated
//independently. Now we have  one shuttle, one animator, and two threads. Thus, we have two threads
//changing the same object concurrently.

// Run the program. See the behavior and output. 
// In AShittleAnimator comment out the printlns in the two loops.
// Can you explain the behavior? Why is there interference in the X direction
// and not in the Y direction? Look carefully at the saved values of original X and Y.
// If you decrease the value of SECOND_THREAD_DELAY, what effect will it have on the saved values.
// Comment out the two printlns to reduce clutter.





public class InterferingConcurrentShuttleAnimations extends ConcurrentShuttleLaunchAnimation  {	
	static final long SECOND_THREAD_DELAY = 500;
	public static void main(String[] args) {
		PlottedShuttle shuttle1 = new AnObservablePlottedShuttle(SHUTTLE1_X, SHUTTLE1_Y);
		displayShuttleFrame(shuttle1);
		ShuttleAnimator aShuttleAnimator = new AShuttleAnimator();
		concurrentDemoShuttleAnimation(aShuttleAnimator, shuttle1);
		ThreadSupport.sleep(SECOND_THREAD_DELAY); // start the second thread a little after the first one
		concurrentDemoShuttleAnimation(aShuttleAnimator, shuttle1);	
	}
}
