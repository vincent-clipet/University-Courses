# === Imports ==========

require 'java'
require 'vector2_d'
require 'socket'

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;


$moveSpeed = 2;
$rotationSpeed = 10;


# Listeners

class MyKey

  include java.awt.event.KeyListener;

  def keyPressed(event)
    input = event.getKeyCode() #.chr();
    puts input;
    if (input == 38)
      $toile.setMidY($toile.getMidY() - 5 * $moveSpeed);
    elsif (input == 37)
      $toile.setMidX($toile.getMidX() - 5 * $moveSpeed);
    elsif (input == 40)
      $toile.setMidY($toile.getMidY() + 5 * $moveSpeed);
    elsif (input == 39)
      $toile.setMidX($toile.getMidX() + 5 * $moveSpeed);
    elsif (input == 65)
      $toile.setAngle($toile.getAngle() - 0.1 * $rotationSpeed);
    elsif (input == 69)
      $toile.setAngle($toile.getAngle() + 0.1 * $rotationSpeed);
    end

    $toile.repaint();
  end

  def keyReleased(event)

  end
  def keyTyped(event)

  end

end



# === Classes ==========

class Toile<java.awt.Canvas

  @a; @midX; @midY; @r;

  def init(a, x, y, r)
    @a = a;
    @midX = x;
    @midY = y;
    @r = r;
  end

  def paint(g)
    a = createVector(0);
    b = createVector(1);
    c = createVector(2);

    addLine(g, a, b);
    addLine(g, b, c);
    addLine(g, c, a);

    tmpVector = Vector2D.new(@midX, @midY - @r);

    addLine(g, a, tmpVector);
    addLine(g, b, tmpVector);
    addLine(g, c, tmpVector);
  end



  # Methods

  def createVector(i)
    return Vector2D.new((@midX - @r * Math.sin(@a * 0.1 + 2.09 * i)), (@midY - @r * Math.cos(@a * 0.1 + 2.09 * i) * 0.5))
  end

  def addLine(g, v1, v2)
    g.drawLine(v1.getX(), v1.getY(), v2.getX(), v2.getY())
  end



  # Get & Set

  def getAngle()
    return @a;
  end

  def setAngle(a)
    @a = a;
  end

  def getMidX()
    return @midX;
  end

  def setMidX(x)
    @midX = x;
  end

  def getMidY()
    return @midY;
  end

  def setMidY(y)
    @midY = y;
  end

  def getR()
    return @r;
  end

  def setR(r)
    @r = r;
  end

end




# === Frame ==========

#$panel = JPanel.new();
$frame = JFrame.new("Frame");
$toile = Toile.new();
$toile.init(0, 200, 200, 50);
$toile.setPreferredSize(java.awt.Dimension.new(300,300));

#$label = JLabel.new("Commandes");
$frame.getContentPane().add($toile);
$toile.addKeyListener(MyKey.new());

#$frame.setContentPane($panel);
$frame.setSize(300, 300);
$frame.setVisible(true);
$frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);
$frame.setLocation(200,200);

$toile.requestFocus();



# Socket

#t = Thread.new do

server = TCPServer.open(7778);
session = server.accept();

while (true) do

  received = session.gets().chomp().to_s();
  value = received[1..received.length()].to_i();
  todo = received[0..0];

  if (todo == "a")
    $toile.setAngle(value);
  elsif (todo == "x")
    $toile.setMidX(value);
  elsif (todo == "y")
    $toile.setMidY(value);
  elsif (todo == "r")
    $toile.setR(value);
  else

  end

  $toile.repaint();

end

session.close();
server.close();

#end