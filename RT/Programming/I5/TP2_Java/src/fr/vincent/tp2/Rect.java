package fr.vincent.tp2;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class Rect extends Rectangle
{
	// PROPERTIES

	public static int _screenW;
	public static int _screenH;



	// CONSTRUCTOR

	public Rect(int x, int y, int w, int h)//, int screenW, int screenH)
	{
		super(x, y, w, h);
		//_screenW = screenW;
		//_screenH = screenH;
	}



	// METHODS

	public boolean moveIfPossible(int targetX, int targetY)
	{
		boolean inside = isInside(targetX, targetY, Core._window);
		boolean obstacle = !isOnObstacle(targetX, targetY);

		Core.log("Inside = " + inside);
		Core.log("Obstacle = " + obstacle);

		if ( inside && obstacle) // Let's Move
		{
			moveOnScreen(targetX, targetY);
			return true;
		}

		return false;
	}

	public boolean isOnObstacle(int targetX, int targetY)
	{
		for (Rect iter : Core._obstacles)
		{
			if (iter.isInside(targetX, targetY, Core._rect))
			{
				return true;
			}
		}

		return false;
	}

	public boolean isInside(int targetX, int targetY, Rect superRect)
	{
		return !(
				targetX <= superRect.getX()
				|| targetX + this.getWidth() > superRect.getX()
				|| targetY <= superRect.getY()
				|| targetY + this.getHeight() > superRect.getY()
				);

				//if (inScreen)
				//moveOnScreen(targetX, targetY);
				//return inScreen;
	}

	private void moveOnScreen(int targetX, int targetY)
	{
		// frame.move(targetX, targetY); // Deprecated
		Core._frame.setLocation(targetX, targetY);
	}
}
