package fileutil;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

public class ReadFile {

public static String readrec(String Filename)

{

// ====================================================================

// Read the Rec

// ====================================================================

BufferedReader br = null;

FileReader fr = null;

String sCurrentLine="";

String retrec="";

try {

fr = new FileReader(Filename);

br = new BufferedReader(fr);

while ((sCurrentLine = br.readLine()) != null) {

retrec=retrec + sCurrentLine;

}

} catch (IOException e) {

e.printStackTrace();

} finally {


try {

if (br != null)

br.close();

if (fr != null)

fr.close();

} catch (IOException ex) {

ex.printStackTrace();

}

}

return retrec;

}

}

