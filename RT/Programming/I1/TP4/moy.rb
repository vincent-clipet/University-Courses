puts "nb de notes ? "
	a=gets.chomp.to_i

somme=0
for i in 1..a do
	if i!=a then
		print "Note n° " + i.to_s + " ? "
		note=gets.chomp.to_i
		somme=note+somme
	elsif i==a then
		print "Note n° " + i.to_s + " ? "
		note=gets.chomp.to_i
		somme=note+somme		
		print "moyenne = " + ((somme/a).to_f).to_s
	end
end
