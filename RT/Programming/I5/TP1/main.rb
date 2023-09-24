# ---------- HORLOGE ----------

=begin
require "Horloge"

monHorloge = Horloge.new(2, 59)
puts "Il est : "
puts monHorloge
for i in 1..60 do
  monHorloge.avancer()
end
puts "60 minutes sont passees. Il est : "
puts monHorloge
for i in 1..1440 do
  monHorloge.avancer()
end
puts "Une journee est passee. Il est : "
puts monHorloge
=end



# ---------- COMPLEX ----------
=begin
require "Complexe"

c1 = Complexe.new(2, 3 )
c2 = Complexe.new(4, 2 )
c3 = Complexe.new(4, 5 )
puts c1*2
puts (c1 + c2)
puts (c1 + c2 - 1)
puts (c1 + c2 - 1) * (c3 + 1)
puts (c1 - c2 + 3)
puts ((c1 - c2 + 3) ** 4)
puts ((c1 - c2 + 3) ** 4) / 2.0
=end



=begin
# ---------- StringTokenizer ----------

require "Proposition"

p = Proposition.new("abc azerty gsdjhsdhzkjdjz")
puts p.getNumberOfWords()
puts p.getLongestWord()
=end





# ---------- Rectangle ----------




require "Rectangle"

rect = Rectangle.new(3,3, 7,7, 50,10)
rect.addObstacle(43, 4)
rect.update()

while (! rect.move(1, 0))
  rect.update()
  sleep(0.15)
end

while (! rect.move(0, 1))
  rect.update()
  sleep(0.2)
end


=begin
for i in 1..50
  rect.move(1,0)
  rect.update()
  sleep(0.2)
end

sleep(1)

for i in 1..10
  rect.move(0,-1);
  rect.update()
  sleep(0.2)
end
=end
