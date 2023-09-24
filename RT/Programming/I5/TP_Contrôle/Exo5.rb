# Imports

require "java"
import javax.swing.JFrame;
import java.awt.Color;


# Classes

class Rectangle

    # Attributes

    @x;
    @y;



    # Constructor

    def initialize(x1, y1, otherRectangle)
        @x = x1;
        @y = y1;

	# 'nil' means that this is the first Rectangle to be created,
	# so we don't need to check if it is collided with another Rectangle.
	# Otherwise, we have to check both Rectangle positions to avoid collision.

	if (otherRectangle != nil)
	    if (isCollidedWith(otherRectangle))
		moveToAvoidCollision(otherRectangle)
	    end
	end
    end



    # Get & Set

    def getX()
	return @x;
    end

    def getY()
	return @y;
    end



    # Methods

    def isCollidedWith(otherRectangle)
	# Check each border to see if they are contained in 'otherRectangle'.
	if (
		isPointInside(otherRectangle.getX(), otherRectangle.getY()) || # Top-left
		isPointInside(otherRectangle.getX() + 50, otherRectangle.getY()) || # Top-Right
		isPointInside(otherRectangle.getX(), otherRectangle.getY() + 50) || # Bottom-left
		isPointInside(otherRectangle.getX() + 50, otherRectangle.getY() + 50) # Bottom-right
	   )
	    return true;
	end
	return false;
    end

    def isPointInside(x, y)
        if (
	    x > @x &&
	    x <= @x + 50 &&
	    y > @y &&
	    y <= @y + 50
	   )
                return true
        end
	return false
    end

    def draw(g)
        g.fillRect(@x, @y, 50, 50);
    end

    def move(x, y)
	@x = x;
	@y = y;
    end

    def moveToAvoidCollision(otherRectangle)

        # Let's choose which Rectangle to move.
	# We'll move the Rectangle which is the furthest on the right even more to the right,
	# in order to 'un-stick' them.
	
	if (@x < otherRectangle.getX()) # We'll move 'otherRectangle' to the right.
	    deltaX = otherRectangle.getX() - @x;
	    otherRectangle.move(otherRectangle.getX() + (50 - deltaX), otherRectangle.getY());
	else # We'll move this current Rectangle to the right.
	    deltaX = @x - otherRectangle.getX();
	    move(@x + (50 - deltaX), @y);
	end
    end

end



class Toile<java.awt.Canvas
    def paint(g)
	g.setColor(Color::BLUE)
        $a.draw(g)
	g.setColor(Color::RED)
	$b.draw(g)
    end
end



# -------------------------------

# Tests

maToile = Toile.new()
maToile.setPreferredSize(java.awt.Dimension.new(400, 300))
frame = JFrame.new("Exo 5 - 2 Rectangles");
frame.getContentPane().add(maToile)
frame.setSize(400, 300);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);

$a = Rectangle.new(100, 100, nil)
$b = Rectangle.new(110, 110, $a)
