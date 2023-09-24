puts " "

puts "Table de . ? "
a=gets.chomp.to_i
b=0
c=10

puts "Table de multiplication par " + a.to_s

for i in b..c do
	d=i*a
	puts i.to_s + " x " + a.to_s + " = " + d.to_s
end

puts " "
