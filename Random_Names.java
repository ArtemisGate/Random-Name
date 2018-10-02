package app;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Scott This program takes two text file of as input, shuffle the
 *         contents which can be acccessed from the respective getters methods
 *
 */
public class Random_Names {

	private static List<String> Last_names = new ArrayList<String>(), First_names = new ArrayList<String>();

	// Returns Last Name List
	public static List<String> getLast_names() {
		return Last_names;
	}

	// Returns First Name List
	public static List<String> getFirst_names() {
		return First_names;
	}

	public static void main(String[] args) {

		// Get file location using resourceAsStream
		InputStream first_names = Random_Names.class.getResourceAsStream("/resources/First_Name.txt");
		InputStream last_names = Random_Names.class.getResourceAsStream("/resources/Last_Names.txt");

		// Read Files and added them to Lists
		try {
			// Use InputStreamReader for buffered Stream
			BufferedReader br = new BufferedReader(new InputStreamReader(first_names));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(last_names));

			String last_name = null, first_name = null;


			// Read File line by line til end of file
			while((last_name = br.readLine()) != null)
			{
				Last_names.add(last_name);
			}
			while ((first_name = br2.readLine()) != null) {
				First_names.add(first_name);
			}

			// Close BufferedReader After Reading
			br.close();
			br2.close();




		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // End of main

	// Shuffle List using Collections class
	public static void shuffle() {
		Collections.shuffle(Last_names);
		Collections.shuffle(First_names);
	}// End of Shuffle

}




