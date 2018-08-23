package Part3;

public class Feature {

	int[] row;
	int[] col;
	int[] sgn;
	boolean isDummy;
	private double weight;

	public Feature(int[] rows, int[] cols, boolean[] vals, boolean isDummy) {
		this.row = rows;
		this.col = cols;
		this.isDummy = isDummy;
		sgn = new int[4];
		for(int i = 0; i < 4; i ++) {
			if(vals[i]) {
				sgn[i] = 1;
			}
			else if(! vals[i]) {
				sgn[i] = 0;
			}
		}
		weight = 0;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getValue(Image im) {
		if(isDummy) {return 1;}
		int sum =0;
		for(int i = 0; i < 4; i ++) {
			if(im.pixels[row[i]][col[i]] == sgn[i]) {sum ++;}
		}
		return (sum>=3)?1:0;
	}

}
