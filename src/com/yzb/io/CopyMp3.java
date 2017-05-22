package com.yzb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyMp3 {

	public static void main(String[] args) {
		copy();
	}

	public static void copy() {
		File mp3File = new File("D:/a.mp3");
		if (!mp3File.exists()) {
			System.out.println("文件不存在");
			return;
		}

		System.out.println("文件存在");
		byte[] b = new byte[1024];

		try {
			InputStream is = new FileInputStream(mp3File);
			OutputStream bos = new FileOutputStream("E:/a.mp3");
			while (is.read(b) != -1) {
				bos.write(b);
			}
			bos.flush();
			is.close();
			bos.close();
			System.out.println("copy complete!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
