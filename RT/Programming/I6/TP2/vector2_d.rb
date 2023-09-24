class Vector2D

  # =========== PROPERTIES ==========

  @x; @y;


  # =========== CONSTRUCTOR ==========

  def initialize(x, y)
    @x = x;
    @y = y;
  end



  # =========== METHODS ==========



  # =========== GET & SET ==========

  def getX()
    return @x.to_i();
  end

  def getY()
    return @y.to_i();
  end

  def setX(x)
    @x = x;
  end

  def setY(y)
    @y = y;
  end


  # ================================

end
