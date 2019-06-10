/* Movie class is an immutable storage class that holds information about a movie.
 * It uses the MovieBuilder to create and define optional parameters. 
 * id is the only required field when creating a movie. This class provides public 
 * getter methods a print function for other classes to use.
 */

package database;

public class Movie {

	//Constructor
	public Movie(MovieBuilder builder) {
		this.id = builder.id;
		this.color = builder.color;
		this.movieTitle = builder.movieTitle;
		this.duration = builder.duration;
		this.directorName = builder.directorName;
		this.actor1Name = builder.actor1Name;
		this.actor2Name = builder.actor2Name;
		this.actor3Name = builder.actor3Name;
		this.movieLink = builder.movieLink;
		this.language = builder.language;
		this.country = builder.country;
		this.contentRating = builder.contentRating;
		this.titleYear = builder.titleYear;
		this.score = builder.score;
	}

	//Getter methods
	public Integer getId() {
		return this.id;
	}

	public String getColor() {
		return this.color;
	}

	public String getMovieTitle() {
		return this.movieTitle;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public String getDirectorName() {
		return this.directorName;
	}

	public String getActor1Name() {
		return this.actor1Name;
	}

	public String getActor2Name() {
		return this.actor2Name;
	}

	public String getActor3Name() {
		return this.actor3Name;
	}

	public String getMovieLink() {
		return this.movieLink;
	}

	public String getLanguage() {
		return this.language;
	}

	public String getCountry() {
		return this.country;
	}

	public String getContentRating() {
		return this.contentRating;
	}

	public Integer getTitleYear() {
		return this.titleYear;
	}

	public Double getScore() {
		return this.score;
	}

	//Print method
	public void print() {

		System.out.println("-----------------------------");
		System.out.println("id: " + id);
		System.out.println("color: " + color);
		System.out.println("title: " + movieTitle);
		System.out.println("duration: " + duration);
		System.out.println("director name: " + directorName);
		System.out.println("actor 1: " + actor1Name);
		System.out.println("actor 2: " + actor2Name);
		System.out.println("actor 3: " + actor3Name);
		System.out.println("movie imdb link: " + movieLink);
		System.out.println("language: " + language);
		System.out.println("country: " + country);
		System.out.println("content rating: " + contentRating);
		System.out.println("title year: " + titleYear);
		System.out.println("imdb score: " + score);
		System.out.println("-----------------------------");
	}

	//Movie Builder. Builder is a creational design pattern that is used to create immutable
	//and complex objects.
	static public class MovieBuilder {

		//Id is required field
		public MovieBuilder(Integer id) {
			this.id = id;
		}

		//Optional methods
		public MovieBuilder color(String color) {
			this.color = color;
			return this;
		}

		public MovieBuilder movieTitle(String movieTitle) {
			this.movieTitle = movieTitle;
			return this;
		}

		public MovieBuilder duration(String duration) {
			try {
				this.duration = Integer.parseInt(duration);
			} catch (NumberFormatException e) {
				this.duration = 0;
			}
			return this;
		}

		public MovieBuilder directorName(String directorName) {
			this.directorName = directorName;
			return this;
		}

		public MovieBuilder actor1Name(String actor1Name) {
			this.actor1Name = actor1Name;
			return this;
		}

		public MovieBuilder actor2Name(String actor2Name) {
			this.actor2Name = actor2Name;
			return this;
		}

		public MovieBuilder actor3Name(String actor3Name) {
			this.actor3Name = actor3Name;
			return this;
		}

		public MovieBuilder movieLink(String movieLink) {
			this.movieLink = movieLink;
			return this;
		}

		public MovieBuilder language(String language) {
			this.language = language;
			return this;
		}

		public MovieBuilder country(String country) {
			this.country = country;
			return this;
		}

		public MovieBuilder contentRating(String contentRating) {
			this.contentRating = contentRating;
			return this;
		}

		public MovieBuilder titleYear(String titleYear) {
			try {
				this.titleYear = Integer.parseInt(titleYear);
			} catch (NumberFormatException e) {
				this.titleYear = 0;
			}
			return this;
		}

		public MovieBuilder score(String score) {
			try {
				this.score = Double.parseDouble(score);
			} catch (NumberFormatException e) {
				this.score = (double) 0;
			}
			return this;
		}

		//Build movie
		public Movie build() {
			return new Movie(this);
		}

		//Required field
		private final Integer id;

		//Optional fields
		private String color = "";
		private String movieTitle = "";
		private Integer duration = 0;
		private String directorName = "";
		private String actor1Name = "";
		private String actor2Name = "";
		private String actor3Name = "";
		private String movieLink = "";
		private String language = "";
		private String country = "";
		private String contentRating = "";
		private Integer titleYear = 0;
		private Double score = (double) 0;
	}

	//Private fields
	private final Integer id;
	private String color;
	private String movieTitle;
	private Integer duration;
	private String directorName;
	private String actor1Name;
	private String actor2Name;
	private String actor3Name;
	private String movieLink;
	private String language;
	private String country;
	private String contentRating;
	private Integer titleYear;
	private Double score;
}
