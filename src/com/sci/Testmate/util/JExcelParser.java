
package com.sci.Testmate.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sci.Testmate.model.WebElementDataDetails;

public class JExcelParser {
  protected transient final Log log = LogFactory.getLog(getClass());
  private static JExcelParser jExcelParser = null;

  // ==========================================================================

  private JExcelParser() {
  }

  // ==========================================================================

  public static synchronized JExcelParser getInstance() {
    if (jExcelParser == null) {
      jExcelParser = new JExcelParser();
    }
    return jExcelParser;
  }

  // ==========================================================================

  public List<WebElementDataDetails> getDataSet(String pageName) {
    log.info("START of the method getDataSet");
    FileInputStream file = null;
    Workbook workbook = null;
    List<WebElementDataDetails> webElementsData = null;
    int rowCount = 0;
    int cellCount = 0;

    try {
      file = new FileInputStream(new File(AppUtil.getExcelFilePath(pageName)));
      workbook = WorkbookFactory.create(file);
      Sheet sheet = workbook.getSheetAt(0);
      webElementsData = new ArrayList<WebElementDataDetails>();

      for (Row row : sheet) {
        if (rowCount > 0) {

          WebElementDataDetails dataDetails = new WebElementDataDetails();
          List<String> dataSet = new ArrayList<String>();
          for (Cell cell : row) {
            if (cellCount == 0) {
              if (getCellValue(cell) != null) {
                Double dataSetNo = Double.parseDouble(getCellValue(cell));
                dataDetails.setDataSetNo(dataSetNo.intValue());
              }
            } else if (cellCount == 1) {
              dataDetails.setExecute(Boolean.parseBoolean(getCellValue(cell)));
            } else {
              dataSet.add(getCellValue(cell));
            }
            cellCount++;
          }
          cellCount = 0;

          dataDetails.setDataSet(dataSet);
          webElementsData.add(dataDetails);
        }
        rowCount++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (file != null) {
        try {
          file.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    log.info("END of the method getDataSet");
    return webElementsData;
  }

  // ==========================================================================

  private String getCellValue(Cell cell) {
    String cellValue = null;

    try {
      switch (cell.getCellType()) {
      case Cell.CELL_TYPE_NUMERIC:
        // System.out.print(cell.getNumericCellValue() + "\t");
    	  Double dataSetNo = cell.getNumericCellValue();
        cellValue = String.valueOf(dataSetNo.intValue());
        break;
      case Cell.CELL_TYPE_STRING:
        // System.out.print(cell.getStringCellValue() + "\t");
        cellValue = cell.getStringCellValue();
        break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cellValue;
  }
  // ==========================================================================

  public static void main(String args[]) {
    List<WebElementDataDetails> webElementsData = JExcelParser.getInstance().getDataSet("USAddOrder");
    if (webElementsData != null && webElementsData.size() > 0) {
      for (WebElementDataDetails dataDetails : webElementsData) {
        System.out.println(dataDetails.getDataSetNo());
        System.out.println(dataDetails.isExecute());
        List<String> dataSet = dataDetails.getDataSet();

        if (dataSet != null && dataSet.size() > 0) {
          for (String s : dataSet) {
            System.out.println(s);
          }
        }

      }
    }

  }

  // ==========================================================================
}
