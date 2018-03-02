package com.kms.operation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**将信息输入Excel，
 * 所用方法：
 * public void writeExcel(String path, List<String[]> list, String sheet,String[] title)
 * @author 刘嘉赓
 *
 */
public class ExcelOperation {
	/**将list里面的信息写入path路径下的文件，
	 * path：文件路径及文件名；
	 * list；具体数据；
	 * sheet：表名；
	 * title：表头；
	 * 
	 * @param path
	 * @param list
	 * @param sheet
	 * @param title
	 */
	public void writeExcel(String path, List<String[]> list, String sheet,String[] title) {
		// 创建Excel工作薄
        WritableWorkbook wwb = null;
		try {
			// 新建立一个jxl文件
	        OutputStream os = new FileOutputStream(path);
			wwb = Workbook.createWorkbook(os);
			
			// 添加第一个工作表并设置第一个Sheet的名字
            WritableSheet sheets = wwb.createSheet(sheet, 1);
            Label label;
            for (int i = 0; i < title.length; i++) {
                // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
                // 在Label对象的子对象中指明单元格的位置和内容
            	label = new Label(i, 0, title[i]);
                //设置列宽
                sheets.setColumnView(i, 20);
                // 将定义好的单元格添加到工作表中
                sheets.addCell(label);
            }
            
            //设置单元格属性
            WritableCellFormat wc = new WritableCellFormat();
            // 设置居中
            wc.setAlignment(Alignment.CENTRE);
            
            for (int i = 0; i < list.size(); i++) {
                String[] arrData = list.get(i);
                for (int j = 0; j < arrData.length; j++) {
                    //向特定单元格写入数据
                    label = new Label(j, 1 + i, arrData[j], wc);
                    sheets.addCell(label);
                }
            }
            // 写入数据
            wwb.write();
            // 关闭文件
            wwb.close();
			System.out.println("成功写入文件！");
		} catch (FileNotFoundException e) {
			System.out.println("创建文件失败！"+e.getMessage());
			e.printStackTrace();
		} catch (RowsExceededException e) {
			System.out.println("创建文件失败！"+e.getMessage());
			e.printStackTrace();
		} catch (WriteException e) {
			System.out.println("创建文件失败！"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("创建文件失败！"+e.getMessage());
			e.printStackTrace();
		}
	}
}
