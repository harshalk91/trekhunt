package com.example.firstdatabaseexample;

public class Fort {
	  private long id;
	  private String name;
      private String height;
      private String type;
      private String range;
      private String grade;
      private String spots;
      private String ways_to_reach;
      private String accomodation;
      private String food;
      private String water;
      private String time_to_reach;
      private int district_id; // foreign key
      private String img_path_1;
      private String img_path_2;      
      private String img_path_3;
      private String img_path_4;
      private String map_path;
      
      
       public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getHeight() {
		    return height;
		  }

		  public void setHeight(String height) {
		    this.height = height;
		  }
        
	  public String getType() {
			    return type;
			  }

	  public void setType(String type) {
			    this.type = type;
			  }

	  public String getGrade()
	  {
		  return this.grade;
	  }
	  
	  public void setGrade(String grade)
	  {
		  this.grade = grade;
	  }
	  public String getRange() {
		    return range;
		  }

	  public void setRange(String range) {
		    this.range = range;
		  }

	  
	  public String getSpots() {
		    return spots;
		  }

	  public void setSpots(String spots) {
		    this.spots = spots;
		  }

	  public String waysToReach() {
		    return ways_to_reach;
		  }

	  public void setWaysToReach(String ways_to_reach) {
		    this.ways_to_reach = ways_to_reach;
		  }
	  
	  public String getAccomodation() {
		    return accomodation;
		  }

	  public void setAccomodation(String accomodation) {
		    this.accomodation = accomodation;
		  }
	  
	  public String getFood() {
		    return food;
		  }

	  public void setFood(String food) {
		    this.food = food;
		  }

	  public String getWater() {
		    return water;
		  }

	  public void setWater(String water) {
		    this.water = water;
		  }
	  
	  public String getTimeToReach() {
		    return time_to_reach;
		  }

	  public void setTimeToReach(String time_to_reach) {
		    this.time_to_reach = time_to_reach;
		  }

	  public String getImagePath1() {
		    return img_path_1;
		  }

	  public void setImagePath1(String img_path_1) {
		    this.img_path_1 = img_path_1;
		  }

	  public String getImagePath2() {
		    return img_path_2;
		  }

	  public void setImagePath2(String img_path_2) {
		    this.img_path_2 = img_path_2;
		  }

	  public String getImagePath3() {
		    return img_path_3;
		  }

	  public void setImagePath3(String img_path_3) {
		    this.img_path_3 = img_path_3;
		  }
	  
	  public String getImagePath4() {
		    return img_path_4;
		  }

	  public void setImagePath4(String img_path_4) {
		    this.img_path_4 = img_path_4;
		  }

	  public String getMapPath() {
		    return map_path;
		  }

	  public void setMapPath(String map_path) {
		    this.map_path = map_path;
		  }
    
	  public long getDistrictId() {
		    return district_id;
		  }

		  public void setDistrictId(int district_id) {
		    this.district_id = district_id;
		  }


	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return name;
	  }
	} 