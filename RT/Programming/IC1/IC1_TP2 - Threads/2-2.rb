
# ========================================




$n = ARGV[0].to_i
$multiThreads = (ARGV[1] == "true") ? true : false

$a = Array.new($n)
$a2 = Array.new($n)
$threads = Array.new($n)
$threads2 = Array.new($n)

for i in 0..($n - 1) do
	$a[i] = Array.new($n)
	$a2[i] = Array.new($n)
	$threads[i] = Array.new($n)

	for j in 0..($n - 1) do
		$a[i][j] = i + j
		$a2[i][j] = 0
		$threads[i][j] = 0
		$threads2[i] = 0
	end
end



# ========================================

def calc(i, j)
	$a2[i][j] = 0

	for k in 0..($n - 1) do
		$a2[i][j] = $a2[i][j] + $a[i][k] * $a[k][j]
	end
end

def calcLigne(i)
	for j in 0..($n - 1) do
		$threads2[i] = Thread.new do
			calcLigneThreaded(i, j)
		end
	end
end


def calcLigneThreaded(i, j)
	if ($multiThreads) then
		$threads[i][j] = Thread.new do
			calc(i, j)
			sleep(0.01)
		end
	else
		calc(i, j)
		sleep(0.01)
	end
end

def printArray(a)
	
	maxSize = (a[a.length - 1][(a[0]).length - 1].to_s()).length

	for y in 0..(a.length - 1) do
		for x in 0..(a[y].length - 1) do
			toAdd = " " * (maxSize - (a[y][x]).to_s().length)
			print toAdd + (a[y][x]).to_s + " "
		end
		puts
	end
end





# ========================================

before = Time.now

# calc
for i in 0..($n - 1) do
	calcLigne(i)
end

# join threads
if ($multiThreads)
	for y in 0..($n - 1) do
		$threads[y].join();
		
		for x in 0..($n - 1) do
			($threads[y][x]).join();
		end
	end
end

after = Time.now
duration = after - before;



# ========================================

puts 

puts "========================"
puts "| Multi-Thread : " + $multiThreads.to_s
puts "| n = " + $n.to_s
puts "| Duration : " + duration.to_s() + "s"
puts "========================"
puts
#puts "-------------- $a ----------------"
#printArray($a)
#puts

puts "-------------- $a2 ---------------"
printArray($a2)
puts
puts
