package project.sud.zoodirectory;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity{

    ListView list;
    String[] itemname ={
            "Tiger",
            "Lion",
            "Crocodile",
            "Monkey",
            "Peacock",
            "Penguins",
            "Fox",
            "Cobra"
    };

    Integer[] imgid={
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
               // String Selecteditem= itemname[+position];
               // Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();

                TextView textView = (TextView) view.findViewById(R.id.item);
                final Intent intent = new Intent(MainActivity.this, AnimalInformation.class);
                String t=textView.getText().toString();
                intent.putExtra("animal", t);

                if(t.equals("Cobra")) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    // set title
                    alertDialogBuilder.setTitle("Warning");

                    // set dialog message'
                    alertDialogBuilder
                            .setMessage("The selected animal is very SCARY ! Do you want to proceed?? ")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog,int id){
                                    startActivity(intent);
                                }

                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int id){
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }

                            });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                }
                else {
                    startActivity(intent);
                }



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem items) {

        super.onOptionsItemSelected(items);

        switch(items.getItemId()){
            case R.id.zoo_info:
                final Intent intent = new Intent(MainActivity.this, ZooInformation.class);
                startActivity(intent);

                Toast.makeText(getBaseContext(), "Zoo Information", Toast.LENGTH_SHORT).show();
                break;

            case R.id.uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                uninstall.setData(Uri.parse("package:" + "project.sud.zoodirectory"));
                startActivity(uninstall);

                break;


        }
        return true;

    }

}