package Part3;

public class Image {

	String category;
	int xSize;
	int ySize;
	int[][] pixels;

	public Image(String cat, String size, String[] data) {
		this.category = cat;
		String[] xy = size.split(" ");
		xSize = Integer.parseInt(xy[0]);
		ySize = Integer.parseInt(xy[1]);
		int dataPos = 0;
		this.pixels = new int[xSize][ySize];
		for(int x = 0; x < pixels.length; x ++) {
			for(int y = 0; y < pixels[x].length; y ++) {
				pixels[x][y] = Integer.parseInt(data[dataPos]);
				dataPos ++;
			}
		}
	}

	public double expect() {
		if(this.category.equals("#X")) {return 1.0;}
		return 0.0;
	}

	public String toString() {
		String s = category + "\n" + xSize + "  " + ySize + "\n";
		for(int x = 0; x < pixels.length; x ++) {
			for(int y = 0; y < pixels[x].length; y ++) {
				s = s + pixels[x][y];
			}
			s = s + "\n";
		}
		return s;
	}

}
