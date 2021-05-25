package kr.co.agramar.demo.api.model.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Data
@Alias("DemoVO")
public class DemoVO {
	private Long id;
	private String description;
	private LocalDateTime regDate;
}
