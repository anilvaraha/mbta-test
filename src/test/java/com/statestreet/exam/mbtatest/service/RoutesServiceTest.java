/**
 * 
 */
package com.statestreet.exam.mbtatest.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.statestreet.exam.mbtatest.exception.RestCustomException;

/**
 * @author varah
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RoutesServiceTest {

	
	@Mock
	RestTemplate rt;

	@InjectMocks
	RoutesService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(service, "apiUrl", "https://api-v3.mbta.com/");
		ResponseEntity<String> resp = new ResponseEntity<String>(
				"{\"data\":[{\"attributes\":{\"color\":\"80276C\",\"description\":\"Commuter Rail\",\"direction_destinations\":[\"Fairmount\",\"South Station\"],\"direction_names\":[\"Outbound\",\"Inbound\"],\"fare_class\":\"Commuter Rail\",\"long_name\":\"Fairmount Line\",\"short_name\":\"\",\"sort_order\":20001,\"text_color\":\"FFFFFF\",\"type\":2},\"id\":\"CR-Fairmount\",\"links\":{\"self\":\"/routes/CR-Fairmount\"},\"relationships\":{\"line\":{\"data\":{\"id\":\"line-Fairmount\",\"type\":\"line\"}}},\"type\":\"route\"}]}",
			HttpStatus.OK);
		ResponseEntity<String> stopResp = new ResponseEntity<String>(
				"{\"data\":[{\"attributes\":{\"address\":\"1800 Hyde Park Ave, Hyde Park, MA 02136\",\"at_street\":null,\"description\":null,\"latitude\":42.238405,\"location_type\":1,\"longitude\":-71.133246,\"municipality\":\"Boston\",\"name\":\"Readville\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-0095\",\"links\":{\"self\":\"/stops/place-DB-0095\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-0095\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-2\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"Fairmount Ave and Truman Hwy, Hyde Park, MA 02136\",\"at_street\":null,\"description\":null,\"latitude\":42.253638,\"location_type\":1,\"longitude\":-71.11927,\"municipality\":\"Boston\",\"name\":\"Fairmount\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-2205\",\"links\":{\"self\":\"/stops/place-DB-2205\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-2205\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"Blue Hill Ave or Cummins Hwy at Woodhaven St, Mattapan, MA 02126\",\"at_street\":null,\"description\":null,\"latitude\":42.271466,\"location_type\":1,\"longitude\":-71.095782,\"municipality\":\"Boston\",\"name\":\"Blue Hill Avenue\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-2222\",\"links\":{\"self\":\"/stops/place-DB-2222\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-2222\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"865 Morton St, Mattapan, MA 02126\",\"at_street\":null,\"description\":null,\"latitude\":42.280994,\"location_type\":1,\"longitude\":-71.085475,\"municipality\":\"Boston\",\"name\":\"Morton Street\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-2230\",\"links\":{\"self\":\"/stops/place-DB-2230\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-2230\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"210 Talbot Ave, Boston, MA 02124\",\"at_street\":null,\"description\":null,\"latitude\":42.292246,\"location_type\":1,\"longitude\":-71.07814,\"municipality\":\"Boston\",\"name\":\"Talbot Avenue\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-2240\",\"links\":{\"self\":\"/stops/place-DB-2240\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-2240\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"171 Geneva Ave, Boston, MA 02121\",\"at_street\":null,\"description\":null,\"latitude\":42.305037,\"location_type\":1,\"longitude\":-71.076833,\"municipality\":\"Boston\",\"name\":\"Four Corners/Geneva\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-2249\",\"links\":{\"self\":\"/stops/place-DB-2249\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-2249\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"691 Dudley St, Dorchester, MA 02125\",\"at_street\":null,\"description\":null,\"latitude\":42.319125,\"location_type\":1,\"longitude\":-71.068627,\"municipality\":\"Boston\",\"name\":\"Uphams Corner\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-2258\",\"links\":{\"self\":\"/stops/place-DB-2258\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-2258\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"1070 Massachusetts Ave, Boston, MA 02118\",\"at_street\":null,\"description\":null,\"latitude\":42.327415,\"location_type\":1,\"longitude\":-71.065674,\"municipality\":\"Boston\",\"name\":\"Newmarket\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-DB-2265\",\"links\":{\"self\":\"/stops/place-DB-2265\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-DB-2265\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"},{\"attributes\":{\"address\":\"700 Atlantic Ave, Boston, MA 02110\",\"at_street\":null,\"description\":null,\"latitude\":42.352271,\"location_type\":1,\"longitude\":-71.055242,\"municipality\":\"Boston\",\"name\":\"South Station\",\"on_street\":null,\"platform_code\":null,\"platform_name\":null,\"vehicle_type\":null,\"wheelchair_boarding\":1},\"id\":\"place-sstat\",\"links\":{\"self\":\"/stops/place-sstat\"},\"relationships\":{\"facilities\":{\"links\":{\"related\":\"/facilities/?filter[stop]=place-sstat\"}},\"parent_station\":{\"data\":null},\"zone\":{\"data\":{\"id\":\"CR-zone-1A\",\"type\":\"zone\"}}},\"type\":\"stop\"}],\"jsonapi\":{\"version\":\"1.0\"}}",
			HttpStatus.OK);
		
		
		Mockito.when(rt.getForEntity("https://api-v3.mbta.com/routes?filter[type]=2", String.class)).thenReturn(resp);
		Mockito.when(rt.getForEntity("https://api-v3.mbta.com/stops?filter[route]=CR-Fairmount", String.class)).thenReturn(stopResp);
		
		
	}

	/**
	 * Test method for
	 * {@link com.statestreet.exam.mbtatest.service.RoutesService#getLongNameOfRoutes()}.
	 * 
	 * @throws RestCustomException
	 */
	@Test
	public void testGetLongNameOfRoutes() throws RestCustomException {
		Assert.assertTrue(service.getLongNameOfRoutes().size()>0);
		
		Assert.assertTrue(service.getStopsForARoute("Fairmount Line").size()>0);
		
		Assert.assertTrue(null==service.getStopsForARoute("CR-Fnt"));
		
		Assert.assertTrue(service.getRouteName("Readville", "Fairmount").equals("Fairmount Line"));
		Assert.assertTrue(null==service.getRouteName("Readville", "Fairt"));
		Assert.assertTrue(null==service.getRouteName(null, null));
		Assert.assertTrue(null==service.getRouteName("Readvi", "Fairmount"));
	}

	@Test(expected = RestCustomException.class)
	public void testGetLongNameOfRoutesForException() throws RestCustomException {
		Mockito.when(rt.getForEntity("https://api-v3.mbta.com/routes?filter[type]=2", String.class)).thenThrow(new RestClientException(" Throw exception"));
		service.getLongNameOfRoutes();
	}
	
	@Test(expected = RestCustomException.class)
	public void testGetLongNameOfRoutesDifferentStatusCode() throws RestCustomException {
		ResponseEntity<String> resp = new ResponseEntity<String>(
				"{ \"errors\": [ { \"status\": \"429\", \"detail\": \"You have exceeded your allowed usage rate.\", \"code\": \"rate_limited\" } ] }",HttpStatus.TOO_MANY_REQUESTS);		
		Mockito.when(rt.getForEntity("https://api-v3.mbta.com/routes?filter[type]=2", String.class)).thenReturn(resp);
		service.getLongNameOfRoutes();
	}
	
	/**
	 * Test method for
	 * {@link com.statestreet.exam.mbtatest.service.RoutesService#getStopsForARoute(java.lang.String)}.
	 * @throws RestCustomException 
	 */
	@Test
	public void testGetStopsForARoute() throws RestCustomException {
		Assert.assertTrue(service.getStopsForARoute("Fairmount Line").size()>0);
	}

	/**
	 * Test method for
	 * {@link com.statestreet.exam.mbtatest.service.RoutesService#getRouteName(java.lang.String, java.lang.String)}.
	 * @throws RestCustomException 
	 */
	@Test
	public void testGetRouteName() throws RestCustomException {
		Assert.assertTrue(service.getRouteName("Readville", "Fairmount").equals("Fairmount Line"));
	}

}
