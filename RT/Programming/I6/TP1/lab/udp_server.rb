require 'socket'

server = UDPSocket.open();
server.bind("0.0.0.0", 1234);

text = server.recvfrom(100, 0);

while (text[0] != "stop") do
  puts text[1][3] + " > " + text[0].to_s
  text = server.recvfrom(100, 0);
end

server.close();
exit();