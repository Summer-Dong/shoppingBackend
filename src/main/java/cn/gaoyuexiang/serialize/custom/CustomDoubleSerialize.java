package cn.gaoyuexiang.serialize.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

public class CustomDoubleSerialize extends JsonSerializer {

	private DecimalFormat df = new DecimalFormat("##.00");

	@Override
	public void serialize(Object value,
	                      JsonGenerator gen,
	                      SerializerProvider serializers)
					throws IOException, JsonProcessingException {
		gen.writeString(df.format(value));
	}
}
