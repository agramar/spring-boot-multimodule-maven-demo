package kr.co.agramar.demo.core.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LANGUAGE")
public class LanguageEntity {

	@Id
	@Column(name = "ISO_CODE", length = 2)
	private String isoCode;

	@Column(name = "NAME")
	private String name;
}
