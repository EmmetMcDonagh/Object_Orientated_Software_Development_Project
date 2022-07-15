# Filtering-an-Image-with-a-Convolution-Kernel
H.Dip. in Science (Software Development)
Object-Oriented Software Development (2021)
ASSIGNMENT:  Filtering an Image with a Convolution Kernel




Submitted by: Emmet McDonagh (G00222864)
Submitted to: Dr. John Healy




31st August 2021


Overview:

To develop a command line menu driven Java application which implements convolution on 2D arrays of buffered images using kernels. In image processing, a convolution kernel is a small 2D matrix, in the application, 2D array structures are used to perform operations like blurring, sharpening, edge-detection etc. on PNG images (Powell, 2014). 

The application contains a command-line driven menu which asks the user to specify the input and output of file images. Relative file paths from the current directory (./filename.png) have been used to make the application more portable. Inside the zip file along with the src and Readme.txt, there are two extra folders, one containing the png images and the other where all output is saved to. These are added to the root of the eclipse project, and therefore not in the src or bin directory. 

Within the src folder there are four main classes: runner.java, menu.java, kernel.java and consolecolour.java. The required main() method to run the application is defined inside the class called Runner.java. 
Inside kernel.class each of the 2D array kernels implemented are declared as "public static final double [][] therefore they belong to this class and not an instance of it. The kernels can be referred to each array using the ClassName.featureName notation, e,g. double [][]kernel =Kernel.BOX_BLUR. 

The console colour class prints colour in the console, the ANSI escape codes are used to use colour in the output. 

Inside the menu class, there are four different methods for different menus, each displaying a prompt to process the user response. Scanner is imported to read in the filename and ImageIO to write the file out as in output.png. A new switch statement is used to process the choice. The menu is kept alive inside a loop. When (4) is selected, the loop control is set to false. Inside the code, contains next() and then when inputting a number to select a menu choice, if the number entered is incorrect I have it in the loop to sysout "[ERROR] invalid input". 

The four methods are as follows:
1) EnterImageFilePath(). Asks the user to enter the image file path that they want to read and write using buffered image "[INFO] Input File Path". The file path which the user enters is represented as a String. 

2) SelectFilter().Asks the user to enter the filter that they want to use to process the image "[INFO] Select a filter you wish to apply. [1-11]". Lists the set the filters available i.e. edge detection, BOX_BLUR etc.

3) AdditionalParametersHere(). Adds extra options to the menu. Asks the user to select additional parameters that they want to use. "[INFO] Select additional parameters you wish to apply. [1-6]". One method is included to convert an RGB image to grey scale.

4) Quit(). Terminates the application. 

The EnterImageFilePath() function prompts the user to specify the file path that reads in an image, therefore a File class is imported. When executing read/write operations also known as I/O or exception handling, errors might occur in the code. To handle the errors, the IOException class has been imported into menu.class and a try-catch block is used. To hold the image file, the bufferedImage class is imported. To execute the image read write operation the ImageIO class is imported. Inside the body of the try-catch statement, an object of File class is created and passed as parameter the image file path. The File object f holds the image file path. When writing the image file, a try-catch block is used again to handle any exception handling errors. An instance of File type is created and passed as parameter the image file path where we want to write the image as output. The image file is written using the write() function of the ImageIO class. The buffered image is then saved as output. 

The SelectFilter() function lists the choice of filters available in kernel.java i.e. edge detection, BOX_BLUR etc. The following steps have been done to filter an image file. 
1. Read in an image from the current directory ("./filename.png") and convert to a buffered image. The kernel filters can be accessed like so: double [ ] [ ] kernel =kernel.BOX_BLUR; etc. 

2. Two variables are declared inside the main() function to hold the width and height dimensions of the image. To get the dimensions of the image, we use the getWidth() and getHeight() functions. 

3. Two variables x and y are created and two for loops are used to traverse each pixel. Read each of the pixels from the Buffered Image into the same width/height position in the double[][] array:
for (int y = 0; y < height; y++) {
	for (int x = 0; x < width; x++) {
The value of the pixel at co-ordinate (x, y) is acquired using the getRGB(x,y) function.

4. Calculating X and Y coordinates of the pixel to be multiplied with current kernel element

5. Apply the convolution kernel. 

6. The RGB is multiplied with current filter element and added on to the variables red, blue and green

7. Write each of the values in the double [ ][ ] array into the pixels in the buffered Image. 

8. Save the buffered Image as a png image to a folder called output in the application. 

Additional extras:
The AdditionalParametersHere() function adds extra options to the menu. The six methods are as follows:

1) GreyScale: Converts an RGB image to grey scale.

2) RedImage: Converts an RGB image to a Red Image. 

3) GreenImage: Converts an RGB image to a Green Image.

4) BlueImage: Converts an RGB image to a Blue Image.

5) Brightness: Adjusts the Brightness of an image. 

6) Hue: Adjusts the hue of an image. 

A grey scale function converts an RGB image to grey scale. Generally, a grayscale image uses an 8-bit representation for each pixel, therefore the values from 0 to 255 can be represented. A grayscale image in 8-bit representation will be a matrix, and the values that are returned from a red, blue or green variables can be anywhere from 0 to 255 (Joram, 2019). An image is read in and converted to Buffered Image variable image. The File variable f is set to null. Two variables are declared inside the main() function to hold the width and heights dimensions of the image. This function takes as parameter the x, y co-ordinates of the pixel and in turn returns an integer value. Inside the outer for loop the value of the pixel at co-ordinate (x, y) is acquired using the getRGB(x,y) function. The alpha, red, green and blue values are then extracted from the pixel value. We do this by creating five integer variables of p, a, r, g, and b to store the pixels respectively (Shakeel, 2014). The Red bits occupy 16 bits from index 16 to index 23.The Green bits occupy 8 bits to index 15.In order to get the Green bits, you need to do right bit shift the 32 bits of the pixels by 8 positions and then bitwise add it with 0Xff.The Blue bits occupy 8 bits from index 0 to index 7. We then find the average of R, B, and G value. To set the pixel value to an image at the x, y co-ordinates, we use the setRGB(x,y,p) function. We finally write out the file in PNG format. 

