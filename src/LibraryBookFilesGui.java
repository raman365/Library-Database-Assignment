/**
 * @author Raman Oraha i7437763
 * 11/08/16
 * Programming Assignment
 * This code displays the files of books that 
 * are in a library with the options of adding
 * and searching for a book
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class LibraryBookFilesGui {

	private JLabel Img,BookFiles, lblAddBook, ISBN, Author, Date, Title, Publisher, Search, 
	lblISBN, lblAuthor, lblDate, lblTitle, lblPublisher;
	private JTextField txtSearch2, txtISBN, txtAuthor, txtDate, txtTitle, 
	txtPublisher;
	private JTextArea BooksInfo;
	private JButton btnAddBook, btnSave, btnGo;
	private JFrame frame, frame2;
	private JPanel panel, panel2;
	private Font F1, F2;
	private JScrollPane Scroll;

	/** 
	 * These are the main method details.
	 * @param JLabel These labels are there to display to a user visibly to indicate the details of the book.
	 * @param JTextField These textfields are there to allow a user to input data.
	 * @param JTextArea The textarea is used so that the files of books are displayed.
	 * @param JButton The buttons are used to add, save and search for a book.
	 * @param JFrame The frames are simply the basic component of a Gui and is the window.
	 * @param JPanel The panels allows multiple objects and functions to be placed.
	 * @param Font The fonts are used to display text in different sizes and fonts throughout the program.
	 * @param JScrollPane This scroll pane is used in the textarea to allow the user to scroll through data.
	 */

	public static void main(String[] args) throws IOException {
		new LibraryBookFilesGui();
	}
	public LibraryBookFilesGui () throws IOException {

		frame = new JFrame("Library Book Files");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		frame.setSize(700,500);


		panel = new JPanel();
		panel.setSize(700,500);
		panel.setLayout(null);
		panel.setBackground(Color.darkGray);


		BookFiles = new JLabel("Library Book Files");
		BookFiles.setBounds(200,15,400,100);
		F1 = new Font("Arial", Font.BOLD, 40);
		BookFiles.setFont(F1);
		BookFiles.setForeground(Color.BLACK);
		panel.add(BookFiles);

		F2 = new Font("Arial", Font.BOLD, 20);
		ISBN = new JLabel("ISBN");
		ISBN.setBounds(20,110,400,100);
		ISBN.setFont(F2);
		ISBN.setForeground(Color.BLACK);
		panel.add(ISBN);

		Author = new JLabel("Author(s)");
		Author.setBounds(120,110,400,100);
		Author.setFont(F2);
		Author.setForeground(Color.BLACK);
		panel.add(Author);

		Date = new JLabel("Date");
		Date.setBounds(260,110,400,100);
		Date.setFont(F2);
		Date.setForeground(Color.BLACK);
		panel.add(Date);

		Title = new JLabel("Title");
		Title.setBounds(380,110,400,100);
		Title.setFont(F2);
		Title.setForeground(Color.BLACK);
		panel.add(Title);

		Publisher = new JLabel("Publisher");
		Publisher.setBounds(520,110,400,100);
		Publisher.setFont(F2);
		Publisher.setForeground(Color.BLACK);
		panel.add(Publisher);

		String input = "";
		FileReader inputFile = new FileReader("BooksInfo.txt");
		BufferedReader br = new BufferedReader(inputFile);

		BooksInfo = new JTextArea();
		BooksInfo.setEditable(false);
		BooksInfo.setForeground(Color.BLACK);
		Scroll = new JScrollPane(BooksInfo);
		Scroll.setBounds(0, 175, 700, 250);


		while( ( input = br.readLine()) != null){
			BooksInfo.append(input+"\n");

		}
		panel.add(Scroll);

		br.close();


		btnAddBook = new JButton ("Add new Book");
		btnAddBook.setBounds(140,100,115,25);
		btnAddBook.addActionListener(new AddBookHandler());
		panel.add(btnAddBook);

		btnGo = new JButton ("Go");
		btnGo.setBounds(630,100,50,25);
		btnGo.addActionListener(new FindHandler());
		panel.add(btnGo);

		Search = new JLabel("Search ISBN: ");
		Search.setBounds(390,100,150,25);
		Search.setFont(F2);
		Search.setForeground(Color.BLACK);
		panel.add(Search);

		txtSearch2 = new JTextField ();
		txtSearch2.setBounds(520,100,100,25);
		panel.add(txtSearch2);

		ImageIcon image2 = new ImageIcon("Library.png");
		JLabel label2 = new JLabel();
		label2 = new JLabel(image2);
		label2.setBounds(20,5,100,150);
		panel.add(label2);

		ImageIcon image = new ImageIcon("background.jpg");
		JLabel label = new JLabel();
		label = new JLabel(image);
		label.setBounds(0,-10,700,500);
		panel.add(label);

		frame.add(panel); 
		frame.setVisible(true);

	}

	class FindHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {

			try {
				Scanner filescan = new Scanner(new File ("booksInfo.txt"));
				Scanner lineInfo;
				BooksInfo.setText(null);
				while(filescan.hasNext()){
					String line = filescan.nextLine();
					lineInfo = new Scanner(line);
					lineInfo.useDelimiter(",");
					String isbn = lineInfo.next();
					if (txtSearch2.getText().equals(isbn)){
						BooksInfo.append(line+"\n");
					} 
				}

				filescan.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

	class AddBookHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {

			frame.dispose();

			frame2 = new JFrame("Add new book");
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setResizable(false);
			frame2.setLocation(100, 100);
			frame2.setSize(700,500);

			panel2 = new JPanel();
			panel2.setSize(700,500);
			panel2.setLayout(null);
			panel2.setBackground(Color.darkGray);

			lblAddBook = new JLabel("Add a new Book");
			lblAddBook.setBounds(200,15,400,100);
			lblAddBook.setFont(F1);
			lblAddBook.setForeground(Color.BLACK);
			panel2.add(lblAddBook);

			lblISBN = new JLabel("ISBN :");
			F2 = new Font("Arial", Font.BOLD, 20);
			lblISBN.setBounds(50, 150, 150, 20);
			lblISBN.setFont(F2);
			lblISBN.setForeground(Color.BLACK);
			panel2.add(lblISBN);
			txtISBN = new JTextField();
			txtISBN.setBounds(130, 150, 150, 20);
			panel2.add(txtISBN);

			lblAuthor = new JLabel ("Author(s) :");
			lblAuthor.setBounds(330,150,150,20);
			lblAuthor.setFont(F2);
			lblAuthor.setForeground(Color.BLACK);
			panel2.add(lblAuthor);
			txtAuthor = new JTextField();
			txtAuthor.setBounds(450,150,150,20);
			panel2.add(txtAuthor);

			lblDate = new JLabel("Date :");
			lblDate.setBounds(330,250,150,20);
			lblDate.setFont(F2);
			lblDate.setForeground(Color.BLACK);
			panel2.add(lblDate);
			txtDate = new JTextField();
			txtDate.setBounds(450,250,150,20);
			panel2.add(txtDate);

			lblTitle = new JLabel("Title :");
			lblTitle.setBounds(50,250,150,20);
			lblTitle.setFont(F2);
			lblTitle.setForeground(Color.BLACK);
			panel2.add(lblTitle);
			txtTitle = new JTextField();
			txtTitle.setBounds(130,250,150,20);
			panel2.add(txtTitle);

			lblPublisher = new JLabel("Publisher :");
			lblPublisher.setBounds(50,350,150,20);
			lblPublisher.setFont(F2);
			lblPublisher.setForeground(Color.BLACK);
			panel2.add(lblPublisher);
			txtPublisher = new JTextField();
			txtPublisher.setBounds(170,350,150,20);
			panel2.add(txtPublisher);

			btnSave = new JButton ("Save");
			btnSave.setBounds(450,347,100,25);
			panel2.add(btnSave);
			btnSave.addActionListener(new SaveHandler());

			ImageIcon image = new ImageIcon("background.jpg");
			Img = new JLabel();
			Img = new JLabel(image);
			Img.setBounds(0,-10,700,500);
			panel2.add(Img);

			frame2.add(panel2); 
			frame2.setVisible(true);
		}
	}

	class SaveHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			BufferedWriter Out;
			try {

				File MyFile = new File("BooksInfo.txt");
				FileWriter fw = new FileWriter(MyFile.getAbsoluteFile(), true);
				Out = new BufferedWriter(fw);
				Out.newLine();
				Out.write(txtISBN.getText());
				Out.write(", " + txtAuthor.getText());
				Out.write(", " + txtDate.getText());
				Out.write(", " + txtTitle.getText());
				Out.write(", " + txtPublisher.getText());

				Out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}


			int o = JOptionPane.showConfirmDialog(panel, 
					"Are you sure you want to Save?",
					"Save?", 
					JOptionPane.YES_NO_OPTION);
			if(o == JOptionPane.YES_OPTION)

			{
				JOptionPane.showMessageDialog(panel, "Book has successfully been added to the library");
				if(o == JOptionPane.YES_OPTION);

				try {
					frame2.dispose();
					new LibraryBookFilesGui();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
