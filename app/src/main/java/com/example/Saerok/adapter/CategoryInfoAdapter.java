package com.example.Saerok.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Saerok.R;

public class CategoryInfoAdapter extends RecyclerView.Adapter<CategoryInfoAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.category_info, parent, false);
        return new CategoryInfoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }
}
