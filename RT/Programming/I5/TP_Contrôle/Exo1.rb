# Imports 

require "java"
import java.util.StringTokenizer



# Classes

class Phrase
	
	# Attributes
	@s;

	# Constructor
	def initialize(s)
		@s = s;
	end

	# Methods
	def to_s()
		st = StringTokenizer.new(@s, ".!?");
		while st.hasMoreTokens() do
			puts st.nextToken();
		end
	end

end



# -------------------------------------

# Tests

p = Phrase.new("Il fait beau! Il pleut. Abc");
puts p.to_s();
