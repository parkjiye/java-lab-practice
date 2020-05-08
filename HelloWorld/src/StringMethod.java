
public class StringMethod {
	static String addString(String s1,int index, String s2) {
		String a=s1.substring(index+1);
		String b=s1.substring(0,index+1);
		String c=b.concat(s2).concat(a);
		return c;
	}
	static String reverse(String s) {
		int i=s.length()-1;
		String k=s.substring(i);
		i=i-1;
		for(int j=0;i>=0;j++) {
			k=k.concat(s.substring(i,i+1));
			--i;
		}
		return k;
	
	}
	static String removeString(String s1,String s2) {
		int i=s2.length();
		int m=s1.length();
		String k="";
		for(int j=0;j<=m-1;j++) {
			if(j!=m-1&&(s1.substring(j,j+i)).equals(s2)) {
				j=j+(i-1);
			}
			else{
				k=k.concat(s1.substring(j,j+1));
			}
		}
		return k;
	}
	public static void main(String[] args) {
		System.out.println(addString("0123456",3,"-"));
		System.out.println(reverse("abc"));
		System.out.println(removeString("01001000","00"));
	}

}
