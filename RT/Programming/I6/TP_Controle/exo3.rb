require "java"
require "socket"
import javax.swing.JPanel
import javax.swing.JFrame
import javax.swing.JButton


##########
# GLOBAL #
##########

$x = 100; # x position of the rectangle
$y = 100; # y position of the rectangle
$size = 50; # size of the rectangle
$range = 10; # step between 2 moves of the rectangle
$old_x = $x # old x position of the rectangle
$old_y = $y # old y position of the rectangle

# List of obstacles
$obstacles_x = [50, 100, 240, 520, 250]
$obstacles_y = [350, 250, 170, 70, 220]



############
# LISTENER #
############

class MyAction
 include java.awt.event.ActionListener
    def actionPerformed(event)
        
		direction = event.getSource().getText().to_s()
		move(direction);
        
        $maToile.repaint() 
    end


	# Move the rectangle in the good direction
	def move(direction)
		if (direction == "UNDO")
			undo()
		elsif (direction == "UP")
			tryMove(0, -$range);
		elsif (direction == "DOWN")
			tryMove(0, +$range);
		elsif (direction == "LEFT")
			tryMove(-$range, 0);
		elsif (direction == "RIGHT")
			tryMove(+$range, 0);
		end
	end

	# Attempt to move the rectangle
	def tryMove(deltaX, deltaY)
		if (isColliding(deltaX, deltaY))
			return;
		else
			$old_x = $x;
			$old_y = $y;
			$x += deltaX;
			$y += deltaY;
		end
	end

	# Undo the last move
	def undo()
		$x = $old_x;
		$y = $old_y;
	end

	# Return true if at least one obstacle is colliding with the rectangle
	def isColliding(deltaX, deltaY)
		for i in 0..4 do
			if (isIn($x + deltaX, $y + deltaY, $obstacles_x[i], $obstacles_y[i])) # true if collision
				return true;
			end
		end

		return false;
	end

	# Return true if at least one of the corner of an obstacle is in the rectangle
	def isIn(xRect, yRect, xObs, yObs)
		if (pointIsInRectangle(xRect, yRect, xObs, 			yObs			) ||
			pointIsInRectangle(xRect, yRect, xObs, 			yObs + $range	) ||
			pointIsInRectangle(xRect, yRect, xObs + $range, yObs			) ||
			pointIsInRectangle(xRect, yRect, xObs + $range, yObs + $range	)
			)
			return true;
		end
	end

	# Return true if a point is contained in a rectangle
	def pointIsInRectangle(xRect, yRect, xObs, yObs)
		if (xObs > xRect && xObs < xRect + $size && yObs > yRect && yObs < yRect + $size)
			return true;
		end
	end

end



##########
# SCREEN #
##########

class Toile<java.awt.Canvas
    def paint(g)
		# draw the rectangle
		g.setColor(java.awt.Color::BLUE);
        g.fillRect($x, $y, $size, $size)

		# draw the obstacles
		g.setColor(java.awt.Color::RED);
		for i in 0..4 do
			g.fillRect($obstacles_x[i], $obstacles_y[i], $range, $range)
		end
    end
end


# create the main panel
pane = JPanel.new();

# create a new canvas
$maToile  = Toile.new();
$maToile.setPreferredSize(java.awt.Dimension.new(1024, 600))

# Add this canvas to the main panel
pane.add($maToile)

# create 5 buttons
up = JButton.new("UP");
down = JButton.new("DOWN");
left = JButton.new("LEFT");
right = JButton.new("RIGHT");
undo = JButton.new("UNDO");

# Bind these buttons to a listener
up.addActionListener(MyAction.new)
down.addActionListener(MyAction.new)
left.addActionListener(MyAction.new)
right.addActionListener(MyAction.new)
undo.addActionListener(MyAction.new)

# Add them to the main panel
pane.add(down)
pane.add(left)
pane.add(right)
pane.add(up)
pane.add(undo)

# Create the window
fenetre  = JFrame.new("Window")
fenetre.setContentPane(pane)
fenetre.setVisible(true)
fenetre.setSize(1024, 720)
fenetre.setLocation(0,0)
fenetre.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE)
