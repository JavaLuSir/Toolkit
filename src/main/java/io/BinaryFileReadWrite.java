package io;

import java.io.*;

/**
 * use stream copy a file demo
 * @author javalusir
 *
 */
public class BinaryFileReadWrite {

	public static void main(String[] args) {
		File file = new File("d:\\bb.bmp");
		File file2 = new File("d:\\bb2s.bmp");
		
		InputStream fs = null;
		BufferedInputStream bi = null;

		OutputStream fo = null;
		BufferedOutputStream bo = null;
		
		try {
			fs = new FileInputStream(file);
			bi = new BufferedInputStream(fs);
			int len = bi.available();
			System.out.println(len);
			byte[] b = new byte[len];
			while((bi.read(b, 0, len))!=-1){
				bi.read(b);
			}
			fo= new FileOutputStream(file2);
			bo = new BufferedOutputStream(fo);
			
			fo.flush();
			bo.flush();
			bo.write(b,0,len);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
				try {
					bi.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					fs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					bo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					fo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
	}
}
