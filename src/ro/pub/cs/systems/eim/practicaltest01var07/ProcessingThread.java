package ro.pub.cs.systems.eim.practicaltest01var07;

import java.util.Date;
import java.util.Random;

import android.content.Context;
import android.content.Intent;

public class ProcessingThread extends Thread {

	private Context context = null;
	private boolean isRunning = true;
	private String name = null;
	private String group = null;
	
	
	private Random random = new Random();
		
	public ProcessingThread(Context context, String studentName, String studentGroup) {
		this.context = context;

	}
	
	@Override
	public void run() {
		while (isRunning) {
			sendMessage();
			sleep();
		}
	}
	
	private void sendMessage() {
		Intent intent = new Intent();
		//intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
		intent.putExtra("message", new Date(System.currentTimeMillis()) + " " + name + " " + group);
		context.sendBroadcast(intent);
	}
	
	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}
	
	public void stopThread() {
		isRunning = false;
	}
	
}
