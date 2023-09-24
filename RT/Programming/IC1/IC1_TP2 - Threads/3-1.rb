require 'socket'
require 'sem.rb'


def broadcastSessions(msg)
	$sessions.each do |session|
  	session.puts(msg)
	end
end

$sem = Semaphore.new(3)

server = TCPServer.new(2000)
$sessions = Array.new()

loop do
  Thread.new do
		client = server.accept()
		$sem.down()
		addrtype, port, name, ip = client.peeraddr()
		$sessions << client

    streamIn = client.gets()
				
		msg = ip.to_s + " > " + streamIn		
		broadcastSessions(msg)
		puts(msg)

		$sem.up()

    client.close()
  end
end
