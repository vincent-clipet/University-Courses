# === Imports ==========

require 'socket'



# === Main ===========

client = TCPSocket.open("127.0.0.1", 7778);

puts ("Enter value : ")
name = gets.chomp();

while (true) do
  client.puts(name);
  name = gets.chomp();
end

client.close();