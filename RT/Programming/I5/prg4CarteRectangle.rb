#voir classe Agenda
class Rect
    @xObst;
    @yObst;
    @larg;
    @haut;
    @x1;
    @y1;
    @x2;
    @y2;
    def initialize(_x1,_y1,_x2,_y2)
        @x1 = _x1;
        @y1 = _y1;
        @x2 = _x2
        @y2 = _y2
        @xObst = Array.new()
        @yObst = Array.new()
    end
    def setCadre(l,h)
        @larg = l
        @haut = h
    end
    def ajoutObstacle(x,y)
        @xObst<<x
        @yObst<<y
    end
	def pointint (x,y, x1, y1, x2, y2)
        if ( (x<=x2) and (y<=y2) and (x>=x1) and (y>=y1) )
                return true
        end
		return false
	end
    def dansLeRectangle(x,y)
		return pointint(x,y,@x1,@y1,@x2,@y2)
    end
    def obsRectConfl()
        i = 0
        while (i<@xObst.length) do
            if dansLeRectangle(@xObst[i],@yObst[i])
                return true
            end
            i+=1
        end
        return false
    end
    def obstacle(x,y)
        if !( (x<@larg)&&(y<@haut) && (x>=0) and (y>=0))
            return true
        end
        i = 0
        while (i<@xObst.length) do
            if (x==@xObst[i] && y==@yObst[i])
                return true
            end
            i+=1
        end

        return false
    end
    def rectConflict()
        if (obstacle(@x1,@y1))
            return true
        end
        if (obstacle(@x2,@y2))
            return true
        end
        return obsRectConfl()
    end
    def afficher()
        for y in -1..@haut do
            for x in -1..@larg do
                if (obstacle(x,y))
                    print "*"
                elsif (dansLeRectangle(x,y))
                    print "+"
                elsif
                    print " "
                end
            end
            puts ""
        end
    end
    def depl(dirx, diry)
        @x1 = @x1 + dirx
        @y1 = @y1 + diry
        @x2 = @x2 + dirx
        @y2 = @y2 + diry
        if(rectConflict())
            @x1 = @x1 - dirx
            @y1 = @y1 - diry
            @x2 = @x2 - dirx
            @y2 = @y2 - diry
            return false
        end
        return true
    end
end

monRect = Rect.new(3,3, 7,7)
monRect.setCadre(50,10)
monRect.ajoutObstacle(47,1)
monRect.ajoutObstacle(48,5)
monRect.afficher()
for i in 1..100
    monRect.depl(1,0)
end
monRect.afficher
for i in 1..100
    monRect.depl(0,-1)
end
monRect.afficher
