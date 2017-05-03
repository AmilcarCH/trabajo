package com.example.alumnos.carrito;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alumnos.carrito.bean.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.R.attr.name;

public class Register extends AppCompatActivity {

    EditText txtdesprod;
    EditText txtcantidad;
    EditText txtprecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtdesprod = (EditText) findViewById(R.id.txtdesProd);
        txtcantidad = (EditText) findViewById(R.id.txtcantidad);
        txtprecio = (EditText) findViewById(R.id.txtprecio);
        Button btnGuardar = (Button)findViewById(R.id.btnguardar);

        // para obtener valores enviados de la otra actividad
        Bundle parameters = getIntent().getExtras();
        final int productId = (int) parameters.getInt("productId");

        if(productId!=0){
            Product person = getProductById(productId);
            txtdesprod.setText(person.getDesProduct());
            txtcantidad.setText(person.getCantidad());
            txtprecio.setText(person.getCantidad());
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(productId==0){
                    Random rn = new Random();
                    int answer = rn.nextInt(1000) + 1;
                    //MainActivity.listPerson.add(new Person(answer,txtNombre.getText().toString(),txtLastNameF.getText().toString(),txtLastNameM.getText().toString(),"www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca","2"));
                }else{
                    updateProduct(productId,txtdesprod.getText().toString(),txtcantidad.getText().toString(), txtprecio.getText().toString());
                }
                goMain();
            }
        });
    }

    public void updateProduct(int productId, String desProduct, String cantidad, String precio) {
        List<Product> listProduct2=new ArrayList<Product>();
        for (Product product:MainActivity.listProduct){
            if(product.getCodProduct()==productId){
                product.setDesProduct(desProduct);
                //product.setCantidad(cantidad);
                //product.setPrecio(precio);
            }
            listProduct2.add(product);
        }
    }

    public Product getProductById(int productId){
        List<Product> listProduct = MainActivity.listProduct ;

        for (Product product:listProduct){
            if(product.getCodProduct()==productId){
                return product;
            }
        }
        return null;
    }

    public void goMain(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
