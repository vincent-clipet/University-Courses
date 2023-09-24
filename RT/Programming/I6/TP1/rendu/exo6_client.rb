require 'socket'


client = TCPSocket.open("127.0.0.1", 7777);

x = y = r = ""

while (x != "stop" && y != "stop") do
	puts ("X ? : ")
	x = gets.chomp();
	puts ("Y ? : ")
	y = gets.chomp();
	puts ("Rayon ? : ")
	r = gets.chomp();

	if (x == "" || x == nil)
		x = y = 400;
	end
	
	client.puts(x);
	client.puts(y);
	client.puts(r)
end

client.close();
