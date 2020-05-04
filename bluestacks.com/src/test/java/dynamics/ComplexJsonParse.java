package dynamics;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String args[])
	{
		JsonPath js= new JsonPath(payload.CoursePrice());
		
		int courseSize=js.getInt("courses.size()");
		
		System.out.println(courseSize);
		
		int purchaseCount=js.getInt("dashboard.purchaseAmount");
		
		System.out.println(purchaseCount);
		
		String firstCourse=js.get("courses[2].title");
		
		System.out.println(firstCourse);
		
		for(int i=0;i<courseSize;i++)
		{
			String courseTitle=js.get("courses["+i+"].title");
			
			System.out.println(js.get("courses["+i+"].price").toString());
			
			System.out.println(courseTitle);
			
			
		}
		System.out.println("Print no of copies sold by RPA Course");
		 
		 for(int i=0;i<courseSize;i++)
		 {
			  String courseTitles=js.get("courses["+i+"].title");
			  if(courseTitles.equalsIgnoreCase("RPA"))
			  {
				  int copies=js.get("courses["+i+"].copies");
				  System.out.println(copies);
				  break;
			  }
			
		
	}

	}
	}
