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
										double yearsInOffice, 
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
		
		
		return presList;
	}
	
	private void getDateRange(int start, int end) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getInaugYear() > end || president.getEndYear() < start){
				iterator.remove();
			}
		}
	}
	
	public List<President> getTermRange(List<President> presList, double min, double max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();			
			if (president.getYearsInOffice() < min && president.getYearsInOffice() > max){
				iterator.remove();
			}
		}
		return presList;
	}
	
	public List<President> getElectoralPercentRange(List<President> presList) {
		return presList;
	}
	
	public List<President> getPopularPercentRange(List<President> presList) {
		return presList;
	}

	
	public List<President> getElectoralVotesRange(List<President> presList) {
		return presList;
	}
	
	public List<President> getPopularVotesRange(List<President> presList) {
		return presList;
	}
	
	public List<President> getStateFilter(List<President> presList) {
		return presList;
	}
	
	public List<President> getPartyFilter(List<President> presList) {
		return presList;
	}
	
	public List<President> getOccupationFilter(List<President> presList) {
		return presList;
	}
	
	public List<President> getCollegeFilter(List<President> presList) {
		return presList;
	}
}
