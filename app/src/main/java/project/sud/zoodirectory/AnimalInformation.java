package project.sud.zoodirectory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AnimalInformation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_information);

        Bundle bundle=getIntent().getExtras();
        String s= bundle.getString("animal");

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(s);
        TextView description = (TextView) findViewById(R.id.desc);


        ImageView picture = (ImageView) findViewById(R.id.picture);

        if (s.equals("Tiger"))

        {
            picture.setImageResource(R.drawable.img1);
            description.setText("Recognizing a tiger at the zoo is easy. But in their natural habitat, tigers are really hard to find. That’s because their unique orange, black and white stripe pattern helps them blend into the forests and grassy areas where they live and hunt");
        }

        if (s.equals("Lion"))

        {
            picture.setImageResource(R.drawable.img2);
            description.setText("Lions have some behaviors that are like those of your cat at home. They are very good climbers and are often seen up in trees checking the area for prey. Lions sleep up to 21 hours a day, and researchers have seen them sleeping in some unusual positions—including on their backs with their paws in the air!");
        }

        if (s.equals("Crocodile"))

        {
            picture.setImageResource(R.drawable.img3);
            description.setText("This crocodile gets its name from its long, slender snout. The length and lightness make it a great tool for catching fish in a “snap.” The narrow nose can also act like a pair of tweezers, allowing the crocodile to pluck prey out of small holes and cracks.");

        }

        if (s.equals("Monkey"))

        {
            picture.setImageResource(R.drawable.img4);
            description.setText("Monkeys are very vocal animals and that is their name way of communicating with each other. They give of different pitches to warm off danger, to call a mate, and even to communicate with their young. Even though the communication of Monkeys has long been studied, there is a great deal that we still don’t know about it.");
        }
        if (s.equals("Peacock"))

        {
            picture.setImageResource(R.drawable.img5);
            description.setText("Most people call them peacocks, but that's only the correct name for male of this type of bird. Females are called peahens, and the whole group are peafowl. There are three types of peafowl in the world: Indian, green, and Congo. ");
        }
        if (s.equals("Penguins"))

        {
            picture.setImageResource(R.drawable.img6);
            description.setText("Penguins are birds with black and white feathers and a funny waddle.  But unlike most birds, penguins are not able to fly -- in the air that is.  Penguins spend as much as 75% of their time underwater, searching for food in the ocean.  When they are in the water, they dive and flap their wings.  It looks just like they are flying!");
        }
        if (s.equals("Fox"))

        {
            picture.setImageResource(R.drawable.img7);
            description.setText("The fox is the smallest member of the dog family, although it also has many similarities with cats - such as vertical slit eyes and retractable claws. They also hunt like a cat, stalking their prey and playing with it before killing it. Keep reading to find more interesting facts about foxes.");
        }
        if (s.equals("Cobra"))

        {
            picture.setImageResource(R.drawable.img8);
            description.setText("The king cobra is the largest venomous snake in the world. It has special muscles and ribs in its neck that spread out to form a hood when the cobra feels threatened. This makes the snake look bigger than it really is, and may help scare away predators.");
        }


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
                final Intent intent = new Intent(AnimalInformation.this, ZooInformation.class);
                startActivity(intent);

               // Toast.makeText(getBaseContext(), "Zoo Information", Toast.LENGTH_SHORT).show();
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
