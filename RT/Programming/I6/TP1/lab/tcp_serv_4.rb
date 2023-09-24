require 'socket'

# ===== METHODS =====
  
def recv()
  text = $session.gets();
  while (text.include?("switch")) do
    if (text.include?("stop"))
      return true;
    end
    puts("< " + text);
    text = $session.gets();
  end
  $mode = false;
end


def send()
  text = gets().chomp();
  while (text.include?("switch")) do
    if (text.include?("stop"))
      return true;
    end
    puts "> " + text;
    $client.puts(text);
    text = gets().chomp();
  end
  $mode = true;
end



def choose()
  choice = -1;
  puts ("=================================")
  puts ("Mode : ")
  puts ("1) Recv")
  puts ("2) Send")
  puts (" ? ")
  puts ("=================================")
  choice = gets.chomp().to_i;

  $mode;
  if (choice == 1)
    $mode = false;
  elsif (choice == 2)
    $mode = true;
  else
    choose();
  end
end







# ===== MAIN =====

server = TCPServer.open(2345);
$client = TCPSocket.open("127.0.0.1", 2345);
$session = $server.accept();

choose();


todo = false;
while (!todo)
  todo = false;
  if ($mode)
    todo = recv()
  else
    todo = send()
  end
end

$session.close();
$client.close();
$server.close();