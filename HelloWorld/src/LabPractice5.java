import java.util.*;

public class LabPractice5 {
	
	public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<> ();
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			String order=sc.next();

			if(order.equals("add")) {
				String name=sc.next();
				System.out.println("Ok");
				if(name.length()==0) {
					System.out.println("error");
					continue;
				}
				String number=sc.nextLine();
				if(number==" ") {
					System.out.println("error");
					continue;
				}
				
				else if(map.get(name)==null&&map.get(number)==null) {
					map.put(name, number);
					System.out.println("Ok");
				}
				else {
					System.out.println("error");
					continue;
				}
			}
			
			else if(order.equals("find")) {
				String name=sc.next();
				System.out.println(map.get(name));
			}
			
			else if(order.equals("delete")) {
				String name=sc.next();
				if(map.get(name)==null) {
					System.out.println("error");
				}
				else{
					map.remove(name);
				}
			}
			
			else if(order.equals("show")){
				Map<String, String> nmap = new TreeMap<String, String>(map); 
		         //System.out.println("After Sorting:");
		         Set set = nmap.entrySet();
		         Iterator iterator = set.iterator();
		         while(iterator.hasNext()) {
		              Map.Entry me = (Map.Entry)iterator.next();
		              System.out.print(me.getKey() + " ");
		              System.out.println(me.getValue());
		         }
			}
			
		}

	}

}
