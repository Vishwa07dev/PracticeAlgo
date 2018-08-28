import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.io.PrintWriter;

public class readandwrite {
    public static final String DATA_XLSX_FILE_PATH = "C:/Users/vsennidurai/Downloads/DCC/HazmatDataSetup_0511.xlsx";
    public static final String DC_XLSX_FILE_PATH = "C:/Users/vsennidurai/Downloads/DCC/DC_LIST.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
    	String CREATED_DATE="sysdate";
    	String MODIFIED_DATE="sysdate";
    	String CREATED_BY="vn0ln3u";
    	String MODIFIED_BY="vn0ln3u";
    	int DB_LOCK_VERSION=0;
    	int HOLIDAY_UPGRADE=0;
    	PrintWriter pw = new PrintWriter(new File("/Users/vsennidurai/Downloads/DCC/test.csv"));
        StringBuilder sb = new StringBuilder();
        Workbook workbook_dc = WorkbookFactory.create(new File(DC_XLSX_FILE_PATH));
        Sheet sheet_dc = workbook_dc.getSheetAt(0);
        DataFormatter dataFormatter_dc = new DataFormatter();
        Iterator<Row> rowIterator_dc = sheet_dc.rowIterator();
        while (rowIterator_dc.hasNext()) {
        Row row_dc = rowIterator_dc.next();
        Iterator<Cell> cellIterator_dc = row_dc.cellIterator();
        while (cellIterator_dc.hasNext()) {
            Cell cell_dc = cellIterator_dc.next();
            String CM_ID = dataFormatter_dc.formatCellValue(cell_dc);
            cell_dc = cellIterator_dc.next();
            String DC_NAME = dataFormatter_dc.formatCellValue(cell_dc);
            cell_dc = cellIterator_dc.next();
            String IS_ACTIVE = dataFormatter_dc.formatCellValue(cell_dc);
            
        Workbook workbook = WorkbookFactory.create(new File(DATA_XLSX_FILE_PATH));
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        
        while (rowIterator.hasNext()) {

            //System.out.println("third");
        	String SHIPPING_METHOD_ID=null;
        	String CARRIER_METHOD_ID=null;
        	String XML_CARRIER_METHOD_CODE=null;
        	String CM_DISPLAY_DESCRIPTION=null;
        	String SCAC_AND_SERVICE=null;
        	String CARRIER_METHOD_TYPE=null;
        	String Ship_Class_8=null;
        	String Ship_Class_9=null;
        	String Ship_Class_11=null;
        	String Address_Types_0=null;
        	String Address_Types_1=null;
        	String Address_Types_7=null;
        	String Ship_Size_MEDIUM=null;
        	String Ship_Size_SMALL=null;
        	String Ship_Size_TINY=null;
        	String Ship_Size_LARGE=null;
            Row row = rowIterator.next();
            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            int itterator=0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                String[] array = cellValue.split(",");
            	int i1=0;                
                	if (itterator == 0){
                    SHIPPING_METHOD_ID=array[i1];
                	}
                	if (itterator == 1){
                    CARRIER_METHOD_ID=array[i1];
                	}
                	if (itterator == 2){
                    XML_CARRIER_METHOD_CODE=array[i1];
                	}
                	if (itterator == 3){
                    CM_DISPLAY_DESCRIPTION=array[i1];
                	}
                	if (itterator == 4){
                    SCAC_AND_SERVICE=array[i1];
                	}
                	if (itterator == 5){
                    CARRIER_METHOD_TYPE=array[i1];
                	}
                	if (itterator == 6){
                	if (i1<array.length){
                    Ship_Class_8=array[0];
                	}
                	i1++;
                	if (i1<array.length){
                    Ship_Class_9=array[1];
                	}
                	i1++;
                	if (i1<array.length){
                    Ship_Class_11=array[2];
                	}
                	}
                	i1=0;
                	if (itterator == 7){
                	if (i1<array.length){
                    Address_Types_0=array[0];
                	}
                	i1++;
                	if (i1<array.length){
                    Address_Types_1=array[1];
                	}
                	i1++;
                	if (i1<array.length){
                    Address_Types_7=array[2];
                	}
                	}
                	i1=0;
                	if (itterator == 8){
                	if (i1<array.length){
                	Ship_Size_MEDIUM=array[0];
                	if (Ship_Size_MEDIUM.isEmpty()){Ship_Size_MEDIUM=null;}
                	}
                	i1++;
                	if (i1<array.length){
                    Ship_Size_SMALL=array[1];
                    if (Ship_Size_SMALL.isEmpty()){Ship_Size_SMALL=null;}
                	}
                	i1++;
                	if (i1<array.length){
                    Ship_Size_TINY=array[2];
                    if (Ship_Size_TINY.isEmpty()){Ship_Size_TINY=null;}
                	}
                	i1++;
                	if (i1<array.length){
                    Ship_Size_LARGE=array[3];
                    if (Ship_Size_LARGE.isEmpty()){Ship_Size_LARGE=null;}
                	}
                	}
                	itterator++;
              }
            if (CARRIER_METHOD_ID.equals(CM_ID)){
                	if (Ship_Class_8 !=null && Address_Types_0 !=null && Ship_Size_MEDIUM !=null ){    
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_8+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_0 !=null && Ship_Size_SMALL !=null ){  
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_8+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_0 !=null && Ship_Size_TINY !=null ){  
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_8+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_0 !=null && Ship_Size_LARGE !=null ){  
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_8+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_0 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_9+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_0 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_9+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_0 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_9+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_0 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_9+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_0 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_11+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_0 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_11+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_0 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_11+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_0 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_11+","+Address_Types_0+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_1 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_8+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_1 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_8+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_1 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_8+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_1 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_8+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_1 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_9+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_1 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_9+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_1 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_9+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_1 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_9+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_1 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_11+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_1 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_11+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_1 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_11+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_1 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_11+","+Address_Types_1+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_7 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_8+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_7 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_8+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_7 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_8+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_8 !=null && Address_Types_7 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_8+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_7 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_9+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_7 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_9+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_7 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_9+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_9 !=null && Address_Types_7 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_9+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_7 !=null && Ship_Size_MEDIUM !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_MEDIUM+"',"+Ship_Class_11+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_7 !=null && Ship_Size_SMALL !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_SMALL+"',"+Ship_Class_11+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_7 !=null && Ship_Size_TINY !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_TINY+"',"+Ship_Class_11+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
                    if (Ship_Class_11 !=null && Address_Types_7 !=null && Ship_Size_LARGE !=null ){
                    sb.append("insert into DCS_DISTRIBUTOR_PREF_CM values ("+DC_NAME+","+CARRIER_METHOD_ID+",'"+Ship_Size_LARGE+"',"+Ship_Class_11+","+Address_Types_7+","+IS_ACTIVE+","+CREATED_DATE+","+MODIFIED_DATE+",'"+CREATED_BY+"','"+MODIFIED_BY+"',"+DB_LOCK_VERSION+","+SHIPPING_METHOD_ID+","+HOLIDAY_UPGRADE+");");//","+XML_CARRIER_METHOD_CODE+","+CM_DISPLAY_DESCRIPTION+","+SCAC_AND_SERVICE+","+CARRIER_METHOD_TYPE);
                    sb.append('\n'); }
            } //if condition for CM_ID
            workbook.close();
        }//Third While        
    }    //second while
   }   //first while
        pw.write(sb.toString());
        pw.flush();
        pw.close();       
        workbook_dc.close();
    }
}


        


