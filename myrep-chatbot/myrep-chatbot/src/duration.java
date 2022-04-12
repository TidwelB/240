package src;


//Create an instance of this class where you want to begin the time stamp
//call      duration Timer = new duration();
//call      Timer.startTime();          when you want the session timer to begin
//call      Timer.endTime();            when you want the session timer to end. This will return how many seconds the session lasted




import java.sql.Timestamp;

public class duration {
    Timestamp startTime;

    void startTime() {
        java.util.Date start = new java.util.Date();
        startTime = new Timestamp(start.getTime());
    }

int endTime () {


    java.util.Date end = new java.util.Date();
    Timestamp endTime = new Timestamp(end.getTime());

    long milliseconds = endTime.getTime() - startTime.getTime();
		int seconds = (int) milliseconds / 1000;

//##Can be used if you wanted to find hours of session 
//  int hours = seconds / 3600;
//##Can be used if you wanted to find minutes of session
	//	int minutes = (seconds % 3600) / 60;

    return seconds;
      
}
}
