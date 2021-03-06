package aaron_tejero.mascotasrecyclerview.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aaron_tejero.mascotasrecyclerview.Mascota;
import aaron_tejero.mascotasrecyclerview.R;

/**
 * Created by AaronTejero on 15/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private List<Mascota> items;
    Activity activity;

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre;
        private TextView raiting;
        private ImageView foto;
        private ImageView hueso;
            public MascotaViewHolder(View v){
                super (v);
                foto=(ImageView) v.findViewById(R.id.imgFoto);
                nombre=(TextView) v.findViewById(R.id.tvNombrePerro);
                raiting=(TextView) v.findViewById(R.id.tvraiting);
                hueso=(ImageView) v.findViewById(R.id.imgHuesoblanco);
            }
        }

    public MascotaAdaptador(List<Mascota> items,Activity activity){
        this.items=items;
        this.activity=activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascotas,viewGroup,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder viewHolder,final int i) {
        viewHolder.foto.setImageResource(items.get(i).getFoto());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.raiting.setText(String.valueOf(items.get(i).getRaiting()));

        viewHolder.hueso.setTag(viewHolder);
        viewHolder.hueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MascotaViewHolder like = (MascotaViewHolder) v.getTag();
                like.raiting.setText(String.valueOf(1 + Integer.parseInt(like.raiting.getText().toString())));

            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
