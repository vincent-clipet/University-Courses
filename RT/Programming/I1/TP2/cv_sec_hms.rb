puts
puts "----------------------------"
puts

	print "Nb de secondes ? : "
	a=gets.chomp.to_i

puts


# -------------------------


	b=a/60 # minutes >60
	c=a%60 # 


# ---

	d=b/60
	e=b%60

# ---

	f=d/24
	g=d%24


# -------------------------


puts

	print "Total : " + f.to_s + "j " + g.to_s + "h " + e.to_s  + "m " + c.to_s + "s"


puts
puts "----------------------------"
puts
