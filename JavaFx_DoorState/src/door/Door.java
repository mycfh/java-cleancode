package door;

import java.util.Timer;
import java.util.TimerTask;

public class Door {
	private DoorDemo app;
	private final long COUNTER_MAX= 100;
	private long counter;
	private Timer timer;
	private enum DoorState{OPENED, CLOSED, OPENING, CLOSING}
	private DoorState state;
	
	public Door(DoorDemo app){
		this.app= app;
		state= DoorState.CLOSED;
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
	        @Override
	        public void run() {
	        	doorLoop();
	        }
		}, 0, 100);
	}
	
	private void doorLoop(){
		switch(state){
		case CLOSED:
			counter= 0;
			break;
		case OPENED:
			counter= COUNTER_MAX;
			break;
		case CLOSING:
			if(counter>0) counter--;
			
			if(counter==0){
				state= DoorState.CLOSED;
				app.message("Door Closed");
			}else{
				app.message("Closing " + counter);
			}
			break;
		case OPENING:
			if(counter<COUNTER_MAX) counter++;
			if(counter==COUNTER_MAX){
				state= DoorState.OPENED;
				app.message("Door Opened");
			}else{
				app.message("Opening " + counter);
			}
			break;
			
		}
	}
	
	public void open(){
		state= DoorState.OPENING;
	}
	
	public void close(){
		state= DoorState.CLOSING;
	}
	
}
