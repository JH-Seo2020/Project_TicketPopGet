package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	// 기존의 파일(원본 파일)을 전달 받아서 수정명작업을 마친 수정된 파일을 반환해주는 메소드
	@Override 
	// (File arg0) -> 매개변수 명을 바꾸는 건 문제 되지않는다! File 타입을 바꾸는건 문제됨!
	public File rename(File originFile) {
		
		// 원본 파일명 ("aaa.jpg")
		String originName = originFile.getName();
		
		// 수정 파일명 : 파일업로드한 시간 (년월일시분초) + 5자리랜덤값(10000 ~ 99999) + .기존확장자
		
		// 원본명		-->	 수정명
		// aaa.jpg  --> 2020091509313045236.jpg
		
		// 1. 파일업로드한 시간 알아내기 (년월일시분초 형태)  (String currentTime)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = sdf.format(new Date());	// "20200915093130"
		
		// 2. 5자리 랜덤값(int ranNum)
		int ranNum = (int)(Math.random() * 90000 + 10000); // 24236
		
		// 3. 기존파일의 확장자 (String ext)
		// > 원본파일명에서 .이 위치해있는 인덱스 알아내기
		int dot = originName.lastIndexOf(".");
		String ext = originName.substring(dot);		// ".jpg"
		
		// 이제 각각 구해놓은 값을 다 조합해서 최종 수정명
		String fileName  = currentTime + ranNum + ext; // "2020091509313045236.jpg"
		
		// 전달받은 원본파일(originFile)을 수정된파일명으로 파일객체 생성해서 리턴
		File renameFile = new File(originFile.getParent(), fileName);
		
		return renameFile;
		

	}

}
