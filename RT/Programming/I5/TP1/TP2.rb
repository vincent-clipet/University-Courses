require "Java"
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@width = 250;
@height = 200;
@posX = 900;
@posY = 500;


frame = JFrame.new("Window 1");
c = frame.getContentPane();

frame.setLocationRelativeTo(null);
frame.setSize(_width, _height);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);
frame.setLocation(_posX, _posY);

label = JLabel.new("Bonjour !");
c.add(label);

b1 = JButton.new("Test");
b1.setSize(100, 20);
b1.setLocation(75, 5);
label.add(b1);

move(frame);


def move(frame)

  centerX = frame.getX() + frame.getWidth() / 2;
  centerY = frame.getY() + frame.getHeight() / 2;
  rayon = 30;

  while (true)
    for i in 0..(2 * Math::PI)
      i = i + Math::PI / 12.0
      sleep(0.100)
      frame.setLocation((centerX + rayon * Math.sin(i)).to_i(), (centerY + 100 * Math.cos(i)).to_i);
      frame.setVisible(true);
    end
  end
end