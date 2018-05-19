package com.example.neikila.testsettings2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.neikila.testsettings2.freetype.FreeTypeObjectFragment;
import com.example.neikila.testsettings2.generated.DtoNode;

public class MainActivity extends AppCompatActivity {

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FreeTypeObjectFragment<DtoConfig> fragment = new FreeTypeObjectFragment<>(new DtoNode(), new DtoConfig());
        fragment.setOnModelChangeListener(new ModelFragment.OnChangeListener() {
            @Override
            public void onChange(Object val) {
                DtoConfig config = (DtoConfig)val;
                Log.d("Test", config.toString());
            }
        });
        setFragment(fragment);
    }
}
