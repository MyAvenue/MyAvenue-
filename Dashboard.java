import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Dashboard extends AbsoluteLayout {
	protected Button courseoutline;
	protected Button aboutus;
	protected Button myprofile;
	protected Button coursecomplete;
	protected Button dashboard;
	protected Button wamcalculator;
	protected ProgressBar prograssionbar;
	protected Label wam;
	protected Label uOCLEFT;
	protected Label cLASSSTATS;

	public Dashboard() {
		Design.read(this);
	}
}
