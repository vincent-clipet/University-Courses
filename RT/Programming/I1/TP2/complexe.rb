puts " "," "

	print "partie réelle ? : "
	r=gets.chomp.to_f
puts
	print "partie imaginaire ? : "
	i=gets.chomp.to_f

# -----------

# m=Math.sqrt(r**2+i**2)
	m=Complex.abs(r,i)




# arg=(Math





# -----------

puts
	print "Module = " + m.to_s
puts
#	print "Argument = " + a


puts " "," "
