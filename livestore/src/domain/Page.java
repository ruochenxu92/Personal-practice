package domain;

import java.util.List;

public class Page {
	
	private int totalrecords;
	private int startindex;
	private int pagenum;
	private final int pagesize = 1;
	
	private int startpage;
	private int endpage;
	private int totalpage;
	
	private List<Book> list;
	
	public Page( int totalrecords, int pagenum){
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		this.totalpage = (totalrecords - 1 + pagesize)/pagesize;
		this.startindex = pagenum * pagesize - pagesize;
		
		if(totalpage < 10){
			this.startpage = 1;
			this.endpage = totalpage;	
			
		}else{
		
			this.startpage = this.pagenum - 4;
			this.endpage = this.pagenum + 5;
			
			
			if(this.startpage < 1){
				this.startpage = 1;
				this.endpage = 10;
			}
			
			if(this.endpage > this.totalpage){
				this.startpage = this.totalpage - pagesize + 1;
				this.endpage = this.totalpage;
			}

		}
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public int getPagesize() {
		return pagesize;
	}
	

}
