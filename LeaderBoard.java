import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class LeaderBoard{
  String lfile = new String("leaderboard.txt");
	JFrame frame;
  StringBuffer strBuff;
	JTextArea txtArea;
	JScrollPane l;

	public LeaderBoard(){
		frame = new JFrame("LeaderBoard");
		frame.setLayout(new BorderLayout());
    txtArea = new JTextArea(100,100);
		l = new JScrollPane(txtArea);
    frame.add(l, BorderLayout.WEST);
		frame.setSize(200, 200);
		frame.setVisible(true);
    writeFile();
    readFile();
	}

  public void readFile(){
    String line;  
    try{
      InputStream in = LeaderBoard.class.getResourceAsStream(lfile);
      BufferedReader bf = new BufferedReader(new InputStreamReader(in));
      txtArea.append("File Name : " + lfile + "\n");
      while((line = bf.readLine()) != null){
        txtArea.append(line + "\n");
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }
 	}

  public void writeFile(){
    try{
      File f = new File(lfile);
      BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
      out.write("\nBob");
      out.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}