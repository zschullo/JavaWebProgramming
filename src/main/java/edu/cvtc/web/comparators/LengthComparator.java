package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author zschullo
 *
 */
public class LengthComparator implements Comparator<Movie> {
	
	@Override
	public int compare(final Movie movie1, final Movie movie2) {
		
		return movie1.getLengthInMinutes().compareTo(movie2.getLengthInMinutes());
		
	}

}
