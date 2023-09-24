# === Imports ==========

require 'java'
require 'socket'

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;



server = TCPServer.open(7779);
session = server.accept();




# Classes

class MyKey

  include java.awt.event.KeyListener;

  def keyPressed(event)
    input = event.getKeyCode() #.chr();

    if (input == 38) # z
      $session.puts("y")
      toPut = $session.gets().chomp();
      $label.setText(toPut);
    elsif (input == 37) # q

    elsif (input == 40) # s

    elsif (input == 39) # d

    elsif (input == 65) # a

    elsif (input == 69) # e

    else
      $label.setText("??????");
    end

    $label.revalidate();
  end

  def keyReleased(event)

  end
  def keyTyped(event)

  end
  
end



$panel = JPanel.new();
$frame = JFrame.new("Frame");

$label = JLabel.new("Commandes");
$label.addKeyListener(MyKey.new());
$panel.add($label);

$frame.setContentPane($panel);
$frame.setSize(300, 300);
$frame.setVisible(true);
$frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);
$frame.setLocation(200,200);

$label.requestFocus();



# Comm



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

  $panel.revalidate();

end

session.close();
server.close();