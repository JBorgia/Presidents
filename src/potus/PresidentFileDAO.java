package potus;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

public class PresidentFileDAO implements PresidentDAO {
	private static final String filename = "WEB-INF/Presidents.csv";
	private int presNum;
	private ServletContext servletContext;
	private List<President> presList;

	public PresidentFileDAO() {
		this(null);
	}

	public PresidentFileDAO(ServletContext context) {
		servletContext = context;
		presList = new ArrayList<>();
		loadPresidentsFromFile();
	}

	private void loadPresidentsFromFile() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		InputStream is = servletContext.getResourceAsStream(filename);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] presidents = line.split(",");
				String firstName = presidents[0];
				String middleName = presidents[1];
				String lastName = presidents[2];
				double yearsInOffice = Double.parseDouble(presidents[3].equals("") ? "-1" : presidents[3]);
				double inaugYear = Double.parseDouble(presidents[4].equals("") ? "-1" : presidents[4]);
				double endYear = Double.parseDouble(presidents[5].equals("") ? "-1" : presidents[5]);
				int ageAtInaug = Integer.parseInt(presidents[6].equals("") ? "-1" : presidents[6]);
				String stateElected = presidents[7];
				int electoralVotes = Integer.parseInt(presidents[8].equals("") ? "-1" : presidents[8]);
				int popularVotes = Integer.parseInt(presidents[9].equals("") ? "-1" : presidents[9]);
				int totalPopularVotes = Integer.parseInt(presidents[10].equals("") ? "-1" : presidents[10]);
				int totalElectoralVotes = Integer.parseInt(presidents[11].equals("") ? "-1" : presidents[11]);
				int ratingPoints = Integer.parseInt(presidents[12].equals("") ? "-1" : presidents[12]);
				String party = presidents[13];
				String occupation = presidents[14];
				String college = presidents[15];
				String electoralPercentage = presidents[16];
				String popularPercentage = presidents[17];

				presList.add(new President(firstName, middleName, lastName, yearsInOffice, inaugYear, endYear,
						ageAtInaug, stateElected, electoralVotes, popularVotes, totalPopularVotes, totalElectoralVotes,
						ratingPoints, party, occupation, college, electoralPercentage, popularPercentage));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public President getPresident(int presNum) {
		this.presNum = presNum;
		return presList.get(presNum);
	}

	public List<President> getAllPresidents() {
		return presList;
	}
}
