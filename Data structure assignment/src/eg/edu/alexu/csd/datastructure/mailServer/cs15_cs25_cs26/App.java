package eg.edu.alexu.csd.datastructure.mailServer.cs15_cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IApp;
import eg.edu.alexu.csd.datastructure.mailServer.IContact;
import eg.edu.alexu.csd.datastructure.mailServer.IFilter;
import eg.edu.alexu.csd.datastructure.mailServer.IFolder;
import eg.edu.alexu.csd.datastructure.mailServer.IMail;
import eg.edu.alexu.csd.datastructure.mailServer.ISort;
/**
 *
 * @author Abd El Fattah
 * @author Abd El Rahman
 * @author Gamal Eldien
 *
 */
public class App implements IApp {

	@Override
	public boolean signin(final String email, final String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean signup(final IContact contact) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void setViewingOptions(final IFolder folder,
			final IFilter filter, final ISort sort) {
		// TODO Auto-generated method stub

	}

	@Override
	public final IMail[] listEmails(final int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmails(final ILinkedList mails) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveEmails(final ILinkedList mails, final IFolder des) {
		// TODO Auto-generated method stub

	}

	@Override
	public final boolean compose(final IMail email) {
		// TODO Auto-generated method stub
		return false;
	}

}
