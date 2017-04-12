package ad;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections4.CollectionUtils;

import java.io.FileReader;
import java.io.FileWriter;
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
        	CSVWriter writer=new CSVWriter(new FileWriter("data-filtered.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
        	try {
        		List<String[]> myEntries=reader.readAll();
        		for (String[] line: myEntries){
            		List<String> alist = Arrays.asList(line);
            		Vector<String> out = new Vector<String>();
            		CollectionUtils.select(alist, new MonPredicat<String>(), out);
            		System.out.println("OUT:" + out);
            		
            		writer.writeNext(out.toArray(new String[0]));
            		
        			for (String val: line){
        				nb++;
        				monmax=app.max(monmax, Integer.parseInt(val));
        			}
        		}


        	} catch (IOException e){
        		System.out.println("Probleme readAll");
        	}
        	reader.close();
        	writer.close();

        } catch(FileNotFoundException e) {
    	    System.out.println(e.getMessage());

        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Nombre lu : "+nb);
        System.out.println("Nombre max : "+monmax);
        
    }


    public int max(int a, int b){
    	return a>b?a:b;
    }

    
    
    
    
}