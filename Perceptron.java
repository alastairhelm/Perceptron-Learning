package Part3;

import java.util.ArrayList;

public class Perceptron {

	ArrayList<Feature> features;
	ArrayList<Image> images;

	public Perceptron(ArrayList<Feature> features, ArrayList<Image> images) {
		this.features = features;
		this.images = images;
	}

	public void train() {
		for(int i = 0; i < Integer.MAX_VALUE; i ++) {
			int correct = 0;
			for(Image im : images) {
				double predict = 0;
				for(Feature f : features) {
					predict += (f.getWeight() * f.getValue(im));
				}
				if(predict > 0) {predict = 1;}
				else {predict = 0;}
				if(predict == im.expect()) {
					correct ++;
				}
				for(Feature f : features) {
					double nWeight = f.getWeight() + (0.2 * (im.expect() - predict)*f.getValue(im));
					f.setWeight(nWeight);
				}
			}
			if(correct == images.size()) {
				System.out.println(i + " Runs through");
				return;}
		}
	}

	public void test() {
		for(Image im : images) {
			double predict = 0;
			for(Feature f : features) {
				predict += (f.getWeight() * f.getValue(im));
			}
			if(predict > 0) {predict = 1;}
			else {predict = 0;}
			if(predict == 1) {System.out.println( "X " + im.category);}
			else if(predict == 0) {System.out.println("O " + im.category);}
		}	
	}
}


