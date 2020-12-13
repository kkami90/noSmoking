package com.example.smoking.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.beans.propertyeditors.CharsetEditor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class DataController {


	@GetMapping("/")
	public StringBuffer call() {
		StringBuffer result = new StringBuffer();
		try {
			String urlstr = "http://api.data.go.kr/openapi/tn_pubr_public_prhsmk_zn_api?"
					+ "serviceKey=dAFCxtlnzOO8KA8tqf5xs0xaaldFJxS2V%2FIvJBhViuv6VOqIZX1dfLGnPAuEH%2F02OuByIklOB%2FZC7XEhMrbiuA%3D%3D"
					+ "&type=json"
					+ "&pageNo=0" 
					+ "&numOFRows=2";
					

			URL url = new URL(urlstr);

			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			
			String returnLine;
//			result.append("<xmp>");
			while((returnLine = br.readLine()) != null) {
				result.append(returnLine + "\n");
			}
			urlConnection.disconnect();
			br.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return result+"</xmp>";
		return result;
	}
//	
//	@GetMapping("/1")
//	public Map<String, Object> test1() {
//		StringBuffer result = new StringBuffer();
//		try {
//			String urlstr = "http://api.data.go.kr/openapi/tn_pubr_public_prhsmk_zn_api?"
//					+ "serviceKey=dAFCxtlnzOO8KA8tqf5xs0xaaldFJxS2V%2FIvJBhViuv6VOqIZX1dfLGnPAuEH%2F02OuByIklOB%2FZC7XEhMrbiuA%3D%3D"
//					+ "&pageNo=0"
//					+ "&numOFRows=2";
//			
//
//			URL url = new URL(urlstr);
//
//			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//			urlConnection.setRequestMethod("GET");
//			
////			JSONPObject js = new JSONPObject(, urlConnection.getPermission());
//			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
//			
//			
//			String returnLine;
////			result.append("<xmp>");
//			while((returnLine = br.readLine()) != null) {
//				result.append(returnLine + "\n");
//				System.out.println(returnLine);
//			}
//			urlConnection.disconnect();
//			br.close();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println("에러발생");
//		}
////		return result+"</xmp>";
//		return jj;
//		
//	}

	

}
