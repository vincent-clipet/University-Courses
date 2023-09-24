package fr.vincent.tp2;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Core
{
	// PROPERTIES

	private static int _width = 800;
	private static int _height = 600;
	private static int _posX = 830;
	private static int _posY = 250;

	public static List<Rect> _obstacles;
	public static JFrame _frame;
	public static Rect _rect;
	public static Dessin _dessin;
	public static Rect _window;



	// MAIN

	public static void main(String[] args)
	{
		_obstacles = new ArrayList<Rect>();
		_obstacles.add(new Rect(600, 500, 5, 5));
		_obstacles.add(new Rect(300, 80, 5, 5));

		_frame = new JFrame("Window 1");

		_rect = new Rect(100, 100, 200, 80);

		_dessin = new Dessin();
		_dessin.setPreferredSize(new java.awt.Dimension(500,300));

		_window = new Rect(0, 0, 1600, 900);

		Container c = _frame.getContentPane();
		c.add(_dessin);

		_frame.setLocationRelativeTo(null);
		_frame.setSize(_width, _height);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setLocation(_posX, _posY);

		sleep(1);
		log("Go !");

		for (int j = 0; j < 100; j += 3)
		{
			boolean check = _rect.moveIfPossible((int)(_rect.getX() + j), (int)(_rect.getY()));
			sleep(0.1);
			log("i = "+j);
		}



		/*JLabel label = new JLabel("Bonjour !");
		c.add(label);

		JButton b1 = new JButton("Test");
		b1.setSize(100, 20);
		b1.setLocation(75, 5);
		label.add(b1);*/

		/*Rect rect = new Rect(10, 10, 200, 70, 1600, 900);

		sleep(1);
		Core.log("" + rect.moveIfPossible(frame, 100, 100));

		sleep(1);
		Core.log("" + rect.moveIfPossible(frame, 300, 300));

		sleep(1);
		Core.log("" + rect.moveIfPossible(frame, 1500, 100));

		sleep(1);
		Core.log("" + rect.moveIfPossible(frame, 100, 100));

		sleep(1);
		Core.log("" + rect.moveIfPossible(frame, 200, 200));*/






	}



	// METHODS

	public static void sleep(double s)
	{
		try { Thread.sleep((long)(s * 1000)); }
		catch (InterruptedException e) { e.printStackTrace(); }
	}

	public static void log(String s)
	{
		System.out.println(s);
	}

	/*public static void moveWindow(JFrame frame)
	{
		int centerX = frame.getX() + frame.getWidth() / 2;
		int centerY = frame.getY() + frame.getHeight() / 2;
		int rayon = 30;

		while (true)
		{
			for (double i = 0; i < (2.0 * Math.PI); i = i + Math.PI / 12.0)
			{
				try { Thread.sleep(100); }
				catch (InterruptedException e) { e.printStackTrace(); }

				frame.setLocation((int)(centerX + rayon * Math.sin(i)), (int)(centerY + 30 * Math.cos(i)));
				frame.setVisible(true);
			}
		}
	}*/
}
