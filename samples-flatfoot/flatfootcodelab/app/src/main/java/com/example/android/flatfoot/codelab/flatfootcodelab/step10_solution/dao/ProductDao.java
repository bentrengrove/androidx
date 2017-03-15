package com.example.android.flatfoot.codelab.flatfootcodelab.step10_solution.dao;

import com.android.support.lifecycle.LiveData;
import com.android.support.room.Dao;
import com.android.support.room.Insert;
import com.android.support.room.OnConflictStrategy;
import com.android.support.room.Query;

import com.example.android.flatfoot.codelab.flatfootcodelab.step10.Product;
import com.example.android.flatfoot.codelab.flatfootcodelab.step10_solution.entity.MyProduct;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    LiveData<List<MyProduct>> loadAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MyProduct> products);

    @Query("select * from products where id = ?")
    LiveData<MyProduct> loadProduct(int productId);
}