To adjust the brightness of an image, the input file is prepared and converted to a buffered image. Two variables are declared inside the main() function to hold the width and height dimension of the image. The getWidth() and getHeight() functions are used to achieve this. An integer variable is declared for storing the factor value and set to 0. A do while loop is used for processing the image matrix. We then add factor to the variables red, green and blue. The red, green and blue elements are returned in the range 0-255 in the default Srgb space. An else if statement is used for the processing loop. The value of the variables red, green, blue at co-ordinate (x, y) is acquired using the getRGB(x,y) function. We finally write out the file in PNG format. 

To adjust the hue of an image, the image file is read in and converted to a buffered image. Again, two integer variables are declared inside the main() function to hold the height and width dimensions of the image. An integer variable is declared to hold the hue value and is set to 0. Two variables x and y are created and two for loops are used to process the image matrix. The components of a colour are converted, as stated by the HSB model to an equivalent set of values for the default RGB model. The saturation and brightness elements are stored as floating point values. 


References:

Classroom (n.d.) How to get and set pixel value in Java How to get and set pixel value in Java - Image Processing Project - DYclassroom | Have fun learning :-)

Code Java. (2020, June 3) Eclipse: Enable Color Coded Output [Video]. Youtube Eclipse: Enable Color Coded Output - YouTube

Fatir, A. (n.d.) Of Bits and Pieces-Kernel Image Processing: Image Filters (with Java Code) Of Bits and Pieces-: Kernel Image Processing : Image Filters (with Java Code) (abdulfatir.com)

Fatir, A. (n.d.) Of Bits and Pieces-Changing Hue of Images (with Java Code)Of Bits and Pieces-: Changing Hue of Images (with Java Code) (abdulfatir.com)

GeeksforGeeks (2016, November 18) Image Processing in Java |Set 1(Read and write) Image Processing in Java | Set 1 (Read and Write) - GeeksforGeeks

GitHub (2018, July 25) PacktPublishing/Java-Machine-Learning-for-Computer-Vision Java-Machine-Learning-for-Computer-Vision/Convolution.java at master · PacktPublishing/Java-Machine-Learning-for-Computer-Vision · GitHub

GMIT, (2021) Week 6: Branching retrieved from hdipOOWk6-Branching (gmit.ie) on 7th August 2021

GMIT, (2021) Week 7: Iteration retrieved from hdipOOWk7-Iteration (gmit.ie) on 7th August 2021

GMIT, (2021) Week 8: Arrays retrieved from hdipOOWk8-Arrays (gmit.ie) on 7th August 2021

GMIT, (2021) Week 11: Multidimensional Arrays retrieved from hdipOOWk11-MultiDimensionalArrays (gmit.ie) on 7h August 2021

GMIT, (2021) Week 12: Exceptional Handling retrieved from hdipOOWk12-Exceptions (gmit.ie) on 7th August 2021

GMIT, (2021) Week 13: Java I/O retrieved from hdipOOWk13-IO-Temp (gmit.ie) on 7th August 2021

Joram, N. (2019, November 13). Converting RGB image to the Grayscale image in Java. Converting RGB image to the Grayscale image in Java | by Nickson Joram | Javarevisited | Medium

Know Program (n.d.) Menu Driven Program for Matrix Operations in Java Menu Driven Program for Matrix Operations in Java (knowprogram.com)

Lode's Computer Graphics Tutorial (n.d.) Image filtering.  Image Filtering (lodev.org)

(n.d.) File Name from User Input File Name from User Input (ccsu.edu)

Powell, V. (n.d.) Image Kernels Explained Visually. Image Kernels explained visually (setosa.io)

Shakeel, Y. (2014, February 16). Java How to read and write image file in Java [Video]. Youtube. Java | How to read and write image file in Java - YouTube

Shakeel, Y. (2014, February 26). Java How to convert color image into grayscale image [Video]. Youtube Java | How to convert color image into grayscale image - YouTube

Stackoverflow. (2011, April 23). How to print color in console using System.out.println? java - How to print color in console using System.out.println? - Stack Overflow

Superuser (2012) Windows console with ANSI colors handling. Windows console with ANSI colors handling - Super User

The Coding Train. (2015, July 24) 10.4: Pixels! (The Pixels Array)- Processing Tutorial [Video]. Youtube 10.4: Pixels! (The Pixels Array) - Processing Tutorial - YouTube

The Whiz. (2020, July 4). How to add Color (and other text customizations) into the Console in Java without library imports [Video]. Youtube  How to add Color (and other text customizations) into the Console in Java without library imports - YouTube

Tutorialspoint (n.d.) How to convert Image to Byte Array in java? How to convert Image to Byte Array in java? (tutorialspoint.com)

Tutorialspoint (n.d.) Java DIP-Grayscale Conversion Java DIP - GrayScale Conversion (tutorialspoint.com)

Wordpress. (2014, April 25). Image processing and computer vision in Java (Image Filtering part 1) Image Processing and Computer vision in java (Image Filtering part1) | Naushadsblog (wordpress.com)
