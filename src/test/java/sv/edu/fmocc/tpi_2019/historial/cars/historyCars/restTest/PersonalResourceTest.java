/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.fmocc.tpi_2019.historial.cars.historyCars.restTest;

import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author kevin
 */
@RunWith(JUnit4.class)
public class PersonalResourceTest extends ResourceTest {

    String urlResource = URL_BASE + "personal";

    @Test
    public void findByIdTest() {
        System.out.println("findById");
        String id = "1";
        target = cliente.target(urlResource).path(id);
        Response response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
        id="50000";
        target = cliente.target(urlResource).path(id);
        response = target.request().get();
        Assert.assertEquals(404, response.getStatus());

    }
}
