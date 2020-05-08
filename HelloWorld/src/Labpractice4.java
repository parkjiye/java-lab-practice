
public class Labpractice4 {
	static public class Book{
		Book(){
			
		}
		Boolean states=true;
	}

	static public class Library{
		Book[] books=new Book[10];
		
		Library(){
			for(int i=0;i<10;i++) {
				books[i]=new Book();
			}
		}
		
		void borrowBook(int n) {
			if(this.books[n].states) {
				System.out.println("OK");
				books[n].states=false;
			}
			else {
				System.out.println("error. The book has already borrowed!");
			}
		}
		
		void returnBook(int n) {
			if(!books[n].states) {
				System.out.println("Thank you for using!");
				books[n].states=true;
			}
			else {
				System.out.println("error. The book is available!");
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}



