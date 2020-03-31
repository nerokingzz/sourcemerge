package com.teamproject.gitsourcemerge.chat;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import org.apache.commons.codec.binary.Base64;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	private static String secretKey = "TkNyakNNR0tzVFZFY0N6RWxJbHpyeVl6VmJ4QnFuREg=";
	private static String apiUrl = "https://s0g2t30ben.apigw.ntruss.com/my_chatbot/beta/";
	
	public ChatController() throws IOException, InterruptedException {
	}
	
	@MessageMapping("/chat.openMessage")
	@SendTo("/topic/chatbot")
	public Message openMessage(@Payload String chatMessage) throws IOException {
		
		Message newMessage = new Message();
		
		String message = getOpenMessage(chatMessage);
		URL url = new URL(apiUrl);
		String encodeBase64String = makeSignature(message, secretKey);

		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;UTF-8");
		con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		wr.write(message.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();

		BufferedReader br;
		
		
		System.out.println("============response code : " + responseCode);

		System.out.println("============response message : " + con.getResponseMessage());

		System.out.println("============signature : " + encodeBase64String );

		if(responseCode==200) { // 정상 호출

			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							con.getInputStream()));
			String decodedString;
			String jsonString = "";
			while ((decodedString = in.readLine()) != null) {
				jsonString = decodedString;
			}
			//chatbotMessage = decodedString;
			
			newMessage = getJSONData(chatMessage, jsonString, con);

			in.close();

		} else {  // 에러 발생
			System.out.println("============error response body : " + readBody(con.getErrorStream()));
			chatMessage = con.getResponseMessage();
		}
		return newMessage;
	}
	

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/chatbot")
	public Message sendMessage(@Payload String chatMessage) throws IOException 
	{
		Message newMessage = new Message();
		String message = "";
		message =  getReqMessage(chatMessage);
		
		URL url = new URL(apiUrl);
		String encodeBase64String = makeSignature(message, secretKey);

		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;UTF-8");
		con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		wr.write(message.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();

		BufferedReader br;
		
		
		System.out.println("============response code : " + responseCode);

		System.out.println("============response message : " + con.getResponseMessage());

		System.out.println("============signature : " + encodeBase64String );

		if(responseCode==200) { // 정상 호출

			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							con.getInputStream()));
			String decodedString;
			String jsonString = "";
			while ((decodedString = in.readLine()) != null) {
				jsonString = decodedString;
			}
			//chatbotMessage = decodedString;
			
			
			newMessage = getJSONData(chatMessage, jsonString, con);

			in.close();

		} else {  // 에러 발생
			System.out.println("============error response body : " + readBody(con.getErrorStream()));
			chatMessage = con.getResponseMessage();
		}
		return newMessage;
	}    
	
	
	private Message getJSONData(String chatMessage, String jsonString, HttpURLConnection con) { //JSON데이터를 읽어오는 작업
		JSONParser jsonparser = new JSONParser();
		JSONObject json;
		List<MultiLink> contentList = new ArrayList<MultiLink>(); 
		
		try {
			json = (JSONObject) jsonparser.parse(jsonString);

			System.out.println("json : " + json);

			JSONArray bubblesArray = (JSONArray) json.get("bubbles");

			System.out.println("bubblesArray : " + bubblesArray);
			JSONObject bubbles = (JSONObject) bubblesArray.get(0);
			System.out.println("bubbles : " + bubbles);

			// body에서 data를 가져오는 프로세스
			JSONObject data = (JSONObject) bubbles.get("data");
			System.out.println("data : " + data);
			
			
			
			if (data.get("cover") != null) { //기본 질답 형태가 아닌 멀티링크형태
				// multilink로 데이터 받기. data 속 커버 있음
				
				JSONObject cover = (JSONObject)data.get("cover");
				JSONObject data2 = (JSONObject)cover.get("data");
				String description = (String)data2.get("description");
				chatMessage = description;
				
				System.out.println("======================");
				System.out.println("this is multiLink");
				System.out.println("multiLink description : " + description);
				System.out.println("======================");
				
				JSONArray contentTable = (JSONArray)data.get("contentTable");
				System.out.println("contentTable : " + contentTable);

				
				for(int i = 0; i < contentTable.size(); i++) {
					JSONArray button = (JSONArray)contentTable.get(i);
					JSONObject contentObject = (JSONObject)button.get(0);
					
					
					JSONObject data3 = (JSONObject)contentObject.get("data");
					
					String buttonTitle = (String)data3.get("title");
					System.out.println(i + "번째 button title... " + buttonTitle);
					
					
					JSONObject data4 = (JSONObject)data3.get("data");
					System.out.println("data4 : " + data4);
					
					JSONObject action = (JSONObject)data4.get("action");
					System.out.println("action : " + action);
					
					JSONObject data5 = (JSONObject)action.get("data");
					System.out.println("data5 : " + data5);
					
					String url = (String)data5.get("url");
					System.out.println(i + "번째 button url... " + url);
					
					contentList.add(new MultiLink(buttonTitle, url));
					
				}
				
			} else {

				// 기본 질답
				// 위에서 가져온 data 속 description을 뽑아내는 프로세스
				String description = "";
				description = (String) data.get("description");
				chatMessage = description;

				// body에서 event명을 가져오는 프로세스
				String event = (String) json.get("event");
				System.out.println("event : " + event);
				contentList = null;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Message(chatMessage, contentList);
		
	}
	
	
	
	private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);
        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
	
	

	public static String makeSignature(String message, String secretKey) {

		String encodeBase64String = "";

		try {
			byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

			SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);

			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.encodeBase64String(rawHmac);

			return encodeBase64String;

		} catch (Exception e){
			System.out.println(e);
		}

		return encodeBase64String;

	}


	public static String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##"+timestamp);

			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.add(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e){
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}
	
	
	
	
	
	
	
	
	
	public static String getOpenMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##"+timestamp);

			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.add(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "open");

			requestBody = obj.toString();

		} catch (Exception e){
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}

}
