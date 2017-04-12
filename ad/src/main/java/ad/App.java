package ad;


import com.opencsv.CSVReader;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	App app = new App();
        System.out.println( "Hello World !" );
        System.out.println("On appel la fonction max : ");
        System.out.println("Max = "+app.max(4,5));
        
        int monmax = 0;
        int nb=0;

        try {
        	CSVReader reader=new CSVReader(new FileReader("data.csv"));
        	try {
        		List<String[]> myEntries=reader.readAll();
        		for (String[] line: myEntries){
        			for (String val: line){
        				nb++;
        				if (Integer.parseInt(val) > monmax){
        					monmax=Integer.parseInt(val);
        				}
        			}
        		}


        	} catch (IOException e){
        		System.out.println("Probleme readAll");
        	}

        } catch(FileNotFoundException e) {
    	    System.out.println(e.getMessage());

        }
        System.out.println("Nombre lu : "+nb);
        System.out.println("Nombre max : "+monmax);
        
    }


    public int max(int a, int b){
    	return a>b?a:b;
    }

    
    
}