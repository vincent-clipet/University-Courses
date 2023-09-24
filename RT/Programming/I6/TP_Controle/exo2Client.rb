require "socket"

# Open the sockets
sock = UDPSocket.new();

# Bind the socket to an IP address & a port
sock.connect("127.0.0.1", 1234);

# Creating 2 vars containing text to send & text received
toSend = received = "";



# =====================
# === SENDER THREAD ===
# =====================

Thread.new do

	sock.send("New client", 0);
	toSend = gets().chomp();

	while (toSend != "/stop") do
		sock.send(toSend, 0);
		toSend = gets().chomp();
	end
end



# =======================
# === RECEIVER THREAD ===
# =======================

Thread.new do
	
	received = sock.recvfrom(100,0)

	while (received[0] != "/stop") do
		puts(received[1][3] + " > " + received[0])
		received = sock.recvfrom(100,0)
	end
end




# Closing the sockets
sock.close();
