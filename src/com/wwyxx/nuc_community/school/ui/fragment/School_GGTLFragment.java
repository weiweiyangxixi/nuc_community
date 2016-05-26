package com.wwyxx.nuc_community.school.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;

import com.wwyxx.nuc_community.ggtl.GGTLBean;
import com.wwyxx.nuc_community.main.activity.R;

public class School_GGTLFragment extends Fragment implements OnClickListener{
	private View parentView;
	private Button buttonGGTLSubmit = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_templat_all_ggtl, container,
				false);
		return parentView;
	}

	private void init() {
		// TODO Auto-generated method stub
		buttonGGTLSubmit = (Button) this.getActivity().findViewById(R.id.button_ggtl_submit);
		buttonGGTLSubmit.setOnClickListener(this);
	}
	@Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        init();
    }  

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_ggtl_submit:
			popGGTLSubmitDia();
			break;

		default:
			break;
		}
	}
	
	 /*自定义对话框*/  
    private void popGGTLSubmitDia()  
    {  
        AlertDialog.Builder ggtlSubmitDia=new AlertDialog.Builder(getActivity());  
        final View viewDia=LayoutInflater.from(getActivity()).inflate(R.layout.ggtl_dialog, null);  
        ggtlSubmitDia.setTitle("自定义对话框");  
        ggtlSubmitDia.setView(viewDia);  
        ggtlSubmitDia.setPositiveButton("确定", new DialogInterface.OnClickListener() {  
              
            @Override  
            public void onClick(DialogInterface dialog, int which) {  
                // TODO Auto-generated method stub  
                EditText diaInput=(EditText) viewDia.findViewById(R.id.editText_ggtl_input);  
                submitGGTL(diaInput.getText().toString());
            }

        });  
        ggtlSubmitDia.create().show();  
    }

	protected void submitGGTL(String string) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), string, 3);
		GGTLBean ggtl = new GGTLBean();
		ggtl.setContent(string);
		ggtl.setPnode(null);
		ggtl.save(getActivity(), new SaveListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "success", 3).show();
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "faild"+arg0+arg1, 3).show();
			}
		});
	}  
}
