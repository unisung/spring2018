package polymorphism07;

import java.io.File;
import java.io.FileWriter;

public class FileOutput implements Output {
  private String fileName;

public void setFileName(String fileName) {
	   this.fileName = fileName;
}


	@Override
	public void output(String msg) {
	  	try {
	  		 FileWriter fw = new FileWriter(new File(fileName));
	  		 fw.write(msg);
	  		 fw.close();
	  	}catch(Exception e) {
	  		e.printStackTrace();
	  	}
	}
}
