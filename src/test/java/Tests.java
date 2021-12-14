import org.sikuli.android.ADBScreen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.sikuli.basics.FileManager.exists;

public class Tests {

    public static int screenNumber = 0;

    @Test
    public void insertNewNote(){
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/InsertNewNote.sikuli/";
        screenshot();
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1636537755998.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1636537755998.png");
                screenshot();
            }
            else {
                s.click(path + "1636537755998.png");
                screenshot();
            }
            s.click(path + "1636537782883.png");
            screenshot();
            s.click(path + "1636537803951.png");
            screenshot();
            s.type("New Note");
            screenshot();
            s.click(path + "1636537831061.png");
            screenshot();
            Assert.assertTrue(s.exists(path+"1636537843807.png", 2.0) != null);
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }
    /*
    Versione con ADB
    @Test
    public void insertNewNote(){

        ADBScreen s = ADBScreen.start("/usr/local/bin/adb");

        Path relativePath = Paths.get("");
        System.out.println(s.toString());
        String path = relativePath.toAbsolutePath().toString() + "/InsertNewNote.sikuli/";
        try{
            s.aTap(path + "1636537755998.png");
            s.aTap(path +"1636537782883.png");
            s.aTap(path +"1636537803951.png");
            s.aTap(path +"1636537831061.png");
            Assert.assertTrue(exists(path+"1636537843807.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }
     @Test
    public void insertNewNote(){
        Screen s = new Screen();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/InsertNewNote.sikuli/";
        try{
            s.click(path + "1636537755998.png");
            s.click(path +"1636537782883.png");
            s.click(path +"1636537803951.png");
            s.type("New Note");
            s.click(path +"1636537831061.png");
            Assert.assertTrue(exists(path+"1636537843807.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    @Test
    public void archiveNote(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\ArchiveNote.sikuli\\";
        try{
            Match t = s.find(path + "1636540108598.png");
            s.dragDrop(t, t.offset(new Location(-200,0)));
            s.click(path + "1636543425997.png");
            s.click(path + "1636543443315.png");
            Assert.assertTrue(exists(path+"1636540108598.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    @Test
    public void searchNote(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\SearchNote.sikuli\\";
        try{
            s.click(path + "1636543638240.png");
            s.click(path +"1636543663192.png");
            s.click(path +"1636543679696.png");
            s.type("X");
            s.click(path +"1636543693128.png");

            s.click(path + "1636543638240.png");
            s.click(path +"1636543663192.png");
            s.click(path +"1636543679696.png");
            s.type("Y");
            s.click(path +"1636543693128.png");

            s.click(path + "1636543638240.png");
            s.click(path +"1636543663192.png");
            s.click(path +"1636543679696.png");
            s.type("Z");
            s.click(path +"1636543693128.png");

            s.click(path + "1636543846996.png");
            s.type("X");
            s.type(Key.ENTER);
            Assert.assertTrue(exists(path+"1636543875022.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }


    @Test
    public void info(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\GoToInfo.sikuli\\";
        try{
            s.click(path + "1636545060608.png");
            s.click(path + "1636545070415.png");
            s.wheel(Mouse.WHEEL_DOWN, 80);
            s.click(path + "1636545097456.png");
            Assert.assertTrue(exists(path+"1636545117997.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteNoteAndEmptyTrash(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\DeleteNoteAndEmptyTrash.sikuli\\";
        try{
            s.click(path + "1636552727265.png");
            s.click(path + "1636552736417.png");
            s.click(path + "1636552749823.png");
            s.type("New Note");

            s.click(path + "1636552759942.png");
            s.click(path + "1636552773948.png");
            s.click(path + "1636552781504.png");
            s.click(path + "1636552790152.png");

            s.click(path + "1636552821611.png");
            s.click(path + "1636552828850.png");

            Assert.assertTrue(exists(path+"1636552841335.png"));

            s.click(path + "1636552848227.png");
            s.click(path + "1636552856153.png");
            s.click(path + "1636552861835.png");

            sleep(2);

            Assert.assertFalse(exists(path+"1636552841335.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

     */

    public void screenshot(){
        try {
            Robot r = new Robot();
            // It saves screenshot to desired path
            String path = System.getProperty("user.dir") + "/screenshots/Screen"+ screenNumber + ".png";
            File myObj = new File(path);

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            screenNumber++;

            // Used to get ScreenSize and capture image
            Rectangle capture =
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = r.createScreenCapture(capture);
            ImageIO.write(Image, "png", myObj);
            System.out.println("Screenshot saved");
        }
        catch (AWTException | IOException ex) {
            System.out.println(ex);
        }
    }
}
