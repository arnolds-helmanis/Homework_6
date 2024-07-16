import java.util.Scanner;

public class ScannerTryCatch1 {

	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String userInput = task1();
		String changedInput = task2(userInput);
		task3(changedInput);
		task4();

		scan.close();
	}

	public static String task1() {
		System.out.println("Please insert a sentence!");
		String sentenceType = "";
		String words = "words";
		int wordCount = 0;
		String sentence;
		do {
			sentence = scan.nextLine();
			if (sentence.endsWith(".")) {
				sentenceType = "Narrative";
			} else if (sentence.endsWith("!")) {
				sentenceType = "Exclamatory";
			} else if (sentence.endsWith("?")) {
				sentenceType = "Question";
			} else {
				sentenceType = "Narrative";
			}
			if (sentence.contains(" ")) {
				String[] array = sentence.split(" ");
				wordCount = array.length;
			} else if (!sentence.isBlank()) {
				wordCount = 1;
				words = "word";
			} else {
				System.out.println("You did not insert anything!");
				System.out.println("Please insert a sentence!");
			}
		} while (sentence.isBlank());

		System.out.println(sentenceType + " sentence contains " + wordCount + " " + words + ".");
		return sentence;
	}

	public static String task2(String text) {
		System.out.println("Please enter the part of the text you want to replace from the sentence you entered!");
		String oldText;
		do {
			oldText = scan.nextLine().trim();
			if (text.contains(oldText) == false) {
				System.out.println("This part of the text is not in the sentence you entered! "
						+ "Please enter the part of the text you want to replace from the sentence you entered!");
			}
		} while (text.contains(oldText) == false);
		System.out.println("Please enter the text you want to replace your selected part with!");
		String newText = scan.nextLine().trim();
		String changedText = text.replace(oldText, newText);
		System.out.println(changedText);
		return changedText;
	}

	public static void task3(String text) {
		System.out
				.println("Please enter the number of which position you want to remove a word from your entered sentence!");
		String[] array = text.split(" ");
		String alteredText = "";
		int position = 0;
		do {
			try {
				String Wordposition = scan.nextLine();
				position = Integer.parseInt(Wordposition);
				//String deletedWord = array[position - 1];
			} catch (Exception InputMismatchException) {
				System.out.println("There is no such position of a word!");
				System.out.println(
						"Please enter the number of which position you want to remove a word from your entered sentence!");
			}
		} while (position < 1 || position > array.length);
		for (int i = 0; i < array.length; i++) {
			if (i == position - 1) {
				continue;
			} else {
				alteredText += array[i] + " ";
			}
		}
		System.out.println(alteredText.trim());
	}

	public static void task4() {
		System.out.println("Please enter your name!");
		String clientName = scan.nextLine().trim();
		System.out.println("Hello, " + clientName + "!");
		System.out.println("Please enter the item you wish to purchase!");
		String item = "";
		try {
			item = scan.nextLine();
			if (item.isBlank()) {
				System.out.println("Your input value is set to default value - bananas.");
				item = "bananas";
			}
		} catch (Exception InputMismatchException) {
			System.out.println("Your input value is set to default value - bananas.");
			item = "bananas";
		}
		int itemCount = 0;
		System.out.println("Please enter the number of items!");
		try {
			String itemCountString = scan.nextLine();
			itemCount = Integer.parseInt(itemCountString);
			if (itemCount < 1) {
				System.out.println("Your input value is set to default value - 100.");
				itemCount = 100;
			}
		} catch (Exception InputMismatchException) {
			System.out.println("Your input value is set to default value - 100.");
			itemCount = 100;
		}
		double itemPrice = 0;
		System.out.println("Please enter the price of the item!");
		try {
			String itemPriceString = scan.nextLine();
			itemPrice = Double.parseDouble(itemPriceString);
			if (itemPrice <= 0) {
				System.out.println("Your input value is set to default value - 0.99.");
				itemPrice = 0.99;
			}
		} catch (Exception InputMismatchException) {
			System.out.println("Your input value is set to default value - 0.99.");
			itemPrice = 0.99;
		}
		double total = itemCount * itemPrice;
		System.out.println("Client: " + clientName + "." + " Purchasing " + itemCount + " " + item + " for " + itemPrice
				+ "€ per piece with a total sum of " + total + "€.");
	}

}

// ja es 74. rindā izmantoju scan.nextInt() un attiecīgi izdzēsu 70. rindu, tad programma pārleca/izlaida 94.
// rindu. Šajā situācijā, ja es 74. rindā ievadīju skaitli un pēc atstarpes vārdu, tad 94. rindā tika
// izmantots vārds pēc atstarpes no 74. rindas.
// Kāpēc tā?
