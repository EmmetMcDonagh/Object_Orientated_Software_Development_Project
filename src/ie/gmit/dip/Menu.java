
package ie.gmit.dip; //the class is contained within a package called ie.gmit.dip

import static java.lang.System.out;
import java.awt.Color;
import java.awt.image.BufferedImage; //To hold the image file, the bufferedImage class is imported.
import java.util.Scanner; //java.util.Scanner class to read in the user input.
import java.io.BufferedReader;
import java.io.File; //To read image files in the application, a File class is imported. 
import javax.imageio.ImageIO; //To execute the image read write operation the ImageIO class is imported. 
import java.io.IOException; //When executing read/write operations, errors might occur in the code. To handle the errors, the IOException class has been imported into menu.class and is written as import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	public static void main(String[] args) {
	}

	private Scanner s;
	private boolean keepRunning = true;

	public Menu() {
		// The line s = new Scanner(System.in)is called once, inside a method called
		// public menu().
		s = new Scanner(System.in);

	}

	private void EnterImageFilePath() {

		// Prompts the user to enter a file that they want to filter using "Enter full
		// path to image file>".
		// Filepath entered is represented as a String.

		System.out.print(ConsoleColour.BLUE); // To print colour in the console, the ANSI escape codes are used to use
												// colour in the output.

		System.out.println(ConsoleColour.RESET);

		BufferedImage img = null;
		try {
			File f = null;

			System.out.print(ConsoleColour.BLUE);
			System.out.println("[INFO] Input File Path:  "); // The file path which the user enters is represented as a
																// String.
			System.out.println("./png/gmit-rgb.png    ");
			System.out.println("./png/gmit-gs.png     ");
			System.out.println("./png/bridge-rgb.png  ");
			System.out.println("./png/bridge-gs.png   ");

			@SuppressWarnings("resource")

			Scanner user = new Scanner(System.in);
			// Scanner for user input

			String inputFilePath;
			// prepare the input file

			inputFilePath = user.nextLine();

			f = new File(inputFilePath);
			img = ImageIO.read(f); // The image file is written using the write() function of the ImageIO class.
			// The File object f holds the image file path “./png/gmit-rgb.png”.

		} catch (IOException e) { // When reading/writing an image file, a try-catch block is used.
			// If a try-catch block is not used then an exception error might happen and the
			// programme will crash.
			System.out.println(e);
		}
		try {
			// prepare the output file

			File f = new File("./output/output.png");

			ImageIO.write(img, "png", f); // The image file is written using the write() function of the ImageIO class.
		} catch (IOException e) {
			System.out.println(e);

		}
	}// main() ends here

	private void SelectFilter() {
		showOptions();
		System.out.println(ConsoleColour.BLUE);

		System.out.println("[INFO] Select a filter you wish to apply. [1-11]>");
		System.out.println("(1) Identity "); // select the choice of filters available in the class Kernel.java
		System.out.println("(2) Edge Detection_1 ");
		System.out.println("(3) Edge Detection_2 ");
		System.out.println("(4) Sharpen ");
		System.out.println("(5) Vertical Lines ");
		System.out.println("(6) Horizontal Lines ");
		System.out.println("(7) Diagonal 45 Lines ");
		System.out.println("(8) Sobel Horizontal");
		System.out.println("(9) Sobel Vertical");
		System.out.println("(10) Laplacian");
		System.out.println("(11) Box Blur ");

		System.out.print(ConsoleColour.BLUE);
		System.out.println(ConsoleColour.RESET);

		String input = s.next();// Inside the code, contains next() and then when inputting a number to select a
								// menu choice, if the number is entered is incorrect I have it in the loop to
								// sysout “[ERROR] invalid input”.

		try {
			int choice = Integer.parseInt(input);
			BufferedImage img1 = null;
			File f = null;

			switch (choice) {
			case 1:

				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  "); // The file path which the user enters is
																		// represented as a
					// String.
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image from the current ("./png/file.png") directory and convert to
					// a buffered image.
					File output = new File("./output/output_IDENTITY.png"); // Save the buffered Image as output
					ImageIO.read(f);

					BufferedImage picture1 = new BufferedImage(img1.getWidth(), img1.getHeight(),
							BufferedImage.TYPE_INT_RGB);

					int width = img1.getWidth(); // Get the width and height of the image
					int height = img1.getHeight();// 2. Two variables are declared inside the main() function to hold
													// the width and height dimensions of the image. To get the
													// dimensions of the image, we use the getWidth() and getHeight()
													// functions.

					// Apply the convolution kernel.
					double[][] kernel = Kernel.IDENTITY; // The kernel filters can be accessed like so: double [ ] [ ]
															// kernel =kernel.BOX_BLUR;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) { // Two variables x and y are created and two
																			// for loops are used to traverse each
																			// pixel. Read each of the pixels from the
																			// Buffered Image into the same width/height
																			// position in the double[][] array:

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));// The value of
																											// the pixel
																											// at
																											// co-ordinate
																											// (x, y) is
																											// acquired
																											// using the
																											// getRGB(x,y)
																											// function.

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);

							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);// Save the buffered Image as a png image to a folder called
															// output in the application.
				} catch (Exception e) {
				}
				System.out.println("Identity selected");

				break;
			case 2:

				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_EDGE_DETECTION_1.png");

					ImageIO.read(f);

					BufferedImage picture1 = new BufferedImage(img1.getWidth(), img1.getHeight(),
							BufferedImage.TYPE_INT_RGB);

					// Get the width and height of the image and getting the kernel as input
					// from the user
					int width = img1.getWidth();
					int height = img1.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.EDGE_DETECTION_1;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Edge Detection_1 Selected");
				break;
			case 3:

				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_EDGE_DETECTION_2.png");

					ImageIO.read(f);

					BufferedImage picture1 = new BufferedImage(img1.getWidth(), img1.getHeight(),
							BufferedImage.TYPE_INT_RGB);

					// Get the width and height of the image
					int width = img1.getWidth();
					int height = img1.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.EDGE_DETECTION_2;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Edge Detection_2 Selected");

				break;
			case 4:

				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_SHARPEN.png");

					ImageIO.read(f);

					BufferedImage picture1 = new BufferedImage(img1.getWidth(), img1.getHeight(),
							BufferedImage.TYPE_INT_RGB);

					// Get the width and height of the image
					int width = img1.getWidth();
					int height = img1.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.SHARPEN;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Sharpen Selected");

				break;

			case 5:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_VERTICAL_LINES.png");

					ImageIO.read(f);
					BufferedImage img11 = ImageIO.read(f);
					BufferedImage picture1 = new BufferedImage(img11.getWidth(), img11.getHeight(),
							BufferedImage.TYPE_INT_RGB);

					// Get the width and height of the image.
					int width = img11.getWidth();
					int height = img11.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.VERTICAL_LINES;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Vertical_Lines Selected");

				break;
			case 6:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_HORIZONTAL_LINES.png");

					ImageIO.read(f);
					BufferedImage img11 = ImageIO.read(f);
					BufferedImage picture1 = new BufferedImage(img11.getWidth(), img11.getHeight(),
							BufferedImage.TYPE_INT_RGB);
					// Get the width and height of the image
					int width = img11.getWidth();
					int height = img11.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.HORIZONTAL_LINES;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Horizontal_Lines Selected");

				break;
			case 7:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_Diagonal_45_Lines.png");

					ImageIO.read(f);
					BufferedImage img11 = ImageIO.read(f);
					BufferedImage picture1 = new BufferedImage(img11.getWidth(), img11.getHeight(),
							BufferedImage.TYPE_INT_RGB);
					// Get the width and height of the image.
					int width = img11.getWidth();
					int height = img11.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.LAPLACIAN;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Diagonal_45_Lines Selected");

				break;
			case 8:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_Sobel_Horizontal.png");

					ImageIO.read(f);
					BufferedImage img11 = ImageIO.read(f);
					BufferedImage picture1 = new BufferedImage(img11.getWidth(), img11.getHeight(),
							BufferedImage.TYPE_INT_RGB);

					// Get the width and height of the image
					int width = img11.getWidth();
					int height = img11.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.SOBEL_HORIZONTAL;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Sobel_Horizontal Selected");

				break;
			case 9:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_Sobel_Vertical.png");

					ImageIO.read(f);
					BufferedImage img11 = ImageIO.read(f);
					BufferedImage picture1 = new BufferedImage(img11.getWidth(), img11.getHeight(),
							BufferedImage.TYPE_INT_RGB);
					// Get the width and height of the image
					int width = img11.getWidth();
					int height = img11.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.SOBEL_VERTICAL;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Sobel_Vertical Selected");

				break;
			case 10:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_Laplacian.png");

					ImageIO.read(f);
					BufferedImage img11 = ImageIO.read(f);
					BufferedImage picture1 = new BufferedImage(img11.getWidth(), img11.getHeight(),
							BufferedImage.TYPE_INT_RGB);
					// Get the width and height of the image and getting the kernel Matrix as input
					// from the user
					int width = img11.getWidth();
					int height = img11.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.LAPLACIAN;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Laplacian Selected");

				break;
			case 11:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_Box_Blur.png");

					ImageIO.read(f);
					BufferedImage img11 = ImageIO.read(f);
					BufferedImage picture1 = new BufferedImage(img11.getWidth(), img11.getHeight(),
							BufferedImage.TYPE_INT_RGB);

					// Get the width and height of the image
					int width = img11.getWidth();
					int height = img11.getHeight();

					// We can access the kernel filters like this:
					double[][] kernel = Kernel.BOX_BLUR;

					// Two variables x and y are created and two for loops are used to traverse each
					// pixel.
					for (int yCoord = 0; yCoord < height; yCoord++) { // loops for images
						for (int xCoord = 0; xCoord < width; xCoord++) {

							int red = 0;// Red Value
							int green = 0;// Green Value
							int blue = 0;// Blue Value

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									try {
										Color c = new Color(img1.getRGB(xCoord + i - 1, yCoord + j - 1));

										// The RGB is multiplied with current filter element and added on to the
										// variables red, blue and green
										red += c.getRed() * kernel[i][j];
										blue += c.getBlue() * kernel[i][j];
										green += c.getGreen() * kernel[i][j];
									} catch (Exception e) {
									}

								}
							}
							// The value is truncated to 0 and 255 if it goes beyond
							red = Math.min(Math.max((int) (red), 0), 255);
							green = Math.min(Math.max((int) (green), 0), 255);
							blue = Math.min(Math.max((int) (blue), 0), 255);
							Color color = new Color(red, green, blue);
							picture1.setRGB(xCoord, yCoord, color.getRGB());
						}
					}
					ImageIO.write(picture1, "png", output);
				} catch (Exception e) {
				}
				System.out.println("Box_Blur Selected");

				break;
			default:
				System.out.print(ConsoleColour.RED_BACKGROUND_BRIGHT);
				System.out.println("[ERROR] invalid input");
				System.out.println("Please enter a value between 1 and 11 ");
				break;
			}
		} catch (Exception e) {
		}
	}

	private void AdditionalParametersHere() {

		showOptions();
		System.out.println(ConsoleColour.BLUE);
		System.out.println("[INFO] Select additional parameters you wish to apply. [1-6]>");
		System.out.println("(1) Brightness "); // Adjust the brightness of an image
		System.out.println("(2) GreyScale  "); // Convert an RGB image to GS.
		System.out.println("(3) RedImage   "); // convert an RGB image to Red Image.
		System.out.println("(4) Hue        "); // Adjust the Hue of an image.
		System.out.println("(5) GreenImage "); // Convert an RGB image to Green Image.
		System.out.println("(6) BlueImage  "); // Convert an RGB image to Blue Image.

		System.out.print(ConsoleColour.BLUE);
		System.out.println(ConsoleColour.RESET);

		String input = s.next();
		try {

			int choice = Integer.parseInt(input);

			BufferedImage img1 = null;
			File f = null;

			switch (choice) {

			case 1:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  ");
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")
					Scanner user = new Scanner(System.in);
					String inputFileName;
					inputFileName = user.nextLine();
					f = new File(inputFileName);
					img1 = ImageIO.read(f);
				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_BRIGHTNESS.png");

					BufferedImage picture1 = new BufferedImage(img1.getWidth(), img1.getHeight(),
							BufferedImage.TYPE_INT_RGB);
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

					int width1111 = img1.getWidth(); // Two variables are declared inside the
					// main() function to hold the width and
					// height dimension of the image.
					int height1111 = img1.getHeight();

					int factor = 0; // An integer variable is declared for storing the factor value and set to 0.
					do {
						System.out.print(ConsoleColour.BLUE);
						System.out.print("[INFO] Please enter a factor value between 0-100:");

						factor = Integer.parseInt(reader.readLine());
						if (factor > 100 || factor < 0) {

						}
					} while ((factor > 100 || factor < 0));

					for (int yCoord = 0; yCoord < height1111; yCoord++) {// loops for image matrix
						for (int xCoord = 0; xCoord < width1111; xCoord++) {
							// The getWidth() and getHeight() functions are used to achieve this.

							Color c = new Color(img1.getRGB(xCoord, yCoord));

							// Adding Factor to The variables red, blue and green
							int red = c.getRed() + factor;// We then add factor to the variables red, green and blue.
															// The red, green and blue elements are returned in the
															// range 0-255 in the default Srgb space.
							int blue = c.getBlue() + factor;
							int green = c.getGreen() + factor;

							// processing loop
							if (red >= 256) {
								red = 255;
							} else if (red < 0) {
								red = 0;
							}

							if (green >= 256) {
								green = 255;
							} else if (green < 0) {
								green = 0;
							}

							if (blue >= 256) {
								blue = 255;
							} else if (blue < 0) {
								blue = 0;
							}
							picture1.setRGB(xCoord, yCoord, new Color(red, green, blue).getRGB());
							// value of the variables red, green, blue at co-ordinate (x, y) is acquired
							// using the getRGB(x,y)
							// function.
						}
					}
					ImageIO.write(picture1, "png", output); // Write out the file in PNG format

				} catch (Exception e) {
					System.out.println(e);
				}

				break;
			case 2:

				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  "); // The image files used in this application are
																		// named as file.png.
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/bridge-rgb.png  ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img1 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}
				// get image width and height of an image.
				int width = img1.getWidth();
				int height = img1.getHeight();

				// convert to grayscale
				// Takes as parameter the x, y co-ordinates of the pixel and in turn returns an
				// integer value.
				for (int yCoord = 0; yCoord < height; yCoord++) {
					for (int xCoord = 0; xCoord < width; xCoord++) {
						int pixel = img1.getRGB(xCoord, yCoord); // Inside the outer for loop the value of the pixel at
																	// co-ordinate
						// (x, y) is acquired using the getRGB(x,y) function.

						int alpha = (pixel >> 24) & 0xff;
						int red = (pixel >> 16) & 0xff; // Red bits occupy 16 bits from index 16 to index 23.
						int green = (pixel >> 8) & 0xff; // Green bits occupy 8 bits to index 15.
						int blue = pixel & 0xff; // The Blue bits occupy 8 bits from index 0 to index 7.
						// There is no need to right bit shift the pixel bits. This is because the BLUE
						// bits already occupy the rightmost 8 bits. We simple bitwise add it with 0xff.

						// calculate average of R, B, and G value.
						int avg = (red + green + blue) / 3;

						// replace RGB value with avg
						pixel = (alpha << 24) | (avg << 16) | (avg << 8) | avg;

						img1.setRGB(xCoord, yCoord, pixel); // To set the pixel value to an image at the x, y
															// co-ordinates, we use the
						// setRGB(x,y,p) function.
					}
				}

				// Write out the file in PNG format
				try {
					f = new File("./output/output_GREYSCALE.png");
					ImageIO.write(img1, "png", f);
				} catch (IOException e) {
					System.out.println(e);
				}
				System.out.println("Greyscale Selected");

				break;
			case 3:
				// Read in an RGB image and convert to a BufferedImage

				BufferedImage img11 = null;
				File f1 = null;

				// read image
				try {
					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  "); // The image files used in this application are
																		// named as file.png.
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);
					img11 = ImageIO.read(f);

				} catch (IOException e) {
					System.out.println(e);
				}

				// get width and height
				int width1 = img11.getWidth();
				int height1 = img11.getHeight();

				// convert to red image
				for (int yCoord = 0; yCoord < height1; yCoord++) {
					for (int xCoord = 0; xCoord < width1; xCoord++) {
						int pixel = img11.getRGB(xCoord, yCoord);

						int alpha = (pixel >> 24) & 0xff;
						int red = (pixel >> 16) & 0xff;

						// set new RGB
						pixel = (alpha << 24) | (red << 16) | (0 << 8) | 0;

						img11.setRGB(xCoord, yCoord, pixel);
					}
				}

				// write image
				try {
					f1 = new File("./output/output_RED_IMAGE.png");
					ImageIO.write(img11, "png", f1);
				} catch (IOException e) {
					System.out.println(e);
				}
				System.out.println("Red_Image Selected");

				break;
			case 4:
				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  "); // The image files used in this application are
																		// named as file.png.
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")
					Scanner user = new Scanner(System.in);
					String inputFileName;
					inputFileName = user.nextLine();
					f = new File(inputFileName);
					img1 = ImageIO.read(f);
				} catch (IOException e) {
					System.out.println(e);
				}
				try {
					// Read in an image and convert to a BufferedImage

					File output = new File("./output/output_HUE.png");
					// Read in an image and convert to a BufferedImage

					BufferedImage picture1 = new BufferedImage(img1.getWidth(), img1.getHeight(),
							BufferedImage.TYPE_INT_RGB);
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

					int width1111 = img1.getWidth(); // Two variables are declared inside the main() function to hold
														// the width and heights dimensions of the image.
					int height1111 = img1.getHeight();

					int HUE = 0; // An integer variable is declared to hold the hue value and is set to 0.
					do { // loops for image matrix
						System.out.print(ConsoleColour.BLUE);
						out.println("[INFO] Please enter a hue value between 0-360: ");
						HUE = Integer.parseInt(reader.readLine());
						if (HUE > 360 || HUE < 0) {

						}
					} while ((HUE > 360 || HUE < 0));
					float hue = HUE / 360.0f;

					for (int yCoord = 0; yCoord < height1111; yCoord++) {// // processing loop for image matrix
						for (int xCoord = 0; xCoord < width1111; xCoord++) {

							{
								int RGB = img1.getRGB(xCoord, yCoord);
								int RED = (RGB >> 16) & 0xff;
								int GREEN = (RGB >> 8) & 0xff;
								int BLUE = (RGB) & 0xff;
								float HSV[] = new float[3];
								Color.RGBtoHSB(RED, GREEN, BLUE, HSV);// The components of a colour are converted, as
																		// stated by the HSB model to an equivalent set
																		// of values for the default RGB model. The
																		// saturation and brightness elements are stored
																		// as floating point values.
								picture1.setRGB(xCoord, yCoord, Color.getHSBColor(hue, HSV[1], HSV[2]).getRGB());
							}
						}
						ImageIO.write(picture1, "png", output); // Write out the file in PNG format
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			case 5:
				BufferedImage img111 = null;
				File f11 = null;

				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  "); // The image files used in this application are
																		// named as file.png.
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");

					@SuppressWarnings("resource")

					Scanner user = new Scanner(System.in);

					String inputFileName;

					inputFileName = user.nextLine();

					f = new File(inputFileName);

					img111 = ImageIO.read(f);
				} catch (IOException e) {
					System.out.println(e);
				}

				// get width and height
				int width11 = img111.getWidth();
				int height11 = img111.getHeight();

				// convert to green image
				for (int yCoord = 0; yCoord < height11; yCoord++) {
					for (int xCoord = 0; xCoord < width11; xCoord++) {
						int pixel = img111.getRGB(xCoord, yCoord);

						int alpha = (pixel >> 24) & 0xff;
						int green = (pixel >> 8) & 0xff;

						// set new RGB
						pixel = (alpha << 24) | (0 << 16) | (green << 8) | 0;

						img111.setRGB(xCoord, yCoord, pixel);
					}
				}

				// write image
				try {
					f11 = new File("./output/output_GREEN_IMAGE.png");
					ImageIO.write(img111, "png", f11);
				} catch (IOException e) {
					System.out.println(e);
				}
				System.out.println("Green_Image Selected");

				break;
			case 6:
				BufferedImage img1111 = null;
				File f111 = null;

				try {

					// prepare the input file
					System.out.print(ConsoleColour.BLUE);
					System.out.println("[INFO] Input File Path:  "); // The image files used in this application are
																		// named as file.png.
					System.out.println("./png/gmit-rgb.png    ");
					System.out.println("./png/gmit-gs.png     ");
					System.out.println("./png/bridge-rgb.png  ");
					System.out.println("./png/bridge-gs.png   ");
					@SuppressWarnings("resource")
					Scanner user = new Scanner(System.in);
					String inputFileName;
					inputFileName = user.nextLine();
					f = new File(inputFileName);
					img1111 = ImageIO.read(f);
				} catch (IOException e) {
					System.out.println(e);
				}

				// get width and height
				int width111 = img1111.getWidth();
				int height111 = img1111.getHeight();

				// convert to blue image
				for (int yCoord = 0; yCoord < height111; yCoord++) {
					for (int xCoord = 0; xCoord < width111; xCoord++) {
						int pixel = img1111.getRGB(xCoord, yCoord);

						int alpha = (pixel >> 24) & 0xff;
						int blue = pixel & 0xff;

						// set new RGB
						pixel = (alpha << 24) | (0 << 16) | (0 << 8) | blue;
						img1111.setRGB(xCoord, yCoord, pixel);
					}
				}

				// write image
				try {
					f111 = new File("./output/output_BLUE_IMAGE.png");
					ImageIO.write(img1111, "png", f111);
				} catch (IOException e) {
					System.out.println(e);
				}
				System.out.println("Blue_Image Selected");

				break;

			default:
				System.out.print(ConsoleColour.RED_BACKGROUND_BRIGHT);
				System.out.println("[ERROR] invalid input");
				System.out.println("Please enter a value between 1 and 6");

			}
		} catch (Exception e) {
		}
	}

	private void Quit() {
		System.out.println(ConsoleColour.BLUE);
		System.out.println("4) Quit");
	}

	public void start() {

		// the menu is kept alive inside a loop.

		while (keepRunning) {
			showOptions();
			int choice = Integer.parseInt((s.next()));

			if (choice == 1) {
				EnterImageFilePath();

			} else if (choice == 2) {
				SelectFilter();

			} else if (choice == 3) {
				AdditionalParametersHere();

			} else if (choice == 4) {
				Quit();
				System.out.print(ConsoleColour.RED_BACKGROUND_BRIGHT);
				System.out.println("[INFO] Shutting down...please wait...");
				keepRunning = false;
				// When (4) is selected, the loop control variable is set to false.

			} else {
				System.out.print(ConsoleColour.RED_BACKGROUND_BRIGHT);
				System.out.println("[ERROR] invalid input");
				System.out.println("Please enter a value between 1 and 4 ");
			}

		}
	}

	private void showOptions() {
		System.out.println(ConsoleColour.BLUE);

		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println("(1) Enter Image File Path "); // Asks the user to specify the file to process.
		System.out.println("(2) Select a Filter"); // Lists the set of filters available in the class Kernel.java
		System.out.println("(3) Additional Parameters Here");// Added in a extra options to the menu.
		// One method is included to convert an RGB image to GS.
		System.out.println("(4) Quit ");// Terminate
		System.out.println("Select an option (1-4)>");
		System.out.print(ConsoleColour.BLUE);

		System.out.println(ConsoleColour.RESET);
	}

}
