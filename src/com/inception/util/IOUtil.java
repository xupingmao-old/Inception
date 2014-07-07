package com.inception.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	
	private static byte[] buf = new byte[2048];
	
	public static File save(File in, String name) throws IOException{
		FileInputStream fis = new FileInputStream(in);
		File newFile = new File(name);
		if( !newFile.exists() ){
			newFile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(newFile);
		int size = 0;
		while( (size = fis.read(buf)) > 0 ){
			fos.write(buf, 0, size);
		}
		fis.close();
		fos.close();
		return newFile;
	}

	public static void deleteFile(String string) {
		File file = new File(string);
		if( file.exists() ){
			file.delete();
		}
	}
}
