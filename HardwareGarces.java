/**
 * This class represents a Computer Hardware Graphics Quality Recommendation Tool
 */
public class HardwareGarces 
{
    private double gpuSpeed, cpuSpeed;
    private int cores = 0, resOpt = 0;

    /**
     * Constructor that accpets arguments
     * @param speedgNumb
     * @param speedcNumb
     * @param coresNumb
     * @param option
     */
    public HardwareGarces(double speedgNumb, double speedcNumb, int coresNumb, int option)
    {
        gpuSpeed = speedgNumb;
        cpuSpeed = speedcNumb;
        cores = coresNumb;
        resOpt = option;
    }

    /**
     * No-arg constructor that explicitly initializes all isntance fields.
     */
    public HardwareGarces()
    {
        gpuSpeed = 0;
        cpuSpeed = 0;
        cores = 0;
        resOpt = 0;
    }

    /**
     * Mutator
     * @param speedgNumb The gpu speed
     */
    public void setGpuSpeed(double speedgNumb)
    {
        gpuSpeed = speedgNumb;
    }

    /**
     * Mutator
     * @param speedcNumb The cpu speed
     */
    public void setCpuSpeed(double speedcNumb)
    {
        cpuSpeed = speedcNumb;
    }

    /**
     * Mutator
     * @param coresNumb The number of cores 
     */
    public void setCoresNumber(int coresNumb)
    {
        cores = coresNumb;
    }

    /**
     * Mutator
     * @param option The resolution options
     */
    public void setResolutionOptions(int option)
    {
        resOpt = option;
    }

    /**
     * Accesor
     * @return The gpu speed
     */
    public double getGpuSpeed()
    {
        return gpuSpeed;
    }

    /**
     * Accesor
     * @return The cpu speed
     */
    public double getCpuSpeed()
    {
        return cpuSpeed;
    }

    /**
     * Accesor
     * @return The number of cores
     */
    public int getCoresNumber()
    {
        return cores;
    }

    /**
     * Accesor
     * @return The resolution
     */
    public int setResolutionOptions()
    {
       return resOpt;
    }

    /**
      Get the resolution
      @return The resolution
   */
    public String getResolutionString()
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

    /**
      Get the multiplier
      @return The multiplier
   */
    public double getMultiplierValue()
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

    /**
      Calculate the performance score
      @return The Performance Score
   */
    public double calculatePerformanceScore()
    {
        double perfScore;
        perfScore =  ((5 * gpuSpeed) + (cores * cpuSpeed)) * getMultiplierValue();
        return perfScore; 
    }

    /**
      Determine the recommended graphic quality
      @return The recommended graphic quality
   */
    public String getRecommendedQuality()
    {
        String recommendedGraphicQuality = "";
        if (calculatePerformanceScore() > 17000)
         {
            recommendedGraphicQuality = "Ultra";
         }
         else if (calculatePerformanceScore() > 15000 && calculatePerformanceScore() <= 17000)
         {
            recommendedGraphicQuality = "High";
         }
         else if (calculatePerformanceScore() > 13000 && calculatePerformanceScore() <= 15000)
         {
            recommendedGraphicQuality = "Medium";
         }
         else if (calculatePerformanceScore() > 11000 && calculatePerformanceScore() <= 13000)
         {
            recommendedGraphicQuality = "Low";
         }
         else if (calculatePerformanceScore() <= 11000)
         {
            recommendedGraphicQuality = "Unable to Play";
         }
         return recommendedGraphicQuality;    
    }

    /**
      Print all the information
   */
    public void displayInformation()
    {
         System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
         System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
         System.out.println("Number of cores: " + cores);
         System.out.println("Monitor Resolution: " + getResolutionString());
         System.out.printf("Performance Score: %,.3f\n", calculatePerformanceScore());
         System.out.println("Recommended Graphics Quality: " + getRecommendedQuality());   
    }
}
