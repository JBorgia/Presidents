package potus;

import java.util.List;

public interface PresidentDAO {
	public President getPresident(int presNum);
	public List<President> getAllPresidents();
}
