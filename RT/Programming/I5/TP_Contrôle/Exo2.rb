# Classes

class Modulo
  
  # Attributes
  
  @a;
  
  
  
  # Constructor
  
  def initialize(a)
    @a = a.to_i() % 10;
  end
  
  
  
  # Get & Set
  
  def getValue()
    return @a;
  end
  
  
  
  # Methods
  
  def +(var)
    #return @a % 10 + var.getValue() % 10
    return Modulo.new(@a + var.getValue())
  end
  
  def -(var)
    return Modulo.new(@a - var.getValue())
  end
  
  def *(var)
    return Modulo.new(@a * var.getValue())
  end
  
  def to_s() # Serialize
    puts @a.to_s()
  end
  
end




# -----------------------------

# Tests

c1 = Modulo.new(7);
c2 = Modulo.new(11);
c3 = c1 + c1 + c2;
c4 = (c3 + c2) * c1;
c5 = c4 - c3;


puts c1;
puts c2;
puts c3;
puts c4;
puts c5;

