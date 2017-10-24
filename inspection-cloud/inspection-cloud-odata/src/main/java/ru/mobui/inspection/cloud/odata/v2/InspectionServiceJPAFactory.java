package ru.mobui.inspection.cloud.odata.v2;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

import ru.mobui.inspection.cloud.odata.JPAEntityManagerFactory;

/**
 * Created by Chebotarev_SA on 14.03.2017.
 */
public class InspectionServiceJPAFactory extends ODataJPAServiceFactory {

    private static final String MAPPING_MODEL_NAME = "map-tuning.xml";

    @Override
    public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
        ODataJPAContext oDataJPAContext = this.getODataJPAContext();
        try {
            oDataJPAContext.setEntityManagerFactory(JPAEntityManagerFactory.getEntityManagerFactory());
            oDataJPAContext.setPersistenceUnitName(JPAEntityManagerFactory.PERSISTENCE_UNIT_NAME);
            oDataJPAContext.setJPAEdmExtension(new InspectionProcessingExtension());
            oDataJPAContext.setJPAEdmMappingModel(MAPPING_MODEL_NAME);

            setDetailErrors(true);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return oDataJPAContext;
    }
}
