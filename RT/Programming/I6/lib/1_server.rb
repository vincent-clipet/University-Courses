# === Imports ==========

require 'java'
require 'socket'

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;



# === Methods ==========

def setLayout(i)
  if (i.to_i() == 2)
    $panel.setLayout(BoxLayout.new($panel, BoxLayout::X_AXIS));
  elsif (i.to_i() == 3)
    $panel.setLayout(GridLayout.new(4, 5));
  else

  end
end



# === Frame ==========

$panel = JPanel.new();
#label = JLabel.new("Label");
#button = JButton.new("clic");
frame = JFrame.new("Frame");

#$panel.add(label);
#$panel.add(button);

frame.setContentPane($panel);
frame.setSize(400, 400);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE)



# === Global ==========

$x = $y = 400;
$r = 200;



# === 2nd thread ==========

#t = Thread.new do
server = TCPServer.open(7777);
session = server.accept();

layout = session.gets().chomp();
setLayout(layout);

name = session.gets().chomp();
while (name != "" && name != nil) do
  $panel.add(JButton.new(name));
  $panel.revalidate();
  name = session.gets().chomp();
end
#end



# === Main thread ==========

#while (true) do
	
#end



# === Close ==========

session.close();
server.close();