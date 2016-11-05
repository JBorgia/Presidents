package potus;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentFileDAO implements PresidentDAO {
	private static final String filename = "WEB-INF/Presidents.csv";
	private ServletContext servletContext;
	private List<President> presList ;

	public PresidentFileDAO(ServletContext context) {
		servletContext = context;
		presList = new ArrayList<>();
		loadPresidentsFromFile();
	}

	public PresidentFileDAO(){
		
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
				int inaugYear = Integer.parseInt(presidents[3]);
				double yearsInOffice = Double.parseDouble(presidents[4]);
				int endYear = Integer.parseInt(presidents[5]);
				int ageAtInaug = Integer.parseInt(presidents[6]);
				String stateElected = presidents[7];
				int electoralVotes = Integer.parseInt(presidents[8]);
				int popularVotes = Integer.parseInt(presidents[9]);
				int totalPopularVotes = Integer.parseInt(presidents[10]);
				int totalElectoralVotes = Integer.parseInt(presidents[11]);
				int ratingPoints = Integer.parseInt(presidents[12]);
				String party = presidents[13];
				String occupation = presidents[14];
				String college = presidents[15];
				double electoralPercentage = Double.parseDouble(presidents[16]);
				double popularPercentage = Double.parseDouble(presidents[17]);
				
				presList.add(new President(firstName, middleName, lastName, inaugYear, yearsInOffice,
						endYear, ageAtInaug, stateElected, electoralVotes, popularVotes,
						totalPopularVotes, totalElectoralVotes, ratingPoints, party, occupation,
						college,  electoralPercentage, popularPercentage));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
