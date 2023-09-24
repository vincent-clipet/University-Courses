# ===== Methods =====

$a,$b,$c = nil;
$n,$p = nil;
$threads = nil;

def printArray(a,maxSize)
  
	puts
  puts "============================"
  puts

	if (maxSize == 0)
    maxSize = (a[a.length - 1][(a[0]).length - 1].to_s()).length
  end
  puts "MaxSize = " + maxSize.to_s()

	for y in 0..(a.length - 1) do
		for x in 0..(a[y].length - 1) do
			toAdd = " " * (maxSize - (a[y][x]).to_s().length);
			print toAdd + (a[y][x]).to_s + " ";
		end
		puts
	end

  puts
  puts "============================"
  puts
end

def printSimpleArray(a)
  
	puts
  puts "============================"
  puts

	for y in 0..(a.length - 1) do
		for x in 0..(a[y].length - 1) do
			print a[y][x].to_s + " ";
		end
		puts
	end

  puts
  puts "============================"
  puts
end


def initArrays()
  $a = Array.new($n)
  $b = Array.new($n)
  $c = Array.new($n)
  $threads = Array.new($n)

  for i in 0..($n - 1) do
    $a[i] = Array.new($n)
    $b[i] = Array.new($n)
    $c[i] = Array.new($n)

    for j in 0..($n - 1) do
      $a[i][j] = 0
      $b[i][j] = 0
      $c[i][j] = 0
    end
  end
end

def fillA()
  for i in 0..($n - 1) do
    for j in 0..($n - 1) do
      $a[i][j] = (i + j + 2) % $p
    end
  end
end

def fillB()
  for i in 0..($n - 1) do
    for j in 0..($n - 1) do
      $b[i][j] = i * j;
    end
  end
end

def fillC()
  for i in 0..($n - 1) do
      calcLineC(i);
  end
end

def calcLineC(i)
  $threads[i] = Thread.new() do
    for j in 0..($n - 1) do
      sleep(0.1)
      $c[i][j] = $a[i][j] + $b[i][j]
      #puts "" + $c[i][j].to_s() + " = " + $a[i][j].to_s() + " + " + $b[i][j].to_s();
    end
  end
end

def joinAllThread()
  for i in 0..$threads.length - 1 do
    $threads[i].join();
    #puts "Thread " + i.to_s() + " joined."
  end
end






# ===== Program =====


#$a
#$b
#$c
#$n
#$p


#puts "N = ?"
#$n = gets().chomp().to_i();
#puts "P = ?"
#$p = gets().chomp().to_i();
$n = 10;
$p = 15;

puts;

initArrays();
fillA();
fillB();

before = Time.now;
fillC();
joinAllThread();
after = Time.now;
duration = after - before;

printArray($a,2);
printArray($b,2);
printArray($c,2);
puts "Durée : " + duration.to_s();