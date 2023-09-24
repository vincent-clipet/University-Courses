require 'socket'

server = TCPServer.open(2345);

text = "";
session = server.accept();

text = session.gets();

while (text != "stop") do
  session.puts("OK");
  puts text.length().to_s + " > " + text.to_s
  text = session.gets();
end
session.puts("Bye !")
session.close();
server.close()