puts " "," "

f = File.open("notes_1","r")
nb_notes_max=f.gets.to_i  # Nb notes

a=0

for i in 0..nb_notes_max do

	a=a+f.gets.to_i

end

puts a/nb_notes_max.to_f

puts " "," "
