Project page website:
https://horatiusmmxiv.github.io/csci4448_project/

**This website doesn't work for writing to leaderboard.txt 
so I'm going to look for a web application hosting service**

On your local machine
----------------------
1. Modify your java.policy file to allow the applet to write to the leadership.txt.
	*Add the line: 
		*permission java.io.FilePermission ".../csci4448_project/leaderboard.txt", "write";
2. Compile the applet with:
	*javac SimpleJavaApplet.java
3. To run the applet:
	*appletviewer index.html


