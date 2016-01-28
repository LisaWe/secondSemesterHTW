package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Histogram {

	public static void main(String[] args) throws IOException {

		// printSingleChar();
		// printChars();
		// writeStringToFile();
		// anotherWayToWriteStringToFile();
		// writeIntegerToFile();
		// anotherWayToWriteIntegerToFile();
		// countFrequencies();
		printHistogram();
	}

	// Prints out single characters from a textfile.
	public static void printSingleChar() throws IOException {

		FileReader fr = new FileReader("hallo.txt");
		BufferedReader br = new BufferedReader(fr);
		int c = 0;
		c = br.read();
		char letter = (char) c;

		System.out.println(letter);
		br.close();
	}

	// Prints out single characters from a textfile. Another Method.
	public static void printChars() throws IOException {

		FileReader fr = new FileReader("hallo.txt");
		BufferedReader br = new BufferedReader(fr);
		int c = 0;

		while ((c = br.read()) != -1) {
			char letter = (char) c;

			System.out.println(letter);
		}
		br.close();
	}

	// Writes a String to a textfile.
	public static void writeStringToFile() throws IOException {

		File file = new File("Beispiel.txt");
		String content = "lalalalala";

		FileOutputStream fop = new FileOutputStream(file);

		if (!file.exists()) {
			file.createNewFile();
		}

		byte[] contentInBytes = content.getBytes();

		fop.write(contentInBytes);
		fop.flush();
		fop.close();
	}

	// Writes a String to a textfile. Another Method.
	public static void anotherWayToWriteStringToFile() throws IOException {
		
		File file = new File("AnotherWritingStringToFile.txt");
		String content = "Content2: Hallo, wie geht es dir?";
		FileWriter filewriter = new FileWriter(file);
		// BufferedWriter writer = new BufferedWriter(filewriter);

		filewriter.write(content);
		filewriter.flush();
		filewriter.close();

		System.out.println("File was saved successfully.");
	}

	// Writes an Integer to a textfile.
	public static void writeIntegerToFile() throws IOException {

		int integerToFile = 7;
		Writer wr = new FileWriter("Integer_ausgeben.txt");
		
		wr.write(Integer.toString(integerToFile));
		wr.close();
	}

	// Writes an Integer to a textfile. Another Method.
	public static void anotherWayToWriteIntegerToFile() throws IOException {
		
		Writer wr = new FileWriter("Integer.txt");
		BufferedWriter writer = new BufferedWriter(wr);
		
		writer.write(4567 + "");
		writer.close();
	}

	// Counts the frequencies of each character from a textfile.
	public static void countFrequencies() throws IOException {

		int[] frequencies = new int[26];
		FileReader fr = new FileReader("hallo.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter out = new BufferedWriter(new FileWriter("frequency.txt"));
		int letter = 0;

		while ((letter = br.read()) != -1) {
			if (97 <= letter && letter <= 122) {
				letter = letter - 32;
			} else if ((0 <= letter && letter < 65)
					|| (90 < letter && letter < 97) || 122 < letter) {
				letter = 0;
			}
			if ((65 <= letter) && (letter <= 90)) {
				frequencies[letter - 65]++;
			}
		}
		
		char firstLetter = 'A';
		
		for (int i = 0; i < frequencies.length; i++) {
			out.write(firstLetter + ": " + frequencies[i]);
			out.newLine();
			firstLetter++;
		}
		br.close();
		out.close();
	}

	// Prints out a histogram.
	// Counts the frequencies of each character from a textfile, marked with
	// "*".
	public static void printHistogram() throws IOException {

		int[] frequencies = new int[26];
		File file = new File("hallo.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter out = new BufferedWriter(new FileWriter("frequency.txt"));

		int letter = 0;

		while ((letter = br.read()) != -1) {
			if (97 <= letter && letter <= 122) {
				letter = letter - 32;
			} else if ((0 <= letter && letter < 65)
					|| (90 < letter && letter < 97) || 122 < letter) {
				letter = 0;
			}

			if ((65 <= letter) && (letter <= 90)) {
				frequencies[letter - 65]++;
			}
		}

		char letterInList = 'A';
		
		out.write("Letters histogram of file: " + file);
		out.newLine();
		out.newLine();
		
		for (int i = 0; i < frequencies.length; i++) {
			int number = 1;
			String s = letterInList + ": ";

			while (number <= frequencies[i]) {
				s += "*";
				number++;
			}
			out.write(s);
			out.newLine();
			letterInList++;
		}

		br.close();
		out.close();
	}
}