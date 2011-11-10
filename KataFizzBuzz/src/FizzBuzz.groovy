
class FizzBuzz {

	def FIZZFACTOR = 3
	def BUZZFACTOR = 5
	
	public parseNumber(Integer num){
		def result = sayFizz(num)
		result += sayBuzz(num)
		result = checkNoFizzBuzz(result, num)

		result
	}

	private sayFizz(Integer num) {
		say(num, FIZZFACTOR, 'Fizz')
	}

	private sayBuzz(Integer num) {
		say(num, BUZZFACTOR, 'Buzz')
	}

	private say (num, modFactor, word) {
		if (!(num % modFactor))
			return word

		''
	}

	private checkNoFizzBuzz(String result, Integer num){
		if (!result)
			result = num.toString()
			
		result
	}
}
