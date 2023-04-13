import java.util.Scanner;

public class Project1_4jgrasp_pabloGarces
{
    public static void main(String[] args)   
    {
        //Delclare all the variables
        double gpuSpeed, cpuSpeed, perfScore = 0, highestScore = 0, lowestScore = 0, multiplier = 0;
        int cores = 0, resOpt = 0, numComputers = 0;
        String recommendedGraphicQuality = "", res = "";

        //Scanner object       
        Scanner input  = new Scanner(System.in);

        //Ask for how many computers
        System.out.print("How many computers are being processed? ");
        numComputers = input.nextInt(); 
        while (numComputers <= 0)
        {
            System.out.print("Please enter a positive number of computers: ");
            numComputers = input.nextInt();
        }
      
        //Print the title once
    	displayTitle();
        
        //Start the loop 
        for(int i = 1; i <= numComputers; i++)
        {
            System.out.println("\nComputer " + i + " information:");
         
            //Ask for the computers information
            System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
            gpuSpeed = input.nextDouble();
            while(gpuSpeed < 800 || gpuSpeed > 2000) 
            {
                System.out.print("Please enter a GPU clock speed between 800 and 2000 MHz: ");
                gpuSpeed = input.nextDouble();
            }
            System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
            cpuSpeed = input.nextDouble();
            while(cpuSpeed < 1000 || cpuSpeed > 5500) 
            {
                System.out.print("Please enter a CPU clock speed between 1000 and 5500 MHz: ");
                cpuSpeed = input.nextDouble();
            }
            System.out.print("Please enter the number of cores of your processor: ");
            cores = input.nextInt();
            while(cores < 1 || cores > 16) 
            {
                System.out.print("Please enter a number of cores between 1 and 16: ");
                cores = input.nextInt();
            }
        
            System.out.println("What is the resolution of your monitor?");
            System.out.println("1. 1280 x 720");
            System.out.println("2. 1920 x 1080");
            System.out.println("3. 2560 x 1440");
            System.out.println("4. 3840 x 2160");
            System.out.print("Please select from the options above: ");
            resOpt = input.nextInt();
            while (resOpt < 1 || resOpt > 4) 
            {
                System.out.print("Please enter a valid menu selection: ");
                resOpt = input.nextInt();
            }
            
            res = getResolutionString(resOpt);

            multiplier = getMultiplierValue(resOpt);

            perfScore = calculatePerformanceScore(gpuSpeed, cpuSpeed, multiplier, cores);

            recommendedGraphicQuality = getRecommendedQuality(perfScore);
            
            displayInformation(gpuSpeed, cpuSpeed, multiplier, perfScore, cores, i, res, recommendedGraphicQuality);
            
            if(i==1)
            {
                highestScore = perfScore;
                lowestScore = perfScore;
            }
            else
            {
                if(perfScore >= highestScore)
                    highestScore = perfScore;
                    
                if(perfScore <= lowestScore)
                    lowestScore = perfScore;
            }

        }

        //Print the highest and lowest scores once
        System.out.printf("\nHighest Performance Score: %,.3f\n", highestScore);
        System.out.printf("Lowest Performance Score: %,.3f\n", lowestScore);
    }
    public static void displayTitle()
    {
        String title = "\nComputer Hardware Graphics Quality Recommendation Tool";
        System.out.println(title);
    }

    public static String getResolutionString(int resOpt)
    {    
        String res = "";
        switch (resOpt)
        {
            case 1:;
                res = "1280 x 720";   
                break;
            case 2:
                res = "1920 x 1080";
                break;   
            case 3:
                res = "2560 x 1440"; 
                break;  
            case 4: 
                res = "3840 x 2160";
                break;
            default:
                System.out.println("That is not an option, try again. ");
                break;         
        }
         return res;   
    }
    public static double getMultiplierValue(int resOpt)
    {    
        double multiplier = 0;
        switch (resOpt)
        {
            case 1:
                multiplier = 1;  
                break;
            case 2:
                multiplier = 0.75;
                break;   
            case 3:
                multiplier = 0.55;
                break;  
            case 4:
                multiplier = 0.35;
                break;
            default:
                System.out.println("That is not an option, try again. ");
                break;         
        }
        return multiplier;
    }

    /*Calculate the performance score*/
    public static double calculatePerformanceScore(double gpuSpeed, double cpuSpeed, double multiplier, int cores)
    {
        double perfScore;
        perfScore =  ((5 * gpuSpeed) + (cores * cpuSpeed)) * multiplier;
        return perfScore; 
    }

    public static String getRecommendedQuality(double perfScore)
    {
        String recommendedGraphicQuality = "";
        if (perfScore > 17000)
         {
            recommendedGraphicQuality = "Ultra";
         }
         else if (perfScore > 15000 && perfScore <= 17000)
         {
            recommendedGraphicQuality = "High";
         }
         else if (perfScore > 13000 && perfScore <= 15000)
         {
            recommendedGraphicQuality = "Medium";
         }
         else if (perfScore > 11000 && perfScore <= 13000)
         {
            recommendedGraphicQuality = "Low";
         }
         else if (perfScore <= 11000)
         {
            recommendedGraphicQuality = "Unable to Play";
         }
         return recommendedGraphicQuality;    
    }

    public static void displayInformation(double gpuSpeed, double cpuSpeed, double multiplier, double perfScore, int cores, int i, String res, String recommendedGraphicQuality)
    {
        System.out.println("\nComputer " + i + " information:");
         System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
         System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
         System.out.println("Number of cores: " + cores);
         System.out.println("Monitor Resolution: " + res);
         System.out.printf("Performance Score: %,.3f\n", perfScore);
         System.out.println("Recommended Graphics Quality: " + recommendedGraphicQuality);    
    }
}

     