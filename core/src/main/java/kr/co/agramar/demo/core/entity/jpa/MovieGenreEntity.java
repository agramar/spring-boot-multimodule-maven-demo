package kr.co.agramar.demo.core.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "GENRE")
public class MovieGenreEntity {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
}
