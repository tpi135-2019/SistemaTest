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
public class VehiculoResourceTest extends ResourceTest {

    String urlResource = URL_BASE + "vehiculo";

    @Test
    public void diagnosticoPorPlacaTest() {
        System.out.println("diagnosticoPorPlaca");
        String placa = "p323-21";
        target = cliente.target(urlResource).path(placa + "/diagnosticos");
        Response response = null;
        verifyOkStatusContent(response);
    }

    @Test
    public void findPlacaLikeTest(){
        System.out.println("findPlacaLike");
        String placa = "p323";
        target = cliente.target(urlResource).queryParam("placa", placa);
        Response response = null;
        verifyOkStatusContent(response);
    }
    
    @Test
    public void reparcionPorVehiculoTest(){
        System.out.println("reparcionPorVehiculo");
        String placa = "p323-21";
        target = cliente.target(urlResource).path(placa+"/paso");
        Response response = null;
        verifyOkStatusContent(response);
    }
    
    public void verifyOkStatusContent(Response response) {
        response = target.request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertNotNull(response.getEntity());
    }

}
