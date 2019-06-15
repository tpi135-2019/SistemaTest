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
public class ProcesoResourceTest extends ResourceTest {

    String urlResource = URL_BASE + "proceso";

    @Test
    public void findRangeTest() {
        System.out.println(" findRange");
        int first = 1;
        int pagesize = 3;
        target = cliente.target(urlResource).queryParam("first", first).queryParam("pagesize", pagesize);
        Response response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
        String registros = response.getHeaderString("x-cantidad-registros");
        System.out.println("Hay " + registros + " registros");
        Assert.assertTrue(new Integer(registros) > 0);
    }

    @Test
    public void pasosPorProcesoTest() {
        System.out.println("pasosPorProceso");
        String id = "1";
        String paso = "";
        target = cliente.target(urlResource).path(id + "/paso").queryParam("paso", paso);
        verifyOkStatusContent();

    }

    @Test
    public void personalPorProcesoTest() {
        System.out.println("personalPorProceso");
        String id = "1";
        target = cliente.target(urlResource).path(id + "/personal");
        verifyOkStatusContent();

    }

    @Test
    public void sucursalPorProcesoTest() {
        System.out.println("sucursalPorProceso");
        String id = "1";
        target = cliente.target(urlResource).path(id + "/sucursal");
        verifyOkStatusContent();
    }

    public void verifyOkStatusContent() {
        Response response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }

}
