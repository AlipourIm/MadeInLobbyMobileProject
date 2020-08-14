package com.example.myfirstandroiddevelopingexperience;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder>{

    private ArrayList<Email> data;
    private LayoutInflater inflater;
    private Context context;

    public EmailAdapter(Context context, ArrayList<Email> data){
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    private class ImageLoadedCallback implements Callback {
        ProgressBar progressBar;

        public  ImageLoadedCallback(ProgressBar progBar){
            progressBar = progBar;
        }

        @Override
        public void onSuccess() {

        }

        @Override
        public void onError() {

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView senderTextView;
        TextView subjectTextView;
        ImageView imageView;
        ProgressBar progressBar = null;

        ViewHolder(View itemView){
            super(itemView);
            senderTextView = itemView.findViewById(R.id.senderInRow);
            subjectTextView = itemView.findViewById(R.id.subjectInRow);
            imageView = itemView.findViewById(R.id.imageView);
            if (itemView != null) {
                progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    @NonNull
    @Override
    public EmailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.email_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmailAdapter.ViewHolder holder, int position) {
        Email email = data.get(position);
        holder.senderTextView.setText(email.getSender());
        holder.subjectTextView.setText(email.getSubject());
        Picasso.with(context)
                .load(email.getImageURL())
                .resize( 400, 300)
                .into(holder.imageView, new ImageLoadedCallback(holder.progressBar) {
                    @Override
                    public void onSuccess() {
                        if (this.progressBar != null) {
                            this.progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
