package first;//处理卡口数据****************************************************

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DoExcle {
	public static void main(String[] args)throws Exception{
		DoExcle.ReadExcle("D:\\深圳浮动车\\卡口数据\\02010138香蜜湖路市委党校路段北行\\香蜜湖路市委党校路段北行2018-3-25 00-05.xlsx");
		DoExcle.ReadExcle("D:\\深圳浮动车\\卡口数据\\02010138香蜜湖路市委党校路段北行\\香蜜湖路市委党校路段北行2018-3-25 00-05.xlsx");
		
	}

    public static void ReadExcle(String path)throws Exception {
        
    	String newpath=path+".txt";
    	
        File excelFile = new File(path); //替换你文档地址
        File newF=new File(newpath);
        FileWriter fw = null;
        if(!newF.exists()){
        	newF.createNewFile();
        	}
        fw = new FileWriter(newF);
        BufferedWriter out = new BufferedWriter(fw);
        
        
        XSSFWorkbook wb = null;
        
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        
        int numberOfSheets = wb.getNumberOfSheets();
        
        String str = "";
        
        //定义时间间隔
		DateFormat df = new SimpleDateFormat("hh:mm:ss");
		
		Date dt2 = df.parse("00:00:00");
		Date dt3 = df.parse("01:59:59");
		Date dt4 = df.parse("03:59:59");
		Date dt5 = df.parse("05:59:59");
		Date dt6 = df.parse("07:59:59");
		Date dt7 = df.parse("09:59:59");
		Date dt8 = df.parse("11:59:59");
		Date dt9 = df.parse("13:59:59");
		Date dt10 = df.parse("15:59:59");
		Date dt11 = df.parse("17:59:59");
		Date dt12 = df.parse("19:59:59");
		Date dt13 = df.parse("21:59:59");//分成12个区间，两个小时为一个区间
		int NumberOfCar[]=new int[12];//记录12个时间段
		int FiveLine[][]=new int[12][5];//记录每个时间段的车道的车辆数量
        XSSFSheet s1=wb.getSheetAt(0);
        int first=s1.getFirstRowNum();
        int last=s1.getLastRowNum();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hh:mm:ss");
        
        
        System.out.println("first"+first);
        System.out.println("last"+last);
    	//Row message=s1.getRow(1);
    	//Cell cell1=message.getCell(2);
    	//System.out.print(cell1);
        Date date=new Date();
        for(int j=first;j<last;j++){
        	Row message=s1.getRow(j);
        	Cell cell2=message.getCell(2);//时间
        	Cell cell4=message.getCell(4);//车道
        	String time=cell2.getStringCellValue();
        	String carline=cell4.getStringCellValue();
        	System.out.println(cell2);
        	System.out.println(j);
        	if(time.equals("时间"))
        		continue;
        	String[] bb=time.split(" ");
        	char[] shijian=time.toCharArray();
        	if(shijian[4]=='-')
        	date=simpleDateFormat.parse(bb[1]);//字符串转化为时间用来比较
        	if(shijian[4]=='/')
            date=simpleDateFormat1.parse(bb[1]);
        	 
        	//System.out.println(date.getTime());
        	//System.out.println(dt2.getTime());
        	if(date.getTime()>dt2.getTime()&&date.getTime()<=dt3.getTime()){//0点到1.55
        		switch(carline){
        		case "1":FiveLine[0][0]++;break;//第一个时间段的一车道
        		case "2":FiveLine[0][1]++;break;
        		case "3":FiveLine[0][2]++;break;
        		case "4":FiveLine[0][3]++;break;
        		case "5":FiveLine[0][4]++;break;
        		default: System.out.print("时间"+time+"   车道："+carline);
        		}
        	}
else if(date.getTime()>=dt3.getTime()&&date.getTime()<=dt4.getTime()){
	switch(carline){
	case "1":FiveLine[1][0]++;break;
	case "2":FiveLine[1][1]++;break;
	case "3":FiveLine[1][2]++;break;
	case "4":FiveLine[1][3]++;break;
	case "5":FiveLine[1][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
        	}
else if(date.getTime()>dt4.getTime()&&date.getTime()<=dt5.getTime()){
	switch(carline){
	case "1":FiveLine[2][0]++;break;
	case "2":FiveLine[2][1]++;break;
	case "3":FiveLine[2][2]++;break;
	case "4":FiveLine[2][3]++;break;
	case "5":FiveLine[2][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt5.getTime()&&date.getTime()<=dt6.getTime()){
	switch(carline){
	case "1":FiveLine[3][0]++;break;
	case "2":FiveLine[3][1]++;break;
	case "3":FiveLine[3][2]++;break;
	case "4":FiveLine[3][3]++;break;
	case "5":FiveLine[3][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt6.getTime()&&date.getTime()<=dt7.getTime()){
	switch(carline){
	case "1":FiveLine[4][0]++;break;
	case "2":FiveLine[4][1]++;break;
	case "3":FiveLine[4][2]++;break;
	case "4":FiveLine[4][3]++;break;
	case "5":FiveLine[4][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt7.getTime()&&date.getTime()<=dt8.getTime()){
	switch(carline){
	case "1":FiveLine[5][0]++;break;
	case "2":FiveLine[5][1]++;break;
	case "3":FiveLine[5][2]++;break;
	case "4":FiveLine[5][3]++;break;
	case "5":FiveLine[5][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt8.getTime()&&date.getTime()<=dt9.getTime()){
	switch(carline){
	case "1":FiveLine[6][0]++;break;
	case "2":FiveLine[6][1]++;break;
	case "3":FiveLine[6][2]++;break;
	case "4":FiveLine[6][3]++;break;
	case "5":FiveLine[6][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt9.getTime()&&date.getTime()<=dt10.getTime()){
	switch(carline){
	case "1":FiveLine[7][0]++;break;
	case "2":FiveLine[7][1]++;break;
	case "3":FiveLine[7][2]++;break;
	case "4":FiveLine[7][3]++;break;
	case "5":FiveLine[7][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt10.getTime()&&date.getTime()<=dt11.getTime()){
	switch(carline){
	case "1":FiveLine[8][0]++;break;
	case "2":FiveLine[8][1]++;break;
	case "3":FiveLine[8][2]++;break;
	case "4":FiveLine[8][3]++;break;
	case "5":FiveLine[8][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt11.getTime()&&date.getTime()<=dt12.getTime()){
	switch(carline){
	case "1":FiveLine[9][0]++;break;
	case "2":FiveLine[9][1]++;break;
	case "3":FiveLine[9][2]++;break;
	case "4":FiveLine[9][3]++;break;
	case "5":FiveLine[9][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt12.getTime()&&date.getTime()<=dt13.getTime()){
	switch(carline){
	case "1":FiveLine[10][0]++;break;
	case "2":FiveLine[10][1]++;break;
	case "3":FiveLine[10][2]++;break;
	case "4":FiveLine[10][3]++;break;
	case "5":FiveLine[10][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}
else if(date.getTime()>dt13.getTime()){
	switch(carline){
	case "1":FiveLine[11][0]++;break;
	case "2":FiveLine[11][1]++;break;
	case "3":FiveLine[11][2]++;break;
	case "4":FiveLine[11][3]++;break;
	case "5":FiveLine[11][4]++;break;
	default: System.out.print("时间"+time+"   车道："+carline);
	}
}

        	
 	
        }
        System.out.println("第一时间段："+"\n"+"第一车道："+FiveLine[0][0]+"\n共有车辆："+FiveLine[0][0]+FiveLine[0][1]+FiveLine[0][2]+FiveLine[0][3]+FiveLine[0][4]);
        
        String s="";
        int number=0;
        int allnumber=0;
        for(int k=1;k<13;k++){
        	s=s+"第"+k+"时间段:\n";
        	s=s+"第1车道车辆数："+FiveLine[k-1][0]+"\n";
        	s=s+"第2车道车辆数："+FiveLine[k-1][1]+"\n";
        	s=s+"第3车道车辆数："+FiveLine[k-1][2]+"\n";
        	s=s+"第4车道车辆数："+FiveLine[k-1][3]+"\n";
        	s=s+"第5车道车辆数："+FiveLine[k-1][4]+"\n";
        	number=FiveLine[k-1][0]+FiveLine[k-1][1]+FiveLine[k-1][2]+FiveLine[k-1][3]+FiveLine[k-1][4];
        	allnumber=allnumber+number;
        	s=s+"共有车流量："+number+"\n**********************\n";
        	out.write(s, 0, s.length()-1);
        	s="";
        }
        
        s="共有车流量："+allnumber+"\n";
        System.out.print(s);
        out.write(s,0, s.length()-1);
        out.close();
        
        
        /*
        for (int x = 0; x < numberOfSheets; x++) {//很详细的打印代码******************
        	boolean aaa=true;
        	if(aaa==false){
            XSSFSheet sheet = wb.getSheetAt(x);
            int columnNum = 0;
            if (sheet.getRow(0) != null) {
                columnNum = sheet.getRow(0).getLastCellNum()
                        - sheet.getRow(0).getFirstCellNum();
            }
            if (columnNum > 0) {
                for (Row row : sheet) {
                    String[] singleRow = new String[columnNum];
                    int n = 0;
                    for (int i = 0; i < columnNum; i++) {
                        Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BLANK:
                                singleRow[n] = "";
                                if (cell == null || cell.equals("") || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
                                    System.out.print("<Null>|");
                                } else {
                                    System.out.print(singleRow[n] + "|");
                                }
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                singleRow[n] = Boolean.toString(cell.getBooleanCellValue());
                                System.out.print(singleRow[n] + "|");
                                break;
                            // 数值
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat sdf = null;
                                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                            .getBuiltinFormat("h:mm")) {
                                        sdf = new SimpleDateFormat("HH:mm");
                                    } else {// 日期
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    }
                                    Date date = cell.getDateCellValue();
                                    System.out.print(sdf.format(date) + "|");
                                } 
                                else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    String temp = cell.getStringCellValue();
                                    // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                    if (temp.indexOf(".") > -1) {
                                        singleRow[n] = String.valueOf(new Double(temp))
                                                .trim();
                                        System.out.print(singleRow[n] + "|");
                                    } else {
                                        singleRow[n] = temp.trim();
                                        System.out.print(singleRow[n] + "|");
                                    }
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                singleRow[n] = cell.getStringCellValue().trim();
                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                singleRow[n] = "";
                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                String temp = cell.getStringCellValue();
                                // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                if (temp.indexOf(".") > -1) {
                                    temp = String.valueOf(new Double(temp))
                                            .trim();
                                    Double cny = Double.parseDouble(temp);//6.2041
                                    DecimalFormat df = new DecimalFormat("0.00");
                                    String CNY = df.format(cny);
                                    System.out.print(CNY + "|");
                                } else {
                                    singleRow[n] = temp.trim();
                                    System.out.print(singleRow[n] + "|");

                                }
                            default:
                                singleRow[n] = "";
                                break;
                        }
                        n++;
                    }
                    System.out.println();
                }
                System.out.println("===========================================================Sheet分割线===========================================================");
            }
        }
        }*/
    }

}