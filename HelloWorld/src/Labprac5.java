import java.util.*;

public class Labprac5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> map=new HashMap<> ();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			String sen=sc.nextLine();
			
			String[] word=null;
			word=sen.split("\\s|\\n");
			
			String order=word[0];
			String name=null;
			String number=null;
			
			if(word[0].equals("add")) {
				int ef=word.length;
				
				if(ef==1||ef==2) {
					System.out.println("error");
					continue;
				}
				
				else {
					name=word[1];
					number=word[2];
					
					if(map.get(name)==null&&map.get(number)==null) {
						map.put(name, number);
					}
					else {
						System.out.println("error");
						continue;
					}
				}
			}
			
			else if(word[0].equals("find")) {
                int ef=word.length;
				
				if(ef==1) {
					System.out.println("error");
					continue;
				}
				
				else {
					name=word[1];
					if(map.get(name)==null) {
						System.out.println("error");
						continue;
					}
					System.out.println(map.get(name));	
				}
			}
			
			else if(word[0].equals("delete")) {
				int ef=word.length;
				
				if(ef==1) {
					System.out.println("error");
				}
				
				else {
					name=word[1];
					if(map.get(name)==null) {
						System.out.println("error");
					}
					else{
						map.remove(name);
					}
				}
			}
			
			else if(word[0].equals("show")) {
				Map<String, String> nmap = new TreeMap<String, String>(map); 
		        Set set = nmap.entrySet();
		        Iterator iterator = set.iterator();
		        while(iterator.hasNext()) {
		              Map.Entry me = (Map.Entry)iterator.next();
		              System.out.print(me.getKey() + " ");
		              System.out.println(me.getValue());
		        }
			}
			
			else {
				System.out.println("error");
	        }
			
		}

	}

}
