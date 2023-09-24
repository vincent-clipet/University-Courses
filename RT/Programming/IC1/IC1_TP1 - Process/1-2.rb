Signal.trap("SIGINT") do
	puts "sigint"
end

sleep(5)
