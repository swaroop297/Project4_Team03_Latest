package utility;

/**
 * Utility class containing Affective part of the face data.
 * @SER516 Project3_Team03
 * @version 1.0
 */
public class FaceAffectiveData {
	
	Double meditation = 0.0;
	Double engagementBoredom = 0.0;
	Double excitementShortTerm = 0.0;
	Double frustation = 0.0;
	Double excitementLongTerm = 0.0;
	
	public FaceAffectiveData() {
		this.meditation = new Double(0.0);
		this.engagementBoredom = new Double(0.0);
		this.excitementShortTerm = new Double(0.0);
		this.frustation = new Double(0.0);
		this.excitementLongTerm = new Double(0.0);
	}

	public Double getMeditation() {
		return meditation;
	}
	public void setMeditation(Double meditation) {
		this.meditation = meditation;
	}
	public Double getEngagementBoredom() {
		return engagementBoredom;
	}
	public void setEngagementBoredom(Double engagementBoredom) {
		this.engagementBoredom = engagementBoredom;
	}
	public Double getExcitementShortTerm() {
		return excitementShortTerm;
	}
	public void setExcitementShortTerm(Double excitementShortTerm) {
		this.excitementShortTerm = excitementShortTerm;
	}
	public Double getFrustation() {
		return frustation;
	}
	public void setFrustation(Double frustation) {
		this.frustation = frustation;
	}
	public Double getExcitementLongTerm() {
		return excitementLongTerm;
	}
	public void setExcitementLongTerm(Double excitementLongTerm) {
		this.excitementLongTerm = excitementLongTerm;
	} 
	
	public void reset(){
		 meditation = 0.0;
		 engagementBoredom = 0.0;
		 excitementShortTerm = 0.0;
		 frustation = 0.0;
		 excitementLongTerm = 0.0;
			
	}
	
	/**
	 * Stores various values into an array
	 * @return contains the affective data array
	 */
	public double[] fetchVectors() {
		double[] p = new double[5];
		p[0] = getMeditation();
		p[1] = getEngagementBoredom();
		p[2] = getExcitementShortTerm();
		p[3] = getFrustation();
		p[4] = getExcitementLongTerm();
		return p;
	}
	
	/**
	 * Converts the received affective data into string.
	 */
	public String toString() {
		return "FaceAffectiveData{" +
				"meditation=" + meditation +
				", engagementBoredom=" + engagementBoredom +
				", excitementShortTerm=" + excitementShortTerm +
				", frustation=" + frustation +
				", excitementLongTerm=" + excitementLongTerm +
				'}';
	}
	
	
}
