package first;
//Process all bayonet file data


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class getAll {//遍历数据集\1101下的所有 浮动车数据文档

	static String basePath="D:\\深圳浮动车\\卡口数据\\20104606福龙路横龙山隧道北行南坪出口";
	static void findFile(File dir) throws Exception{
	File[] dirFiles = dir.listFiles();
	for(File temp : dirFiles){
	//if(!temp.isFile()){
	//findFile(temp);
	//}
	//查找指定的文件
		if(temp.isFile() && temp.getAbsolutePath().endsWith(".xlsx") ){
	      System.out.println(temp.isFile() + "  " + temp.getAbsolutePath());
	      //去错
	      // AbandonError.abandonerror(temp.getAbsolutePath());
	      //提取每辆车的轨迹
	      //getUnit.GetUnit(temp.getAbsolutePath());
	      //提取geohash区域
	     // AllAreaAndNum.allareaandnum(temp.getAbsolutePath());
	      DoExcle.ReadExcle(temp.getAbsolutePath());
		}
	}
}
	  
	  /**
	  * @param file 要读取的文件对象
	  * @return 返回文件的内容
	  * */
	  public static String  readFileContent(File file) throws Exception{
	  FileReader fr = new FileReader(file);
	  BufferedReader br = new BufferedReader(fr);
	  StringBuffer sb = new StringBuffer();
	  while(br.ready()){
	  sb.append(br.readLine());
	  }
	  System.out.println(sb.toString());
	  return sb.toString();
	  }
	  
	  /**
	  * @param file 要写入的文件对象
	  * @param content 要写入的文件内容
	  * */
	  public static void  writeFileContent(File file,String content) throws Exception{
	  FileWriter fw = new FileWriter(file);
	  fw.write(content);
	  fw.flush();
	  fw.close();
	  }
	  
	  public static void main(String[] args) throws Exception{
 
		findFile(new File(basePath));
		
 
	  }
}
