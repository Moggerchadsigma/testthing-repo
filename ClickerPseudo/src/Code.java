import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Code {
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		    public void run() {
		    	try {
		    		Clip clip = AudioSystem.getClip();
		        	AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir")+"/sound/" + url));
		        	clip.open(inputStream);
		        	clip.start(); 
		    	} catch (Exception e) {
		    		System.err.println(e.getMessage());
		    	}
		    }
		  }).start();
	}
	Code()
	{
		//initialization
		JFrame window = new JFrame("Clicker");
		ImageIcon bubble = new ImageIcon(System.getProperty("user.dir")+"/img/bubblewrap.png");
	
		JLabel bubbledisplay = new JLabel(bubble);
		int scores[] = {0};
		JLabel score = new JLabel(String.valueOf(scores[0]));
		//end of initialization
		//settings general
		
		
		//end of settings general
		//start of event handling
		bubbledisplay.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent b) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent b) {
				// TODO Auto-generated method stub
				scores[0] += 1;
				score.setText(String.valueOf(scores[0]));
				playSound("popsound2.wav");
			   
			}

			@Override
			public void mouseReleased(MouseEvent b) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent b) {
				// TODO Auto-generated method stub
				System.out.println("mouse entered the icon");
			}

			@Override
			public void mouseExited(MouseEvent b) {
				// TODO Auto-generated method stub
				System.out.println("mouse exited the icon");
			}
				
		});
	
		
		//end of event handling
		
		//jframe setting1s
		window.add(bubbledisplay);
		
		window.add(score);
		window.setLayout(new FlowLayout());
		window.setSize(400,300);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setFocusable(true);
	}
}
