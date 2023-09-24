require 'socket'

host = "";
port = 1234
bomb = "Coucou ! " * 10000;


server = TCPSocket.new(host, port);
server.puts(bomb);
