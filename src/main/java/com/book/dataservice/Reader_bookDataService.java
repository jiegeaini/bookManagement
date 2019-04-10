package com.book.dataservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.formbean.Reader_bookFormbean;
import com.book.pojo.Book;
import com.book.pojo.Reader;
import com.book.pojo.Reader_book;
import com.book.pojo.State;
import com.book.service.BookService;
import com.book.service.ReaderService;
import com.book.service.Reader_bookService;
import com.book.service.StateService;

@Service
public class Reader_bookDataService {

	@Autowired
	Reader_bookService rbService;
	@Autowired
	BookService bookService;
	@Autowired
	ReaderService readerService;
	@Autowired
	StateService stateService;

	/**
	 * @function 检察用户是否存在
	 * @param formbean
	 * @return
	 */
	public boolean addRb_User(Reader_bookFormbean formbean) {
		Reader reader = readerService.get_nameReader(formbean.getReaderName());
		if (reader == null) {
			return false;
		}
		return true;
	}

	/**
	 * @function 检察图书的库存
	 * @param formbean
	 * @return
	 */
	public boolean addRb_book(Reader_bookFormbean formbean) {
		Book book = bookService.get_nameBook(formbean.getBookName());
		if (book != null) {
			int inventory = book.getInventory();
			if (inventory > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @function 添加借书信息
	 * @param formbean reader_book
	 *
	 */
	public void addRb(Reader_bookFormbean formbean,Reader_book reader_book) throws Exception {
		Book book = bookService.get_nameBook(formbean.getBookName());
		Reader reader = readerService.get_nameReader(formbean.getReaderName());
		State state = stateService.get_nameState(formbean.getStateName());
		reader_book.setBook(book);
		reader_book.setReader(reader);
		reader_book.setState(state);
		book.setInventory(book.getInventory()-1);
		bookService.updateBook(book, book.getCategory().getName(),
				book.getAuthor().getName());
		rbService.addReader_book(reader_book);	
	}
	
	/**
	 * @function 修改借书信息
	 * @param formbean reader_book
	 * @throws Exception
	 */
	private void updateRb(Reader_book reader_book) throws Exception {
		rbService.updateReader_book(reader_book);
	}

	/**
	 * @function 修改书籍之前要做的事儿
	 * @param formbean
	 * @param reader_book
	 * @throws Exception
	 */
	public void updateRb_book(Reader_bookFormbean formbean,Reader_book reader_book) throws Exception {
		Book book = bookService.get_nameBook(formbean.getBookName());
		Reader reader = readerService.get_nameReader(formbean.getReaderName());
		State state = stateService.get_nameState(formbean.getStateName());
		reader_book.setBook(book);
		reader_book.setReader(reader);
		reader_book.setState(state);
		//获取本来的借书信息
		Reader_book rb = rbService.getReader_book(reader_book.getId());
		//对比图书信息看看是否改变
		if (rb.getBook().getName().equals
				(reader_book.getBook().getName()) == false) {
			//如果是修改了书籍名称，那么把原本的书籍库存加一
			Book book2 = rb.getBook();
			book2.setInventory(book2.getInventory()+1);
			bookService.updateBook(book2, book2.getCategory().getName(),
					book2.getAuthor().getName());
			//并且把当前修改的书籍库存减一
			book.setInventory(book.getInventory()-1);
			bookService.updateBook(book, book.getCategory().getName(),
					book.getAuthor().getName());
		}
		//对比状态信息看看是否改变
		if (reader_book.getState().getName().equals("已归还")) {
			Book book2 = rb.getBook();
			System.out.println("本来的图书数量："+book2.getInventory());
			System.out.println("本来的图书name："+book2.getName());
			book2.setInventory(book2.getInventory()+1);
			bookService.updateBook(book2, book2.getCategory().getName(),
					book2.getAuthor().getName());
		}
		
		
		updateRb(reader_book);
	}
	
}
