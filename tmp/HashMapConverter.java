package allen.model;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {
	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Object> map) {
		String json = null;
		try {
			json = objectMapper.writeValueAsString(map);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String json) {
		Map<String, Object> map = null;
		try {
			map = objectMapper.readValue(json, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
