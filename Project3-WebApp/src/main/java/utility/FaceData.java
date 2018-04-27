package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Utility class containing the face data.
 * 
 * @SER516 Project3_Team03
 * @version 1.0
 */
public class FaceData {
	FaceExpressionData faceExpressionData;
	FaceAffectiveData faceAffectiveData;
	Double timeElapsed = 0.0;

	public FaceExpressionData getFaceExpressionData() {
		return faceExpressionData;
	}

	public void setFaceExpressionData(FaceExpressionData faceExpressionData) {
		this.faceExpressionData = faceExpressionData;
	}

	public FaceAffectiveData getFaceAffectiveData() {
		return faceAffectiveData;
	}

	public void setFaceAffectiveData(FaceAffectiveData faceAffectiveData) {
		this.faceAffectiveData = faceAffectiveData;
	}

	public Double getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(Double timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	/**
	 * Converts the received affective data into string.
	 */
	public String toString() {
		return "FaceData{" + "faceExpressionData=" + faceExpressionData + ", faceAffectiveData=" + faceAffectiveData
				+ '}';
	}

	/**
	 * Method to convert Face Data values into a csv file. File will be in Downloads
	 * folder of user's machine.
	 */
	public void tocsv() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File(System.getProperty("user.home") + "/Downloads/FaceExpressiondata.csv"));
			StringBuilder sb = new StringBuilder();
			sb.append("Raise Brow ,Furrow Brow ,Smile,Clench,Smirk Left,Smirk Right, laugh, blink, "
					+ "Wink Left, Wink Right, Look Left, Look Right, Eye Reset, Meditation, Engagement Boredom,"
					+ "Frustation, Excitement ShortTerm,Excitement LongTerm, Time Elapsed");
			sb.append('\n');
			sb.append(faceExpressionData.getRaiseBrow() + "," + faceExpressionData.getFurrowBrow() + ","
					+ faceExpressionData.getSmile() + "," + faceExpressionData.getClench() + ","
					+ faceExpressionData.getSmirkLeft() + "," + faceExpressionData.getSmirkRight() + ","
					+ faceExpressionData.getLaugh() + "," + faceExpressionData.getBlink() + ","
					+ faceExpressionData.getWinkLeft() + "," + faceExpressionData.getWinkRight() + ","
					+ faceExpressionData.getLookLeft() + "," + faceExpressionData.getLookRight() + ","
					+ faceExpressionData.getEyeReset() + "," + faceAffectiveData.getMeditation() + ","
					+ faceAffectiveData.getEngagementBoredom() + "," + faceAffectiveData.getFrustation() + ","
					+ faceAffectiveData.getExcitementShortTerm() + "," + faceAffectiveData.getExcitementLongTerm() + ","
					+ getTimeElapsed());
			pw.write(sb.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("done!");
	}
}
