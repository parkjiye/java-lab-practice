import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class reverse {
	public static void main(String[] args) throws IOException {
		InputStream fis=new FileInputStream("input.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		
		FileOutputStream fos=new FileOutputStream("output.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		BufferedWriter bw=new BufferedWriter(osw);
		
		String data="";
		ArrayList a=new ArrayList(0);
		while((data=br.readLine())!=null) {
			a.add(data);
		}
		String lines[]=new String[a.size()];
		for(int i=(lines.length-1);i>=0;i--) {
			lines[i]=(String)a.get(a.size()-(i+1));

		}
		for(int i=0;i<lines.length;i++) {
			bw.write(lines[i]);
			bw.write("\n");
		}

		bw.flush();
		br.close();isr.close();fis.close();
		bw.close();fos.close();osw.close();
	}
		

}
