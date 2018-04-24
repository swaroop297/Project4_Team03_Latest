package server.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import utility.FaceAffectiveData;
import utility.FaceData;
import utility.FaceExpressionData;

public class ProcessJsonFile {
	public void processFile() throws IOException {
		String file = "sample.json";
		BufferedReader bufferReader = new BufferedReader(new FileReader(file));
		try {
		    StringBuilder sb = new StringBuilder();
		    String inputLine = bufferReader.readLine();
		    inputLine = bufferReader.readLine();
		    sb.append(inputLine);
		    String[] inputValues = sb.toString().split(",");
		    System.out.println(inputValues);
		    FaceData faceData = setValuesToModal(inputValues);
		    System.out.println(faceData.toString());
		} finally {
		    bufferReader.close();
		}
	}
	
	public FaceData setValuesToModal(String [] input) {

		FaceExpressionData faceExpressionData = new FaceExpressionData();
		FaceAffectiveData faceAffectiveData = new FaceAffectiveData();
		FaceData faceData = new FaceData();
		
		faceExpressionData.setRaiseBrow(Double.parseDouble(input[0]));
		faceExpressionData.setFurrowBrow(Double.parseDouble(input[1]));
		faceExpressionData.setSmile(Double.parseDouble(input[2]));
		faceExpressionData.setClench(Double.parseDouble(input[3]));
		faceExpressionData.setSmirkLeft(Double.parseDouble(input[4]));
		faceExpressionData.setSmirkRight(Double.parseDouble(input[5]));
		faceExpressionData.setLaugh(Double.parseDouble(input[6]));
		faceExpressionData.setBlink(Double.parseDouble(input[7]));
		faceExpressionData.setWinkLeft(Double.parseDouble(input[8]));
		faceExpressionData.setWinkRight(Double.parseDouble(input[9]));
		faceExpressionData.setLookLeft(Double.parseDouble(input[10]));
		faceExpressionData.setLookRight(Double.parseDouble(input[11]));
		if(input[12] == "false") {
			faceExpressionData.setEyeReset(false);
		}else {
			faceExpressionData.setEyeReset(true);
		}
		faceAffectiveData.setMeditation(Double.parseDouble(input[13]));
		faceAffectiveData.setEngagementBoredom(Double.parseDouble(input[14]));
		faceAffectiveData.setFrustation(Double.parseDouble(input[15]));
		faceAffectiveData.setExcitementShortTerm(Double.parseDouble(input[16]));
		faceAffectiveData.setExcitementLongTerm(Double.parseDouble(input[17]));
		faceData.setTimeElapsed(Double.parseDouble(input[18]));
		faceData.setFaceAffectiveData(faceAffectiveData);
		faceData.setFaceExpressionData(faceExpressionData);
		
		return faceData;
	}
	
	public static void main(String args[]) {
		ProcessJsonFile processJsonFile = new ProcessJsonFile();
		try {
			processJsonFile.processFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
