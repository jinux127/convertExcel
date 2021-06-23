package convertExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.List;

public class WriteProperties {
	/**
     * 대상 프로퍼티 파일 경로
     */
    private String targetPropertiesPath;
 
    /**
     * 기본 생성자
     * 
     * @param targetPropertiesPath
     *            대상 프로퍼티 파일 경로
     */
    public WriteProperties(String targetPropertiesPath) {
 
        super();
        this.targetPropertiesPath = targetPropertiesPath;
    }
 
    /**
     * 프로퍼티 파일 아스키코드로 작성한다.
     * 
     * @param keyValuePairs
     *            key-value 쌍 리스트
     */
    public void writeAsciiProperties(List<KeyValuePair> keyValuePairs) {
 
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(targetPropertiesPath),
                    Charset.forName("UTF-8"));
 
            for(KeyValuePair pair : keyValuePairs) {
                writer.write(pair.getKey() + " = " + Native2Ascii.native2Ascii(pair.getValue())
                        + "\n");
            }
 
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 프로퍼티 파일을 작성한다.
     * 
     * @param keyValuePairs
     *            key-value 쌍 리스트
     */
    public void writeProperties(List<KeyValuePair> keyValuePairs) {
    	
    	try {
    		Writer writer = new OutputStreamWriter(new FileOutputStream(targetPropertiesPath),
    				Charset.forName("UTF-8"));
    		
    		for(KeyValuePair pair : keyValuePairs) {
    			writer.write(pair.getKey() + " = " + (pair.getValue())
    			+ "\n");
    		}
    		
    		writer.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    /**
     * xml 파일을 작성한다.
     * 
     * @param keyValuePairs
     *            key-value 쌍 리스트
     */
    public void writeXml(List<KeyValuePair> keyValuePairs) {
    	
    	try {
    		Writer writer = new OutputStreamWriter(new FileOutputStream(targetPropertiesPath),
    				Charset.forName("UTF-8"));
    		writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
    				+ "<resources>\n");
    		for(KeyValuePair pair : keyValuePairs) {
    			writer.write("	<string name='"+pair.getKey() + "'>" + (pair.getValue()+"</string>")
    					+ "\n");
    		}
    		writer.write("</resources>");
    		writer.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }


}
