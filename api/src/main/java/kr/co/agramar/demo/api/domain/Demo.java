package kr.co.agramar.demo.api.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class Demo {
	Long id;
	String description;
	LocalDateTime regDate;
}
