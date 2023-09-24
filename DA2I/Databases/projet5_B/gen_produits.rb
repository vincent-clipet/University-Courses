file = File.open("data_produits.csv", "w")

for i in 1..ARGV[0].to_i
	req = "" + i.to_s + ";libelle" + i.to_s + ";" + (rand(400) + 201).to_s + "\n"
	file.write(req)
end

file.close
