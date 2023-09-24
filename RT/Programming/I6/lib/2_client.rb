# === Imports ==========

require 'socket'



# === Main ===========

client = TCPSocket.open("127.0.0.1", 7777);

puts ("Press any key to move : ")
client.puts(gets.chomp());

client.close();