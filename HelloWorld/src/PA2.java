import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class BombInputException extends Exception{
	
}
class ModelInputException extends Exception{
	
}
class HitException extends Exception{
	
}

public class PA2{
	public static int row=10;
	public static int col=10;
	public static int playerShips;
	public static int computerShips;
	public static char[][] grid=new char[12][35];
	public static int[][] missedGuesses=new int[row][col];
	Scanner sc=new Scanner(System.in);
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("Right now, sea is empty\n");
		for(int i=0;i<12;i++) {
			for(int j=0;j<35;j++) {
				grid[i][j]=' ';
			}
		}
		
		Scanner sc=new Scanner(System.in);
		int bombs=sc.nextInt();
		char mode=sc.next().charAt(0);
		String sentence=sc.nextLine();
		
		try {
			if(bombs<0) {
				throw new BombInputException();
			}
			if(mode!='d'&&mode!='D'&&mode!='R'&&mode!='r') {
				throw new ModelInputException();
			}
		}
		catch(BombInputException e) {
			System.out.println("BombInputException");
		}
		catch(ModelInputException e) {
			System.out.println("ModelInputException");
		}
		if(sentence.split(" ").equals("input")) {
			makeRandomMap(sentence);
		}
		
		//Step1-Create the ocean map
		else{
			makeFirstMap();
		}
		
        if(mode=='d'||mode=='D') {
			Debugmode(bombs);
			
		}
        
        if(mode=='r'||mode=='R') {
        	ReleaseMode(bombs);
        }

		
		//Step2-Deploy player's ships
		//displayPlayerships();

	

	}
	//초기 보드 만들기
	public static void makeFirstMap() throws IOException {
		InputStream fis=new FileInputStream("input_board.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		
		//First section of FirstMap(첫줄)
		for(int i=0;i<5;i++) {
			PA2.grid[0][i]=' ';
		}
		char ch1='A';
		for(int i=5;i<35;i++) {
			PA2.grid[0][i]=ch1;
			PA2.grid[0][i+1]=' ';
			PA2.grid[0][i+2]=' ';
			ch1++;
			i=i+2;
		}
		
		//두번째줄
		for(int i=0;i<5;i++) {
			PA2.grid[1][i]=' ';
		}
		for(int i=5;i<35;i++) {
			PA2.grid[1][i]='-';
			PA2.grid[1][i+1]=' ';
			PA2.grid[1][i+2]=' ';
			i=i+2;
		}
		
		//세로줄 정리
		char cp='1';
		for(int i=2;i<12;i++) {
			if(i==11) {
				PA2.grid[i][0]='1';
				PA2.grid[i][1]='0';
			}
			else{
				PA2.grid[i][0]=cp;
				cp++;
			}
			
			PA2.grid[i][3]='|';
		}
		
		String line="";
		
		int n=2;
		while((line=br.readLine())!=null) {
			String[] spell=line.split("",0);
			/*for(int i=0;i<line.length();i++) {
				System.out.print(spell[i]);
			}*/
			//System.out.println();
			int k=5;
			for(int i=0;i<line.length();i++) {
				
				PA2.grid[n][k]=spell[i].charAt(0);
				PA2.grid[n][k+1]=' ';
				PA2.grid[n][k+2]=' ';
				k=k+3;
			}
			n++;
		}
		
		br.close();isr.close();fis.close();		
	}
	
	public static void displayPlayerships() {
		//print
		for(int i=0;i<12;i++) {
			for(int j=0;j<35;j++) {
				System.out.print(PA2.grid[i][j]);
			}
			System.out.println();
		}				
						
	}
	
	public static void Debugmode(int bombs) {
		int time=0;
		int score=0;
		while(time<=bombs) {
			displayPlayerships();
			Scanner sc=new Scanner(System.in);
			String or=sc.nextLine();
			String[] der=or.split("",2);
			//System.out.println(der[0]);
			//System.out.println(der[1]);
			
			int i=0;
			while(grid[0][i]!=der[0].charAt(0)) {
				i++;
			}
			int COL=i;
			int j=0;
            while(grid[j][0]!=der[1].charAt(0)) {
				j++;
			}
            int ROW=j;
            
            //System.out.println(COL);
            //System.out.println(ROW);
            
            if(grid[ROW][COL]==' ') {
            	System.out.println("Miss");
            	grid[ROW][COL]='X';
            }
            else {
            	System.out.println("Hit "+grid[ROW][COL]);
            	switch(grid[ROW][COL]) {
            	case 'P':
            		score=score+2;
            		break;
            	case 'S':
            		score=score+3;
            		break;
            	case 'B':
            		score=score+4;
            		break;
            	case 'D':
            		score=score+3;
            		break;
            	case 'A':
            		score=score+6;
            		break;
            	default:
            	    break;
            
            	}
            	grid[ROW][COL+1]=Character.toLowerCase(grid[ROW][COL]);
            	grid[ROW][COL]='X';	
            }
            time++;
		}
		System.out.println("Score "+score);
	}
	
	public static void ReleaseMode(int bombs) {
		int time=0;
		int score=0;
		while(time<=bombs) {
			Scanner sc=new Scanner(System.in);
			String or=sc.nextLine();
			String[] der=or.split("",2);
			//System.out.println(der[0]);
			//System.out.println(der[1]);
			
			int i=0;
			while(grid[0][i]!=der[0].charAt(0)) {
				i++;
			}
			int COL=i;
			int j=0;
            while(grid[j][0]!=der[1].charAt(0)) {
				j++;
			}
            int ROW=j;
            
            //System.out.println(COL);
            //System.out.println(ROW);
            
            if(grid[ROW][COL]==' ') {
            	System.out.println("Miss");
            	grid[ROW][COL]='X';
            }
            else {
            	System.out.println("Hit "+grid[ROW][COL]);
            	switch(grid[ROW][COL]) {
            	case 'P':
            		score=score+2;
            		break;
            	case 'S':
            		score=score+3;
            		break;
            	case 'B':
            		score=score+4;
            		break;
            	case 'D':
            		score=score+3;
            		break;
            	case 'A':
            		score=score+6;
            		break;
            	default:
            	    break;
            
            	}
            	grid[ROW][COL+1]=Character.toLowerCase(grid[ROW][COL]);
            	grid[ROW][COL]='X';
            }
            
            time++;
		}
		displayPlayerships();
		System.out.println("Score "+score);
	}
	
	public static void makeRandomMap(String sentence) throws IOException{
		String word[]=sentence.split("",0);
		
	}
}