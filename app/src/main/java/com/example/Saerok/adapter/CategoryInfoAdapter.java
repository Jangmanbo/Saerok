package com.example.Saerok.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Saerok.R;
import com.example.Saerok.source.CategoryInfoItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CategoryInfoAdapter extends RecyclerView.Adapter<CategoryInfoAdapter.ViewHolder> {
    private ArrayList<CategoryInfoItem> infoItems=new ArrayList<>();
    String[] types={"단문형 텍스트", "장문형 텍스트", "체크박스", "별점", "사진"};
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.category_info, parent, false);
        return new CategoryInfoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setCategoryInfo(infoItems.get(position));
    }

    public void setInfoItems(ArrayList<CategoryInfoItem> infoItems) {
        this.infoItems=infoItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return infoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private EditText editText;
        private Spinner spinner;
        private ImageButton imageButton;
        public ViewHolder(View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
            editText=itemView.findViewById(R.id.itemEditText);
            spinner=itemView.findViewById(R.id.typeSpinner);
            imageButton=itemView.findViewById(R.id.imageButton);
        }

        public void setCategoryInfo(CategoryInfoItem item) {
            textView.setText(Integer.toString(item.getNum()));
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_spinner_item, types);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }
}
