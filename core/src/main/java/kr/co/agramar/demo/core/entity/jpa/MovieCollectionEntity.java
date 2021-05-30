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
@Table(name = "MOVIE_COLLECTION")
public class MovieCollectionEntity {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 1000)
	private String name;

	@Column(name = "POSTER_PATH", length = 1000)
	private String posterPath;

	@Column(name = "BACKDROP_PATH", length = 1000)
	private String backdropPath;
}
