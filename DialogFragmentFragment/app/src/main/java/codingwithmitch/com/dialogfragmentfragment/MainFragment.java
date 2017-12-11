package codingwithmitch.com.dialogfragmentfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by User on 12/10/2017.
 */

public class MainFragment extends Fragment implements MyCustomDialog.OnInputSelected{


    private static final String TAG = "MainFragment";

    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: found incoming input: " + input);

        mInputDisplay.setText(input);
    }

    private Button mOpenDialog;
    public TextView mInputDisplay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mOpenDialog = view.findViewById(R.id.open_dialog);
        mInputDisplay = view.findViewById(R.id.input_display);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog");

                MyCustomDialog dialog = new MyCustomDialog();
                dialog.setTargetFragment(MainFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");
            }
        });


        return view;
    }


}














