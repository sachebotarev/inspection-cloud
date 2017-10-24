package ru.mobui.inspection.cloud.jpa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;

import ru.mobui.inspection.cloud.jpa.Status;
import ru.mobui.inspection.cloud.jpa.WorkOrder;

public class WorkOrderTest extends AbstractTest {
	private static Logger logger = Logger.getLogger(WorkOrderTest.class.getName());
	
	@Test
	public void createWorkOrder() {
		logger.info("--------------------------------------------");
		String number = "123213212";
		WorkOrder WorkOrder = null;
		EntityManager em = emf.createEntityManager();
		try {
			assertNotNull("EmtityManager must not ve null", em);
			WorkOrder  = createWorkOrder(em, number, null, null);
			assertNotNull("Order not created", WorkOrder);
			assertNotNull("Order uuid is not defined", WorkOrder.getId());
			logger.info("createWorkOrder OrderHeader with id = " + WorkOrder.getId());
			deleteWorkOrder(em, WorkOrder);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			em.close();
		}
	}
	
	@Test
	public void searchWorkOrderById() {
		logger.info("--------------------------------------------");
		String number = "123213212";
		WorkOrder WorkOrder = null;
		WorkOrder WorkOrderAct = null;
		EntityManager em = emf.createEntityManager();
		try {
			assertNotNull("EmtityManager must not ve null", em);
			WorkOrder  = createWorkOrder(em, number, null, null);
			WorkOrderAct = em.find(WorkOrder.class, WorkOrder.getId());
			assertNotNull("Work order not found", WorkOrderAct);
			assertEquals("Id not equi", WorkOrder.getId(), WorkOrderAct .getId());
			logger.info("searchWorkOrderById OrderHeader::id = " + WorkOrderAct.getId());
			logger.info("searchWorkOrderById OrderHeader::Number = " + WorkOrderAct.getWorkOrderNumber());
			logger.info("searchWorkOrderById OrderHeader::Description = " + WorkOrderAct.getDescription());
			deleteWorkOrder(em, WorkOrderAct);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			em.close();
		}
	}
	
	@Test
	public void searchWorkOrderByNumber() {
		logger.info("--------------------------------------------");
		String number = "123213212";
		WorkOrder WorkOrder= null;
		WorkOrder WorkOrderAct = null;
		EntityManager em = emf.createEntityManager();
		try {
			assertNotNull("EmtityManager must not ve null", em);
			WorkOrder  = createWorkOrder(em, number, null, null);
			TypedQuery<WorkOrder> query = em.createNamedQuery("WorkOrder.getByWONumber",
					WorkOrder.class);
			WorkOrderAct  = query.setParameter("workOrderNumber", number).getSingleResult();
		
			assertNotNull("Work order not found", WorkOrderAct );
			assertEquals("Id not equi", WorkOrder.getId(), WorkOrderAct .getId());
			assertEquals("Number not equi", number, WorkOrderAct.getWorkOrderNumber());
			
			logger.info("searchWorkOrderByNumber OrderHeader::id = " + WorkOrderAct.getId());
			logger.info("searchWorkOrderByNumber OrderHeader::Number = " + WorkOrderAct.getWorkOrderNumber());
			logger.info("searchWorkOrderByNumber OrderHeader::Description = " + WorkOrderAct .getDescription());
			deleteWorkOrder(em, WorkOrderAct);
		}catch (Exception e) { 
			throw new RuntimeException(e);
		}finally {
			em.close();
		}	
	}
	
