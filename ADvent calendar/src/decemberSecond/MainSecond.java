package decemberSecond;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSecond {

	public static void main(String[] args) {
		ArrayList<String>  commandList = new ArrayList<>();
		ArrayList<String> passwordList = new ArrayList<>();
		
		try {
		      File myObj = new File("C:\\Users\\Link0.ZOMBILINK0\\Documents\\notas programacio\\december02.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		       String data = myReader.nextLine();
		       String[] pool = new String[2];
		       pool = data.split(":");
		       commandList.add(pool[0]);
		       passwordList.add(pool[1]);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		int validPasswords = 0;
		for (int i = 0; i < commandList.size(); i++) {
			int minimum = 0;
			int maximum = 0;
			String command = commandList.get(i);
			command = command.substring(0, command.length()-2);
			String[] numbers = new String[2];
			numbers = command.split("-");
			minimum = Integer.parseInt(numbers[0]);
			maximum = Integer.parseInt(numbers[1]);
			char letter = commandList.get(i).charAt(commandList.get(i).length()-1);
			String password = passwordList.get(i).strip();
			int counter = 0;
			for (int j = 0; j < password.length(); j++) {
				if(password.charAt(j) == letter) {
					counter++;
				}
			}
			if (counter <= maximum && counter >= minimum) {
				validPasswords++;
			}
		}
		System.out.println(validPasswords);

	}

}
