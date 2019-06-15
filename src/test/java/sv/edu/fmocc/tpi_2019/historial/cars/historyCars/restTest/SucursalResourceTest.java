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
public class SucursalResourceTest extends ResourceTest {

    String urlResource = URL_BASE + "sucursal";

    @Test
    public void findRangeTest() {
        System.out.println("findRange");
        int first = 1;
        int pagesize = 3;
        target = cliente.target(urlResource).queryParam("first", first).queryParam("pagesize", pagesize);
        Response response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
        String registros = response.getHeaderString("x-cantidad-registros");
        Assert.assertTrue(new Integer(registros) > 0);
    }

    @Test
    public void personalPorSucursalTest() {
        System.out.println("personalPorSucursal");
        String id = "1";
        String nombre = "";
        target = cliente.target(urlResource).path(id + "/personal").queryParam("nombre", nombre);
        Response response = null;
        verifyOkStatusContent(response);

    }

    @Test
    public void procesosPorSucursalTest() {
        System.out.println("procesosPorSucursal");
        String id = "1";
        target = cliente.target(urlResource).path(id + "/proceso");
        Response response = null;
        verifyOkStatusContent(response);

    }

    public void verifyOkStatusContent(Response response) {
        response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }

}
