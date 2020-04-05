package com.teamproject.gitsourcemerge.chat;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Message {
    private String content;
    
    @JsonSerialize(using = MultiLinkSerializer.class)
    private List<MultiLink> multiLinkList;

    public Message() {
    }
    
    public Message(String content) {
    	this.content = content;
    }
    
    public Message(String content, List<MultiLink> multiLinkList) {
    	this.content = content;
    	this.multiLinkList = multiLinkList;
    }
    
    public String getContent() {
    	return this.content;
    }
    
    public List<MultiLink> getMultiLinkList() {
    	return this.multiLinkList;
    }
    
}