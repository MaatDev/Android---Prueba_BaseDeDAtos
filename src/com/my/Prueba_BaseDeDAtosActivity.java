package com.my;

import java.util.ArrayList;

import com.my.classDTO.CevicheDTO;
import com.my.classDTO.ImagenSecDTO;
import com.my.classDTO.IngredienteDTO;
import com.my.databases.SQLiteManager;
import com.my.databases.SQLiteManager2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Prueba_BaseDeDAtosActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SQLiteManager2 sm = new SQLiteManager2(this);
        
        Toast.makeText(this, "resultado: "+sm.existeTablas(), Toast.LENGTH_LONG).show();
        
        //Prueba
        CevicheDTO cev = new CevicheDTO();
        
        cev.setCod_plato(1);
        cev.setNombre("cevichito2");
        
        cev.getImg_prim().setCod_img_prim(1);
        cev.getImg_prim().getFuente().setCod_fuente(1);
        cev.getImg_prim().getFuente().setDesc_fuente("aca");
        cev.getImg_prim().setUrl_external_img("ho");
        cev.getImg_prim().setUrl_local_img("ho");
        
        ImagenSecDTO img2 = new ImagenSecDTO();
        img2.setCod_img_sec(1);
        img2.setCod_plato(1);
        img2.getFuente().setCod_fuente(1);
        img2.setUrl_external_img("ho");
        img2.setUrl_local_img("ho");
        cev.getImgs_sec().add(img2);
        
        IngredienteDTO ingre = new IngredienteDTO();
        ingre.setCod_ingrediente(1);
        ingre.setDesc_ingrediente("ho");
        ingre.setCantidad(1);
        ingre.setUnidad("ho");
        ingre.setCod_plato(1);
        cev.getIngredientes().add(ingre);
        
        cev.getRating().setCod_rating(1);
        cev.getRating().setNum_estrellas(1);
        cev.getRating().setDesc_comentario("ho");
        
        cev.getRegion().setCod_region(1);
        cev.getRegion().setDesc_region("ho");
        
        cev.getTip().setCot_tip(1);
        cev.getTip().setDesc_tip("ho");
        
        cev.getTipo().setCod_tipo(1);
        cev.getTipo().setDesc_tipo("ho");
        
        cev.getVideo().setCod_video(1);
        cev.getVideo().setCod_plato(1);
        cev.getVideo().getFuente().setCod_fuente(1);
        cev.getVideo().getFuente().setDesc_fuente("ho");
        cev.getVideo().setUrl_external_video("ho");
        cev.getVideo().setUrl_local_video("ho");
        
        
        ArrayList<CevicheDTO> ceviches = new ArrayList<CevicheDTO>();
        ceviches.add(cev);
        sm.insertarDatos(ceviches);
//        sm.eliminarDatos(ceviches);
//        sm.actualizarDatos(ceviches);
        
        Toast.makeText(this, "Terminado", Toast.LENGTH_LONG).show();
        
    }
}