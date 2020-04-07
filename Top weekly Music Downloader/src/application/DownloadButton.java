package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DownloadButton {

public String URL;
public  String name;
public static String error;
public DownloadButton(String songURL, String songName ) {

	this.URL=songURL;
	this.name=songName;

}

public static void download(String songURL, String songName)  {
	
	
	String user =System.getProperty("user.name");
	String File_NAME = "C://Users//"+user+"//Music//"+songName+".mp3";
	 
	 File tmpDir = new File(File_NAME);
	 boolean exists = tmpDir.exists();
	 if(exists) {
	 }else if(!exists){
		 
	 
	// TODO Auto-generated method stub+
	// songURL = "http://s320.ve.vc/data/320/47699/295004/Red%20Eyes%20-%20Karan%20Aujla%20(DjPunjab.Com).mp3";
	try (BufferedInputStream in = new BufferedInputStream(new URL(songURL).openStream());
			  FileOutputStream fileOutputStream = new FileOutputStream(File_NAME)) {
			    byte dataBuffer[] = new byte[1024];
			    int bytesRead;
			    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
			        fileOutputStream.write(dataBuffer, 0, bytesRead);
			        
			    }
			} catch (IOException e) {
			    // handle exception
				error = e.getMessage();
				System.out.println(e.getMessage());
			}
	
	 }
	
	
}



public Button returnButton() {
	
	Image img = new Image("http://sarbsagar143.com/download.png");
	Button download= new Button("DOWNLOAD", new ImageView(img));
	DropShadow shadow = new DropShadow();

	download.setOnAction(new EventHandler<ActionEvent>() {
	    @Override 
	    public void handle(ActionEvent e) {
            download.setEffect(shadow);
            
	    	download(URL, name);
	    }
	});	
	
	return download;
	
	
}


public ProgressIndicator downloadProgress(String songURL, String songName) {
	
	String user =System.getProperty("user.name");
	String File_NAME = "C://Users//"+user+"//Music//"+songName+".mp3";
	 ProgressIndicator doesntExist = new ProgressIndicator();

	 File tmpDir = new File(File_NAME);
	 boolean exists = tmpDir.exists();
	 if(exists) {
		 ProgressIndicator download = new ProgressIndicator(1.0);
		 
	 return download;
	 }else 
		 
		 return doesntExist;
		 
		 
	 
	 
}






















}
