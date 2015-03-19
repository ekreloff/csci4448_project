import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class LeaderBoard implements ActionListener{
  String lfile = new String("leaderboard.txt");
	JFrame frame;
  StringBuffer strBuff;
	JTextArea lArea;
  JLabel nameLabel;
  JTextField nameInput;
  JButton submitButton;
  JPanel nameSubmitPane;
	JScrollPane lBoardScroll;

	public LeaderBoard(){
    nameForm();
    addListeners();
    createLeaderBoard();
    showLeaderBoard();		
	}

  /* Create the leaderboard frame and add components to it */
  public void showLeaderBoard(){
    frame = new JFrame("LeaderBoard");
    frame.setLayout(new BorderLayout());
    frame.add(nameSubmitPane, BorderLayout.SOUTH);
    frame.add(lBoardScroll, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    readFile();
  }

  /* Create the form for the submission of a name to the leaderboard */
  public void nameForm(){
    nameLabel = new JLabel("Submit name to leaderboard:");
    nameInput = new JTextField(10);
    submitButton = new JButton("Submit");
    nameSubmitPane = new JPanel();
    nameSubmitPane.add(nameLabel);
    nameSubmitPane.add(nameInput);
    nameSubmitPane.add(submitButton);
  }

  /* Create the text area for the leaderboard */
  public void createLeaderBoard(){
    lArea = new JTextArea(10,10);
    lArea.setEditable(false);
    lBoardScroll = new JScrollPane(lArea);
  }


  /* Detect the submission of a name */
  public void actionPerformed(ActionEvent ae){
    Object obj = ae.getSource();
    if(obj == submitButton){
        writeFile("\n" + nameInput.getText());
        readFile();
    }
  }

  /* Handle events in the frame */
  public void addListeners(){
    submitButton.addActionListener(this);
  }

  /* Read from the leaderboard.txt and put in the textarea */
  public void readFile(){
    lArea.setText(null);
    String line;  
    try{
      InputStream in = LeaderBoard.class.getResourceAsStream(lfile);
      BufferedReader bf = new BufferedReader(new InputStreamReader(in));
      //readArea.append("File Name : " + lfile + "\n");
      while((line = bf.readLine()) != null){
        lArea.append(line + "\n");
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }
 	}

  /* Write a string to leadership.txt */
  public void writeFile(String text){
    try{
      File f = new File(lfile);
      BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
      out.write(text);
      out.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}