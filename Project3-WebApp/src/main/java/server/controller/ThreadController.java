package server.controller;

import server.service.FaceServer;
import server.view.DetectionPanel;
import utility.FaceData;

/**
 * Controller for sending multiple values in certain time durations
 */
public class ThreadController implements Runnable {
	static Thread th;
	DetectionPanel dpanel ; 
	Double emointerval = 1.0;
	Double timeElapsed = 0.0;
	public ThreadController(Double emointerval, DetectionPanel dpanel ){	
		th= new Thread(this);
		this.dpanel=dpanel;
		this.emointerval= emointerval;
		timeElapsed = Double.parseDouble(dpanel.timeElapsedTextbox.getText());
	}
	
	public void run() {
		while(true){
			timeElapsed += emointerval;
			try {
				Thread.sleep((long) (1000 * emointerval));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dpanel.timeElapsedTextbox.setText(timeElapsed+"");
			FaceData faceData = dpanel.getDetectionController().createFaceDataInstance();
			faceData.setTimeElapsed(timeElapsed);
			FaceServer.put(faceData);
		}
	}
	
	/**
	 * Stops the thread
	 */
	@SuppressWarnings("deprecation")
	public static void stop() {
		th.stop();
	}
	
	/**
	 * Starts the thread
	 */
	public static void start(){
		th.start();
	}
}
