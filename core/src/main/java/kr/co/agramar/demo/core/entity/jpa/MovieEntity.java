package kr.co.agramar.demo.core.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "MOVIE")
public class MovieEntity {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "ADULT")
	private Boolean adult;

	@Column(name = "BUDGET", precision = 20, scale = 2)
	private BigDecimal budget;

	@Column(name = "HOMEPAGE")
	private String homepage;

	@Column(name = "IMBD_ID")
	private String imdbID;

	@Column(name = "ORIGINAL_TITLE")
	private String originalTitle;

	@Column(name = "OVERVIEW", length = 4000)
	private String overview;

	@Column(name = "POPULARITY", precision = 10, scale = 6)
	private BigDecimal popularity;

	@Column(name = "POSTER_PATH")
	private String posterPath;

	@Column(name = "RELEASE_DATE")
	private LocalDate releaseDate;

	@Column(name = "REVENUE")
	private Long revenue;

	@Column(name = "RUNTIME", precision = 10, scale = 2)
	private BigDecimal runtime;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private MovieStatus status;

	@Column(name = "TAGLINE", length = 1000)
	private String tagline;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "VIDEO")
	private Boolean video;

	@Column(name = "VOTE_AVERAGE", precision = 4, scale = 2)
	private BigDecimal voteAverage;

	@Column(name = "VOTE_COUNT")
	private Long voteCount;

	@ManyToOne
	@JoinColumn(name = "COLLECTION_ID")
	private MovieCollectionEntity collection;

	@ManyToMany
	private List<MovieGenreEntity> genres;

	@ManyToMany
	private List<CompanyEntity> productionCompanies;

	@ManyToMany
	private List<CountryEntity> productionCountries;

	@ManyToOne
	@JoinColumn(name = "ORIGINAL_LANGUAGE")
	private LanguageEntity originalLanguage;

	@ManyToMany
	private List<LanguageEntity> spokenLanguages;

}
