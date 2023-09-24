puts " " 


puts "Départ de l'intervalle"
a=gets.chomp.to_i

puts "Fin de l'intervalle"
b=gets.chomp.to_i

for i in a..b do
	if i==b then
		print i.to_s
	elsif i!=b then
		print i.to_s + ", "
	end
end
puts " "
