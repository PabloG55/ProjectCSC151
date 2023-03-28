import java.util.Scanner;

public class Project1jgrasp_pabloGarces
{
   public static void main(String[] args)   
   {
      double gpuSpeed;
      double cpuSpeed;
      int cores;
      
      Scanner input  = new Scanner(System.in);
      System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
      gpuSpeed = input.nextDouble();
      System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
      cpuSpeed = input.nextDouble();
      System.out.print("Please enter the number of cores of your processor: ");
      cores = input.nextInt();
      
      System.out.println("\nComputer Hardware Graphics Quality Recommendation Tool\n");

      System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
      System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
      System.out.println("Number of cores: " + cores);
      
      String res1 = "1280 x 720";
      String res2 = "1920 x 1080";
      String res3 = "2560 x 1440";
      String res4 = "3840 x 2160";
      
      System.out.println("What is the resolution of your monitor?");
      System.out.println("1. 1280 x 720");
      System.out.println("2. 1920 x 1080");
      System.out.println("3. 2560 x 1440");
      System.out.println("4. 3840 x 2160");
      
      
   }

}   