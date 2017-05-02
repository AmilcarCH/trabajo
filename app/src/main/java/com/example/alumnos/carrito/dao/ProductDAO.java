package com.example.alumnos.carrito.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alumnos.carrito.bean.Product;
import com.example.alumnos.carrito.util.Commons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumnos on 02/05/2017.
 */

public class ProductDAO extends SQLiteOpenHelper{


    private static final int VERSION = 1;

    public ProductDAO(Context context) {
        super(context, Commons.DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE Person (" +
                " codProduct INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " desProduct TEXT," +
                " cantidad REAL," +
                " precio REAL," +
                " total REAL," +
                ");";

        db.execSQL(ddl);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String ddl = "DROP TABLE IF EXISTS Product";
        db.execSQL(ddl);
        this.onCreate(db);
    }

    public void saveProduct(Product product){

        ContentValues values =new ContentValues();
        values.put("codProduct", product.getCodPrduct());
        values.put("desProduct", product.getDesProduct());
        values.put("cantidad", product.getCantidad());
        values.put("precio", product.getPrecio());
        values.put("total", product.getTotal());

        getWritableDatabase().insert("Product",null,values);

    }
    public Product findPersonById(String id) {
        String column[] = {"id", "name", "lastNameF", "lastNameM", "site", "address", "sex", "status", "statusMarried", "score", "photo"};
        String where = "id = " + id;

        Product product = null;
        Cursor cursor = getReadableDatabase().query("Person", column, where, null, null, null, null);
        if (cursor.moveToFirst()) {
            product = new Product();
            product.setCodPrduct(cursor.getLong(0));
            product.setDesProduct(cursor.getString(1));
            product.setCantidad(cursor.getInt(2));
            product.setPrecio(cursor.getDouble(3));
            product.setTotal(cursor.getDouble(4));
        }
        cursor.close();
        return product;
    }



    public List<Product> findProductAll(){
        List<Product> listProduct=new ArrayList<Product>();
        String columns[]={"codProduct","desProduct","cantidad","precio","total"};
        String where = null;
        Cursor cursor = getReadableDatabase().query("",columns,where,null,null,null,null);

        Product product = null;
        while (cursor.moveToNext()){
            product =new Product();
            product.setCodPrduct(cursor.getLong(0));
            product.setDesProduct(cursor.getString(1));
            product.setCantidad(cursor.getInt(2));
            product.setPrecio(cursor.getDouble(3));
            product.setTotal(cursor.getDouble(4));
            listProduct.add(product);
        }
        return null;
    }

}