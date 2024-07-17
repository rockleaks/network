import java.io.*;
import java.net.*;
// import java.util.*;

// Run this command in the terminal for compiling the programs
// command : `java -source 1.8 -target 1.8 filename.java`

class Clientfile {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Socket clsct = new Socket("127.0.0.1", 1300);
            DataInputStream din = new DataInputStream(clsct.getInputStream());
            DataOutputStream dout = new DataOutputStream(clsct.getOutputStream());
            System.out.println("Enter the file name:");
            String str = in.readLine();
            dout.writeBytes(str + '\n');
            System.out.println("Enter the new file name:");
            String str2 = in.readLine();
            String str1, ss;
            FileWriter f = new FileWriter(str2);
            char buffer[];
            while (true) {
                str1 = din.readLine();
                if (str1.equals("-1"))
                    break;
                System.out.println(str1);
                buffer = new char[str1.length()];
                str1.getChars(0, str1.length(), buffer, 0);
                f.write(buffer);
            }
            f.close();
            clsct.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
