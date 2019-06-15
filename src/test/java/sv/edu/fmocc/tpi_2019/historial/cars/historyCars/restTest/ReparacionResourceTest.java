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
public class ReparacionResourceTest extends ResourceTest {

    String urlResource = URL_BASE + "reparacion";

    @Test
    public void findByIdTest() {
        System.out.println("finbyId");
        String id = "5"; //debe de existir esta reparacion
        Response response = null;
        target = cliente.target(urlResource).path(id);
        verifyOkStatusContent(response);
        id = "-1";
        target = cliente.target(urlResource).path(id);
        response = target.request().get();
        Assert.assertEquals(404, response.getStatus());
    }

    @Test
    public void piezasPorReparacionTest() {
        System.out.println("piezasPorReparacion");
        String id = "5";
        target = cliente.target(urlResource).path(id + "/pieza");
        Response response = null;
        verifyOkStatusContent(response);

    }

    @Test
    public void personalPorReparacionTest() {
        System.out.println("personalPorReparacion");
        String id = "5";
        target = cliente.target(urlResource).path(id + "/personal");
        Response response = null;
        verifyOkStatusContent(response);
    }

    @Test
    public void lugarReparacionTest() {
        System.out.println("lugarReparacion");
        String id = "5";
        target = cliente.target(urlResource).path(id + "/sucursal");
        Response response = null;
        verifyOkStatusContent(response);
    }

    public void verifyOkStatusContent(Response response) {
        response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }
}
