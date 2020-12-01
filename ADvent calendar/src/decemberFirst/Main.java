package decemberFirst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer>  numberList = new ArrayList<>();
		
		try {
		      File myObj = new File("C:\\Users\\Link0.ZOMBILINK0\\Documents\\notas programacio\\december01.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        Integer data = Integer.parseInt(myReader.nextLine());
		        numberList.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		Integer x = 0;
		Integer y = 0;
		boolean test = true;
		while (test) {
			 for (int i = 0; i < numberList.size(); i++) {
				 for(Integer n : numberList) {
					 if ((n + numberList.get(i)) == 2020 && n != numberList.get(i)) {
						 x = n;
						 y = numberList.get(i);
						 test = false;
					 }
				 }
			 }
			 test = false;
		}
		System.out.println("first number is: " + x + " and second number is: " + y + "so the answer is: " + x*y);

	}

}
