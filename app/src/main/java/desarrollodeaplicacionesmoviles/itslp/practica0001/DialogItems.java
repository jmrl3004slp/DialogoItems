package desarrollodeaplicacionesmoviles.itslp.practica0001;

import android.app.Activity;
import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class DialogItems extends Activity {

    //Declaraciones
    TextView tv;
    CharSequence items [] = {"Item 0", "Item 1", "Item 2", "Item 3", "Item 4"};
    boolean marcados[]= new boolean[items.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_items);

        //Apuntar a Objetos gráficos
        tv = findViewById(R.id.txtDialogoItems);
        Button button =findViewById(R.id.button);

        //Escuchador del boton
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view){
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(DialogItems.this);
                builder = builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Este es un diálogo con Items")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                if(i == DialogInterface.BUTTON_POSITIVE){
                                    tv.setText("Ha marcado los items: ");
                                    for (int j=0; j< marcados.length;j=j+1) {
                                        if (marcados[j]){
                                            tv.append("\n"+items[j]);
                                        }//if
                                    }//for
                                }//if
                            }//onClick
                        })//.setPositiveButton
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tv.setText("Ha Cancelado la selección");

                            }//onClick
                        })//.setNegativeButton
                        //Contenido del Cuadro de dialogo
                        .setMultiChoiceItems(items, marcados, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if(isChecked){
                                    marcados[which]=isChecked;
                                }//if
                                else {
                                    marcados[which]=false;
                                }//else

                                //CREAR MENSAJE
                                tv.setText("Ha pulsado el Item: "+items[which]);
                                Toast.makeText(DialogItems.this, "Ha elegido la opción: "+items[which],Toast.LENGTH_SHORT).show();
                            }//onClick
                        })//.setMultiChoice
                ;
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }//onClick
        });

    } // OnCreate
}//DialogItems

