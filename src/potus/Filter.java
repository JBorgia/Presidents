package potus;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

public class Filter implements PresidentDAO {
	private int presNum;
	private List<President> presList;
	
	public Filter(PresidentDAO presList){
		this.presList = presList.getAllPresidents();
	}

	public List<President> getFilter(
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
			int ratingPointsMin, 
			int ratingPointsMax,
			String party, 
			String occupation, 
			String college, 
			String electoralPercentageMin,
			String electoralPercentageMax, 
			String popularPercentageMin, String popularPercentageMax) {


		if (rangeYearMin != 0 && rangeYearMax != 0)
			getDateRange(rangeYearMin, rangeYearMax);
		if (yearsInOfficeMin != 0 && yearsInOfficeMax != 0)
			getTermRange(yearsInOfficeMin, yearsInOfficeMax);
		if (electoralPercentageMin != "" && electoralPercentageMax != "")
			getElectoralPercentRange(electoralPercentageMin, electoralPercentageMax);
		if (popularPercentageMin != "" && popularPercentageMax != "")
			getPopularPercentRange(popularPercentageMin, popularPercentageMax);
		if (electoralVotesMin != 0 && electoralVotesMax != 0)
			getElectoralVotesRange(electoralVotesMin, electoralVotesMax);
		if (popularVotesMin != 0 && popularVotesMax != 0)
			getPopularVotesRange(popularVotesMin, popularVotesMax);
		if (stateElected != "")
			getStateFilter(stateElected);
		if (party != "")
			getPartyFilter(party);
		if (occupation != "")
			getOccupationFilter(occupation);
		if (college != "")
			getCollegeFilter(college);

		return this.presList;
	}

	private void getDateRange(double min, double max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (president.getInaugYear() > max || president.getEndYear() < min) {
				iterator.remove();
			}
		}
	}

	public void getTermRange(double min, double max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (president.getYearsInOffice() < min || president.getYearsInOffice() > max) {
				iterator.remove();
			}
		}
	}

	public void getElectoralPercentRange(String minS, String maxS) {
		double min = Double.parseDouble(minS);
		double max = Double.parseDouble(maxS);
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (Double.parseDouble(president.getElectoralPercentage()) < min
					|| Double.parseDouble(president.getElectoralPercentage()) > max) {
				iterator.remove();
			}
		}
	}

	public void getPopularPercentRange(String minS, String maxS) {
		double min = Double.parseDouble(minS);
		double max = Double.parseDouble(maxS);
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (Double.parseDouble(president.getPopularPercentage()) < min
					|| Double.parseDouble(president.getPopularPercentage()) > max) {
				iterator.remove();
			}
		}
	}

	public void getElectoralVotesRange(int min, int max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (president.getElectoralVotes() < min || president.getElectoralVotes() > max) {
				iterator.remove();
			}
		}
	}

	public void getPopularVotesRange(int min, int max) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (president.getPopularVotes() < min || president.getPopularVotes() > max) {
				iterator.remove();
			}
		}
	}

	public void getStateFilter(String stateElected) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (!president.getStateElected().equals("stateElected")) {
				iterator.remove();
			}
		}
	}

	public void getPartyFilter(String party) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (!president.getParty().equals("party")) {
				iterator.remove();
			}
		}
	}

	public void getOccupationFilter(String occupation) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (!president.getOccupation().equals("occupation")) {
				iterator.remove();
			}
		}
	}

	public void getCollegeFilter(String college) {
		for (Iterator<President> iterator = presList.iterator(); iterator.hasNext();) {
			President president = (President) iterator.next();
			if (!president.getCollege().equals("college")) {
				iterator.remove();
			}
		}
	}	public President getPresident(int presNum) {
		this.presNum = presNum;
		return presList.get(presNum);
	}

	public List<President> getAllPresidents() {
		return presList;
	}
}
