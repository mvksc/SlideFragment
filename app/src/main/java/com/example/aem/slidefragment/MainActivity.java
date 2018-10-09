package com.example.aem.slidefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.aem.slidefragment.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    private static final String LIST_FRAGMENT_TAG = "list_fragment";
    private String TAG_FRAGEMENT_MAIN = "FRAGMENT_MAIN",TAG_FRAGEMENT_ONE = "FRAGMENT_ONE",TAG_FRAGEMENT_TWO = "FRAGMENT_TWO",TAG_FRAGEMENT_THREE = "FRAGMENT_THREE";
    private Button btnPrevious,btnNext;
    private int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = getSupportFragmentManager().findFragmentByTag(TAG_FRAGEMENT_MAIN);
                Toast.makeText(MainActivity.this,f + "",Toast.LENGTH_LONG).show();
                if (f == null) {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.slide_up,
                                    R.animator.slide_down,
                                    R.animator.slide_up,
                                    R.animator.slide_down)
                            .replace(R.id.list_fragment_container, MainFragment.newInstance(),TAG_FRAGEMENT_MAIN
                            ).addToBackStack(TAG_FRAGEMENT_MAIN).commit();
                }


/*                if (page == 3 || page == 0){
                    page = 1;
                }
                switch (page){
                    case 1:
                        page++;
                        Fragment f1 = getFragmentManager().findFragmentByTag(TAG_FRAGEMENT_ONE);
                        Toast.makeText(MainActivity.this,f1 + " : F1",Toast.LENGTH_LONG).show();
                        if (f1 == null) {
                            getSupportFragmentManager().beginTransaction()
                                    .setCustomAnimations(R.animator.slide_up,
                                            R.animator.slide_down,
                                            R.animator.slide_up,
                                            R.animator.slide_down)
                                    .replace(R.id.list_fragment_container, OneFragment.newInstance())
                                    .addToBackStack(TAG_FRAGEMENT_ONE).commit();
                        }
                        break;
                    case 2:
                        page++;
                        Fragment f2 = getFragmentManager().findFragmentByTag(TAG_FRAGEMENT_TWO);
                        Toast.makeText(MainActivity.this,f2 + " : F2",Toast.LENGTH_LONG).show();
                        if (f2 == null) {
                            getSupportFragmentManager().beginTransaction()
                                    .setCustomAnimations(R.animator.slide_up,
                                            R.animator.slide_down,
                                            R.animator.slide_up,
                                            R.animator.slide_down)
                                    .replace(R.id.list_fragment_container, TwoFragment.newInstance())
                                    .addToBackStack(TAG_FRAGEMENT_TWO).commit();
                        }
                        break;
                    case 3:
                        page++;
                        Fragment f3 = getFragmentManager().findFragmentByTag(TAG_FRAGEMENT_TWO);
                        Toast.makeText(MainActivity.this,f3 + " : F3",Toast.LENGTH_LONG).show();
                        if (f3 == null) {
                            getSupportFragmentManager().beginTransaction()
                                    .setCustomAnimations(R.animator.slide_up,
                                            R.animator.slide_down,
                                            R.animator.slide_up,
                                            R.animator.slide_down)
                                    .replace(R.id.list_fragment_container, ThreeFragment.newInstance())
                                    .addToBackStack(TAG_FRAGEMENT_TWO).commit();
                        }
                        break;
                }*/

            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = getSupportFragmentManager().findFragmentByTag(TAG_FRAGEMENT_MAIN);
                Toast.makeText(MainActivity.this,f + "",Toast.LENGTH_LONG).show();
                if (f != null && f.getTag().toString().trim().equals(TAG_FRAGEMENT_MAIN)) {
                    getSupportFragmentManager().popBackStack(TAG_FRAGEMENT_MAIN, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }

/*                switch (page){
                    case 1:
                        page--;
                        Fragment f1 = getFragmentManager().findFragmentByTag(TAG_FRAGEMENT_ONE);
                        Toast.makeText(MainActivity.this,f1 + " : F11",Toast.LENGTH_LONG).show();
                        if (f1 != null) {
                            getFragmentManager().popBackStack(TAG_FRAGEMENT_ONE, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        }
                        break;
                    case 2:
                        page--;
                        Fragment f2 = getFragmentManager().findFragmentByTag(TAG_FRAGEMENT_TWO);
                        Toast.makeText(MainActivity.this,f2 + " : F22",Toast.LENGTH_LONG).show();
                        if (f2 != null) {
                            getFragmentManager().popBackStack(TAG_FRAGEMENT_TWO, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        }
                        break;
                    case 3:
                        page--;
                        Fragment f3 = getFragmentManager().findFragmentByTag(TAG_FRAGEMENT_THREE);
                        Toast.makeText(MainActivity.this,f3 + " : F33",Toast.LENGTH_LONG).show();
                        if (f3 != null) {
                            getFragmentManager().popBackStack(TAG_FRAGEMENT_THREE, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        }
                        break;
                }

                if (page == 3 || page == 0){
                    page = 1;
                }*/
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_show_list) {
            toggleList();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleList() {
        Fragment f = getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT_TAG);
        Toast.makeText(MainActivity.this,f + "",Toast.LENGTH_LONG).show();
        if (f != null) {
            getSupportFragmentManager().popBackStack(LIST_FRAGMENT_TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .replace(R.id.list_fragment_container, SlidingListFragment
                                    .instantiate(this, SlidingListFragment.class.getName()),
                            LIST_FRAGMENT_TAG
                    ).addToBackStack(LIST_FRAGMENT_TAG).commit();
        }
    }
}

