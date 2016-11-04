package potus;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

private static final //CSV document

public class PresidentFileDAO implements PresidentDAO {
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
				int inaugYear = presidents[3];
				int yearsInOffice = presidents[4];
				int endYear = presidents[5];
				int ageAtInaug = presidents[6];
				String stateElected = presidents[7];
				int electoralVotes = presidents[8];
				int popularVotes = presidents[9];
				int totalPopularVotes = presidents[10];
				
				presidents.add(new President(symbol, name, price));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
