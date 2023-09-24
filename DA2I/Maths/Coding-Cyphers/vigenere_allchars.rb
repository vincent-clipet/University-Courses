puts
if (ARGV == nil || ARGV[0] == nil || ARGV[1] == nil)
	exit
end



f = File.open(ARGV[0].to_s, "r")

shiftLength = ARGV[1].length
shifter = 0
shifts = Array.new()

for i in (0...shiftLength) do
	if ARGV[2] == "-" then
		shifts[i] = - (ARGV[1][i]).ord + 97
	else
		shifts[i] = (ARGV[1][i]).ord - 97
	end
end

f.each_char do |char|
	newLetter = ((char.ord + shifts[shifter % shiftLength]) % 255).chr
	print newLetter
	shifter += 1
end

puts
f.close
