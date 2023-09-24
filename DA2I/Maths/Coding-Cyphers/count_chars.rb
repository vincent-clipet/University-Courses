if (ARGV == nil || ARGV[0] == nil)
	exit
end

count = Array.new(256, 0)
f = File.open(ARGV[0].to_s, "r")

f.each_line do |line|
	line.each_byte do |b|
		count[b] = count[b] + 1
	end
end

f.close

for i in 0...256 do
	if (count[i] > 0) then
		puts "#{i} | #{i.chr} | + #{count[i]}"
	end
end
