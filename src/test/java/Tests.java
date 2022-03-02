import org.sikuli.script.*;
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

    //OK
    @Test
    public void insertNewNote(){
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/InsertNewNote.sikuli/";
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("New Note");
            s.click(path + "1646138440164.png");
            s.type("New Note Content");
            s.click(path + "1646138452543.png");
            Thread.sleep(2000);
            screenshot();
            Assert.assertNotNull(s.exists(path + "1646138525756.png", 2.0));
            screenshot();
            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
        }
    }

    //OK
    @Test
    public void insertNewChecklist(){
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/InsertNewChecklist.sikuli/";
        screenshot();
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646143844832.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("New Checklist");
            s.click(path + "1646143858357.png");
            s.type("New Checklist Item");
            s.click(path + "1646143883620.png");
            screenshot();
            Assert.assertNotNull(s.exists(path + "1646148141563.png", 3.0));
            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
        }
    }
    /*
    //not ok
    @Test
    public void archiveNote() {
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/ArchiveNote.sikuli/";
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("New Note");
            s.click(path + "1646138440164.png");
            s.type("New Note Content");
            s.click(path + "1646138452543.png");
            Thread.sleep(2000);
            Match t = s.find(path + "1646138525756.png");
            s.dragDrop(t, t.offset(new Location(-200,0)));
            Thread.sleep(2000);
            s.click(path + "1646149664379.png");
            screenshot();
            s.click(path + "1646149674081.png");
            Assert.assertNotNull(s.exists(path + "1646149686065.png", 2.0));
            screenshot();
            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
            screenshot();
        }
    }

    //OK
    @Test
    public void searchNote() {
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/SearchNote.sikuli/";
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("X");
            s.click(path + "1646138452543.png");

            s.click(path + "1646138404642.png");
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("Y");
            s.click(path + "1646138452543.png");

            s.click(path + "1646138404642.png");
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("Z");
            s.click(path + "1646138452543.png");

            s.click(path + "1646150891648.png");
            s.type("X");
            s.type(Key.ENTER);
            screenshot();
            Assert.assertNotNull(s.exists(path + "1646150913496.png", 2.0));
            screenshot();
            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
            screenshot();
        }
    }

    //OK
    @Test
    public void insertNoteWithReminder() {
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/InsertNoteWithReminder.sikuli/";
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("New Note With Reminder");
            s.click(path + "1646154651866.png");
            s.type(Key.ENTER);
            s.click(path + "1646138452543.png");
            Assert.assertNotNull(s.exists(path + "1646154683667.png", 2.0));
            screenshot();
            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
            screenshot();
        }
    }

    //not ok
    @Test
    public void sortNotes() {
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/SortNotes.sikuli/";
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("Note 1");
            s.click(path + "1646138452543.png");

            s.click(path + "1646138404642.png");
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("Note 2");
            s.click(path + "1646138452543.png");

            s.click(path + "1646138404642.png");
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("Note 3");
            s.click(path + "1646138452543.png");

            s.click(path + "1646212420707.png");
            s.click(path + "1646212441564.png");

            Assert.assertNotNull(s.exists(path + "1646212463199.png", 2.0));
            screenshot();
            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
            screenshot();
        }
    }

    //not ok
    @Test
    public void insertNewCategory() {
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/InsertNewCategory.sikuli/";
        screenshot();
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            s.click(path + "1646216730595.png");
            s.click(path + "1646216745417.png");
            s.click(path + "1646216760801.png");
            s.type("New Category");
            screenshot();
            s.click(path + "1646216777931.png");
            s.click(path + "1646216795912.png");
            s.click(path + "1646216810135.png");
            s.click(path + "1646216819055.png");

            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("New Note");

            s.click(path + "1646138452543.png");

            screenshot();
            Assert.assertNotNull(s.exists(path + "1646216854386.png", 2.0));
            s.click(path + "1646222369476.png");
            Assert.assertNotNull(s.exists(path + "1646216863742.png", 2.0));
            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteCategory() {
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/DeleteCategory.sikuli/";
        screenshot();
        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            s.click(path + "1646216730595.png");
            s.click(path + "1646216745417.png");
            s.click(path + "1646216760801.png");
            s.type("New Category");
            s.click(path + "1646216819055.png");

            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("New Note");

            s.click(path + "1646138452543.png");
            s.click(path + "1646222369476.png");

            Assert.assertNotNull(s.exists(path + "1646231939434.png", 2.0));
            Match t = s.find(path + "1646231939434.png");
            s.dragDrop(t, t.offset(new Location(0,0)));
            s.click(path + "1646231986265.png");
            s.click(path + "1646231996203.png");
            Assert.assertNotNull(s.exists(path + "1646232025838.png", 2.0));

            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteNoteAndEmptyTrash() {
        Screen s = new Screen();
        Screen.showMonitors();
        Path relativePath = Paths.get("");
        System.out.println(relativePath.toAbsolutePath().toString());
        String path = relativePath.toAbsolutePath().toString() + "/DeleteNoteAndEmptyTrash.sikuli/";

        try{
            s.click(path + "emulator.png");
            if(s.exists(path + "1646138404642.png", 1.0) == null){
                s.click(path + "emulator.png");
                s.click(path + "1646138404642.png");
            }
            else {
                s.click(path + "1646138404642.png");
            }
            s.click(path + "1646138418301.png");
            if(s.exists(path + "1646155682237.png", 1.0) == null)
                s.click(path + "1646155682237.png");
            s.type("New Note");
            s.click(path + "1646138440164.png");
            s.type("New Note Content");
            s.click(path + "1646138452543.png");
            Thread.sleep(2000);

            s.click(path + "1646138525756.png");
            s.click(path + "1646233029187.png");
            s.click(path + "1646233038892.png");

            Assert.assertNotNull(s.exists(path + "1646233057968.png", 2.0));

            s.click(path + "1646233901227.png");
            s.click(path + "1646233067424.png");
            s.click(path + "1646234785106.png");
            s.click(path + "1646233087573.png");
            s.click(path + "1646233095446.png");

            Assert.assertNull(s.exists(path + "1646138525756.png", 2.0));

            cleanAppState();
        }
        catch(FindFailed | InterruptedException | IOException e){
            e.printStackTrace();
        }
    }*/

    public void screenshot(){
        try {
            Thread.sleep(2000);
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
        catch (AWTException | IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public void cleanAppState() throws IOException, InterruptedException {

        //stop application
        Process proc1 = new ProcessBuilder("adb", "shell", "am", "force-stop", "it.feio.android.omninotes.alpha").start();
        proc1.waitFor();

        //clean application state
        Process proc2 = new ProcessBuilder("adb", "shell", "pm", "clear", "it.feio.android.omninotes.alpha").start();
        proc2.waitFor();

        //restart application
        Process proc3 = new ProcessBuilder("adb", "shell", "am", "start", "it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity").start();
        proc3.waitFor();

    }
}
