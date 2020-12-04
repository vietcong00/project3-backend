package project3.backend.helper.helper;//package viettel.project3.helper.helper;
//
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import viettel.project3.model.Employee;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//
//public class ExcelHelper {
//
//    private static SimpleDateFormat dateFormat;
//    private static TimeHelper timeHelper;
//    private static CellStyle cs;
//
//    private static void setHeader(String[] headers, Row headerRow) {
//        for (int col = 0; col < headers.length; col++) {
//            Cell cell = headerRow.createCell(col);
//            cell.setCellValue(headers[col]);
//        }
//    }
//
////    public static ByteArrayInputStream customerToExcel(List<Customer> customers) {
////
////        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
////            Sheet sheet = workbook.createSheet("Customer");
////
////            // Header
////            Row headerRow = sheet.createRow(0);
////            String[] headers = {"ID", "Name", "Phone", "Email", "Address", "Id Employee create", "Time Create"};
////            setHeader(headers, headerRow);
////
////            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////
////            int rowIdx = 1;
////            for (Customer customer : customers) {
////                Row row = sheet.createRow(rowIdx++);
////
////
////                row.createCell(0).setCellValue(customer.getIdCustomer());
////                row.createCell(1).setCellValue(customer.getName());
////                row.createCell(2).setCellValue(customer.getPhone());
////                row.createCell(3).setCellValue(customer.getEmail());
////                row.createCell(4).setCellValue(customer.getAddress());
////                row.createCell(5).setCellValue(customer.getCreateByIdEmployee());
////                if (customer.getCreateTime() != null) {
////                    row.createCell(6).setCellValue(dateFormat.format(customer.getCreateTime()));
////                }
////            }
////            for (int i = 0; i < headers.length; i++) {
////                sheet.autoSizeColumn(i);
////            }
////            workbook.write(out);
////            return new ByteArrayInputStream(out.toByteArray());
////        } catch (IOException e) {
////            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
////        }
////    }
//
////    public static ByteArrayInputStream userToExcel(List<Employee> users) {
////
////        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
////            Sheet sheet = workbook.createSheet("Customer");
////
////            // Header
////            Row headerRow = sheet.createRow(0);
////            String[] headers = {"ID", "Employee Name", "Name", "Phone", "Email", "Address", "Id Admin create", "Time Create"};
////            setHeader(headers, headerRow);
////
////            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////
////            int rowIdx = 1;
////            for (Employee user : users) {
////                Row row = sheet.createRow(rowIdx++);
////
////
////                row.createCell(0).setCellValue(user.getIdEmployee());
////                row.createCell(1).setCellValue(user.getEmployeename());
////                row.createCell(2).setCellValue(user.getName());
////                row.createCell(3).setCellValue(user.getPhone());
////                row.createCell(4).setCellValue(user.getEmail());
////                row.createCell(5).setCellValue(user.getAddress());
////                row.createCell(6).setCellValue(user.getCreateByIdAdmin());
////                if (user.getCreateTime() != null) {
////                    row.createCell(7).setCellValue(dateFormat.format(user.getCreateTime()));
////                }
////            }
////            for (int i = 0; i < headers.length; i++) {
////                sheet.autoSizeColumn(i);
////            }
////            workbook.write(out);
////            return new ByteArrayInputStream(out.toByteArray());
////        } catch (IOException e) {
////            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
////        }
////    }
//
////    public static ByteArrayInputStream historyCareToExcel(List<HistoryCare> historyCares) {
////
////        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
////            Sheet sheet = workbook.createSheet("Customer");
////            sheet.setColumnWidth(0, 18000);
////            cs = workbook.createCellStyle();
////            cs.setWrapText(true);
////
////            // Header
////            Row headerRow = sheet.createRow(0);
////            String[] headers = {"ID", "ID Customer", "Employee Name","Start Time","End Time", "Concern Level", "Note", "Potential Level", "Next Action", "Menthod", "Purpose", "Product Name"};
////            for (int col = 0; col < headers.length; col++) {
////                Cell cell = headerRow.createCell(col);
////                cell.setCellValue(headers[col]);
////            }
////
////            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////            timeHelper = new TimeHelper();
////
////            int rowIdx = 1;
////            for (HistoryCare historyCare : historyCares) {
////                Row row = sheet.createRow(rowIdx++);
////
////                row.createCell(0).setCellValue(historyCare.getId());
////                row.createCell(1).setCellValue(historyCare.getIdCustomer());
////                row.createCell(2).setCellValue(historyCare.getEmployeeName());
////                if (historyCare.getStartTime() != null) {
////                    row.createCell(3).setCellValue(dateFormat.format(historyCare.getStartTime()));
////                }
////                if (historyCare.getEndTime() != null) {
////                    row.createCell(4).setCellValue(dateFormat.format(historyCare.getEndTime()));
////                }
////                row.createCell(5).setCellValue(historyCare.getConcernLevel());
////                row.createCell(6).setCellValue(historyCare.getNote());
////                row.createCell(7).setCellValue(historyCare.getPotentialLevel());
////                row.createCell(8).setCellValue(historyCare.getAction());
////                row.createCell(9).setCellValue(historyCare.getMethod());
////                row.createCell(10).setCellValue(historyCare.getPurpose());
////                row.createCell(11).setCellValue(historyCare.getProductName());
////
////
////            }
////            for (int i = 0; i < headers.length; i++) {
////                sheet.autoSizeColumn(i);
////            }
////            workbook.write(out);
////            return new ByteArrayInputStream(out.toByteArray());
////        } catch (IOException e) {
////            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
////        }
////    }
//
////    public static ByteArrayInputStream transactionToExcel(List<Transaction> transactions) {
////
////        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
////            Sheet sheet = workbook.createSheet("Customer");
////            sheet.setColumnWidth(0, 1000);
////            cs = workbook.createCellStyle();
////            cs.setWrapText(true);
////            // Header
////            Row headerRow = sheet.createRow(0);
////            String[] headers = {"ID", "ID Customer", "ID Employee", "Time Transaction", "ID Product", "Status", "Note"};
////            setHeader(headers, headerRow);
////
////            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////
////            int rowIdx = 1;
////            for (Transaction transaction : transactions) {
////                Row row = sheet.createRow(rowIdx++);
////
////                row.createCell(0).setCellValue(transaction.getIdDeal());
////                row.createCell(1).setCellValue(transaction.getIdCustomer());
////                row.createCell(2).setCellValue(transaction.getIdEmployee());
////                row.createCell(3).setCellValue(dateFormat.format(transaction.getTransactionTime()));
////                row.createCell(4).setCellValue(transaction.getIdProduct());
////                row.createCell(5).setCellValue(transaction.getStatus());
////                row.createCell(6).setCellStyle(cs);
////                row.createCell(6).setCellValue(transaction.getNote());
////            }
////            for (int i = 0; i < headers.length; i++) {
////                sheet.autoSizeColumn(i);
////            }
////            workbook.write(out);
////            return new ByteArrayInputStream(out.toByteArray());
////        } catch (IOException e) {
////            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
////        }
////    }
//
////    public static ByteArrayInputStream productToExcel(List<Product> products) {
////
////        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
////            Sheet sheet = workbook.createSheet("Customer");
////            sheet.setColumnWidth(0, 18000);
////            cs = workbook.createCellStyle();
////            cs.setWrapText(true);
////            // Header
////            Row headerRow = sheet.createRow(0);
////            String[] headers = {"ID Product", "Name", "Price", "Description"};
////            setHeader(headers, headerRow);
////
////            int rowIdx = 1;
////            for (Product product : products) {
////                Row row = sheet.createRow(rowIdx++);
////
////                row.createCell(0).setCellValue(product.getIdProduct());
////                row.createCell(1).setCellValue(product.getName());
////                row.createCell(2).setCellValue(product.getPrice());
////                row.createCell(3).setCellStyle(cs);
////                row.createCell(3).setCellValue(product.getDescription());
////            }
////            for (int i = 0; i < headers.length; i++) {
////                sheet.autoSizeColumn(i);
////            }
////            workbook.write(out);
////            return new ByteArrayInputStream(out.toByteArray());
////        } catch (IOException e) {
////            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
////        }
////    }
//}
