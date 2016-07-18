package cn.gaoyuexiang.service;

import cn.gaoyuexiang.exception.StoreException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class SerializeService {

	private final ObjectMapper objectMapper = new ObjectMapper();

	public <T> T convertTo(InputStream inputStream, TypeReference<T> typeRef) {
		try {
			return objectMapper.readValue(inputStream, typeRef);
		} catch (IOException e) {
			throw new StoreException(e.getMessage());
		}
	}
}
