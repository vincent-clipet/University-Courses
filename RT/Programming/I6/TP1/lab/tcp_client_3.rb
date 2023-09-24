require 'socket'

client = TCPSocket.open("127.0.0.1", 2345);
file = File.open("C:\\Users\\F4E\\Desktop\\tp\\send.txt", 'r')

text = file.gets();

while (text != nil && text != "stop") do
  sleep(0.3);
  text = text.chomp();
  puts "> " + text;
  client.puts(text);
  text = file.gets(text);
end

file.close();
client.close();