# === Imports ==========

require 'java'
require 'socket'

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;



# === Classes ==========

class MyAction

  include java.awt.event.ActionListener;

  def actionPerformed(event)
    $mustMove = (event.getSource() == $button);
    puts $mustMove;
  end
end



# === Methods ==========

def move(a, midX, midY, r)
  $frame.setLocation(midX + r * Math.cos(a), midY + r * Math.sin(a))
end



# === Frame ==========

$panel = JPanel.new();
$label = JLabel.new("Label");
$button = JButton.new("Move");
$frame = JFrame.new("Frame");

$panel.add($label);
$panel.add($button);

$frame.setContentPane($panel);
$frame.setSize(200, 200);
$frame.setLocation(400, 400);
$frame.setVisible(true);
$frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE)



# === Listeners ==========

$button.addActionListener(MyAction.new());



# === Global ==========

$r = 200;
$x = $y = 400;
$mustMove = false;



# === 2nd thread ==========

t = Thread.new do
	server = TCPServer.open(7777);
	session = server.accept();

	r = session.gets().chomp().to_f();
  $mustMove = true;

	session.close();
  server.close();
end



# === Main thread ==========

full = (2 * Math::PI).to_f;

while (true) do
  if ($mustMove)
    for i in (0..full).step(full / 100) do
      move(i, $x, $y, $r);
      sleep(0.05);
    end
  end
end