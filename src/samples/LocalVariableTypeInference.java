package samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LocalVariableTypeInference {

    public static void main(String[] args) throws IOException {
        List<Set<Integer>> listOfGenerics = List.of(Set.of(1, 2), Set.of(2, 3), Set.of());
        try (var bw = Files.newBufferedWriter(Path.of("test.txt"))) {
            for (var set : listOfGenerics) {
                bw.write(set.toString());
            }
        }
    }
}
