package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

/**
 * @author Scott
 *
 *         GUI Inteface for Random Name Program Generates Ten Random Names at a
 *         time
 *
 */
public class GUI_Inteface extends JFrame {

	public GUI_Inteface() {
		// Set default Settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName("Random Name GUI");
		setTitle("Randomize Names");
	}

	public static void main(String[] args) {
		// Frame Components
		GUI_Inteface frame = new GUI_Inteface();
		JPanel canvas = new JPanel(new MigLayout());
		JTextArea gen_names = new JTextArea(15, 30);
		JScrollPane scroll = new JScrollPane(gen_names);
		JButton generate = new JButton("Generate Names"), clear = new JButton("Clear");



		// Intialize JTextArea with default settings and text
		gen_names.setEditable(false);
		gen_names.setLineWrap(true);
		gen_names.append("This Program Generates ten random names at a time\n");


		// ActionListener for buttons using lambda expression
		generate.addActionListener(e -> {
			// Call Random Names class methods
			Random_Names.main(args);
			Random_Names.shuffle();


			List<String> f_names = new ArrayList<String>();
			List<String> l_names = new ArrayList<String>();

			// Get Memory Reference of Lists
			f_names = Random_Names.getFirst_names();
			l_names = Random_Names.getLast_names();

			// Append names to textarea
			for (int i = 0; i < 10; i++)
			{
				String full_name = f_names.get(i) + " " + l_names.get(i);

				gen_names.append(full_name + "\n");

			}

		});

		// Clear TextArea
		clear.addActionListener(e -> {
			gen_names.setText("");
		});

		// Add textarea and button to panel
		canvas.add(new JLabel("This Program will generate Ten Names"), "wrap");
		canvas.add(scroll, "wrap");
		canvas.add(Box.createHorizontalStrut(10), "wrap");
		canvas.add(generate);
		canvas.add(clear);

		// Add panel to the frame
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
