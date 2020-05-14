package com.example.paithanigui.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.paithanigui.R;
import com.example.paithanigui.models.Product;


import java.util.List;



public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.VerticalViewHolder> {

    private List<Product> regular;
    private Context context;


    public static class VerticalViewHolder extends RecyclerView.ViewHolder{

        ImageView imgBanner;
        TextView txtTitle,txtMrp,txtpricew;
        Button buttond;

        Button botton2;
        TableLayout tableLayout;
        TextView disp;
        //  static int numtest = 1;
        LinearLayout linearLayout;
        public VerticalViewHolder(View v) {
            super(v);
            imgBanner = v.findViewById(R.id.imag);
            txtTitle = v.findViewById(R.id.textTitle);
            txtMrp=v.findViewById(R.id.txtmrp);
            txtpricew=v.findViewById(R.id.txtprice);
            buttond=v.findViewById(R.id.buttoncart);
            botton2=v.findViewById(R.id.btoomwish);
            // linearLayout = itemView.findViewById(R.id.vertical_parent_layout);

            txtMrp.setPaintFlags(txtMrp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            /*verticalLayout = itemView.findViewById(R.id.vertical_parent_layout);
            regularTitle = itemView.findViewById(R.id.regular_food_title);
            regularImage = itemView.findViewById(R.id.regular_food_pc);
            regularPrice = itemView.findViewById(R.id.regular_food_price);
            regularPlus = itemView.findViewById(R.id.regular_food_plus);*/

        }
    }

    public ProductAdapter(List<Product> regular, int data_content, Context context){
        this.context = context;
        this.regular = regular;
    }

    @NonNull
    @Override
    public ProductAdapter.VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_content, parent, false);
        return new ProductAdapter.VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.VerticalViewHolder holder, final int position) {
        holder.txtTitle.setText(regular.get(position).getProductName());
        holder.txtpricew.setText("Rs"+(regular.get(position).getDiscountedPrice()));
        holder.txtMrp.setText((((regular.get(position).getOriginalPrice()))) );
        //  Picasso.get().load(regularFoods.get(position).getFilepath()).fit().into(holder.imgBanner);
        Glide.with(context)
                .load((regular.get(position).getProductPath()))
                .fitCenter()
                .into(holder.imgBanner);
        holder.buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Id Of item is"+regular.get(position).getProductId(), Toast.LENGTH_SHORT).show();
            }
        });


    }

/*    @Override
    public int getItemCount() {
        return 0;
    }*/

    @Override
    public int getItemCount()
    {


        return regular.size();
    }
}