	@Test
	public void searchWorkOrderByDescription() {
		logger.info("--------------------------------------------");
		String descriptionPrefix = "Work Order #";
		String number = "5555555";
		WorkOrder WorkOrder= null;
		WorkOrder WorkOrderAct = null;
		EntityManager em = emf.createEntityManager();
		try {
			assertNotNull("EmtityManager must not ve null", em);
			WorkOrder  = createWorkOrder(em, number,  descriptionPrefix + number, null);
			TypedQuery<WorkOrder> query = em.createNamedQuery("WorkOrder.getByDescription",
					WorkOrder.class);
			WorkOrderAct  = query.setParameter("description", "%" + number + "%").getSingleResult();
		
			assertNotNull("Work order not found", WorkOrderAct );
			assertEquals("Id not equi", WorkOrder.getId(), WorkOrderAct .getId());
			assertEquals("Number not equi", number, WorkOrderAct.getWorkOrderNumber());
			
			logger.info("searchWorkOrderByDescription OrderHeader::id = " + WorkOrderAct.getId());
			logger.info("searchWorkOrderByDescription OrderHeader::Number = " + WorkOrderAct.getWorkOrderNumber());
			logger.info("searchWorkOrderByDescription OrderHeader::Description = " + WorkOrderAct .getDescription());
			deleteWorkOrder(em, WorkOrderAct);
		}catch (Exception e) { 
			throw new RuntimeException(e);
		}finally {
			em.close();
		}	
	}
	
	@Test
	public void searchWorkOrderByStatus() {
		logger.info("--------------------------------------------");
		final Status status = Status.NEW;
		final int count = 3;
		int number = 12312;
		EntityManager em = emf.createEntityManager();
		try {
			assertNotNull("EtityManager must not ve null", em);
			for(int i = 0; i < count; i++) {
				createWorkOrder(em, String.valueOf(number++), null, status);
			}
			TypedQuery<WorkOrder> query = em.createNamedQuery("WorkOrder.getByStatus",
					WorkOrder.class);
			List<WorkOrder> workOrders = query.setParameter("status", status).getResultList();
		
			assertNotNull("Work orders not found", workOrders );
			assertEquals("Not right count Work orders found", workOrders.size(), count);
			logger.info("searchWorkOrderByStatus count = " + workOrders.size());
			for(WorkOrder wo : workOrders) {
				deleteWorkOrder(em, wo);
			}
			
		}catch (Exception e) { 
			throw new RuntimeException(e);
		}finally {
			em.close();
		}	
	}
	
	@Test
	public void removeWorkOrderByNumber() {
		String number = "123213212";
		WorkOrder WorkOrder = null;
		WorkOrder WorkOrderAct = null;
		EntityManager em = emf.createEntityManager();
		try {
			assertNotNull("EmtityManager must not ve null", em);
			WorkOrder  = createWorkOrder(em, number, null, null);
			assertNotNull("Order not created", WorkOrder);
			deleteWorkOrder(em, WorkOrder);
			WorkOrderAct = em.find(WorkOrder.class, WorkOrder.getId());
			assertNull("Work Order not deleted",  WorkOrderAct);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			em.close();
		}	
	}
	
	private WorkOrder createWorkOrder(EntityManager em, String number, String description, Status status) {
		WorkOrder WorkOrder = null;
		em.getTransaction().begin();
		WorkOrder = new WorkOrder();
		WorkOrder.setWorkOrderNumber(number);
		WorkOrder.setDescription(description);
		WorkOrder.setStatus(status);
		WorkOrder.setCreatedAt(new Date());
		UUID userBy = UUID.randomUUID();
		WorkOrder.setCreatedBy(userBy.toString());
		em.persist(WorkOrder);
		em.getTransaction().commit();
		return WorkOrder;
	}
	
	private void deleteWorkOrder(EntityManager em, WorkOrder WorkOrder ) {
		em.getTransaction().begin();
		em.remove(WorkOrder);;
		em.getTransaction().commit();
	}
	
	private void deleteWorkOrder(EntityManager em, String id ) {
		WorkOrder WorkOrder = null;
		em.getTransaction().begin();
		WorkOrder = em.find(WorkOrder.class, id);
		em.remove(WorkOrder);
		em.getTransaction().commit();
	}
	
	
}
