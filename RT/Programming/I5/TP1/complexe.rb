# To change this template, choose Tools | Templates
# and open the template in the editor.

class Complexe

  # =========== PROPERTIES ==========

  @r;
  @i;



  # =========== CONSTRUCTOR ==========

  def initialize(real, imaginary)
    @r = real
    @i = imaginary
  end



  # =========== METHODS ==========

  def to_s
    return @r.to_s + " + " + @i.to_s + "i"
  end



  # Multiply -----

  def *(var)
    multiply(var, true)
  end

  def /(var)
    multiply(var, false)
  end

  def multiply(var, multiply)
    if (var.class() == Complexe)
      if (multiply)
        a = @r * var.getR() - @i * var.getI()
        b = @r * var.getI() - @i * var.getR()
        return Complexe.new(a, b)
      else
        a = @r / var.getR() - @i / var.getI()
        b = @r / var.getI() - @i / var.getR()
        return Complexe.new(a, b)
      end
    else
      if (multiply)
        return multiply(Complexe.new(var, 1), true)
      else
        return multiply(Complexe.new(var, 1), false)
      end
    end
  end



  # Add -----

  def +(var)
    add(var, true)
  end

  def -(var)
    add(var, false)
  end

  def add(var, add)
    if (var.class() == Complexe)
      if (add)
        return Complexe.new(var.getR() + @r, var.getI() + @i)
      else
        return Complexe.new(var.getR() - @r, var.getI() - @i)
      end
    else
      if (add)
        return Complexe.new(var + @r, @i)
      else
        return Complexe.new(var - @r, @i)
      end
    end
  end


  # Pow -----

  def **(var)
    if (var.class() == Complexe)
      return Complexe.new(@r ** var, @i ** var)
    else
      if (var == 1)
        return self;
      elsif (var > 1)
        self**(var - 1)
      end
    end
  end



  # =========== GET & SET ==========

  def getR()
    return @r
  end
  def setR(val)
    @r = val
  end
  def getI()
    return @i
  end
  def setI(val)
    @i = val
  end



  # ================================

end
