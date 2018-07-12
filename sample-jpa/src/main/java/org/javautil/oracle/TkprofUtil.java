package org.javautil.oracle;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TkprofUtil {

	public static String analyzeTrace(String fileName) throws IOException {
		return analyzeTrace(new File(fileName));
	}
	
	public static String analyzeTrace(File traceFile) throws IOException {
		String result = null;
		String outfile = "/tmp/trace.prf";
		String tkProf = "/common/oracle/product/12.2.0/dbhome_1/bin/tkprof";
		ProcessBuilder pb = new ProcessBuilder(tkProf, traceFile.getCanonicalPath(), "/tmp/trace.prf");
		 Process p = pb.start();
		  Charset charset = Charset.forName("ISO-8859-1");
		  Path traceFilePath = Paths.get(outfile);
		    try {
		      List<String> lines = Files.readAllLines(traceFilePath, charset);

		      for (String line : lines) {
		        System.out.println(line);
		      }
		    } catch (IOException e) {
		      System.out.println(e);
		    }
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		analyzeTrace(new File("/common/oracle/diag/rdbms/dev12c/dev12c/trace/dev12c_ora_5125_OracleHelperTest.trc"));
	}
}
