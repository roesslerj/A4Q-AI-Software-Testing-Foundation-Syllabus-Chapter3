
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.approvaltests.Approvals;
import org.approvaltests.writers.ApprovalTextWriter;
import org.junit.Assert;
import org.junit.Test;

public class RemoveElementTransformerTest {

	final RemoveElementTransformer transformer = new RemoveElementTransformer("parent", "remove");

	@Test
	public void extended_xml_should_be_removed_correctly() throws Exception {
		// Prepare state
		final String xml = FileUtils.readFileToString(new File("src/test/resources/minimal-input.xml"), UTF_8);

		// Execute feature under test
		final String result = transformer.transform(xml);

		// Assert result
		Assert.assertFalse(result.contains("<remove>"));
		Assert.assertTrue(result.contains("<keep>"));
	}

	@Test
	public void extended_xml_should_be_removed_correctly_Using_Approvals() throws Exception {
		// Prepare state
		final String xml = FileUtils.readFileToString(new File("src/test/resources/minimal-input.xml"), UTF_8);

		// Execute feature under test
		final String result = transformer.transform(xml);

		// Assert result
		Approvals.verify(new ApprovalTextWriter(result, "xml"));
	}
}