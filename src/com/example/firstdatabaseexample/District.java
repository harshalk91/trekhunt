package com.example.firstdatabaseexample;

public class District {
	  private long id;
	  private String district;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getComment() {
	    return district;
	  }

	  public void setDistrict(String district) {
	    this.district = district;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return district;
	  }
	} 