if (ARGV == nil || ARGV[0] == nil || ARGV[1] == nil)
	exit
end

puts
ret = Array.new
f = File.open(ARGV[0].to_s, "r")

shifting = (ARGV[1]).ord - 97

if ARGV[2] == "-" then
	f.each_line do |line|
	
		for i in 0...(line.length) do
			letter = line[i]
			newLetterIndex = (letter.ord - shifting) % 255
			newLetter = newLetterIndex.chr
			print newLetter
		end
		puts
	end
else
	f.each_line do |line|
	
		for i in 0...(line.length) do
			letter = line[i]
			newLetterIndex = (letter.ord + shifting) % 255
			newLetter = newLetterIndex.chr
			print newLetter
		end
		puts
	end
end
f.close
