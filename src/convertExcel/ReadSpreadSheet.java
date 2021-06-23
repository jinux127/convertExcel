package convertExcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSpreadSheet {
	/**
     * 소스 스프레드시트 파일 경로
     */
    private String sourceSpreadSheetPath;
 
    /**
     * 소스 시트 인덱스
     */
    private int sourceSheetIndex = 0;
 
    /**
     * 키 셀 인덱스
     */
    private int keyCellIndex = 0;
 
    /**
     * 값 셀 인덱스
     */
    private int valueCellIndex = 1;
 
    /**
     * 시작 행 인덱스
     */
    private int startRowIndex = 0;
 
    /**
     * 소스 스프레드시트 파일 경로만 설정하는 생성자
     * 
     * @param sourceSpreadSheetPath
     *            소스 스프레드시트 파일 경로
     */
    public ReadSpreadSheet(String sourceSpreadSheetPath) {
 
        super();
        this.sourceSpreadSheetPath = sourceSpreadSheetPath;
    }
 
    /**
     * 모든 옵션을 설정하는 생성자
     * 
     * @param sourceSpreadSheetPath
     *            소스 스프레드시트 파일 경로
     * @param sourceSheetIndex
     *            소스 시트 인덱스
     * @param keyCellIndex
     *            키 셀 인덱스
     * @param valueCellIndex
     *            값 셀 인덱스
     * @param startRowIndex
     *            시작 행 인덱스
     */
    public ReadSpreadSheet(String sourceSpreadSheetPath, int sourceSheetIndex, int keyCellIndex,
            int valueCellIndex, int startRowIndex) {
 
        super();
        this.sourceSpreadSheetPath = sourceSpreadSheetPath;
        this.sourceSheetIndex = sourceSheetIndex;
        this.keyCellIndex = keyCellIndex;
        this.valueCellIndex = valueCellIndex;
        this.startRowIndex = startRowIndex;
    }
 
    /**
     * 스프레드시트의 정보를 읽어들인다.
     * 
     * @return 스트레드시트 정보의 key-value 쌍 리스트
     */
    public List<KeyValuePair> readSpreadSheet() {
 
        List<KeyValuePair> keyValuePairs = new ArrayList<KeyValuePair>();
 
        try {
            Workbook workbook = WorkbookFactory.create(new File(sourceSpreadSheetPath));
            Sheet sheet = workbook.getSheetAt(sourceSheetIndex);
 
            int currentRow = startRowIndex;
            Row row = null;
            while (true) {
                row = sheet.getRow(currentRow++);
 
                if (row == null)
                    break;
 
                Cell keyCell = row.getCell(keyCellIndex);
                Cell valueCell = row.getCell(valueCellIndex);
 
                if (keyCell == null || valueCell == null)
                    break;
 
                String key = keyCell.getStringCellValue();
                String value = valueCell.getStringCellValue();
                keyValuePairs.add(new KeyValuePair(key, value));
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return keyValuePairs;
    }
    
    /**
     * 스프레드시트의 정보를 읽어들인다.
     * 
     * @return 스트레드시트 정보의 key-value 쌍 리스트
     */
    public List<KeyValuePair> readXlsxSpreadSheet() {
    	
    	List<KeyValuePair> keyValuePairs = new ArrayList<KeyValuePair>();
    	
    	try {
    		Workbook workbook = WorkbookFactory.create(new File(sourceSpreadSheetPath));
    		Sheet sheet = workbook.getSheetAt(sourceSheetIndex);
    		
    		int currentRow = startRowIndex;
    		Row row = null;
    		while (true) {
    			row = sheet.getRow(currentRow++);
    			
    			if (row == null)
    				break;
    			
    			Cell keyCell = row.getCell(keyCellIndex);
    			Cell valueCell = row.getCell(valueCellIndex);
    			
    			if (keyCell == null || valueCell == null)
    				break;
    			
    			String key = keyCell.getStringCellValue();
    			String value = valueCell.getStringCellValue();
    			keyValuePairs.add(new KeyValuePair(key, value));
    		}
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	return keyValuePairs;
    }

}
