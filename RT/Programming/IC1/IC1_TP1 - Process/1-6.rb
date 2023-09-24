$n = 10
$a = Array.new($n)
$a2 = Array.new($n)

for i in 0..($n - 1) do
	$a[i] = Array.new($n)
	$a2[i] = Array.new($n

	for j in 0..($n - 1) do
		$a[i][j] = i + j
		$a2[i][j] = 0
	end
end

def calc(i, j)
	$a2[i][j] = 0
	
	for k in 0..($n - 1) do
		$a2[i][j] = $a2[i][j] + $a[i][k] * $a[k][j]
		sleep(0.01)
	end
end

def calcLigne(i)
	for j in 0..($n - 1) do
		calc(i, j)
	end
end

for i in 0..($n - 1) do
	calcLigne(i)
end

puts a
