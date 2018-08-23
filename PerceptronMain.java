package Part3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PerceptronMain {

	public PerceptronMain() {}

	ArrayList<Feature> features;
	ArrayList<Image> images;


	/**
	 * Fill out an arraylist of features with 50 random features.
	 * */
	private void fillFeatures() {
		features = new ArrayList<Feature>();
		Random rand = new Random(new Long(123456789));
		for(int i = 0; i < 50; i ++) {
			int[] row = new int[4];
			int[] col = new int[4];
			boolean[] val = new boolean[4];
			for(int j = 0; j < 4; j ++) {
				row[j] = rand.nextInt(10);
				col[j] = rand.nextInt(10);
				val[j] = rand.nextBoolean();
			}
			if(i == 0) {features.add(new Feature(row, col, val, true));}
			else{features.add(new Feature(row, col, val, false));}
		}
	}

	private void loadImages(File f) {
		images = new ArrayList<Image>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			while(reader.ready()) {
				if(reader.readLine().equals("P1")) {
					String classify = reader.readLine();
					String size = reader.readLine();
					String dataLn1 = reader.readLine();
					String dataLn2 = reader.readLine();
					String[] data = (dataLn1 + dataLn2).split("");
					images.add(new Image(classify, size, data));
				}

			}
			}
		catch(IOException e) {System.out.println("File read error: " + e);}
	}

	public static void main(String[] args) {
		PerceptronMain main = new PerceptronMain();
		main.fillFeatures();
		File f = new File("COMP307_ASSN1_Part3/part3/image.data");
		main.loadImages(f);
		Perceptron per = new Perceptron(main.features, main.images);
		per.train();
		per.test();
	}

}
