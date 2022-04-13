package it.edu.polomanettiporciatti.provajson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Utilities {
    
    public static void deleteChars(File f, int num_chars) throws IOException{
        
        FileOutputStream fos = new FileOutputStream(f, true);
		FileChannel fc = fos.getChannel();

		Long size = f.length();

		if (size >= num_chars)
			fc.truncate(size-num_chars);

		fc.close();
		fos.close();
    }

}
