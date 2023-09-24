require 'socket'

host = "";
port = 1234
bomb = "Coucou ! " * 10000;


sock = TCPSocket.new(host, port);
sock.puts(bomb);
sock.close();
