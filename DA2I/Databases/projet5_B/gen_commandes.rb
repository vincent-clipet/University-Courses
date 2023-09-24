file = File.open("data_commandes.csv", "w")

for i in 1..ARGV[0].to_i
	req = "" + i.to_s + ";" + (rand(10000) + 1).to_s + ";" + (rand(1000) + 1).to_s + ";" + (rand(100) + 1).to_s + "\n"
	file.write(req)
end

file.close
