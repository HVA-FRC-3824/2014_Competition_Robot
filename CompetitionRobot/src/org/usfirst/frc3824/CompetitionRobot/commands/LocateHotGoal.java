// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3824.CompetitionRobot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.image.RGBImage;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3824.CompetitionRobot.Constants;
import org.usfirst.frc3824.CompetitionRobot.Robot;
/**
 *
 */
public class LocateHotGoal extends Command
{
    
    //Camera constants used for distance calculation
    final int Y_IMAGE_RES = 480;		//X Image resolution in pixels, should be 120, 240 or 480
    final double VIEW_ANGLE = 49;		//Axis M1013
    //final double VIEW_ANGLE = 41.7;		//Axis 206 camera
    //final double VIEW_ANGLE = 37.4;  //Axis M1011 camera
    final double PI = 3.141592653;
    //Score limits used for target identification
    final int  RECTANGULARITY_LIMIT = 40;
    final int ASPECT_RATIO_LIMIT = 55;
    //Score limits used for hot target determination
    final int TAPE_WIDTH_LIMIT = 50;
    final int  VERTICAL_SCORE_LIMIT = 50;
    final int LR_SCORE_LIMIT = 50;
    //Minimum area of particles to be considered
    final int AREA_MINIMUM = 150;
    //Maximum number of particles to process
    final int MAX_PARTICLES = 8;
    AxisCamera camera;          // the axis camera object (connected to the switch)
    CriteriaCollection cc;      // the criteria for doing the particle filter operation
    boolean finished;
    Timer elapsedTime;
    Timer timeForFirstImage;
    boolean useSavedImages;
    boolean imagesSaved;
    
    //---
    // image objects for the NIVision stuff - this MUST be free'd when done
    ColorImage image;
    BinaryImage thresholdImage;
    BinaryImage filteredImage;
    
    public class Scores {
        double rectangularity;
        double aspectRatioVertical;
        double aspectRatioHorizontal;
    }
    
    public class TargetReport {
		int verticalIndex;
		int horizontalIndex;
		boolean Hot;
		double totalScore;
		double leftScore;
		double rightScore;
		double tapeWidthScore;
		double verticalScore;
    };
    
    public class TargetSide {
        public static final int NONE = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
    }
    
    public class TargetInfo
    {
        public int hotTarget;                  // HOT TARGET: TargetSide.LEFT, TargetSide.RIGHT or NO HOT TARGET: TargetSide.NONE
        public double targetDistance;          // Distance to the Target (whether HOT or NOT)
        public double lastDistanceFoundAtTime; // time in seconds with uSec resolution since distance was last set
    }
    
    protected static TargetInfo lastTarget;
    // SendableChooser testImageChooser;
    
