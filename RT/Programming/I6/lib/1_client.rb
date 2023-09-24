# IMPORTS
require 'socket'


# MAIN
client = TCPSocket.open("127.0.0.1", 7777);

puts ("Layout ? : ")
layout = gets.chomp();

if (layout == nil)
  layout = 1;
else
  layout = layout.to_i();
end

client.puts(layout);

name = " "
while (name != "" && name != nil) do
	name = gets.chomp();
	client.puts(name);
end

client.close();