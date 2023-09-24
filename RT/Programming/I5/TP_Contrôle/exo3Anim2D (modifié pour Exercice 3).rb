class Rectangle
    @xObst;              #liste d'obstacles (les position x)
    @yObst;              #liste d'obstacles (les position y)
    @larg;               #largeur cadre de jeu
    @haut;               #hauteur
    @x1;                 #coordonnées du rectangle principal
    @y1;
    @x2;
    @y2;
    def initialize(x1,y1,x2,y2)
        @x1 = x1;
        @y1 = y1;
        @x2 = x2
        @y2 = y2
        @xObst = Array.new()
        @yObst = Array.new()
    end
    def setCadre(l,h)
        @larg = l
        @haut = h
    end
    def ajoutObstacle(x,y)
	@xObst<<x;
        @yObst<<y;
    end
	def pointInterieur (x,y, x1, y1, x2, y2)
        if ( (x<=x2) and (y<=y2) and (x>=x1) and (y>=y1) )
                return true
        end
		return false
	end
    def pointDuRectPrincipal(x,y)
		return pointInterieur(x,y,@x1,@y1,@x2,@y2)
    end
    def pointDansLeCadre(x,y)
        return pointInterieur(x,y,0,0,@larg,@haut)
    end
    def rectDansLeCadre()
        if (!pointDansLeCadre(@x1,@y1))
            return false
        end
        if (!pointDansLeCadre(@x2,@y2))
            return false
        end
        return true
    end
    def rectConflAvecObst()
        i = 0
        while (i<@xObst.length) do
            if (pointDuRectPrincipal(@xObst[i],@yObst[i]))
                return true
            end
            i+=1
        end
        return false
    end

    def obstacle(x,y)                        #renvoie "true" s'il y a un 
                                             #obstacle à la position x,y
        i = 0
        while (i<@xObst.length) do           #pour chaque obstacle
            if (x==@xObst[i] && y==@yObst[i])#vérifier si l'obstacle courant 
                return true                  #est situé à la position (x,y)
            end
            i+=1
        end

        return false
    end
    def afficher()
        for y in -1..@haut do
            for x in -1..@larg do
                if (obstacle(x,y))
                    print "#"
                elsif (!pointDansLeCadre(x,y))
                    print "*"
                elsif (pointDuRectPrincipal(x,y))
                    print "+"
                elsif
                    print " "
                end
            end
            puts ""
        end
    end

    def dessiner(g)
        g.fillRect(@x1,@y1,@x2-@x1,@y2-@y1)   
    end
    def depl(dirx, diry)
        @x1 = @x1 + dirx
        @y1 = @y1 + diry
        @x2 = @x2 + dirx
        @y2 = @y2 + diry
        if( rectConflAvecObst() || (!rectDansLeCadre()) )
            @x1 = @x1 - dirx
            @y1 = @y1 - diry
            @x2 = @x2 - dirx
            @y2 = @y2 - diry
            return false
        end
        return true
    end

    def getXObstacles()
	return @xObst;
    end

    def getYObstacles()
	return @yObst;
    end

end


require "java"
import javax.swing.JFrame
class Toile<java.awt.Canvas
    def paint(g)
        $monRectangle.dessiner(g)

	# ===================
	i = 0
	puts "test : " + $monRectangle.getXObstacles().to_s
	while (i < $monRectangle.getXObstacles().length) do
            g.fillRect($monRectangle.getXObstacles()[i], $monRectangle.getYObstacles()[i], 4, 4)
            i += 1
        end
	# ===================

        #x = [1,50, 20]
        #y = [10, 20, 40] 
        #g.drawPolygon(x.to_java(Java::int),y.to_java(Java::int),3) 
    end
end
maToile = Toile.new()
maToile.setPreferredSize(java.awt.Dimension.new(500,300))
                                               #ou bien votre taille de toile
frame = JFrame.new("Titre Frame");
frame.getContentPane().add(maToile)
frame.setSize(500,500);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame::EXIT_ON_CLOSE);


$monRectangle = Rectangle.new(100,100,150,150)#coordonnées rectangle
$monRectangle.setCadre(500,300)               #ou bien votre taille de toile
$monRectangle.ajoutObstacle(380,40)
$monRectangle.ajoutObstacle(400,120)

puts @xObst;
puts @yObst;

for i in 1..100
    $monRectangle.depl(3,0) 
    maToile.repaint()                        #repaint() appelle la méthode paint(g), 
                                             #de l'objet maToile, qui appelle ensuite
                                             #$monRectangle.dessiner(g)
    sleep(0.2)
end
for i in 1..100
    #puts i
    $monRectangle.depl(0,-5) 
    maToile.repaint()
    sleep(0.2)
end
