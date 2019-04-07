package com.christ.tts.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import com.christ.tts.model.Lecturer;
import com.christ.tts.model.Room;
import com.christ.tts.model.StudentGroup;
import com.christ.tts.model.Subject;

/**
 * 
 */
package com.christ.tts.excelreader;
/**
 * @author spallai
 *
 */
public class ExcelReader {

	private static ExcelReader excelReader;
	private XSSFWorkbook workbook;
	private List<Lecturer> lecturers = new ArrayList<Lecturer>();
	private ArrayList<Subject> subjects = new ArrayList<>();
	Map<String, Integer> groupToCapacityMap = new HashMap<String, Integer>();

	FileInputStream excelFileStream = null;
	private final String excelFile = "D:\\\\Christ Docs\\\\Sem-4\\\\Project\\\\Timetable.xlsx";

	private ExcelReader() {

	}

	public static ExcelReader getInstance() {
		if (excelReader == null) {
			return new ExcelReader();
		} else {
			return excelReader;
		}
	}

	public static void main(String args[]) throws InvalidFormatException, IOException, SAXException {
		ExcelReader excelReader = ExcelReader.getInstance();
		excelReader.display(excelReader.getLectures());
		excelReader.display(excelReader.getSubjects());
		excelReader.getStudentGroups();
	}

	private void display(List players) {
		for (Object player : players) {
			System.out.println("========" + player.toString());
		}
	}

	public List<Lecturer> getLectures() {

		try (FileInputStream file = new FileInputStream(new File(this.excelFile))) {
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Hours");

			for (int i = sheet.getFirstRowNum() + 4; i <= sheet.getLastRowNum(); i++) {
				Lecturer e = new Lecturer();
				Row ro = sheet.getRow(i);
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 2) {
						e.setLectureId((int) ce.getNumericCellValue());
					}
					if (j == 3) {
						String name = ce.getStringCellValue();
						e.setLectureName(name.substring(0, name.indexOf("(")).trim());
						e.setLectureShortName(name.substring(name.indexOf("(") + 1, name.indexOf(")")).trim());
					}
					if (j == 4) {
						e.setTeachHoursPerWeek((int) ce.getNumericCellValue());
					}
				}
				lecturers.add(e);
			}

			return lecturers;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Subject> getSubjects() {
		List<Lecturer> lects = null;
		Subject s = null;
		List<Subject> subjects = new ArrayList<Subject>();
		int subjectCnt = 0;
		try (FileInputStream file = new FileInputStream(new File(this.excelFile))) {
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("SUBJECT MAP");
			int row = sheet.getFirstRowNum() + 1;
			int lastRow = sheet.getLastRowNum();
			String groupName = "";
			Map<String, List<Subject>> gMap = new HashMap<>();

			while (row <= lastRow) {
				// System.out.println("Row=="+lastRow);
				Row ro = sheet.getRow(row);
				if (isRowEmpty(ro)) {
					// Look for Group on next row
					Row groupRow = sheet.getRow(row + 1);
					for (int c = groupRow.getFirstCellNum(); c < groupRow.getLastCellNum(); c++) {
						Cell cell = groupRow.getCell(c);
						System.out.println("c=" + cell.getColumnIndex() + ",r=" + cell.getRowIndex());
						groupName = cell.getStringCellValue();
						List<Subject> ssList = new ArrayList<>();
						gMap.put(groupName, ssList);
						if (groupName.equals(""))
							continue;
						else
							break;
					}
					System.out.println(">>>>>>>" + groupName.trim());
					row += 1;
					ro = sheet.getRow(row);
					System.out.println("==" + row);
				} else {
					ro = sheet.getRow(row);
					System.out.println("--" + row);
					System.out.println("--" + ro.getRowNum());
					int cell = ro.getFirstCellNum();
					int lastCell = ro.getLastCellNum();
					s = new Subject();
					subjectCnt += 1;
					s.setGroupName(groupName);
					while (cell != lastCell) {
						lects = new ArrayList<Lecturer>();
						Cell ce = ro.getCell(cell);
						s.setSubjectId(subjectCnt);

						switch (cell) {
						case 1:
							System.out.print(ce.getStringCellValue() + ",");
							s.setSubject(ce.getStringCellValue().trim());
							break;

						case 2:
							System.out.print(ce.getStringCellValue() + ",");
							s.setSubjectCode(ce.getStringCellValue().trim());
							break;

						case 3:
							System.out.println("=" + ce.getStringCellValue());
							String str = ce.getStringCellValue();
							String a[] = null;
							if (str.indexOf(",") >= 0) {
								a = ce.getStringCellValue().split(",");
							} else {
								a = ce.getStringCellValue().split("/");
							}

							if (a.length > 0) {
								for (String x : a) {
									lects.add(getLectureByShortName(x.trim()));
								}
							} else {
								lects.add(getLectureByShortName(ce.getStringCellValue().trim()));
							}
							s.setLecturers(lects);
							break;
						case 5:
							s.setLab(ce.getStringCellValue().trim().equalsIgnoreCase("practical"));
							break;
						}
						cell += 1;
					}
					if ((s.getSubject().trim().indexOf("Elective")) != 0
							&& s.getSubject().trim().indexOf("Foreign") != 0) {
						gMap.get(groupName).add(s);
						subjects.add(s);
					}
				}
				row += 1;
			}
			System.out.println("Size========" + subjects.size());
			// System.out.println(subjects);
			System.out.println("-------------");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + gMap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjects;
	}

	/**
	 * @param trim
	 * @return
	 */
	private Lecturer getLectureByShortName(String sname) {
		Lecturer lecturer = null;
		for (Lecturer lecture : lecturers) {
			if (lecture.getLectureShortName().equals(sname)) {
				return lecture;
			}
		}
		if (sname.length() == 0)
			lecturer = new Lecturer("Fr. Joesph".hashCode(), "Fr. Joesph", "Fr. Joesph");
		lecturer = new Lecturer(sname.hashCode(), sname, sname);
		lecturers.add(lecturer);
		return lecturer;
	}

	public static boolean isRowEmpty(Row row) {
		if (row == null) {
			return true;
		}
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);

			if (cell != null && cell.getCellType() != CellType.BLANK) {
				return false;
			}
		}
		return true;
	}

	public List<StudentGroup> getStudentGroups() {
		try (FileInputStream file = new FileInputStream(new File(this.excelFile))) {
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Groups");
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				String group = null;
				int capacity = 0;
				Row ro = sheet.getRow(i);
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 3) {
						group = ce.getStringCellValue().trim();
					}
					if (j == 4) {
						capacity = (int) ce.getNumericCellValue();
					}
				}
				groupToCapacityMap.put(group, capacity);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<StudentGroup> groups = new ArrayList<StudentGroup>();

//		for (Subject subject : subjects) {
//			Map<String, List<String>> groupNameToSubjectsMap = new HashMap<String,List<String>>();
//			List<String> list = new ArrayList<>();
//			groupNameToSubjectsMap.put(subject.getGroupName(), new ArrayList("12"));
//			
//			i=1;
//			StudentGroup sg = new StudentGroup(i,subject.getGroupName(),groupToCapacityMap.get(subject.getGroupName(),subject.));
//		}
		return groups;
	}

	public List<Room> getRooms() {
		List<Room> rooms = new ArrayList<Room>();
//		for () {
//			
//		}
		return rooms;
	}

}
