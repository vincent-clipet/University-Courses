package fr.vincent.tp2;

import java.awt.Container;
import java.awt.Image;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main
{
	private static int _width = 250;
	private static int _height = 200;
	private static int _posX = 900;
	private static int _posY = 500;


	/*public static void main(String[] args)
	{	
		JFrame frame = new JFrame("Window 1");
		Container c = frame.getContentPane();

		frame.setLocationRelativeTo(null);
		frame.setSize(_width, _height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(_posX, _posY);

		JLabel label = new JLabel("Bonjour !");
		c.add(label);

		JButton b1 = new JButton("Test");
		b1.setSize(100, 20);
		b1.setLocation(75, 5);
		label.add(b1);

		moveRandom(frame);
	}

	public static void move(JFrame frame)
	{
		int centerX = frame.getX() + frame.getWidth() / 2;
		int centerY = frame.getY() + frame.getHeight() / 2;
		int rayon = 101;

		boolean incr = true;
		int iter = 0;

		while (iter < 1000)
		{
			for (double i = 0; i < (2 * Math.PI); i = i + Math.PI / 12.0)
			{
				try { Thread.sleep(10); }
				catch (InterruptedException e) { e.printStackTrace(); }

				//frame.setLocation((int)(centerX + rayon * Math.sin(i)), (int)(centerY + rayon * Math.cos(i)));
				//frame.setVisible(true);

				frame.setSize(rayon, rayon / 2);

				if (rayon == 500)
				{
					rayon = 499;
					incr = false;
				}
				else if (rayon == 100)
				{
					rayon = 101;
					incr = true;
				}
				else if (incr == true)
					rayon++;
				else if (incr == false)
					rayon--;
			}
		}
	}


	public static void moveRandom(JFrame frame)
	{
		Random r = new Random();
		int iter = 0;

		while (iter < 50)
		{
			try { Thread.sleep(100); }
			catch (InterruptedException e) { e.printStackTrace(); }

			frame.setLocation(r.nextInt(1350) + 1, r.nextInt(700) + 1);
		}
	}*/



}
