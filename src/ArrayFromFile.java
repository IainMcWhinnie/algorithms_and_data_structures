import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ArrayFromFile {
	public static int[] getFromPath(Path path) {
		int[] A = null;
		try {
			for (String line : Files.readAllLines(path)) {
				System.out.println(line);
			}
		}catch (IOException e) {}
		return A;
	}
}
