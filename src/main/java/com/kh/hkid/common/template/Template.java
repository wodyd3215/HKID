package com.kh.hkid.common.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.kh.hkid.common.vo.PageInfo;

public class Template {

	/**
	 * 
	 * @param listCount : 총 게시글 수
	 * @param currentPage : 현재페이지
	 * @param pageLimit : 하단에 보여질 페이징바의 수
	 * @param boardLimit : 한 페이지에 보여질 게시글 최대 수
	 * @return PageInfo
	 */
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		int maxPage = (int)Math.ceil((double)listCount/boardLimit); // 가장 마지막 페이지
		int startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1; // 페이징바의 시작
		int endPage = startPage + pageLimit - 1; //페이징바의 마지막
		
		endPage = endPage > maxPage ? maxPage : endPage;
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		return pi;
	}
	
	public static String saveFile(MultipartFile upfile, HttpSession session, String path) {
		//파일원본명
		String originName = upfile.getOriginalFilename(); 
		
		//확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		 
		//년월일시분초
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//5자리 랜덤값
		int randNum = (int)(Math.random() * 90000) + 10000;
		
		String changeName = currentTime + "_" + randNum + ext;
		
		//첨부파일 저장할 폴더의 물리적 경로
		String savePath = session.getServletContext().getRealPath(path);
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
	
	// API에 GET요청 보내고 응답을 받아오는 메서드
	public static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection conn = connect(apiUrl);
		
		try {
			conn.setRequestMethod("GET");
			
			for(Map.Entry<String, String> header : requestHeaders.entrySet()) {
				conn.setRequestProperty(header.getKey(), header.getValue());
			}
			
			int responseCode = conn.getResponseCode();
			
			if(responseCode == 200) {
				return readBody(conn.getInputStream());
			}
			
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("API요청을 통한 응답 실패 : " + apiUrl, e);
		}
	}
	
	// API에 연결하기위한 HttpURLConnection객체를 생성해서 반환하는 메서드
	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("연결에 실패하였습니다. : " + apiUrl, e);
		}
	}
	
	public static String readBody(InputStream bodyInput) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(bodyInput))){
			StringBuffer res = new StringBuffer();
			
			String inputLine;
	    	while((inputLine = br.readLine()) != null) {
	    		res.append(inputLine);
	    	}
	    	
	    	return res.toString();
		} catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("바디정보를 읽는데 실패하였습니다. ", e);
		}
	}
}