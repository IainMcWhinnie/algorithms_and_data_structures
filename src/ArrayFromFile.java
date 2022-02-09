import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ArrayFromFile {
	public static int[] getFromPath(Path path) {
		List<String> lines = new ArrayList<String>();
		
		try {
			lines = Files.readAllLines(path);
		}catch (IOException e) {}
		int[] A = new int[lines.size()];
		for (int i=0; i<lines.size(); i++) {
			A[i] = Integer.parseInt(lines.get(i));
		}
		
		return A;
	}
}
