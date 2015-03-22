Project page website:
https://horatiusmmxiv.github.io/csci4448_project/

**This website doesn't work for writing to leaderboard.txt with leaderboard.php.**
**You must comment out references to leaderboard in order for the applet to work here.**

If you are running MAMP, LAMP, ...  or just Apache w/ PHP on port 8888 on your local machine
----------------------
1. Modify your **java.policy** file to allow the applet to write to leaderboard.txt located in the document root.
  * Add this line within 'grant { }': 
    * **permission java.net.SocketPermission "localhost:8888", "connect,resolve";**
2. Compile the applet with:
  * **javac** SimpleJavaApplet.java
3. To run the applet:
  * **appletviewer** index.html


