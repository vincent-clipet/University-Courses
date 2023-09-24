require 'vector2_d'
import java.awt.Canvas;



# === Classes ==========

class Toile<Canvas

  @a; @midX; @midY; @r;

  def init(a, x, y, r)
    @a = a;
    @midX = x;
    @midY = y;
    @r = r;
  end

  def paint(g)
    puts "test 2"
    a = createVector(0);
    b = createVector(1);
    c = createVector(2);

    addLine(g, a, b);
    addLine(g, b, c);
    addLine(g, c, a);

    tmpVector = Vector2D.new(@midX, @midY - @r);

    addLine(g, a, tmpVector);
    addLine(g, b, tmpVector);
    addLine(g, c, tmpVector);
  end

  

  # Methods

  def createVector(i)
    return Vector2D.new((@midX - @r * Math.sin(a * 0.1 + 2.09 * i)), (@midY - @r * Math.cos(a * 0.1 + 2.09 * i) * 0.5))
  end

  def addLine(g, v1, v2)
    g.drawLine(v1.getX(), v1.getY(), v2.getX(), v2.getY())
  end



  # Get & Set

  def getAngle()
    return @a;
  end

  def setAngle(a)
    @a = a;
  end

  def getMidX()
    return @midX;
  end

  def setMidX(x)
    @midX = x;
  end

  def getMidY()
    return @midY;
  end

  def setMidY(y)
    @midY = y;
  end

  def getR()
    return @r;
  end

  def setR(r)
    @r = r;
  end

end
