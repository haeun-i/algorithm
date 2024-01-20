import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		str = str.replaceAll("BR", "B|R");
		str = str.replaceAll("RB", "R|B");

		String[] splited = str.split("\\|");
		
		int red = 0;
		int blue = 0;
		for(int i=0; i<splited.length; i++) {
			if(splited[i].charAt(0) == 'B') blue++;
			else if(splited[i].charAt(0) == 'R') red++;
		}
		
		if(red == 0 || blue == 0) System.out.println(1);
		else System.out.println(Math.min(red, blue) + 1);
	}
}