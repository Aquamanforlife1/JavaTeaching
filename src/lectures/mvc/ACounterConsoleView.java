package lectures.mvc;
public class ACounterConsoleView implements CounterObserver {
	// One implementation of update, provides console output in reaction to counter change
	
	public void update(Counter counter) {
		System.out.println("Counter: " + counter.getValue());
	}
}
