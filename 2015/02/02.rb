
def part01(input)
    l, w, h = input
              .split("x")
              .map do |it| it.to_i end
              .sort
              .reverse
    
    return 2*l*w + 2*w*h + 2*h*l + w*h
end

def part02(input)
    l, w, h = input
              .split("x")
              .map do |it| it.to_i end
              .sort
              .reverse
    
    return w+w+h+h + l*w*h
end


File.open("input.txt") do |file|
    Inputs = file.readlines

    totalPaper = 0
    totalRibbon = 0
    Inputs.each do |input|
        totalPaper += part01(input)
        totalRibbon += part02(input)
    end
    puts "Part01: #{totalPaper}"
    puts "Part02: #{totalRibbon}"
end
