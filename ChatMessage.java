package com.jordanpeterson.textly.messages;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("ChatMessage")
public class ChatMessage extends ParseObject {
	public String getUserId() {
		return getString("userId");
	}

	public String getBody() {
		return getString("body");
	}

	public void setUserId(String userId) {
		put("userId", userId);
	}

	public void setBody(String body) {
		put("body", body);
	}
}
