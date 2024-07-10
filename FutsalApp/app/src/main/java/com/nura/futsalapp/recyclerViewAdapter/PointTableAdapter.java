package com.nura.futsalapp.recyclerViewAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.PointTableRecyclerViewBinding;
import com.nura.futsalapp.model.PointsTable;

import java.util.ArrayList;

public class PointTableAdapter  extends RecyclerView.Adapter<PointTableAdapter.ViewHolder> {
    private static final String TAG = "PastFixturesAdapter";
    private ArrayList<PointsTable> pointsTableArrayList;

    private PointTableRecyclerViewBinding pointTableBinding;
    public PointTableAdapter(ArrayList<PointsTable> pointsTableArrayList) {
        this.pointsTableArrayList = pointsTableArrayList;
    }

    @NonNull
    @Override
    public PointTableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.point_table_data , parent , false);
        pointTableBinding = PointTableRecyclerViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       try {
           PointsTable captain = pointsTableArrayList.get(position);
           holder.captainName.setText(captain.getCaptainName());
           holder.win.setText(captain.getWin());
           holder.draw.setText(captain.getDraw());
           holder.lose.setText(captain.getLose());
           holder.points.setText(captain.getPoints());
           holder.logo.setImageResource(captain.getLogoId());
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

//    @Override
//    public void onBindViewHolder(@NonNull PastFixturesAdapter.ViewHolder holder, int position) {
//        try {
//            Fixture fixture = fixtureArrayList.get(position);
//            Log.d(TAG, "onBindViewHolder: " + fixture.toString());
//            holder.teamOneName.setText(fixture.getPlayerOne().getNickName());
//            holder.teamTwoName.setText(fixture.getPlayerTwo().getNickName());
//            holder.score.setText(fixture.getScore());
//            holder.teamOneLogo.setImageResource(fixture.getPlayerOne().getTeamLogoId());
//            holder.teamTwoLogo.setImageResource(fixture.getPlayerTwo().getTeamLogoId());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public int getItemCount() {
        return pointsTableArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView captainName , win ,lose ,draw ,points;
        private ImageView logo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             captainName = itemView.findViewById(R.id.captainName);
             logo = itemView.findViewById(R.id.pointsLogo);
             win = itemView.findViewById(R.id.win);
             draw = itemView.findViewById(R.id.draw);
             lose = itemView.findViewById(R.id.lose);
             points = itemView.findViewById(R.id.points);
        }
    }
}
