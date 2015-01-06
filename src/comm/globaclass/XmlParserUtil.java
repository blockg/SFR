package comm.globaclass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


public class XmlParserUtil {
	private static Logger log = Logger.getLogger(XmlParserUtil.class);
	
	private static String paserXml(String path,String tagName) throws ParserConfigurationException, SAXException, IOException{
	
	 
		File f=new File(path);
 
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		org.w3c.dom.Document doc=builder.parse(f);
		Element root=doc.getDocumentElement();
		NodeList childrens=root.getChildNodes();
		String sql=null;
		for(int i=0;i<childrens.getLength();i++){
			Node child=childrens.item(i);
			if(child instanceof Element ){
				Element childElement=(Element) child;
				if(childElement.getTagName().equals(tagName.trim())){
					Text textNode=(Text) childElement.getFirstChild();					
					sql=textNode.getData().toString();
				}
			}
		}
	    return sql;
	}
	
	public static String getXmlStr(String fpath,String name){
		String xstr=null;
		try {
			String Path=Thread.currentThread()
					.getContextClassLoader().getResource("").toURI().getPath();
			xstr=paserXml(Path+fpath, name);
		} catch (Exception e) {
			log.error("解析SQLXML出错 "+e);
		} 
		return xstr;
	}
	
	/**
	 * 微信平台 解析xml出错返回 信息
	 * @param fpath
	 * @param name
	 * @return
	 */
	public static String getXmlStrw(String fpath,String name){
		String xstr=null;
		try {
			String Path=Thread.currentThread()
					.getContextClassLoader().getResource("").toURI().getPath();
			xstr=paserXml(Path+fpath, name);
		} catch (Exception e) {
			xstr="/:,@!/:,@!系统故障，请联系管理员!";
		} 
		return xstr;
	}
	
	/**
	 * 写xml
	 * @param strs
	 * @param filePat
	 * @return
	 */
	public boolean writeToXml(String strs, String filePat) {
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePat);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			return false;
		}
		OutputStreamWriter outw = new OutputStreamWriter(out);
		try {
			outw.write(strs);
			outw.close();
			out.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
	
}
