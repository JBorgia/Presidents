package potus;

import java.util.Iterator;
import java.util.List;

public class Filter {
//	private String firstName;
//	private String middleName;
//	private String lastName;
//	private double inaugYear;
//	private double yearsInOffice;
//	private double endYear;
//	private int ageAtInaug;
//	private String stateElected;
//	private int electoralVotes;
//	private int popularVotes;
//	private int totalPopularVotes;
//	private int totalElectoralVotes;
//	private int ratingPoints;
//	private String party;
//	private String occupation;
//	private String college;
//	private String electoralPercentage;
//	private String popularPercentage;
//	private String presidentPic;
	List<President> presList;
	
	public List<President> getFilter(	List<President> presList, 
										double yearsInOfficeMin, 
										double yearsInOfficeMax, 
										double rangeYearMin,
										double rangeYearMax, 
										int ageAtInAugMin, 
										int ageAtInAugMax, 
										String stateElected, 
										int electoralVotesMin, 
										int electoralVotesMax, 
										int popularVotesMin,
										int popularVotesMax,
										int totalElectoralVotesMin,
										int totalElectoralVotesMax,
										int ratingPointsMin,
										int ratingPointsMax,
										String party,
										String occupation,
										String college, 
										String electoralPercentageMin, 
										String electoralPercentageMax, 
										String popularPercentageMin,
										String popularPercentageMax) {
		
		this.presList = presList;
		getDateRange(rangeYearMin, rangeYearMax);
		getTermRange( yearsInOfficeMin, yearsInOfficeMax);
		
		return presList;
	}
	
	private void getDateRange(double min, double max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getInaugYear() > max || president.getEndYear() < min){
				iterator.remove();
			}
		}
	}
	
	public void getTermRange( double min, double max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getYearsInOffice() < min || president.getYearsInOffice() > max){
				iterator.remove();
			}
		}
	}
	
	public void getElectoralPercentRange(String minS, String maxS) {
		double min = Double.parseDouble(minS);
		double max = Double.parseDouble(maxS);
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getTotalElectoralVotes() < min || president.getTotalElectoralVotes() > max){
				iterator.remove();
			}
		}
	}
	
	public void getPopularPercentRange(String minS, String maxS) {
		double min = Double.parseDouble(minS);
		double max = Double.parseDouble(maxS);
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getPopularPercentage() < min || president.getPopularPercentage() > max){
				iterator.remove();
			}
		}
	}

	
	public void getElectoralVotesRange( int min, int max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getElectoralVotes() < min || president.getElectoralVotes() > max){
				iterator.remove();
			}
		}
	}
	
	public void getPopularVotesRange( int min, int max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getPopularVotes() < min || president.getPopularVotes() > max){
				iterator.remove();
			}
		}
	}
	
	public void getStateFilter(String stateElected){
		
	}
	
	public void getPartyFilter(List<President> presList) {
	}
	
	public void getOccupationFilter(List<President> presList) {
	}
	
	public void getCollegeFilter(List<President> presList) {
	}
}
