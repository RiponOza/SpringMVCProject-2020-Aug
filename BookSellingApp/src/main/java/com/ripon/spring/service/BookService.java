package com.ripon.spring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ripon.spring.dao.BookDao;
import com.ripon.spring.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookDao dao;
	private boolean status;
	private String imageAbsolutePath = "C:/Users/Ripon/Desktop/SpringMvcProject-Aug-2020/SpringMVCProject-2020-Aug/BookSellingApp/src/main/webapp/resources/file/image";

	
	
	
	// converts Map object taken from request scope to a Book object.
	public Book getBookObject(Map<String, String> map) {
		Book book = new Book();
		book.setId(Long.parseLong(map.get("Id")));
		book.setBname(map.get("bname"));
		book.setAuthor(map.get("author"));
		book.setPrice(Double.parseDouble(map.get("price")));
		book.setTotalpage(Long.parseLong(map.get("totalpage")));
		return book;
	}

	
	
	
	// it does server side validation of the data present in Book object.
	public boolean validateBook(Book book) {
		return true; // Not complete
	}

	
	
	
	
	// insert method
	// returns 1 if successful, returns 2 if record already available, returns 0 for
	// failure.
	public int insertBook(Book book) {
		if (dao.isRecordAvailable(book) == false) {
			status = dao.insertBookRecord(book);
			if (status) {
				return 1;
			}
		} else if (dao.isRecordAvailable(book) == true) {
			return 2;
		}

		return 0;
	}

	
	

	
	// returns 1 if successful, returns 2 if record not available, returns 0 for
	// failure.
	public int deleteBook(Book book) {
		if (dao.isRecordAvailable(book)) {
			status = dao.deleteBookRecord(book);
			if (status) {
				return 1;
			}
		} else if (!(dao.isRecordAvailable(book))) {
			return 2;
		}
		return 0;
	}

	
	
	
	
	
	
	// get book record using Book Id, returns null if record not available
	public Book getBook(long id) {
		Book book = dao.getBookRecord(id);
		return book;
	}

	
	
	
	
	
	public int updateBook(Book book) {
		return 0;
	}

	
	
	
	
	public List<Book> getAllBook() {
		return null;
	}

	
	
	
	
	
	
	/**
	 * uploads book image to file. Returns 1 --> success, Returns 0 ---> Failure,
	 * Returns 404 --> File Not selected or file is empty, Returns 101 --> File is
	 * larger than 1mb
	 **/
	public int saveImage(MultipartFile uploadFile) {

		Long fileSize;
		File totalFilesList[] = null;
		String returnstatus;

		File directoryLocation = new File(imageAbsolutePath);

		fileSize = uploadFile.getSize();
		if (fileSize > 1048576) {
			return 101;
		}

		// checking the file location directory is existed or not
		if (!directoryLocation.exists()) {
			directoryLocation.mkdir();
		}
		// uploads if file is not empty, otherwise returns 0
		if (!uploadFile.isEmpty()) {
			String uploadFileName = "FILE" + uploadFile.getOriginalFilename();
			try {
				FileOutputStream fos = new FileOutputStream(
						directoryLocation.getAbsolutePath() + File.separator + uploadFileName);
				byte[] bt = uploadFile.getBytes();
				fos.write(bt);
				fos.flush();
				totalFilesList = directoryLocation.listFiles();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			return 404;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
