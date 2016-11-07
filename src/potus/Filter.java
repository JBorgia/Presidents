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
										double RangeYearMin,
										double RangeYearMax, 
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
		getDateRange(RangeYearMin, RangeYearMax);
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
			if (president.getYearsInOffice() < min && president.getYearsInOffice() > max){
				iterator.remove();
			}
		}
	}
	
	public void getElectoralPercentRange(List<President> presList) {
	}
	
	public void getPopularPercentRange(List<President> presList) {
	}

	
	public void getElectoralVotesRange(List<President> presList) {
	}
	
	public void getPopularVotesRange(List<President> presList) {
	}
	
	public void getStateFilter(List<President> presList) {
	}
	
	public void getPartyFilter(List<President> presList) {
	}
	
	public void getOccupationFilter(List<President> presList) {
	}
	
	public void getCollegeFilter(List<President> presList) {
	}
}
