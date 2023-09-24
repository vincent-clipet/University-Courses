require "socket"

# Creating the socket
broadcaster = UDPSocket.open();
# Set the socket to mode UDP
broadcaster.setsockopt(Socket::SOL_SOCKET,Socket::SO_BROADCAST, true);
# Bind the socket to an IP address & a port
broadcaster.bind("127.0.0.1", 1234); # !!! Doesn't work !!!
broadcaster.send("Server Online", 0)


# Waiting the first message
received = broadcaster.recvfrom(100,0)


while (received[0] != "/stop") do
	puts received[1][3] + " > " + received[0];
	broadcaster.send(received[1][3] + " > " + received[0], 0);
	# Wait for the next message to be received
	received = broadcaster.recvfrom(100,0)
end


# Close the socket
broadcaster.close();
