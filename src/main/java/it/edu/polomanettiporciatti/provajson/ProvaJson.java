package it.edu.polomanettiporciatti.provajson;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProvaJson {
	
	private static final String CONFIG_FILE = "config.json";
	private static final String LOG_FILE = "log.json";

	private ProvaJson(){
	}

	/**
	 * 
	 * @param args Command line arguments
	 * @author Matteo Ceserani
	 * @version 1.0
	 */
    public static void main(String[] args){
       
		ObjectMapper mapper = new ObjectMapper();

		File conf = new File(CONFIG_FILE);

		String entry = null;

		File log = new File(LOG_FILE);
		FileWriter out = null;

		if (!log.exists()) {
			try{
				out = new FileWriter(log, true); 
				out.append("{\"log\": [" + System.lineSeparator());
				entry = mapper.writeValueAsString(new LogEntry(new Date(), "Log file created"));
				out.append(entry + System.lineSeparator());
				out.append("]}");
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			Configuration config = mapper.readValue(conf, Configuration.class);
			System.out.println(config);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			out = new FileWriter(log, true); 
			entry = mapper.writeValueAsString(new LogEntry(new Date(), "Log entry created"));
			out.append(entry + System.lineSeparator());
			out.append("]}");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}