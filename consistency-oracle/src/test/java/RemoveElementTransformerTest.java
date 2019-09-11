
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.approvaltests.Approvals;
import org.approvaltests.writers.ApprovalTextWriter;
import org.junit.Assert;
import org.junit.Test;

public class RemoveElementTransformerTest {
	@Test
	public void extended_xml_should_be_removed_correctly() throws Exception {
		// Prepare state
		final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" //
				+ "<root>\n" //
				+ "\t<parent>\n" //
				+ "\t\t<remove>should be removed</remove>\n" //
				+ "\t\t<keep>should not be removed</keep>\n" //
				+ "\t</parent>\n" //
				+ "</root>";
		final RemoveElementTransformer transformer = new RemoveElementTransformer( "parent", "remove" );

		// Execute feature under test
		final InputStream transform = transformer.transform( new ByteArrayInputStream( xml.getBytes() ) );

		// Assert result
		final String result = IOUtils.toString( transform, "UTF-8" );
		Assert.assertFalse( result.contains( "<remove>" ) );
		Assert.assertTrue( result.contains( "<keep>" ) );
	}

	@Test
	public void extended_xml_should_be_removed_correctly_Using_Approvals() throws Exception {
		// Prepare state
		final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" //
				+ "<root>\n" //
				+ "\t<parent>\n" //
				+ "\t\t<remove>should be removed</remove>\n" //
				+ "\t\t<keep>should not be removed</keep>\n" //
				+ "\t</parent>\n" //
				+ "</root>";
		final RemoveElementTransformer transformer = new RemoveElementTransformer( "parent", "remove" );

		// Execute feature under test
		final InputStream transform = transformer.transform( new ByteArrayInputStream( xml.getBytes() ) );

		// Assert result
		Approvals.verify( new ApprovalTextWriter( IOUtils.toString( transform, "UTF-8" ), "xml" ));
	}
}