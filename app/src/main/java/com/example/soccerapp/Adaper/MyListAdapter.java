
        package com.example.soccerapp.Adaper;

        //  import android.support.v7.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.recyclerview.widget.RecyclerView;

        import com.example.soccerapp.Activities.TeamsActivity;
        import com.example.soccerapp.R;
        import com.example.soccerapp.Teams.Arsenal;
        import com.example.soccerapp.Teams.Chelsea;
        import com.example.soccerapp.Teams.ManchesterCity;
        import com.example.soccerapp.Teams.ManchesterUnited;

        public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
            private MyListData[] listdata;

            // RecyclerView recyclerView;
            public MyListAdapter(MyListData[] listdata) {
                this.listdata = listdata;
            }
            @Override
            //contains image and Text view..
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                View listItem= layoutInflater.inflate( R.layout.list_item, parent, false);
                ViewHolder viewHolder = new ViewHolder(listItem);
                return viewHolder;
            }

            @Override
            //description of the position of items on the List..with functions of onClick item.!
            public void onBindViewHolder(ViewHolder holder, int position) {
                final MyListData myListData = listdata[position];
                holder.textView.setText(listdata[position].getDescription());
                holder.imageView.setImageResource(listdata[position].getImgId());
                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //move data to next Activity
                        // bundle stores data to be retrived in the next Activity using Intent
                        Bundle bundle = new Bundle();
                        bundle.putString("TeamName",myListData.getDescription());
                        bundle.putInt("imageName",myListData.getImgId());
                        Intent intent = new Intent(view.getContext(), TeamsActivity.class);

                        if(myListData.getDescription().contains("Arsenal")){
                            intent = new Intent(view.getContext(), Arsenal.class);
                        }
                        if(myListData.getDescription().contains("ManchesterUnited")){
                            intent = new Intent(view.getContext(), ManchesterUnited.class);

                        }
                        if(myListData.getDescription().contains("Chelsea")){
                            intent = new Intent(view.getContext(), Chelsea.class);

                        }

                        intent.putExtras(bundle);
                        view.getContext().startActivity(intent);
                        Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
                    }
                });
            }


            @Override
            public int getItemCount() {
                return listdata.length;
            }

            public static class ViewHolder extends RecyclerView.ViewHolder {
                public ImageView imageView;
                public TextView textView;
                public RelativeLayout relativeLayout;
                public ViewHolder(View itemView) {
                    super(itemView);
                    this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
                    this.textView = (TextView) itemView.findViewById(R.id.textView);
                    relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
                }


            }
        }
