$n = 5
$a = Array.new($n)
$a2 = Array.new($n)
$threads = Array.new($n)

for i in 0..($n - 1) do
	$a[i] = Array.new($n)
	$a2[i] = Array.new($n)
	$threads[i] = Array.new($n)

	for j in 0..($n - 1) do
		$a[i][j] = i + j
		$a2[i][j] = 0
		$threads[i][j] = 0
	end
end

def calc(i, j)
	$a2[i][j] = 0

	printArray($threads)

	# calc
	for k in 0..($n - 1) do
		$threads[i][j] = Thread.new do
			$a2[i][j] = $a2[i][j] + $a[i][k] * $a[k][j]
			sleep(0.01)
		end
	end

	# join threads
	sleep(10)
	for y in 0..($n - 1) do
		for x in 0..($n - 1) do
			($threads[y][x]).join();
		end
	end
end

def calcLigne(i)
	for j in 0..($n - 1) do
		calc(i, j)
	end
end

def printArray(a)
	
	maxSize = (a[a.length - 1][(a[0]).length - 1].to_s()).length

	for y in 0..(a.length - 1) do
		for x in 0..(a.length - 1) do
			toAdd = " " * (maxSize - (a[y][x]).to_s().length)
			print toAdd + (a[y][x]).to_s + " "
		end
		puts
	end
end

before = Time.now

for i in 0..($n - 1) do
	calcLigne(i)
end

after = Time.now
duration = after - before;
puts 

puts "========="
puts "Duration : " + duration.to_s() + "s"
puts
puts "-------------- $a ----------------"
printArray($a)
puts

puts "-------------- $a2 ---------------"
printArray($a2)
puts
puts
