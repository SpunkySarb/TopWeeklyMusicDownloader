package application;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SampleController {
	
	@FXML
	private static String songName;
	@FXML
	private static String songURL;
	@FXML
    private Button downloadALL;
    
	  @FXML
	    public static Label error;
	@FXML
    private ListView<HBox> list;
	
	public void initialize()  {
		djPunjab();
	}
	  
	  @FXML
	    void downloadAll(ActionEvent event) {

	    	
	    	
			
			
			try {
				
				Document doc = Jsoup.connect("https://djpunjab.fm/page/top20.html?download=320&type=week").userAgent("mozilla/17.0").get();
			
				Elements temp=doc.select("ol li");
				


			    
			int i=0;
			for (Element punjabi:temp) {
				
				try{

					 
					Element link = doc.select("li a").get(i); 
					i++;
					 songName = punjabi.getElementsByTag("li").first().text();
					 
						


					 
					 
					
					 songURL= link.absUrl("href");

					  
						DownloadButton.download(songURL, songName);

					 

								 
					 
					   

							
				}catch(java.lang.NullPointerException e) {
					System.out.println("");
				}
				
			}
			
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		
	   
	  
	  
	  }
	
	
	
	
    @FXML
    public void djPunjab()  {
    	
    	
		
		
		try {
			
			Document doc = Jsoup.connect("https://djpunjab.fm/page/top20.html?download=320&type=week").userAgent("mozilla/17.0").get();
		
			Elements temp=doc.select("ol li");
			


		    
		int i=0;
		for (Element punjabi:temp) {
			
			try{

				 String find = "http://sarbsagar143.com/music.png";     //  works
		         // "http://127.0.0.1:8080/images/sail.jpg";     // Shows image ok using my server
		         //  "images/Duke.gif";       //  Shows image in center of frame
		 
		  // Image ii = new Image(find); 
		  Image img = new Image(find);
		   ImageView imgView = new ImageView(img);
				Element link = doc.select("li a").get(i); 
				i++;
				 songName = punjabi.getElementsByTag("li").first().text();
				 
					


			      //  Label label = new Label("My Label", imageView);
				 
				 
				 Label musicName = new Label(songName);
				 musicName.setTextFill(Color.BLUE);
				 musicName.setAlignment(Pos.CENTER);
				 musicName.setFont(Font.font("Arial",18));
				 HBox music = new HBox();
				 songURL= link.absUrl("href");
					//download(songURL, songName);

				  
					 DownloadButton obj = new DownloadButton(songURL, songName);
					 VBox vbox= new VBox(obj.returnButton(),obj.downloadProgress(songURL, songName));
					 final Pane spacer = new Pane();
					    HBox.setHgrow(spacer, Priority.ALWAYS);
					    spacer.setMinSize(10, 1);
					//String url= "http://s320.ve.vc/data/320/47742/295047/Jab Hum Padheya Karte The - Parmish Verma (DjPunjab.Com).mp3";
						music.getChildren().addAll(imgView,musicName, spacer,vbox);
				    
			
				
				 

							 
				 
				    list.getItems().addAll(music);
				   

						
				System.out.println("");
			//System.out.println(songURL);
			}catch(java.lang.NullPointerException e) {
				System.out.println("");
			}
			
		}
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
}
