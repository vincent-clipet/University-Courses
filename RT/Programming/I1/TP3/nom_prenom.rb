

print "prenom ? "
prenom=gets.chomp
	
print "nom ? "
	nom=gets.chomp
	
print "sexe (m ou f)	 ? "
sexe=gets.chomp
	

puts " "
print "Bonjour "	
	
	
if sexe=="M" || sexe=="m" then
		print "Monsieur "
elsif sexe=="F" || sexe="f" then
		print "Madame "
end



puts prenom + " " + nom







