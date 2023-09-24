if (ARGV == nil || ARGV[0] == nil || ARGV[1] == nil)
	exit
end

puts
f = File.open(ARGV[0].to_s, "r")

shifting = (ARGV[1]).ord - 97

if ARGV[2] == "-" then
	shifting *= -1
end


f.each_char do |char|
	newLetterIndex = (char.ord + shifting) % 255
	newLetter = newLetterIndex.chr
	print newLetter
end

puts
f.close
