package first;
//Process all bayonet file data


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class getAll {//�������ݼ�\1101�µ����� �����������ĵ�

	static String basePath="D:\\���ڸ�����\\��������\\20104606����·����ɽ���������ƺ����";
	static void findFile(File dir) throws Exception{
	File[] dirFiles = dir.listFiles();
	for(File temp : dirFiles){
	//if(!temp.isFile()){
	//findFile(temp);
	//}
	//����ָ�����ļ�
		if(temp.isFile() && temp.getAbsolutePath().endsWith(".xlsx") ){
	      System.out.println(temp.isFile() + "  " + temp.getAbsolutePath());
	      //ȥ��
	      // AbandonError.abandonerror(temp.getAbsolutePath());
	      //��ȡÿ�����Ĺ켣
	      //getUnit.GetUnit(temp.getAbsolutePath());
	      //��ȡgeohash����
	     // AllAreaAndNum.allareaandnum(temp.getAbsolutePath());
	      DoExcle.ReadExcle(temp.getAbsolutePath());
		}
	}
}
	  
	  /**
	  * @param file Ҫ��ȡ���ļ�����
	  * @return �����ļ�������
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
	  * @param file Ҫд����ļ�����
	  * @param content Ҫд����ļ�����
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
