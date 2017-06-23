package com.yzb.lee.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

public class IOTest
{
	private static final String FILE_NAME = "hello.txt";
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	@Test
	public void testFile()
	{
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		System.out.println(LINE_SEPARATOR); // 换行符
	}

	@Test
	public void testWriter() throws IOException
	{
		Writer writer = new BufferedWriter(new FileWriter(FILE_NAME, true));

		// 指定文件写入时的编码格式
		// Writer writer = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(FILE_NAME, true), "utf-8"));
		writer.write("我的天" + LINE_SEPARATOR);
		writer.flush();
		writer.close();
	}

	@Test
	/**
	 * 一行一行的写
	 * @throws IOException
	 */
	public void testWriterLine() throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,
				true));
		// Writer writer = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(FILE_NAME, true), "utf-8"));
		writer.write("hahah");
		writer.newLine();
		writer.flush();
		writer.close();
	}

	@Test
	/**
	 * Reads characters into an array
	 * @throws IOException
	 */
	public void testReader() throws IOException
	{
		Reader reader = new BufferedReader(new FileReader(FILE_NAME));

		// 指定以utf-8的编码格式读取文件内容
		// Reader reader = new BufferedReader(new InputStreamReader(new
		// FileInputStream(FILE_NAME), "utf-8"));

		char[] content = new char[1024];
		int length = 0;
		while ((length = reader.read(content)) != -1) // 不是以行的方式读取， 返回的内容包括换行符
		{
			System.out.print(new String(content, 0, length));
		}
		reader.close();
	}

	@Test
	/**
	 * 一行一行读取文件
	 * @throws IOException
	 */
	public void testReaderLine() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
		/*
		 * String content = null; while ((content = reader.readLine()) != null)
		 * // readLine返回的内容不包括换行符 { System.out.println(content); }
		 */
		for (String content = reader.readLine(); content != null; content = reader
				.readLine())
		{
			System.out.println(content);
		}
		reader.close();
	}

	@Test
	/**	
	 * 字节流写文件
	 */
	public void testOutputStream() throws IOException
	{
		OutputStream os = new BufferedOutputStream(new FileOutputStream(
				FILE_NAME, true));
		os.write(("outputStream测试" + LINE_SEPARATOR).getBytes("utf-8")); // ISO-8859-1
		os.flush();
		os.close();
	}

	@Test
	/**
	 * 字节流读文件
	 */
	public void testInputStream() throws IOException
	{
		InputStream is = new BufferedInputStream(new FileInputStream(FILE_NAME));
		byte[] content = new byte[1024];
		int length = 0;
		while ((length = is.read(content)) != -1)
		{
			System.out.print(new String(content, 0, length, "utf-8"));
		}
		is.close();
	}
}
