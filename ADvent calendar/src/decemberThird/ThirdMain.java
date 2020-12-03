package decemberThird;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThirdMain {

	public static void main(String[] args) {
		ArrayList<String>  treeMap = new ArrayList<>();
		
		try {
		      File myObj = new File("C:\\Users\\Link0.ZOMBILINK0\\Documents\\notas programacio\\december03.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        treeMap.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		int position = 0;
		int treeCount = 0;
		for (int i = 0; i < treeMap.size(); i++) {
			if (position >= treeMap.get(i).length()) {
				position = position - treeMap.get(i).length();
			}
			if (treeMap.get(i).charAt(position) == '#') {
				treeCount++;
			}
			position += 3;
		}
		System.out.println(treeCount);
		
		int positionTwo = 0;
		int secondTreeCount = 0;
		for (int i = 0; i < treeMap.size(); i++) {
			if (positionTwo >= treeMap.get(i).length()) {
				positionTwo = positionTwo - treeMap.get(i).length();
			}
			if (treeMap.get(i).charAt(positionTwo) == '#') {
				secondTreeCount++;
			}
			positionTwo++;
		}
		System.out.println(secondTreeCount);
		
		int positionThree = 0;
		int thirdTreeCount = 0;
		for (int i = 0; i < treeMap.size(); i++) {
			if (positionThree >= treeMap.get(i).length()) {
				positionThree = positionThree - treeMap.get(i).length();
			}
			if (treeMap.get(i).charAt(positionThree) == '#') {
				thirdTreeCount++;
			}
			positionThree+=5;
		}
		System.out.println(thirdTreeCount);
		
		int positionFour = 0;
		int fourthTreeCount = 0;
		for (int i = 0; i < treeMap.size(); i++) {
			if (positionFour >= treeMap.get(i).length()) {
				positionFour = positionFour - treeMap.get(i).length();
			}
			if (treeMap.get(i).charAt(positionFour) == '#') {
				fourthTreeCount++;
			}
			positionFour+=7;
		}
		System.out.println(fourthTreeCount);
		
		int positionFive = 0;
		int fifthTreeCount = 0;
		for (int i = 0; i < treeMap.size(); i+=2) {
			if (positionFive >= treeMap.get(i).length()) {
				positionFive = positionFive - treeMap.get(i).length();
			}
			if (treeMap.get(i).charAt(positionFive) == '#') {
				fifthTreeCount++;
			}
			positionFive++;
		}
		System.out.println(fifthTreeCount);
		long total = treeCount*secondTreeCount*thirdTreeCount*fourthTreeCount*fifthTreeCount;
		
		System.out.println(total);

	}
	

}
