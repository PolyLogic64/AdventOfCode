
Input = File.new("input.txt").read

def part01(input)
    counter = 0
    input.each_char do |char|
        counter += 1 if char == "("
        counter -= 1 if char == ")"
    end
    return counter
end

def part02(input)
    counter = 0
    input.length.times do |index|
        counter += 1 if input[index] == "("
        counter -= 1 if input[index] == ")"
        return index + 1 if counter < 0
    end
    return counter
end

puts "Part01: #{part01(Input)}"
puts "Part02: #{part02(Input)}"