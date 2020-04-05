package com.teamproject.gitsourcemerge.chat;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MultiLinkSerializer extends JsonSerializer<List<MultiLink>>{

	@Override
	public void serialize(List<MultiLink> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartArray();
		
		for(MultiLink multiLink : value) {
			
			gen.writeStartObject();
			gen.writeObjectField("title", multiLink.title);
			gen.writeObjectField("url", multiLink.url);
			gen.writeEndObject();
			
		}
		
		gen.writeEndArray();
		
	}

}
