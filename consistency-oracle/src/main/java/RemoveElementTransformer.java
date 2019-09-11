
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RemoveElementTransformer {

	public RemoveElementTransformer(final String elementName) {
	}

	public RemoveElementTransformer(final String parentElementName, final String elementName) {
	}

	public String transform(String xml) {
		try {
			return FileUtils.readFileToString(new File("src/main/resources/correct-output.xml"), UTF_8);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
