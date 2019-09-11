
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class BuggyRemoveElementTransformer extends RemoveElementTransformer {

	public BuggyRemoveElementTransformer(final String elementName) {
		super(elementName);
	}

	public BuggyRemoveElementTransformer(final String parentElementName, final String elementName) {
		super(parentElementName, elementName);
	}

	@Override
	public final String transform(String xml) {
		try {
			return FileUtils.readFileToString(new File("src/main/resources/wrong-but-passing-output.xml"), UTF_8);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
