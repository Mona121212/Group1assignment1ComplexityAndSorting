package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;


import shapes.*;
import utils.SortUtil;


public class AppDriver
{

	public static void main( String[] args )
	{
		
		 String filePath = "res/shapes.txt";
	     char t = 'h';  // h = height, a = base area, v = volume
	     char s = 'm';  // b,i,s,m,q,z  (any one of the six)
	     
	     for (String a : args) {
	         if (a.startsWith("-f")) filePath = a.substring(2);
	         if (a.startsWith("-t")) t = Character.toLowerCase(a.charAt(2));
	         if (a.startsWith("-s")) s = Character.toLowerCase(a.charAt(2));
	     }

	    File inputType = new File(filePath);
		Scanner input = null;

		try
		{
			input = new Scanner( inputType );
		}
		catch( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        // ---- read shapes into an array ----
        int n = Integer.parseInt(input.nextLine().trim()); // determines how many shapes are in the file
        Shape[] shapes = new Shape[n];
        for (int i = 0; i < n; i++) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) { i--; continue; } // to avoid crashing because of empty line
            String[] tok = line.split("\\s+"); // splits the line into parts
            String kind = tok[0]; // shape type
            // converts second and third parts into numeric values
            double h = Double.parseDouble(tok[1]); // height
            double p = Double.parseDouble(tok[2]); // radius or edge
            
            // decides which shape subclass to create based on the shape name
            switch (kind) {
                case "Cylinder":        shapes[i] = new Cylinder(h, p); break;
                case "Cone":            shapes[i] = new Cone(h, p); break;
                case "Pyramid":         shapes[i] = new Pyramid(h, p); break;
                case "SquarePrism":     shapes[i] = new SquarePrism(h, p); break;
                case "TriangularPrism": shapes[i] = new TriangularPrism(h, p); break;
                case "PentagonalPrism": shapes[i] = new PentagonalPrism(h, p); break;
                case "OctagonalPrism":  shapes[i] = new OctagonalPrism(h, p); break;
            }
        }
        input.close();
        
        
        // ---- choose comparator ----
        Comparator<Shape> cmp =
                (t == 'a') ? new BaseAreaComparator() :
                (t == 'v') ? new VolumeComparator()   :
                             Comparator.naturalOrder(); // height via Comparable
        
        
        // work on a copy
        Shape[] work = Arrays.copyOf(shapes, shapes.length);

        // ---- run chosen sort and time only the sort ----
        long start = System.nanoTime();
        switch (s) {
            case 'b': SortUtil.bubbleSort(work, cmp); break;
            case 'i': SortUtil.insertionSort(work, cmp); break;
            case 's': SortUtil.selectionSort(work, cmp); break;
            case 'm': SortUtil.mergeSort(work, cmp); break;
            case 'q': SortUtil.quickSort(work, cmp); break;
            case 'z': SortUtil.heapSort(work, cmp); break;
            default:  SortUtil.mergeSort(work, cmp); // simple default
        }
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
        
        // ---- output ----
        System.out.println("time: " + elapsedMs + " ms");
        if (work.length > 0) {
            for (int i = 0; i < work.length; i++) {
                if (i == 0 || i == work.length - 1 || i % 1000 == 0) {
                    System.out.printf("[%d] %s%n", i, work[i].toString());
                }
            }
        }
	}
}
