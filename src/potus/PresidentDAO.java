package potus;

import java.util.List;

public interface PresidentDAO {
	public President getPresident(int presNum);
	public President getNext();
	public President getPrev();
	public List<President> getAllPresidents();
}
