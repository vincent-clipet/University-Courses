# Imports

require "java"
import javax.swing.JFrame;
import java.awt.Color;



# Classes

class Toile<java.awt.Canvas
    def paint(g)
	g.setColor(Color::ORANGE)
        g.drawOval(60, 85, 70, 20);
        g.drawOval(270, 85, 70, 20);
	g.setColor(Color::RED)
	g.drawOval(150, 180, 100, 35);
	g.setColor(Color::BLACK)
	g.drawRect(50, 75, 300, 150);
	g.drawString("Vincent Clipet", 150, 250)
    end
end




# -----------------------------

# Tests

maToile = Toile.new()
maToile.setPreferredSize(java.awt.Dimension.new(400, 300))
frame = JFrame.new("Exo 5 - 2 Rectangles");
frame.getContentPane().add(maToile)
frame.setSize(400, 300);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);