    public LocateHotGoal()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        useSavedImages = false;
   }
    
    public LocateHotGoal(boolean testing)
    {
        useSavedImages = testing;
    }
    
    // Called just before this Command runs the first time
    protected void initialize()
    {
        imagesSaved = false;
        finished = false;
        camera = AxisCamera.getInstance();  // get an instance of the camera
        lastTarget = new TargetInfo();
        lastTarget.hotTarget = TargetSide.NONE;
        lastTarget.lastDistanceFoundAtTime = -1;
        lastTarget.targetDistance = -1;
       
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
        elapsedTime = new Timer();
        timeForFirstImage = new Timer();
        timeForFirstImage.reset();
        timeForFirstImage.start();
        
        SmartDashboard.putString("ImageProcessStatus", "");
        SmartDashboard.putNumber("Image Process Time (ms)", 0.0);

        //---------------------
        // Use this if processing sample files on cRIO.  FTP the files to the cRIO
        // If using camera, comment these out.
//        testImageChooser = new SendableChooser();
//        testImageChooser.addDefault("Center", "/samples/2014VisionTarget/Center.jpg");
//        testImageChooser.addObject("Center18ft_Off", "/samples/2014VisionTarget/Center_18ft_Off.jpg");
//        testImageChooser.addObject("Center18ft_On2", "/samples/2014VisionTarget/Center_18ft_On2.jpg");
//        testImageChooser.addObject("Center18ft_On", "/samples/2014VisionTarget/Center_18ft_On.jpg");
//        testImageChooser.addObject("Center27ft_Off", "/samples/2014VisionTarget/Center_27ft_Off.jpg");
//        testImageChooser.addObject("Center27ft_On2", "/samples/2014VisionTarget/Center_27ft_On2.jpg");
//        testImageChooser.addObject("Center27ft_On", "/samples/2014VisionTarget/Center_27ft_On.jpg");
//        testImageChooser.addObject("Right18ft_Off2", "/samples/2014VisionTarget/Right_18ft_Off2.jpg");
//        testImageChooser.addObject("Right18ft_Off", "/samples/2014VisionTarget/Right_18ft_Off.jpg");
//        testImageChooser.addObject("Right18ft_On", "/samples/2014VisionTarget/Right_18ft_On.jpg");
//        testImageChooser.addObject("Right27ft_Off", "/samples/2014VisionTarget/Right_27ft_Off.jpg");
//        testImageChooser.addObject("Right27ft_On", "/samples/2014VisionTarget/Right_27ft_On.jpg");
//        testImageChooser.addObject("GamePieces1", "/samples/2014VisionTarget/GamePieces1.jpg");
//        testImageChooser.addObject("GamePieces2", "/samples/2014VisionTarget/GamePieces2.jpg");
//        SmartDashboard.putData("TestImages", testImageChooser); 
 }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        // This prevents the code from hanging when autonomous starts.  
        // The test for camera present should have happened in RobotInit() at 
        // boot time.
        if(!Robot.cameraAvailable)
        {
           finished = true;
           return;
        }
        
        elapsedTime.reset();
        elapsedTime.start();
        
        TargetReport target = new TargetReport();
        int verticalTargets[] = new int[MAX_PARTICLES];
        int horizontalTargets[] = new int[MAX_PARTICLES];
        int verticalTargetCount, horizontalTargetCount;
        SmartDashboard.putString("ImageProcessStatus", "Starting Execute");
        try {
            /**
             * Do the image capture with the camera and apply the algorithm
             * described above. This sample will either get images from the
             * camera or from an image file stored in the top level directory in
             * the flash memory on the cRIO. The file name in this case is
             * "testImage.jpg"
             *
             */
             SmartDashboard.putString("ImageProcessStatus", "Getting image");
             if(useSavedImages)
             {
                 // if testing with saved image, read saved image from cRIO flash
                 image = new RGBImage("/image_original.bmp");
             }
             else
             {
                 // read image from camera
                 image = camera.getImage();
             }
            timeForFirstImage.stop();
            System.out.println("Image Found After " + (timeForFirstImage.get() * 1000) + "(in ms)");

            //String imageToProcess = (String) testImageChooser.getSelected();
            //System.out.println("processing image: " + imageToProcess);
            //image = new RGBImage(imageToProcess);		// get the sample image from the cRIO flash

            // values obtained from NIVision and sample images  90, 145, 90, 255, 128, 255
            // original values from samples 90, 137, 0, 51, 190, 255
            thresholdImage = image.thresholdHSV(90, 145, 90, 255, 128, 255);   // keep only green objects
            filteredImage = thresholdImage.particleFilter(cc);           // filter out small particles

            System.out.println("ready for compare: imagesSaved: " + imagesSaved + ", useSavedImages: " + useSavedImages);
            if(!imagesSaved && !useSavedImages)
            {
                System.out.println("saving images");
                image.write("/image_original.bmp");
                thresholdImage.write("/image_threshold.bmp");
                filteredImage.write("/image_filtered.bmp");
                imagesSaved = true;
                System.out.println("images saved");
            }
            
            //iterate through each particle and score to see if it is a target
            Scores scores[] = new Scores[filteredImage.getNumberParticles()];
            horizontalTargetCount = verticalTargetCount = 0;
            
            if (filteredImage.getNumberParticles() > 0) {
                SmartDashboard.putString("ImageProcessStatus", "Particles Found: " + filteredImage.getNumberParticles());
                for (int i = 0; i < MAX_PARTICLES && i < filteredImage.getNumberParticles(); i++) {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    scores[i] = new Scores();
                    
                    //Score each particle on rectangularity and aspect ratio
                    scores[i].rectangularity = scoreRectangularity(report);
                    scores[i].aspectRatioVertical = scoreAspectRatio(filteredImage, report, i, true);
                    scores[i].aspectRatioHorizontal = scoreAspectRatio(filteredImage, report, i, false);
                    
                    //Check if the particle is a horizontal target, if not, check if it's a vertical target
                    if (scoreCompare(scores[i], false)) {
                        System.out.println();
                        System.out.println("particle: " + i + " is a Horizontal Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                        horizontalTargets[horizontalTargetCount++] = i; //Add particle to target array and increment count
                    } else if (scoreCompare(scores[i], true)) {
                        System.out.println();
                        System.out.println("particle: " + i + " is a Vertical Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                        verticalTargets[verticalTargetCount++] = i;  //Add particle to target array and increment count
                    } else {
                        System.out.println();
                        System.out.println("particle: " + i + " is not a Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                    }
                    System.out.println("      rect: " + scores[i].rectangularity + " -- ARHoriz: " + scores[i].aspectRatioHorizontal + " -- ARVert: " + scores[i].aspectRatioVertical);
                }
                
                //Zero out scores and set verticalIndex to first target in case there are no horizontal targets
                target.totalScore = target.leftScore = target.rightScore = target.tapeWidthScore = target.verticalScore = 0;
                target.verticalIndex = verticalTargets[0];
                for (int i = 0; i < verticalTargetCount; i++) {
                    ParticleAnalysisReport verticalReport = filteredImage.getParticleAnalysisReport(verticalTargets[i]);
                    for (int j = 0; j < horizontalTargetCount; j++) {
                        ParticleAnalysisReport horizontalReport = filteredImage.getParticleAnalysisReport(horizontalTargets[j]);
                        double horizWidth, horizHeight, vertWidth, leftScore, rightScore, tapeWidthScore, verticalScore, total;
                        
                        //Measure equivalent rectangle sides for use in score calculation
                        horizWidth = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
                        vertWidth = NIVision.MeasureParticle(filteredImage.image, verticalTargets[i], false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
                        horizHeight = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
                        
                        //Determine if the horizontal target is in the expected location to the left of the vertical target
                        leftScore = ratioToScore(1.2 * (verticalReport.boundingRectLeft - horizontalReport.center_mass_x) / horizWidth);
                        //Determine if the horizontal target is in the expected location to the right of the  vertical target
                        rightScore = ratioToScore(1.2 * (horizontalReport.center_mass_x - verticalReport.boundingRectLeft - verticalReport.boundingRectWidth) / horizWidth);
                        //Determine if the width of the tape on the two targets appears to be the same
                        tapeWidthScore = ratioToScore(vertWidth / horizHeight);
                        //Determine if the vertical location of the horizontal target appears to be correct
                        verticalScore = ratioToScore(1 - (verticalReport.boundingRectTop - horizontalReport.center_mass_y) / (4 * horizHeight));
                        total = leftScore > rightScore ? leftScore : rightScore;
                        total += tapeWidthScore + verticalScore;
                        
                        //If the target is the best detected so far store the information about it
                        if (total > target.totalScore) {
                            target.horizontalIndex = horizontalTargets[j];
                            target.verticalIndex = verticalTargets[i];
                            target.totalScore = total;
                            target.leftScore = leftScore;
                            target.rightScore = rightScore;
                            target.tapeWidthScore = tapeWidthScore;
                            target.verticalScore = verticalScore;
                        }
                    }
                    //Determine if the best target is a Hot target
                    target.Hot = hotOrNot(target);
                }
                
                if (verticalTargetCount > 0) {
                    //Information about the target is contained in the "target" structure
                    //To get measurement information such as sizes or locations use the
                    //horizontal or vertical index to get the particle report as shown below
                    ParticleAnalysisReport distanceReport = filteredImage.getParticleAnalysisReport(target.verticalIndex);
                    lastTarget.targetDistance = computeDistance(filteredImage, distanceReport, target.verticalIndex);
                    if (target.Hot) {
                        lastTarget.hotTarget = targetWhichSide(target);
                        System.out.println("Hot target FOUND, distanct to target: " + lastTarget.targetDistance);
                        if(TargetSide.LEFT == lastTarget.hotTarget)
                        {
                            SmartDashboard.putString("ImageProcessStatus", "HOT Target LEFT");
                        }
                        else if(TargetSide.RIGHT == lastTarget.hotTarget)
                        {
                            SmartDashboard.putString("ImageProcessStatus", "HOT Target RIGHT");
                        }
                        else
                        {
                            SmartDashboard.putString("ImageProcessStatus", "HOT NOT FOUND");
                        }
                    } 
                    else {
                        lastTarget.hotTarget = TargetSide.NONE;
                        System.out.println("Hot target NOT FOUND, distance to target: " + lastTarget.targetDistance);
                        SmartDashboard.putString("ImageProcessStatus", "HOT NOT FOUND");
                    }
                    lastTarget.lastDistanceFoundAtTime = Timer.getFPGATimestamp();
                }
                else
                {
                   lastTarget.hotTarget = TargetSide.NONE;
                   SmartDashboard.putString("ImageProcessStatus", "No Targets Found");
                }
            }
            else 
            {
                lastTarget.hotTarget = TargetSide.NONE;
                SmartDashboard.putString("ImageProcessStatus", "No Targets Found");
            }
            
            Robot.hotGoalInfo = lastTarget;
            
            /**
             * all images in Java must be freed after they are used since they
             * are allocated out of C data structures. Not calling free() will
             * cause the memory to accumulate over each pass of this loop.
             */
            filteredImage.free();
            thresholdImage.free();
            image.free();
            finished = true;
        } 
        catch (AxisCameraException ex) {        // this is needed if the camera.getImage() is called
                // happens BEFORE the images are allocated
                //ex.printStackTrace();
                System.out.println("No Image Available");
        } 
        catch (NIVisionException ex) {
            // happens AFTER the images are allocated
            ex.printStackTrace();
        }
        
        elapsedTime.stop();
        double time = elapsedTime.get() * 1000;
        SmartDashboard.putNumber("Image Process Time (ms)", time);
        
        if(timeForFirstImage.get() > Constants.CAMERA_STARTUP_TIMEOUT)
        {
            Robot.cameraAvailable = false;
            finished = true;
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
       return finished;
    }
    // Called once after isFinished returns true
    protected void end()
    {
        try{
            if(filteredImage != null) filteredImage.free();
            if(thresholdImage != null) thresholdImage.free();
            if(image != null) image.free();
        }
        catch(NIVisionException e){
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        end();
    }
    
        /**
     * Computes the estimated distance to a target using the height of the particle in the image. For more information and graphics
     * showing the math behind this approach see the Vision Processing section of the ScreenStepsLive documentation.
     * 
     * @param image The image to use for measuring the particle estimated rectangle
     * @param report The Particle Analysis Report for the particle
     * @param outer True if the particle should be treated as an outer target, false to treat it as a center target
     * @return The estimated distance to the target in Inches.
     */
    double computeDistance (BinaryImage image, ParticleAnalysisReport report, int particleNumber) throws NIVisionException {
            double rectLong, height;
            int targetHeight;
            rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
            //using the smaller of the estimated rectangle long side and the bounding rectangle height results in better performance
            //on skewed rectangles
            height = Math.min(report.boundingRectHeight, rectLong);
            targetHeight = 32;
            return Y_IMAGE_RES * targetHeight / (height * 12 * 2 * Math.tan(VIEW_ANGLE*Math.PI/(180*2)));
    }
    
    /**
     * Computes a score (0-100) comparing the aspect ratio to the ideal aspect
     * ratio for the target. This method uses the equivalent rectangle sides to
     * determine aspect ratio as it performs better as the target gets skewed by
     * moving to the left or right. The equivalent rectangle is the rectangle
     * with sides x and y where particle area= x*y and particle perimeter= 2x+2y
     *
     * @param image The image containing the particle to score, needed to perform additional measurements
     * @param report The Particle Analysis Report for the particle, used for the width, height, and particle number
     * @param outer	Indicates whether the particle aspect ratio should be compared to the ratio for the inner target or the outer
     * @return The aspect ratio score (0-100)
     */
    public double scoreAspectRatio(BinaryImage image, ParticleAnalysisReport report, int particleNumber, boolean vertical) throws NIVisionException {
        double rectLong, rectShort, aspectRatio, idealAspectRatio;
        rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        rectShort = NIVision.MeasureParticle(image.image, particleNumber, false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
        idealAspectRatio = vertical ? (4.0 / 32) : (23.5 / 4);	//Vertical reflector 4" wide x 32" tall, horizontal 23.5" wide x 4" tall
        //Divide width by height to measure aspect ratio
        if (report.boundingRectWidth > report.boundingRectHeight) {
            //particle is wider than it is tall, divide long by short
            aspectRatio = ratioToScore((rectLong / rectShort) / idealAspectRatio);
        } else {
            //particle is taller than it is wide, divide short by long
            aspectRatio = ratioToScore((rectShort / rectLong) / idealAspectRatio);
        }
        return aspectRatio;
    }
    /**
     * Compares scores to defined limits and returns true if the particle
     * appears to be a target
     *
     * @param scores The structure containing the scores to compare
     * @param outer True if the particle should be treated as an outer target, false to treat it as a center target
     * @return True if the particle meets all limits, false otherwise
     */
    boolean scoreCompare(Scores scores, boolean vertical) {
        boolean isTarget = true;
        isTarget &= scores.rectangularity > RECTANGULARITY_LIMIT;
        if (vertical) {
            isTarget &= scores.aspectRatioVertical > ASPECT_RATIO_LIMIT;
        } else {
            isTarget &= scores.aspectRatioHorizontal > ASPECT_RATIO_LIMIT;
        }
        return isTarget;
    }
   
    /**
     * Computes a score (0-100) estimating how rectangular the particle is by
     * comparing the area of the particle to the area of the bounding box
     * surrounding it. A perfect rectangle would cover the entire bounding box.
     *
     * @param report The Particle Analysis Report for the particle to score
     * @return The rectangularity score (0-100)
     */
    double scoreRectangularity(ParticleAnalysisReport report) {
        if (report.boundingRectWidth * report.boundingRectHeight != 0) {
            return 100 * report.particleArea / (report.boundingRectWidth * report.boundingRectHeight);
        } else {
            return 0;
        }
    }
   
    /**
     * Converts a ratio with ideal value of 1 to a score. The resulting function
     * is piecewise linear going from (0,0) to (1,100) to (2,0) and is 0 for all
     * inputs outside the range 0-2
     */
    double ratioToScore(double ratio) {
        return (Math.max(0, Math.min(100 * (1 - Math.abs(1 - ratio)), 100)));
    }
	
    /**
     * Takes in a report on a target and compares the scores to the defined
     * score limits to evaluate if the target is a hot target or not.
     *
     * Returns True if the target is hot. False if it is not.
     */
    boolean hotOrNot(TargetReport target) {
        boolean isHot = true;
        isHot &= target.tapeWidthScore >= TAPE_WIDTH_LIMIT;
        isHot &= target.verticalScore >= VERTICAL_SCORE_LIMIT;
        isHot &= (target.leftScore > LR_SCORE_LIMIT) | (target.rightScore > LR_SCORE_LIMIT);
        return isHot;
    }
    
    /**
     * Tells whether the target is a left or right target
     *
     * Returns an int that is a member of TargetSide object
     */
    int targetWhichSide(TargetReport target)
    {
        int ts;
        
        ts = TargetSide.NONE;
        if(target.leftScore > LR_SCORE_LIMIT)
        {
            ts = TargetSide.LEFT;
        }
        else if(target.rightScore > LR_SCORE_LIMIT)
        {
            ts = TargetSide.RIGHT;
        }
        
        return ts;
    }
    /**
     * Provide information about the last object seen
     * possible cases are:
     *  - HOT TARGET seen on LEFT (also updates distance and time)
     *  - HOT TARGET seen on RIGHT (also updates distance and time)
     *  - NO HOT TARGET, but a TARGET WAS SEEN (update distance and time)
     *  - NO OBJECTS SEEN at all (distance and time are NOT updated)
     * 
     * TargetInfo.hotTarget - TargetSide.LEFT, TargetSide.RIGHT, TargetSide.NONE
     * TargetInfo.targetDistance - distance to last seen target
     * TargetInfo.lastDistanceFoundAtTime - time when the distance was last set
     * 
     * Returns a TargetInfo object that is a member of TargetSide object
     */
    public static TargetInfo getTarget()
    {
        return lastTarget;
    }
}
