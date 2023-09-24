class Horloge

  # ========== PROPERTIES ==========

  @h; @m;



  # ========== CONSTRUCTOR ==========
  def initialize(heures, minutes)
    @h = heures;
    @m = minutes;
  end



  # ========== METHODS ==========

  def to_s
    return @h.to_s + "h" + @m.to_s
  end

  

  def avancer

    @m+=1

    if (@m == 60)
      @m = 0
      @h+=1
    else
      return
    end

    if (@h == 24)
      @h = 0
    end
    # ==============================

  end
end