package kr.co.agramar.demo.core.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Configuration
public class ObjectMapperConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return Jackson2ObjectMapperBuilder.json()
			.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
			.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.featuresToEnable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
			.modules(javaTimeModule())
			.build();
	}

	private JavaTimeModule javaTimeModule() {
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
		return javaTimeModule;
	}
}
