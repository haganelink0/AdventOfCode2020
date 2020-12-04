package december.fourth;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class MainPartOne {

	public static void main(String[] args) {
		ArrayList<String> passports = new ArrayList<>();
		
		try {
			File myObj = new File("C:\\Users\\Link0.ZOMBILINK0\\Documents\\notas programacio\\december04.txt");
			Scanner fileReader = new Scanner(myObj);
			
			while(fileReader.hasNext()) {
				StringBuilder sb = new StringBuilder();
				String nextLine = fileReader.nextLine();
				
				while(!nextLine.isEmpty()) {
					sb.append(nextLine + " ");
					
					if(fileReader.hasNext()) 
						nextLine = fileReader.nextLine();
						else
							break;
				}
				
				if(sb.length()> 0)
					passports.add(sb.toString());
			}
					
					
		} catch(Exception e) {
			System.out.println(e.toString());
		}

		int count = 0;
		ArrayList<String> res = new ArrayList<>();
		
		for(String s : passports) {
			String[] splitPassport = s.split("[\\s++]");
			Set<String> validKeys = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"));
			validKeys.remove("cid");
			
			for(String splitStr : splitPassport) {
				String[] strSplit = splitStr.split("[:]");
				
				if(validKeys.contains(strSplit[0]))
					validKeys.remove(strSplit[0]);
			}
			
			if(validKeys.size() == 0) {
				count++;
				res.add(s);
			}
		}
		
		System.out.println("Valid passports: " + count);
		
		int secondCount = 0;
		
		for (String s : res) {
			String[] splitPassport = s.split("[\\s++]");
			Set<String>validKey = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
			
			for (String splitStr : splitPassport) {
				String[] strSplit = splitStr.split("[:]");
				String key = strSplit[0];
				String value = strSplit[1];
				
				if(validKey.contains(key)) {
					if(key.contentEquals("byr") || key.contentEquals("iyr") || key.contentEquals("eyr")) {
						if(value.length() == 4) {
							
							StringBuilder sb = new StringBuilder();
							for(char c : value.toCharArray()) {
								int numChar = c - '0';
								if (numChar >= 0 && numChar <= 9)
									sb.append(numChar);
								else
									break;
							}
							
							int number = (sb.length() > 0) ? Integer.parseInt(sb.toString()) : 0;
							if(number >= 1920 && number <= 2002 && key.equals("byr"))
								validKey.remove(key);
							else if(number >= 2010 && number <= 2020 && key.equals("iyr"))
								validKey.remove(key);
							else if (number >= 2020 && number <= 2030 && key.equals("eyr"))
								validKey.remove(key);
						}
					}
					else if(key.contentEquals("hgt")) {
						String unitsOfMeasure = value.substring(value.length()-2);
						StringBuilder sb = new StringBuilder();
						boolean conversion = true;
						
						for(int i = 0; i< value.length()-2; i++) {
							int numChar = value.charAt(i) - '0';
							if(numChar >= 0 && numChar <= 9)
								sb.append(numChar);
							else {
								conversion = false;
								break;
							}
						}
						
						int units = (sb.length() > 0 && conversion) ? Integer.parseInt(sb.toString()) : 0;
						if (units >= 150 && units <= 193 && unitsOfMeasure.equals("cm"))
							validKey.remove(key);
						else if(units >= 59 && units <= 75 && unitsOfMeasure.equals("in"))
							validKey.remove(key);
					}
					else if(key.equals("hcl")) {
						if (value.charAt(0) == '#') {
							boolean validHair = true;
							
							for(int i = 1; i < value.length(); i++) {
								int numCheck = value.charAt(i) - '0';
								int alphaCheck = value.charAt(i) - 'a';
								
								if(numCheck < 0 || numCheck > 9) {
									if(alphaCheck < 0 || alphaCheck > 5) {
										validHair = false;
										break;
									}
								}
							}
							
							if(validHair)
								validKey.remove(key);
						}
					}
					
					else if(key.contentEquals("ecl")) {
						HashSet<String> eyeColor = new HashSet<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
						
						if(eyeColor.contains(value))
							validKey.remove(key);
					}
					else if(key.equals("pid")) {
						if(value.length() == 9) {
							boolean numberCon = true;
							for (char c : value.toCharArray()){
								int numChar = c - '0';
								if(numChar < 0 || numChar > 9) {
									numberCon = false;
									break;
								}
							}
							
							if(numberCon)
								validKey.remove(key);
						}
					}
					
					else if(key.equals("cid")) {
						validKey.remove(key);
						continue;
					}
				}
			}
			
			if(validKey.size() == 0)
				secondCount++;
		}
		
		System.out.println("Valid Passports: "+ secondCount);
	}
}