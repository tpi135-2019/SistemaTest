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
public class DiagnosticoResourceTest extends ResourceTest {

    String urlResource = URL_BASE + "diagnostico";

    /*
    LISTA DE STATUS MAS FRECUENTES
    
    400	Bad Request
    200 OK
    404 NOT FOUND
    500	Internal Server Error
    
     */
    @Test
    public void reparacionPorDiagnosticoTest() {
        System.out.println("reparacionPorDiagnostico");
        String id = "5";
        target = cliente.target(urlResource).path(id + "/reparacion");
        Response response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
        id = "-1";
        target = cliente.target(urlResource).path(id + "/reparacion");
        response = target.request().get();
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void buscarDiagnosticoLikeTest(){
        System.out.println("buscarDiagnosticoLike");
        String id="5";
        target = cliente.target(urlResource).queryParam("id", id);
        Response response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
        
    }
}
