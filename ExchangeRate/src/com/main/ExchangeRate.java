package com.main;
import com.main.bean.*;
import java.io.File;
import java.util.Date;
import java.util.List;

public class ExchangeRate {
	    private Date startDate = null;//��ʼʱ�䣬Ĭ����30��֮ǰ
	    private Date endDate = null; //����ʱ�䣬Ĭ���ǽ���
	    private String dirPath = "./output"; //�ļ�Ŀ¼��·����Ϣ,Ĭ����"./output"

	    public ExchangeRate(){}

	    public ExchangeRate(String path){
	        dirPath = path;
	    }

	    public ExchangeRate(Date startDate, Date endDate, String dirPath){
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.dirPath = dirPath;
	    }

	    public String createRateData(){
	        List<data> data = netObtain.getRateData(startDate, endDate);
	        if (data == null) {
	            return "������ȡʧ��";
	        }
	        File fileDir = new File(dirPath);
	        if (!fileDir.exists() || !fileDir.isDirectory()){
	            return "�ļ�Ŀ¼���ó���";
	        }

	        String path = dirPath + "/����һ���.xls";
	        if (!createExcel.createExcelFile(path, data)){
	            return "�ļ�����ʧ��";
	        }

	        return "�ļ�����·��Ϊ��" + path;
	    }




	    public static void main(String[] args) {
	        //long start = System.currentTimeMillis();
	        System.out.println(new ExchangeRate().createRateData());
	        //System.out.println(System.currentTimeMillis()-start);
	    }
}
