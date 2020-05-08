import java.util.Random;

public class Gameboard {
	public static void main(String[] args) {
		char rancol=(char)((int)(Math.random()*10)+65);
		int ranrow=(int)(Math.random()*10+1);
		
		System.out.println(rancol);
		System.out.println(ranrow);
	}


}
