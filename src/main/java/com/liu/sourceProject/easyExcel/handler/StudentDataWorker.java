package com.liu.sourceProject.easyExcel.handler;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.liu.sourceProject.easyExcel.exception.ImportExcelException;
import com.liu.sourceProject.easyExcel.form.ImportForm;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/8/29 16:59
 */
@Data
public class StudentDataWorker extends AnalysisEventListener<ImportForm> {
    private List<ImportForm> datas = new ArrayList<>();

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        this.checkHead( headMap);
    }

    @Override
    public void invoke(ImportForm importForm, AnalysisContext analysisContext) {
        datas.add(importForm);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    private void checkHead(Map<Integer, String> headMap) {
        if(headMap.size() != 3){
            throw new ImportExcelException("excel的列数必须为6列");
        }
    }
}
