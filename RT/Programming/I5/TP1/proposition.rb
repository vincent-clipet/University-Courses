require "java"
import java.util.StringTokenizer;

class Proposition

  # =========== PROPERTIES ==========

  @str;
  @token;


  # =========== CONSTRUCTOR ==========

  def initialize(s)
    @str = s
  end



  # =========== METHODS ==========

  def getNumberOfWords()
    return StringTokenizer.new(@str.to_s, " ").countTokens();
  end
  
  def getLongestWord()
    ret = "";
    token = StringTokenizer.new(@str.to_s, " ")
    while token.hasMoreTokens() do
      tmp = token.nextToken()
      if (tmp.length() > ret.length())
        ret = tmp;
      end
    end

    return ret
  end



  # =========== GET & SET ==========



  # ================================

end
