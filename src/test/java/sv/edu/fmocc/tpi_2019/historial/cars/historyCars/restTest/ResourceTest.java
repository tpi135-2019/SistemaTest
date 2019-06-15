/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.fmocc.tpi_2019.historial.cars.historyCars.restTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author kevin Figueroa
 */
//@RunWith(JUnit4.class)
public abstract class ResourceTest<T> {

//    protected abstract String getUrl();

    WebTarget target;
    String URL_BASE = "http://localhost:8080/HistoryCars-1.0-SNAPSHOT/webresources/";
    Client cliente;

    public ResourceTest() {
        cliente = ClientBuilder.newClient();
    }

//    @Test
//    public void findRangeTest() {
//        System.out.println("findRange");
//        target = cliente.target(URL_RESOURCE);
//        System.out.println("" + URL_RESOURCE);
//        Response response = target.request().get();
//        Assert.assertEquals(200, response.getStatus());
//        String registros = response.getHeaderString("x-cantidad-registros");
//        System.out.println("Hay " + registros + " registros");
//        Assert.assertTrue(new Integer(registros) > 0);
//    }
//
//    @Test
//    public void findByIdTest(){
//        System.out.println("finbyId");
//        target = cliente.target(URL_RESOURCE + getId());
//        Response response = target.request().get();
//        Assert.assertEquals(200, response.getStatus());
//       
//    }
//    
//
//    protected abstract String getId();

}
