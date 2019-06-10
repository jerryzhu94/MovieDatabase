package database;

import java.io.IOException;
import java.util.Map;

import query.*;

//Entry point of the application
public class Client {

	public static void main(String[] args) throws IOException {
		//Parse file and create database
		MovieDB db = new MovieDB("movie_metadata.csv");
		//Create red-black-trees
		db.addFieldIndex("id");
		db.addFieldIndex("color");
		db.addFieldIndex("movieTitle");
		db.addFieldIndex("duration");
		db.addFieldIndex("directorName");
		db.addFieldIndex("actor1Name");
		db.addFieldIndex("actor2Name");
		db.addFieldIndex("actor3Name");
		db.addFieldIndex("movieLink");
		db.addFieldIndex("language");
		db.addFieldIndex("country");
		db.addFieldIndex("contentRating");
		db.addFieldIndex("titleYear");
		db.addFieldIndex("score");
		Map map = db.getIndexTreeMap();
		//Make and execute query. Then print out results
		Query query = makeQuery();
		System.out.println(query.execute(map));
		for(Object id : query.execute(map))
			db.print((Integer) id);
	}
	
	public static Query makeQuery() {
		
		//return new And(new Equal("titleYear",2012),new Equal("score",6.1));
		//return new And(new GTE("score", 7.8), new LTE("score", 7.9));
		//return new Or(new Equal("score", 7.7), new Equal("score", 7.9));
		//return new Not(new And(new Not(new Equal("titleYear", 2012)), new Not(new Equal("score", 7.0))));
		//return new And(new NotEqual("score", 7.3), new GTE("score", 7.1), new LTE("score", 7.5));
		//return new And(new Or(new Equal("titleYear",2013),new GTE("score",6.0)), new NotEqual("language", "English"), new GTE("movieTitle","Y"));
		return new Or(new And(new Equal("country", "USA"), new Equal("titleYear", 2016), new GTE("duration", 120)), new GTE("language", "Z"));
	}
}
