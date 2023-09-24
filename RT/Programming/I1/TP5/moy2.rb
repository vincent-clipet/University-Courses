puts " "," "

f = File.open("notes_2","r")
nb_notes_max=f.gets.to_i  # Nb notes

somme=0
nb_notes=nb_notes_max

for i in 0...nb_notes_max do

	b=f.gets.chomp
	
	if b.to_s=="a" || b.to_s=="A" then
		nb_notes=nb_notes-1
	else
        somme=somme+b.to_i
	end
end

puts somme
puts nb_notes

puts somme/nb_notes.to_f

puts " "," "
