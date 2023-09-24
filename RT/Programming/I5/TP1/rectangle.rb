class Rectangle

  # =========== PROPERTIES ==========

  @posX1; @posY1;
  @posX2; @posY2;

  @screen



  # =========== CONSTRUCTOR ==========

  def initialize(posX1, posY1, posX2, posY2, frameW, frameH)
    @screen = Array.new()
    @posX1 = posX1;
    @posY1 = posY1;
    @posX2 = posX2;
    @posY2 = posY2;

    @screen = Array.new(frameW) {|i| Array.new(frameH) {|j| '.'} }
    setFrame(frameW, frameH)
    drawMovingRectangle()
  end

  #def initialize(posX1, posY1, posX2, posY2)
  #new(posX1, posY1, posX2, posY2, 50, 10)
  #end



  # =========== METHODS ==========

  #private :setFrame
  def setFrame(width, height)

    for i in 0..width-1
      @screen[i][0] = @screen[i][height-1] = '*'
    end

    for i in 0..height-1
      @screen[0][i] = @screen[width-1][i] = '*'
    end
    
  end


  def addObstacle(x, y)
    @screen[x][y] = 'X'
  end
  

  def move(x, y)

    # Pre-calculation (Hitbox)
    for i in @posX1+x..@posX2+x
      for j in @posY1+y..@posY2+y
        if (@screen[i][j] == 'X' || @screen[i][j] == '*') # Collision
          puts "Collision"
          return true;
        end
      end
    end

    # Delete
    for i in @posX1..@posX2
      for j in @posY1..@posY2
        @screen[i][j] = '.'
      end
    end

    

    @posX1 += x;
    @posY1 += y;
    @posX2 += x;
    @posY2 += y;

    # Redraw
    drawMovingRectangle()

    return false;
  end

  def drawMovingRectangle()
    for i in @posX1..@posX2
      for j in @posY1..@posY2
        @screen[i][j] = 'o'
      end
    end
  end

  def update()
    puts
    iter = 0;
    for j in 0..(@screen[iter].size()-1)   # 0 -> 9
      puts
      for i in 0..(@screen.size()-1)   # 0 -> 49
        print @screen[i][j]
      end
      iter += 1
    end
    puts
  end



  # =========== GET & SET ==========



  

  # ================================

end
