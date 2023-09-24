package fr.vincent.tp2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Dessin extends Canvas
{
	// PROPERTIES



	// CONSTRUCTOR

	public Dessin()
	{
		super();
	}



	// AUTO-CALL

	public void paint(Graphics g)
	{
		//drawMovingRect(g);
		//drawAll(g);

		drawObstacles(g);
		drawRect(g);
	}



	// METHODS

	public void drawObstacles(Graphics g)
	{
		g.setColor(Color.BLUE);

		for (Rect iter : Core._obstacles)
		{
			g.fillRect((int)iter.getX(), (int)iter.getY(), 5, 5);
		}

		g.setColor(Color.RED);
	}

	public void drawRect(Graphics g)
	{
		g.fillRect((int)Core._rect.getX(), (int)Core._rect.getY(), (int)Core._rect.getWidth(), (int)Core._rect.getHeight());
	}

	public void drawMovingRect(Graphics g)
	{
		g.setXORMode(java.awt.Color.white);

		for (int i = 0; i < 20; i++) 
		{
			g.fillRect(100 + i*10, 100, 100, 100);
			try	{ Thread.sleep(300); }
			catch (InterruptedException e) { e.printStackTrace(); }
			g.fillRect(100 + i*10, 100, 100, 100);
		}
	}

	public void drawAll(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.drawRect(10, 10, 50, 20);

		g.setColor(Color.BLUE);
		g.fillRect(70, 10, 40, 22);

		g.setColor(Color.MAGENTA);
		g.drawLine(100, 5, 260, 25);

		g.setColor(Color.GREEN);
		g.drawRoundRect(10, 60, 60, 20, 3, 3);

		g.setColor(Color.BLACK);
		g.drawString("rect", 12, 12);

		g.setColor(Color.ORANGE);
		g.drawOval(10, 120, 50, 20);

		g.setColor(Color.RED);
		Polygon polygon = new Polygon();
		polygon.addPoint(15, 200);
		polygon.addPoint(42, 221);
		polygon.addPoint(38, 249);
		polygon.addPoint(54, 215);
		polygon.addPoint(15, 200);
		/*polygon.addPoint(15, 300);
		polygon.addPoint(15, 300);
		polygon.addPoint(15, 300);*/
		g.drawPolygon(polygon);
	}



}
