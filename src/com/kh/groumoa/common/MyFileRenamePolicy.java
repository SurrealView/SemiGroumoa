package com.kh.groumoa.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		int randomNumber = (int) (Math.random() * 100000);
		
		String name = oldFile.getName();
		
		String body = "";
		String ext = "";
		
		//정수를 반환하는데, 없으면 -1을 반환.
		int dot = name.lastIndexOf(".");
		
		if(dot != -1) {
			body = name.substring(0, dot);
			ext = name.substring(dot);
		} else {
			//ex)jinho의 경우 .이 없으므로 확장자가 없어서 못찾음.
			body = name;
		}
		
		//날짜와 난수로 랜덤한 이름을 하나 만들었음.
		String fileName = ft.format(new Date(currentTime)) + randomNumber + ext;		
		File newFile = new File(oldFile.getParent(), fileName);
		
		return newFile;
	}
	
}
