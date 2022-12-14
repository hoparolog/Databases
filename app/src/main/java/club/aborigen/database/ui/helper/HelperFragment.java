package club.aborigen.database.ui.helper;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.List;

import club.aborigen.database.databinding.FragmentHelperBinding;


public class HelperFragment extends Fragment {
    private DatabaseConnector dbConnector;

    private FragmentHelperBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHelperBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHelper;

        dbConnector = new DatabaseConnector(getContext());

        dbConnector.insert("Felix Karapetyan", 345000);
        dbConnector.insert("Ruben Danielyan", 645000);

        List<Employee> employees = dbConnector.selectAll();
        employees.forEach(employee -> {
            Log.i("UWC", "Helper Employee: " + employee.getName());
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}