package com.liu.sourceProject.easyExcel.handler;

import com.alibaba.excel.write.handler.AbstractRowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.liu.sourceProject.easyExcel.validate.ValidateStudentContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.util.Objects;

/**
 * @author liu
 * @Date 2020/8/30 10:44
 */
public class StudentWriteHandler extends AbstractRowWriteHandler {
	private final int rowLength = 6;
	ValidateStudentContext validateStudentContext;

	public StudentWriteHandler(ValidateStudentContext validateStudentContext) {
		this.validateStudentContext = validateStudentContext;
	}

	@Override
	public void afterRowDispose(WriteSheetHolder writeSheetHolder,
			WriteTableHolder writeTableHolder, Row row,
			Integer relativeRowIndex, Boolean isHead) {
		if (!isHead) {
			Sheet sheet = writeSheetHolder.getSheet();
			for (int i = 0; i < 3; i++) {
				if (StringUtils.isBlank(row.getCell(i).toString())) {
					CellStyle cellStyle = generateRedCellStyle(sheet);
					Comment comment = generateComment(sheet, "不能为空");
					sheet.getRow(relativeRowIndex + 1).createCell(i)
							.setCellComment(comment);
					sheet.getRow(relativeRowIndex + 1).createCell(i)
							.setCellStyle(cellStyle);
				} else {
					if (i == 1
							&& Objects.nonNull(validateStudentContext
									.getCollegeNameErrorLineNum())
							&& validateStudentContext
									.getCollegeNameErrorLineNum()
									.contains(relativeRowIndex)) {
						// 更改的cell样式
						CellStyle cellStyle = generateRedCellStyle(sheet);
						// 添加的批注
						Comment comment = generateComment(sheet, "学院不存在");
						// 拿到当前cell，设置批注
						sheet.getRow(relativeRowIndex + 1).getCell(i)
								.setCellComment(comment);
						// 拿到当前cell，设置cell的样式
						sheet.getRow(relativeRowIndex + 1).getCell(i)
								.setCellStyle(cellStyle);
					} else if (i == 2
							&& Objects.nonNull(validateStudentContext
									.getStudentNumberErrorLineNum())
							&& validateStudentContext
									.getStudentNumberErrorLineNum()
									.contains(relativeRowIndex)) {
						// 更改的cell样式
						CellStyle cellStyle = generateRedCellStyle(sheet);
						// 添加的批注
						Comment comment = generateComment(sheet, "学号重复");
						// 拿到当前cell，设置批注
						sheet.getRow(relativeRowIndex + 1).getCell(i)
								.setCellComment(comment);
						// 拿到当前cell，设置cell的样式
						sheet.getRow(relativeRowIndex + 1).getCell(i)
								.setCellStyle(cellStyle);
					}
				}
			}
		}
	}

	/**
	 * 生成一个红色的cell
	 *
	 * @param sheet
	 *            excel的sheet
	 */
	private CellStyle generateRedCellStyle(Sheet sheet) {
		Workbook workbook = sheet.getWorkbook();
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		return cellStyle;
	}

	/**
	 * 添加批注
	 *
	 * @param sheet
	 *            当前sheet
	 * @param message
	 *            需要添加的批注信息
	 */
	private Comment generateComment(Sheet sheet, String message) {
		Drawing<?> drawingPatriarch = sheet.createDrawingPatriarch();
		Comment comment = drawingPatriarch.createCellComment(
				new XSSFClientAnchor(0, 0, 0, 0, 10, 0, 10, 1));

		comment.setString(new XSSFRichTextString(message));
		return comment;
	}
}
