/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotgoaldetection;

import hotgoaldetection.Webcam.ImagePanel;
import static hotgoaldetection.Webcam.toBufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import static org.opencv.highgui.Highgui.CV_LOAD_IMAGE_COLOR;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.GaussianBlur;
import static org.opencv.imgproc.Imgproc.erode;
import static org.opencv.imgproc.Imgproc.moments;
import org.opencv.imgproc.Moments;

/**
 *
 * @author FIRST
 */
public class HotGoalDetection {
    
    private static int counter = 0;
    private static boolean direction = false; // left=false  right=true
    private static Mat binary, hsv, dst, filter, img;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        img = Highgui.imread("..\\Robot-26ft.png", CV_LOAD_IMAGE_COLOR);
        //CameraWindow cWindow = new CameraWindow();
        //cWindow.setVisible(true);
        Webcam.ImagePanel panel = Webcam.createPanel(img, "img");
        Webcam.ImagePanel panel2 = Webcam.createPanel(img, "hsv");
        //Webcam.ImagePanel panel3 = Webcam.createPanel(filter, "filter");
        
        binary = new Mat(); hsv = new Mat();
        filter = new Mat(); dst = new Mat();
                
        GaussianBlur(img, img, new Size(3,3), 2, 2);
        
        while(true) {
            Imgproc.cvtColor(img, hsv, Imgproc.COLOR_BGR2HSV);
            
            //Core.inRange(img, new Scalar(120, 170, 10), new Scalar(160, 240, 40), filter);
            //Core.inRange(hsv, new Scalar(cWindow.get_hLower(), cWindow.get_sLower(), cWindow.get_vLower()), new Scalar(cWindow.get_hUpper(), cWindow.get_sUpper(), cWindow.get_vUpper()), hsv);
            Core.inRange(hsv, new Scalar(40, 52, 64), new Scalar(97, 255, 255), binary);
            erode(binary, binary, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3,3)));
            
            double[] condensedMat = new double[binary.width()];
            for(int y = 0; y<binary.size().width; y++)
            {
                double totalX = 0;
                for(int x = 0; x<binary.size().height; x++)
                {
                    if(binary.get(x,y)[0] == 255.0)
                        totalX++;
                    //System.out.println(java.util.Arrays.toString(binary.get(x,y)));
                }
                condensedMat[y] = totalX;
            }
            double[] rightOfMat = Arrays.copyOfRange(condensedMat, 0, (condensedMat.length/2)-1);
            double[] leftOfMat = Arrays.copyOfRange(condensedMat, condensedMat.length/2, condensedMat.length);
            double totalRight = 0, totalLeft = 0;
            
            for(double s : rightOfMat)
                totalRight += s;
            for(double s : leftOfMat)
                totalLeft += s;
            
            //System.out.println(totalRight + ", " + totalLeft);
            
            if(totalRight > totalLeft)
                direction = true;
            else
                direction = false;
                
            totalLeft = 0; totalRight = 0;
            
            panel.updateImage(toBufferedImage(img));
            panel2.updateImage(toBufferedImage(binary));
           // panel3.updateImage(toBufferedImage(filter));
        }
    }
    
    public static void takeScreenshot(int mat)
    {
        Date tempDate = new Date();
        Mat matFrame = new Mat();
        
        switch(mat)
        {
            case 1:
                matFrame = img;
                break;
            case 2:
                matFrame = dst;
                break;
            case 3:
                matFrame = hsv;
                break;
            default:
                matFrame = filter;
                break;
        }
        
        //camera.read(matFrame);
        Highgui.imwrite("screenshots\\ Screenshot " + counter + " -" + String.format("%1$s %2$tb %2$td at %2$tH %2$tM %2$tS","", tempDate) + ".jpeg", matFrame);
        counter++;
    }
    
}
