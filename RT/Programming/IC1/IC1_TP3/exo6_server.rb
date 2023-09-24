require 'socket'

host = "localhost";
port = 1234
msg = "I'm a Web Server !"

server = TCPServer.open(host, port);

while (true) do
	session = server.accept();

	Thread.new do		
		line = session.gets()
		while (line.chomp == "") do
			puts "> " + line;
		end

		addrtype, ip, host, port = session.peeraddr();
		session.puts("HTTP/1.1 200 OK");
		session.puts("");
		session.puts("<html><body>")
		for i in 0..msg.length
			sleep(0.01);
			session.puts("<span style=\"font-size:"	+ (rand(30) + 8).to_s + "px\">" + msg[i..i] + "</span>");
		end
		session.puts("</body></html>");
		session.close();
	end
end

server.close();
