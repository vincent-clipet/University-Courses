require 'socket'

client = TCPSocket.open("127.0.0.1", 2345);
text = gets().chomp!();

while (text != "stop") do
  puts "> " + text;
  client.puts(text);
  text = gets().chomp();
end