require 'java'
require 'socket'



# ===== Frame =====

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

panel = JPanel.new();
label = JLabel.new("Label");
button = JButton.new("clic");
frame = JFrame.new("Frame");

panel.add(label);
panel.add(button);

frame.setContentPane(panel);
frame.setSize(200, 200);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE)







# ===== Socket =====



$x = $y = 400;
$r = 200;


t = Thread.new do
	server = TCPServer.open(7777);
	session = server.accept();
	x = y = r = "";
	while (x.chomp() != "stop" && y.chomp() != "stop") do
		x = session.gets();
		y = session.gets();
		r = session.gets();

		if (x.chomp() == "stop" || y.chomp() == "stop")
			break;
		else
			$x = x.to_i();
			$y = y.to_i();
			$r = r.to_i();
		end
	end
end



while (true) do
	full = (2 * Math::PI).to_f;
	for i in (0..full).step(full / 100) do
		#if ($x == "stop" || $y == "stop")
			#return
		#else
			x = $x + $r * Math.sin(i.to_f);
			y = $y + $r * Math.cos(i.to_f);
			frame.setLocation(x, y);
			sleep(0.05);
		#end
	end
end

# t.join

session.close();
server.close();
