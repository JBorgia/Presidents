package potus;

public class President {
	private String firstName;
	private String middleName;
	private String lastName;
	private int inaugYear;
	private int yearsInOffice;
	private int endYear;
	private int ageAtInAug;
	private String stateElected;
	private int electoralVotes;
	private int popularVotes;
	private int totalPopularVotes;
	private int totalElectoralVotes;
	private int ratingPoints;
	private String party;
	private String occupation;
	private String college;
	private int electoralPercentage;
	private int popularPercentage;
	

	public President(String firstName, String middleName, String lastName, int inaugYear, int yearsInOffice,
			int endYear, int ageAtInAug, String stateElected, int electoralVotes, int popularVotes,
			int totalPopularVotes, int totalElectoralVotes, int ratingPoints, String party, String occupation,
			String college, int electoralPercentage, int popularPercentage) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.inaugYear = inaugYear;
		this.yearsInOffice = yearsInOffice;
		this.endYear = endYear;
		this.ageAtInAug = ageAtInAug;
		this.stateElected = stateElected;
		this.electoralVotes = electoralVotes;
		this.popularVotes = popularVotes;
		this.totalPopularVotes = totalPopularVotes;
		this.totalElectoralVotes = totalElectoralVotes;
		this.ratingPoints = ratingPoints;
		this.party = party;
		this.occupation = occupation;
		this.college = college;
		this.electoralPercentage = electoralPercentage;
		this.popularPercentage = popularPercentage;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getInaugYear() {
		return inaugYear;
	}
	public void setInaugYear(int inaugYear) {
		this.inaugYear = inaugYear;
	}
	public int getYearsInOffice() {
		return yearsInOffice;
	}
	public void setYearsInOffice(int yearsInOffice) {
		this.yearsInOffice = yearsInOffice;
	}
	public int getAgeAtInAug() {
		return ageAtInAug;
	}
	public void setAgeAtInAug(int ageAtInAug) {
		this.ageAtInAug = ageAtInAug;
	}
	public String getStateElected() {
		return stateElected;
	}
	public void setStateElected(String stateElected) {
		this.stateElected = stateElected;
	}
	public int getElectoralVotes() {
		return electoralVotes;
	}
	public void setElectoralVotes(int electoralVotes) {
		this.electoralVotes = electoralVotes;
	}
	public int getPopularVotes() {
		return popularVotes;
	}
	public void setPopularVotes(int popularVotes) {
		this.popularVotes = popularVotes;
	}
	public int getTotalPopularVotes() {
		return totalPopularVotes;
	}
	public void setTotalPopularVotes(int totalPopularVotes) {
		this.totalPopularVotes = totalPopularVotes;
	}
	public int getTotalElectoralVotes() {
		return totalElectoralVotes;
	}
	public void setTotalElectoralVotes(int totalElectoralVotes) {
		this.totalElectoralVotes = totalElectoralVotes;
	}
	public int getRatingPoints() {
		return ratingPoints;
	}
	public void setRatingPoints(int ratingPoints) {
		this.ratingPoints = ratingPoints;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public int getElectoralPercentage() {
		return electoralPercentage;
	}
	public void setElectoralPercentage(int electoralPercentage) {
		this.electoralPercentage = electoralPercentage;
	}
	public int getPopularPercentage() {
		return popularPercentage;
	}
	public void setPopularPercentage(int popularPercentage) {
		this.popularPercentage = popularPercentage;
	}
	
}
