package com.example.soccerapp.Adaper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerapp.Methods.TeamsModel;
import com.example.soccerapp.Db.DatabaseHelper;
import com.example.soccerapp.R;
import com.example.soccerapp.Teams.Arsenal;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    List<TeamsModel> players;
    Context context;
    DatabaseHelper databaseHelper;

    public TeamsAdapter(List<TeamsModel> players, Context context) {
        this.players = players;
        this.context = context;
        databaseHelper = new DatabaseHelper( context );
    }

    //where its displayed


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        View view = layoutInflater.inflate( R.layout.player_item_list, parent, false );
        ViewHolder viewHolder = new ViewHolder( view );
        return viewHolder;
    }

    //Gets And Sets
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final TeamsModel teamsModel = players.get( position );

        holder.textViewID.setText( Integer.toString( teamsModel.getID() ) );
        holder.editText_name.setText( teamsModel.getName() );
        holder.editText_position.setText( teamsModel.getPosition() );
        holder.editText_age.setText( teamsModel.getAge() );


        holder.button_Edit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_name.getText().toString();
                String stringPosition = holder.editText_position.getText().toString();
                String stringAge = holder.editText_age.getText().toString();

                // updates ChelseaDetails/
                databaseHelper.updateCHELSEA( new TeamsModel( teamsModel.getID(), stringName, stringPosition, stringAge ) );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Updated successfully!", Toast.LENGTH_SHORT ).show();

                //Updates LiverpoolDetails

                databaseHelper.updateLIVERPOOL( new TeamsModel( teamsModel.getID(), stringName, stringPosition, stringAge ) );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Updated successfully!", Toast.LENGTH_SHORT ).show();

                //Updates LeicesterDetails

                databaseHelper.updateLEICESTER( new TeamsModel( teamsModel.getID(), stringName, stringPosition, stringAge ) );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Updated successfully!", Toast.LENGTH_SHORT ).show();

                //Updates ManUDetails

                databaseHelper.updateMANUNITED( new TeamsModel( teamsModel.getID(), stringName, stringPosition, stringAge ) );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Updated successfully!", Toast.LENGTH_SHORT ).show();

                //Updates ManCDetails

                databaseHelper.updateMANCITY(new TeamsModel( teamsModel.getID(), stringName, stringPosition, stringAge ) );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Updated successfully!", Toast.LENGTH_SHORT ).show();


                //Updates SpursDetails

                databaseHelper.updateSPURS( new TeamsModel( teamsModel.getID(), stringName, stringPosition, stringAge ) );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Updated successfully!", Toast.LENGTH_SHORT ).show();

                //Updates ArsenalDetails

                databaseHelper.updateARSENAL( new TeamsModel( teamsModel.getID(), stringName, stringPosition, stringAge ) );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Updated successfully!", Toast.LENGTH_SHORT ).show();


            }
        } );

        holder.button_delete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder( v.getContext() );
                alert.setTitle( "Delete Information" );
                alert.setMessage( "Are you sure want to Delete?! " );
                alert.setIcon( R.drawable.delete_icon_android_9);
                alert.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        databaseHelper.deleteARSENAL( teamsModel.getID() );
                        players.remove( position );
                        notifyDataSetChanged();
                        ((Activity) context).finish();
                        Toast.makeText( v.getContext(), "Deleted successfully!", Toast.LENGTH_SHORT ).show();



                databaseHelper.deleteCHELSEA( teamsModel.getID() );
                players.remove( position );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), " Deleted successfully!", Toast.LENGTH_SHORT ).show();


                databaseHelper.deleteLIVERPOOL( teamsModel.getID() );
                players.remove( position );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Deleted successfully!", Toast.LENGTH_SHORT ).show();

                databaseHelper.deleteLEICESTER( teamsModel.getID() );
                players.remove( position );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Deleted successfully!", Toast.LENGTH_SHORT ).show();


                databaseHelper.deleteMANU( teamsModel.getID() );
                players.remove( position );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Deleted successfully!", Toast.LENGTH_SHORT ).show();


                databaseHelper.deleteMANCITY( teamsModel.getID() );
                players.remove( position );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Deleted successfully!", Toast.LENGTH_SHORT ).show();


                databaseHelper.deleteSPURS( teamsModel.getID() );
                players.remove( position );
                notifyDataSetChanged();
                ((Activity) context).finish();
                Toast.makeText( v.getContext(), "Deleted successfully!", Toast.LENGTH_SHORT ).show();


                    }
                } );

                alert.setNegativeButton( "No",null );

                alert.show();
            }
        } );
    }

    //To Display Data All on RecyclerView
    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewID;
        EditText editText_name;
        EditText editText_position;
        EditText editText_age;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            textViewID = itemView.findViewById( R.id.text_id );
            editText_name = itemView.findViewById( R.id.edittext_name );
            editText_position = itemView.findViewById( R.id.edittext_position );
            editText_age = itemView.findViewById( R.id.editText_age );
            button_delete = itemView.findViewById( R.id.button_delete );
            button_Edit = itemView.findViewById( R.id.button_edit );

        }
    }
}


