require 'socket'

server = TCPServer.open(2345);

file = File.open("C:\\Users\\F4E\\Desktop\\tp\\recv.txt", 'w');

session = server.accept();
text = session.gets();

while (! text.include?("stop")) do
  puts " > " + text.to_s
  file.puts(text);
  text = session.gets();
end

session.close();
server.close();
file.close();