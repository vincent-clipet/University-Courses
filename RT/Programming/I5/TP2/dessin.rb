require "java"

class Dessin<java.awt.Canvas

  # =========== PROPERTIES ==========



  # =========== CONSTRUCTOR ==========

  def initialize

  end



  # =========== METHODS ==========

  def paint(g)
    g.setXORMode(java.awt.Color.white)

    for i in 0..20 do
      g.fillRect(100 + i*10, 100, 100, 100)
      sleep(0.3)
      g.fillRect(100 + i*10, 100, 100, 100)
    end

  end



  # =========== GET & SET ==========



  # ================================

end




require "java"

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@width = 500;
@height = 300;
@posX = 900;
@posY = 500;

dessin = Dessin.new();
dessin.setPreferredSize(java.awt.Dimension.new(500,300)) # /!\

frame = JFrame.new("Window 1");
c = frame.getContentPane();

c.add(dessin);

frame.setLocationRelativeTo(nil);
frame.setSize(@width, @height);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);
frame.setLocation(@posX, @posY);

label = JLabel.new("Bonjour !");
c.add(label);

b1 = JButton.new("Test");
b1.setSize(100, 20);
b1.setLocation(75, 5);
label.add(b1);

#moveWindow(frame)

=begin
#def moveWindow(f)
  centerX = frame.getX() + frame.getWidth() / 2;
  centerY = frame.getY() + frame.getHeight() / 2;
  rayon = 30;

  while (true)
    for i in 0..(2 * Math::PI)
      i = i + Math::PI / 12.0
      sleep(0.100)
      frame.setLocation((centerX + rayon * Math.sin(i)).to_i(), (centerY + 30 * Math.cos(i)).to_i);
      frame.setVisible(true);
    end
  end
#end
=end