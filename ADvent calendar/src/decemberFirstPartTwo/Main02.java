package decemberFirstPartTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main02 {

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
		Integer z = 0;
		Integer result = 2020;
		int a = 0;
		int b = 0;
		int c = 0;


			for (int i = 0; i < numberList.size(); i++) {
				x = numberList.get(i);
				for (int j = 0; j < numberList.size(); j++) {
					y = numberList.get(j);
					for (int k = 0; k < numberList.size(); k++) {
						z = numberList.get(k);
						if ((z + y + x) == result) {
							a = z;
							b = y;
							c = x;
						}
					}
				}
			}

			

		System.out.println("numbers: "+ a + " " + b + " " + c + ". Result: " + a*b*c);
		

	}

}
