package com.example.productorderingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class ProductOrderingActivity extends AppCompatActivity {

    ArrayList<String> productList;
    ArrayList<String> productList2;
    String currProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_ordering);

        if(savedInstanceState != null){
            productList = new ArrayList<>(savedInstanceState.getStringArrayList("productList"));
            productList2 = new ArrayList<>(savedInstanceState.getStringArrayList("productList2"));
            currProduct = new String(savedInstanceState.getString("currProduct"));
            TextView textView = (TextView) findViewById(R.id.text_cart);
            textView.setText("Cart Contents: \n");
            for(String v: productList){
                currProduct = v;
                textView.append(currProduct);
                currProduct = "";
            }
        }
        else{
            productList = new ArrayList<String>();
            productList2 = new ArrayList<String>();
            currProduct = new String();
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        ArrayList<String> temp = new ArrayList<String>(productList);
        ArrayList<String> temp2 = new ArrayList<String>(productList2);
        String tempString = new String(currProduct);
        savedInstanceState.putStringArrayList("productList", temp);
        savedInstanceState.putStringArrayList("productList2", temp2);
        savedInstanceState.putString("currProduct", tempString);
    }

    public void onCheckboxClicked(View view){
        CheckBox checkbox = ((CheckBox)view);
        boolean checked = checkbox.isChecked();
        String item = checkbox.getText().toString();

        if(checked){
            productList.add(item);
            currProduct = (currProduct + " " + item);
            //productList2.add(item);
        }
        else{
            //productList.remove(item);
        }
        for(String v:productList){
            productList2.add(v);
        }
        //currProduct = (currProduct + "\n");

    }
    public void onClickAddToCart1(View view){

        TextView textView = (TextView) findViewById(R.id.text_cart);
        textView.setText("Current Cart: \n");
        currProduct = (currProduct + "\n");
        textView.append(currProduct);
        textView.append("\n" + productList);
        //System.out.println("Product List: \n" + productList );
        //currProduct = "";
        //int i = 0;
        //for(String v:productList2){
            //i++;
            //textView.append("\n");
            //textView.append(v);

            //if(i == (productList2.size())){
                //textView.append("\n");
            //}
            //else{
                //textView.append(", ");
            //}
            //}
        }
        //textView.append("\n");
        //productList.clear();
        //productList2.clear();




}