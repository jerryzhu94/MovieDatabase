package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MovieDB<T extends Comparable<T>> {
	//Constructor
	public MovieDB(String fileName) throws IOException {
		movies = new ArrayList<Movie>();
		parseFile(fileName);
		indexTreeMap = new HashMap<String, RedBlackTree<T, HashSet<Integer>>>();
		//Create red black tree for id key
		addFieldIndex("id");
	}
	
	public void addFieldIndex(String field) {
		RedBlackTree<T, HashSet<Integer>> rbtree = new RedBlackTree<T, HashSet<Integer>>();
		//Insert each movie into rbtree
		for(int i = 0; i < movies.size(); i++) {
			
			//Map field to corresponding key parameter
			T key = null;
			switch(field) {
				case "id":
					key = (T) movies.get(i).getId();
					break;
				case "color":
					key = (T) movies.get(i).getColor();
					break;
				case "movieTitle":
					key = (T) movies.get(i).getMovieTitle();
					break;
				case "duration":
					key = (T) movies.get(i).getDuration();
					break;
				case "directorName":
					key = (T) movies.get(i).getDirectorName();
					break;
				case "actor1Name":
					key = (T) movies.get(i).getActor1Name();
					break;
				case "actor2Name":
					key = (T) movies.get(i).getActor2Name();
					break;
				case "actor3Name":
					key = (T) movies.get(i).getActor3Name();
					break;
				case "movieLink":
					key = (T) movies.get(i).getMovieLink();
					break;
				case "language":
					key = (T) movies.get(i).getLanguage();
					break;
				case "country":
					key = (T) movies.get(i).getCountry();
					break;
				case "contentRating":
					key = (T) movies.get(i).getContentRating();
					break;
				case "titleYear":
					key = (T) movies.get(i).getTitleYear();
					break;
				case "score":
					key = (T) movies.get(i).getScore();
					break;
			}
			
			HashSet<Integer> ids = rbtree.get(key);
			//Initialize HashSet if key does not already exist in tree
			if(ids == null)
				ids = new HashSet<Integer>();
			ids.add(movies.get(i).getId());
			rbtree.insert(key, ids);
		}
		//Insert field and rbtree into indexTreeMap
		indexTreeMap.put(field, rbtree);
	}
	
	private void parseFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String[] fields;
		//Skip first line
		String line = br.readLine();
		for(int i = 0; (line = br.readLine()) != null; i++) {
			//Delimiter is comma that is not surrounded by quotes
			fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			//Build movie using MovieBuilder and add it to Movie arrayList
			movies.add(new Movie.MovieBuilder(Integer.parseInt(fields[0]))
								 .color(fields[1])
								 .movieTitle(fields[2])
								 .duration(fields[3])
								 .directorName(fields[4])
								 .actor1Name(fields[5])
								 .actor2Name(fields[6])
								 .actor3Name(fields[7])
								 .movieLink(fields[8])
								 .language(fields[9])
								 .country(fields[10])
								 .contentRating(fields[11])
								 .titleYear(fields[12])
								 .score(fields[13])
								 .build());
		}
		br.close();
	}

	//Print the movie information
	public void print(Integer id) {
		movies.get(id - 1).print();
	}
	
	//Returns the hash map for index trees (red black trees)
	public Map<String, RedBlackTree<T, HashSet<Integer>>> getIndexTreeMap(){
		return indexTreeMap;
	}
	
	//Private fields
	private ArrayList<Movie> movies;
	private Map<String, RedBlackTree<T, HashSet<Integer>>> indexTreeMap;
}
