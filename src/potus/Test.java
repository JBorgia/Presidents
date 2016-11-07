package potus;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

@SuppressWarnings("serial")
public class Test {
	private PresidentDAO presidentDAO;
	int presNum;

	public void main()  {
		presNum = 0;
		presidentDAO = new PresidentFileDAO();

		Filter filter = new Filter(presidentDAO);
		filter.getFilter(
						4,
						12,
						0,
						0,
						0,
						0,
						"",
						0,
						0,						
						0,
						0,
						0,
						0,
						"",
						"",
						"",
						"",
						"",
						"",
						"");
		
		presidentDAO = (PresidentDAO)filter;
		
		for (int i = 0; i<presidentDAO.getAllPresidents().size();i++) {
			System.out.println(presidentDAO.getPresident(i).getFirstName());
		}
	}

}