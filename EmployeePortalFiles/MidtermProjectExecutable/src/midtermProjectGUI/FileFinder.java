package midtermProjectGUI;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import testFolder.test3.Finder;

public class FileFinder {
	public static ArrayList<String> pathing = new ArrayList<>();
	
    public static class Finder extends SimpleFileVisitor<Path> {
	    private final PathMatcher matcher;
	    private int numMatches = 0;

	    Finder(String pattern) {
	    	matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
	    }
	
	    // Compares the glob pattern against
	    // the file or directory name.
	    void find(Path file) {
	        Path name = file.getFileName();
	        String stringFile = file.toFile().toString();
	        if (name != null && matcher.matches(name)) {
	            if(!stringFile.contains("OneDrive")
	            	&& !(file.getNameCount() > 3)) {
	            	numMatches++;
	            	pathing.add(file.toString());
	                System.out.println(file);
	                pathing.add(stringFile);
	            }
	        }
	    }
	
	    // Prints the total number of
	    // matches to standard out.
	    void done() {
	        System.out.println("Matched: " + numMatches);
	    }
	
	    // Invoke the pattern matching
	    // method on each file.
	    @Override
	    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
	        find(file);
	        return CONTINUE;
	    }
	
	    // Invoke the pattern matching
	    // method on each directory.
	    @Override
	    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
	    	find(dir);
	        return CONTINUE;
	    }
	
	    @Override
	    public FileVisitResult visitFileFailed(Path file, IOException exc) {
	        return CONTINUE;
	    }
	    public static void usage() {
		    System.err.println("java Find <path>" + " -name \"<glob_pattern>\"");
		    System.exit(-1);
		}
		
		public String Pathing() throws IOException {
			String system = System.getProperty("user.home");
	    	
	    	String[] args = new String[] {system, "-name", "Documents"};
	    	
	        if (args.length < 3 || !args[1].equals("-name"))
	            usage();
	 
	        Path startingDir = Paths.get(args[0]);
	        String pattern = args[2];
	 
	        Finder finder = new Finder(pattern);
	        Files.walkFileTree(startingDir, finder);
	        finder.done();
			return pathing.get(pathing.size()-1);
		}
	}
}
