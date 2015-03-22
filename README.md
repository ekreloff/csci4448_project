Project page website:
https://horatiusmmxiv.github.io/csci4448_project/

**This website doesn't work for writing to leaderboard.txt with leaderboard.php 
so I'm going to look for a web application hosting service**

On your local machine 
If you are running MAMP, LAMP, ...  or just Apache w/ PHP on port 8888
----------------------
1. Modify your **java.policy** file to allow the applet to write to the leaderboard.txt located in the document root.
  * Add the line within 'grant { }': 
    * **permission java.net.SocketPermission "localhost:8888", "connect,resolve";**
2. Compile the applet with:
  * **javac** SimpleJavaApplet.java
3. To run the applet:
  * **appletviewer** index.html


