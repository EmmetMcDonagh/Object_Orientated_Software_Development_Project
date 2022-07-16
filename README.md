# IMAGE FILTERING SYSTEM V0.1

## CONTENTS OF THIS FILE
   
* Introduction
* Requirements
* Installation
* Configuration
* Troubleshooting
* FAQ

## INTRODUCTION

* The Image Filtering System V0.1 is a program that provides many image editing features for raster images.
  It uses a matrix , 2D array of numbers that slides across the pixels and makes computations changing the value of each pixel.
  The program allows users to select an image an apply different filters. It displays a four option menu, where users can choose an image, 
  see the different filters available and select the desired filter and the last option allows the user to quit the program.
  
  ## REQUIREMENTS

* As it comes inside a zip compressed folder, all the files need to be extracted to a secure location in the user's machine.

* This program requires to be opened from a Terminal.

## INSTALLATION
 
* To Install the program we need to unzip the folder, to do that, we press and hold (or right-click) the folder, 
  and select Extract All.

* From there, navigate to src folder and open a Terminal, .

  	- In the Terminal the first step is to compile the java files, typing: javac ie\gmit\dip\*.java

 	- When the previous step is done, run the program with the following command: java ie.gmit.dip.Runner

	- After that, the main menu of the program will appear.

## CONFIGURATION
 
* Once the main menu is showing in the terminal we will see four options to choose from:

1) EnterImageFilePath(). Asks the user to enter the image file path that they want to read and write using buffered image "[INFO] Input File Path". The file path which the user enters is represented as a String. 

2) SelectFilter().Asks the user to enter the filter that they want to use to process the image "[INFO] Select a filter you wish to apply. [1-11]". Lists the set the filters available i.e. edge detection, BOX_BLUR etc.

3) AdditionalParametersHere(). Adds extra options to the menu. Asks the user to select additional parameters that they want to use. "[INFO] Select additional parameters you wish to apply. [1-6]". One method is included to convert an RGB image to grey scale.

4) Quit(). Terminates the application. 

## FAQ

Q: After running the program where can I find the new image?

A: The new image will be located inside the << resources >> folder, located in the program main folder.

Q: What happens when misspelling the name of the filter?

A: In this case, the user will be prompt to try again, until it types the filter name in a correct way.

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
