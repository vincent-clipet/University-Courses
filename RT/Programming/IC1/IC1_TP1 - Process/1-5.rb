puts "id process ?"
pid = gets.chomp().to_i();

Process.kill("TERM", pid)
