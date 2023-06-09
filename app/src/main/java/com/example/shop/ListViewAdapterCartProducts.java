package com.example.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

public class ListViewAdapterCartProducts extends ArrayAdapter<Product> {
    private final RequestQueue requestQueue;
    private int listLayout;
    private ArrayList<Product> usersList;
    private Context context;
    private Button btn;

    private Cart cart;
    private int shop_id;

    CartWindow cartWindow;

    public ListViewAdapterCartProducts(Context context, int listLayout,
                                       int field, ArrayList<Product> usersList, Cart cart, int shop_id, RequestQueue requestQueue, CartWindow cartWindow) {
        super(context, listLayout, field, usersList);
        this.context = context;
        this.listLayout=listLayout;
        this.usersList = usersList;
        this.cart = cart;
        this.shop_id = shop_id;
        this.requestQueue = requestQueue;
        this.cartWindow = cartWindow;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView name = listViewItem.findViewById(R.id.textName);
        TextView category = listViewItem.findViewById(R.id.textCategory);
        TextView price = listViewItem.findViewById(R.id.textPrice);
        name.setText(usersList.get(position).getName());
        category.setText(usersList.get(position).getCategory());
        price.setText(usersList.get(position).getPrice() + "");
        btn = listViewItem.findViewById(R.id.buttonProductCart);
        btn.setOnClickListener(new OnClickCartDelete(usersList.get(position),shop_id,requestQueue,cartWindow,cart));
        return listViewItem;
    }
}
