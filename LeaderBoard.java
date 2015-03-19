import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class LeaderBoard{
    String fileToRead = new String("results.txt");
	JFrame frame;
    StringBuffer strBuff;
	JTextArea txtArea;
	JScrollPane l;

	public LeaderBoard(){
		frame = new JFrame("LeaderBoard");
		frame.setLayout(new BorderLayout());
        txtArea = new JTextArea(100,100);
		readFile();
		l = new JScrollPane(txtArea);
        frame.add(l, BorderLayout.WEST);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

    public void readFile(){
       String line;  
       try{
          InputStream in = LeaderBoard.class.getResourceAsStream(fileToRead);
          BufferedReader bf = new BufferedReader(new InputStreamReader(in));
          txtArea.append("File Name : " + fileToRead + "\n");
          while((line = bf.readLine()) != null){
             txtArea.append(line + "\n");
          }
       }
       catch(IOException e){
       	e.printStackTrace();
       }
 	}
}