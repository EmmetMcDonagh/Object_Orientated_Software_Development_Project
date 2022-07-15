
package ie.gmit.dip;

public class Kernel {

	// Within kernel.class each of the 2D array kernels implemented are declared as
	// “public static final double [][] therefore they belong to this class and not
	// an instance of it. The kernels can be referred to each array using the
	// ClassName.featureName notation, e,g. double [][]kernel =Kernel.BOX_BLUR.

	public static final double[][] IDENTITY = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

	public static final double[][] EDGE_DETECTION_1 = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };

	public static final double[][] EDGE_DETECTION_2 = { { 1, 0, -1 }, { 0, 0, 0 }, { -1, 0, 1 } };

	public static final double[][] LAPLACIAN = { { 0, -1, 0 }, { -1, 4, -1 }, { 0, -1, 0 } };

	public static final double[][] SHARPEN = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };

	public static final double[][] VERTICAL_LINES = { { -1, 2, -1 }, { -1, 2, -1 }, { -1, 2, -1 } };

	public static final double[][] HORIZONTAL_LINES = { { -1, -1, -1 }, { 2, 2, 2 }, { -1, -1, -1 } };

	public static final double[][] DIAGONAL_45_LINES = { { -1, -1, 2 }, { -1, 2, -1 }, { 2, -1, -1 } };

	public static final double[][] BOX_BLUR = { { 0.111, 0.111, 0.111 }, { 0.111, 0.111, 0.111 },
			{ 0.111, 0.111, 0.111 } };

	public static final double[][] SOBEL_HORIZONTAL = { { -1, -2, -1 }, { 0, 0, 0 }, { 1, 2, 1 } };

	public static final double[][] SOBEL_VERTICAL = { { -1, 0, 1 }, { -2, 0, 2 }, { -1, 0, 1 } };
}