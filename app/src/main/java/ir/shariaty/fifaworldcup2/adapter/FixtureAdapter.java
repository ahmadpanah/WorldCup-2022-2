package ir.shariaty.fifaworldcup2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.shariaty.fifaworldcup2.R;
import ir.shariaty.fifaworldcup2.models.FixtureData;

public class FixtureAdapter extends RecyclerView.Adapter<FixtureViewHolder> {

    Context context;
    List<FixtureData> list;

    public FixtureAdapter(Context context, List<FixtureData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FixtureViewHolder(LayoutInflater.from(context).inflate(R.layout.list_fixture , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureViewHolder holder, int position) {

        final FixtureData data = list.get(position);

        Picasso.get().load(data.home_flag).into(holder.imageView_home);
        Picasso.get().load(data.away_flag).into(holder.imageView_away);

        holder.textView_home.setText(data.home_team_fa);
        holder.textView_away.setText(data.away_team_fa);

        holder.textView_match.setText(data.type + " مرحله ") ;

        holder.textView_time.setText(data.persian_date) ;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class FixtureViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView_home , imageView_away;
    TextView textView_home, textView_away, textView_time , textView_match;

    public FixtureViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView_home = itemView.findViewById(R.id.imageView_home);
        imageView_away = itemView.findViewById(R.id.imageView_away);
        textView_home = itemView.findViewById(R.id.textView_home);
        textView_away = itemView.findViewById(R.id.textView_away);
        textView_time = itemView.findViewById(R.id.textView_time);
        textView_match = itemView.findViewById(R.id.textView_match);
    }
}
