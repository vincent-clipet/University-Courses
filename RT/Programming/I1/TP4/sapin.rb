puts " "

puts "hauteur du sapin ? "
	sapin=gets.chomp
	
puts "hauteur du pied ? "
	pied=gets.chomp.to_i
	
x=sapin.to_i-pied.to_i
z=1

# ----

for i in 1..x do

	y=x-i
	lol="*"
	print " " * y
	puts lol * z
	z=(z+2).to_i

end



for j in 1..pied do
	w=x-2
	print " " * w
	puts "*" * 3
end

puts

puts "press ENTER"
gets.chomp

puts