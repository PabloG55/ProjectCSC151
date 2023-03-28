import java.util.Scanner;

public class Project1_2jgrasp_pabloGarces
{
   public static void main(String[] args)   
   {
      double gpuSpeed = 0,
             cpuSpeed = 0,
             perfScore = 0,
             multiplier = 0;
      int cores = 0,
          resOpt = 0;
      String text = "Computer Hardware Graphics Quality Recommendation Tool", 
             res = "",  
             recommendedGraphicQuality = "";
             
      Scanner input  = new Scanner(System.in);
      System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
      gpuSpeed = input.nextDouble();
      System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
      cpuSpeed = input.nextDouble();
      System.out.print("Please enter the number of cores of your processor: ");
      cores = input.nextInt();
      System.out.println("What is the resolution of your monitor?");
      System.out.println("1. 1280 x 720");
      System.out.println("2. 1920 x 1080");
      System.out.println("3. 2560 x 1440");
      System.out.println("4. 3840 x 2160");
      System.out.print("Please select from the options above: ");
      resOpt = input.nextInt();
      
      switch (resOpt)
      {
         case 1:
         multiplier = 1;
         res = "1280 x 720";
         perfScore =  ((5 * gpuSpeed) + (cores * cpuSpeed)) * multiplier;   
         break;
         case 2:
         multiplier = 0.75;
         res = "1920 x 1080";
         perfScore =  ((5 * gpuSpeed) + (cores * cpuSpeed)) * multiplier;
         break;   
         case 3:
         multiplier = 1;
         res = "2560 x 1440";
         perfScore =  ((5 * gpuSpeed) + (cores * cpuSpeed)) * multiplier; 
         break;  
         case 4:
         multiplier = 1;
         res = "3840 x 2160";
         perfScore =  ((5 * gpuSpeed) + (cores * cpuSpeed)) * multiplier;
         break;
         default:
         System.out.println("That is not an option, try again. ");
         break;            
      }
      
      if (perfScore >= 17000)
      {
      recommendedGraphicQuality = "Ultra";
      }
      else if (perfScore >= 15000 && perfScore < 17000)
      {
      recommendedGraphicQuality = "High";
      }
      else if (perfScore >= 13000 && perfScore < 15000)
      {
      recommendedGraphicQuality = "Medium";
      }
      else if (perfScore > 11000 && perfScore < 13000)
      {
      recommendedGraphicQuality = "Low";
      }
      else if (perfScore <= 11000)
      {
      recommendedGraphicQuality = "Unable to Play";
      }
      
      System.out.println("\n" + text + "\n");

      System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
      System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
      System.out.println("Number of cores: " + cores);
      System.out.println("Monitor Resolution: " + res);
      System.out.printf("Performance Score: %,.3f\n", perfScore);
      System.out.println("Recommended Graphics Quality: " + recommendedGraphicQuality);
      
   }

}     