require 'socket'

client = UDPSocket.new();
client.setsockopt(Socket::SOL_SOCKET, Socket::SO_BROADCAST, true)
client.connect("127.0.0.255", 1234)

text = "";
while (text != "stop")
  text = gets.chomp();
  client.send(text, 0)
end

client.close();