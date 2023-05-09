import java.util.Scanner;

public class Project1_4jgrasp_pabloGarces
{
    public static void main(String[] args)   
    {
        //Delclare all the variables.
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
            
            HardwareGarces hardware = new HardwareGarces(gpuSpeed, cpuSpeed, cores, resOpt);

            displayInformation(hardware);

            //Determine the highest and lowest scores
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
    }//End Main

    /*
      Print the title 
      @param none
      @return none
   */
    public static void displayTitle()
    {
        String title = "\nComputer Hardware Graphics Quality Recommendation Tool";
        System.out.println(title);
    }

}//End class

     