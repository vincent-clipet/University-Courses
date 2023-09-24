file = File.open("data_fournisseurs.csv", "w")

for i in 1..ARGV[0].to_i
	req = "" + i.to_s + ";user" + i.to_s + ";ville" + i.to_s + "\n"
	file.write(req)
end

file.close
