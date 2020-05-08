import java.util.Scanner;

public class Labsession1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		int[] arr1=new int[100];
		int k=0;
		int a=i;
		
		for(int j=0;i>=1;j++) {
			arr1[j]=i%2;
			i=i/2;
			k=k+1;
		}
		System.out.print("b ");
		for(int l=k-1;l>=0;l--) {
			System.out.print(arr1[l]);
		}
		
		System.out.println();
		System.out.printf("o %o",a);
		System.out.println();
		System.out.printf("h %x",a);
	}

}
