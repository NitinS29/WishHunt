package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Wish {
	
	String wishTitle, description, location, postedBy;
	String startDate, endDate;
	Timestamp postedAt;
	int wishId;
	
	
	public Wish(){
		
	}
	
	

	public int getWishId() {
		return wishId;
	}



	public void setWishId(int wishId) {
		this.wishId = wishId;
	}



	public String getWishTitle() {
		return wishTitle;
	}

	public void setWishTitle(String wishTitle) {
		this.wishTitle = wishTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Timestamp getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Timestamp postedAt) {
		this.postedAt = postedAt;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	public String getPostedBy() {
		return postedBy;
	}



	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}



	public static Date getInsertDate(String s){
		java.sql.Date dte=null;
		try{
		String str = s;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
		java.util.Date dt = formatter.parse(str);
		dte=new java.sql.Date(dt.getTime());
		}catch(Exception e){
		e.printStackTrace();	
		}	

		return dte;
		}

}
