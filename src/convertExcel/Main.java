package convertExcel;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		int startValue = 1; //번역내용 시작열
		int endValue = 3; // 번역내용 끝열
		
		String name = "propertiesEx"; //파일명
		
		System.out.println("각 번역 항목마다 파일 생성됨\nEx) FileName"+startValue+" .properties or .xml");
		for(; startValue<=endValue; ++startValue) {
			
			ReadSpreadSheet readSpreadSheet = new ReadSpreadSheet("D:\\workspace\\SiSM-DEV\\convertExcel\\resource\\excel\\"+name+".xls", 0, 0, startValue, 1);
			 
	        WriteProperties writeAsciiProperties = new WriteProperties("D:\\workspace\\SiSM-DEV\\convertExcel\\resource\\ascii_properties\\"+name+startValue+".properties");
	        WriteProperties writeProperties = new WriteProperties("D:\\workspace\\SiSM-DEV\\convertExcel\\resource\\properties\\"+name+startValue+".properties");
	        WriteProperties writeXml = new WriteProperties("D:\\workspace\\SiSM-DEV\\convertExcel\\resource\\xml\\"+name+startValue+".xml");
	        
	        writeAsciiProperties.writeAsciiProperties(readSpreadSheet.readSpreadSheet());
	        writeProperties.writeProperties(readSpreadSheet.readSpreadSheet());
	        writeXml.writeXml(readSpreadSheet.readSpreadSheet());
		}  
		System.out.println("생성된 파일 개수: " + endValue);
        	
	}

}
