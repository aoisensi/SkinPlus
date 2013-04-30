package info.aoisensi.skinplus;

import info.aoisensi.skinplus.client.model.ModelPlusBiped;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SkinPlusDownloader extends Thread {
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	private String _username;
	
	public SkinPlusDownloader(String username) {
		_username = username;
	}
	
	public void run() {
		
		DocumentBuilder builder;
		URL url;
		try {
			//url = new URL("http://aoisensi.info/skinplus/user/" + StringUtils.stripControlCodes(_username) + ".xml");
			
			url = new URL("http://aoisensi.info/skinplus/user/" + _username + ".xml");
			
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(url.openStream());
			ModelPlusBiped modelPlusBiped = new ModelPlusBiped(0.0F, document);
			SkinPlus.instance.RenderPlusMap.put(_username, modelPlusBiped);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
