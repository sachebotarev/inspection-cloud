package ru.mobui.inspection.cloud.odata.v4;

import java.io.IOException;

import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;

import com.sap.olingo.jpa.metadata.api.JPAEdmProvider;

import ru.mobui.inspection.cloud.odata.JPAEntityManagerFactory;

/**
 * Servlet implementation class ODataServlet
 */
public class ODataV4Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			EntityManagerFactory emf = JPAEntityManagerFactory.getEntityManagerFactory();
			JPAEdmProvider metadataProvider = new JPAEdmProvider(JPAEntityManagerFactory.PERSISTENCE_UNIT_NAME, emf,
					null, null);

			OData odata = OData.newInstance();
			ServiceMetadata edm = odata.createServiceMetadata(metadataProvider, new ArrayList<EdmxReference>());
			ODataHttpHandler handler = odata.createHandler(edm);

			handler.process(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
