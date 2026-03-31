import java.util.*;

class Solution 
{

	static String[] words = 
	{
        	"codechef", "programming", "learning",
        	"practice", "contests", "rating"
    	};

    	// 🔹 Random word generator
    	static String getRandomWord() 
	{
        	Random rand = new Random();
        	int index = rand.nextInt(words.length);
        	return words[index];
    	}

    	// 🔹 Create blank display word
    	static char[] wordDisplay(String word) 
	{
    	    char[] display = new char[word.length()];
    	    Arrays.fill(display, '_');
    	    return display;
    	}

    	// 🔹 Print display word
    	static void printDisplay(char[] display) 
	{
        	for (char c : display) 
		{
        	    System.out.print(c + " ");
        	}
        	System.out.println();
    	}

    	// 🔹 Update display based on guess
    	static boolean updateDisplay(String word, char[] display, char guess) 
	{
        	boolean found = false;

        	for (int i = 0; i < word.length(); i++) 
		{
        	    	if (word.charAt(i) == guess) 
			{
        	        	display[i] = guess;
        	        	found = true;
        		}
        	}

        	return found;
    	}

    	// 🔹 Check win condition
    	static boolean hasPlayerWon(char[] display) 
	{
        	for (char c : display) 
		{
        	    if (c == '_') return false;
        	}
       		return true;
    	}

    	// 🔹 Check lose condition
    	static boolean hasPlayerLost(int turns, char[] display) 
	{
        	if (turns == 0) 
		{
        		for (char c : display) 
			{
                		if (c == '_') 
				{
                    			System.out.println("You Lose");
                    			return true;
                		}
            		}
        	}
        	return false;
    	}

    	public static void main(String[] args) 
	{
        	Scanner sc = new Scanner(System.in);

        	String word = getRandomWord();
        	char[] display = wordDisplay(word);

        	int turns = 6; // number of guesses

        	System.out.println("Welcome to Hangman!");

        	while (true) 
		{

            		printDisplay(display);
            		System.out.println("Guesses left: " + turns);
            		System.out.print("Enter a letter: ");

            		char guess = sc.next().charAt(0);

            		boolean correct = updateDisplay(word, display, guess);

            		if (!correct) 
			{
                		turns--; // reduce only for wrong guess
                		System.out.println("Wrong guess!");
            		} 
			else 
			{
                		System.out.println("Correct guess!");
            		}

            		// ✅ Win check
            		if (hasPlayerWon(display)) 
			{
                		printDisplay(display);
                		System.out.println("You won!");
                		break;
            		}

            		// ❌ Lose check
            		if (hasPlayerLost(turns, display)) 
			{
                		System.out.println("Word was: " + word);
                		break;
            		}
        	}

        	sc.close();
    	}
}