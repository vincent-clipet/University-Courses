require 'socket'

host = "localhost";
port = 1234

server = TCPServer.open(host, port);

$clients = 0;

while ($clients <= 5) do

  session = server.accept();

  Thread.new do
    $clients += 1
    cmd = session.gets().chomp();
    output = exec(cmd, "/");
    session.puts(output); # Doesn't work, don't know why
    puts output;
    session.close();
    $clients -= 1
  end

end

server.close();