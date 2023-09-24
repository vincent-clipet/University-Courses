require 'java'
import javax.swing.JFrame;

$window = JFrame.new("Bonjour");
$window.setSize(200, 200);
$window.setVisible(true);
$window.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);

sens = 1;

Signal.trap("SIGINT") do
	puts("sens changé")
	sens = -sens;
end

i = 1;

while (true) do
	x = 300 + (50 * Math.sin(i * Math::PI / 180.0))
	y = 300 + (50 * Math.cos(i * Math::PI / 180.0))
	$window.setLocation(x, y);
	sleep(0.02)
	i = i + sens;
	puts("i = " + i.to_s())
end
