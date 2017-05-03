package com.example.alumnos.carrito;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.alumnos.carrito.bean.Product;
import com.example.alumnos.carrito.dao.ProductDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.alumnos.carrito", appContext.getPackageName());

        ProductDAO dao = new ProductDAO(appContext);
        Product product = new Product();
        product.setDesProduct("reloj");
        product.setCantidad(1);
        product.setPrecio(20.5);
        dao.saveProduct(product);

        List<Product> list = dao.findProductAll();

        Log.i("list:::",list.size()+"");

        dao.close();
    }
}
