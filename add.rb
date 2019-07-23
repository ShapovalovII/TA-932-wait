address = "0.10.12.1.0.2.0.7.1.0.0.0.0.0.2.0"

array = address.split(".")
for i in array
  print "/*[#{i.to_i + 1}]"
end

print "\n"