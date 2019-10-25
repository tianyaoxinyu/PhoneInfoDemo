package com.hehoo.phone.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hehoo.phone.R;
import com.hehoo.phone.popup.AreaCodeListPop;
import com.hehoo.phone.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.register_back)
    TextView registerBack;
    @BindView(R.id.register_hint)
    TextView registerHint;
    @BindView(R.id.register_tab1)
    TextView registerTab1;
    @BindView(R.id.register_tab_line1)
    View registerTabLine1;
    @BindView(R.id.register_tab2)
    TextView registerTab2;
    @BindView(R.id.register_tab_line2)
    View registerTabLine2;
    @BindView(R.id.register_account)
    EditText registerAccount;
    @BindView(R.id.register_area_code)
    TextView registerAreaCode;
    @BindView(R.id.register_code)
    EditText registerCode;
    @BindView(R.id.register_get_code)
    TextView registerGetCode;
    @BindView(R.id.register_btn)
    TextView registerBtn;
    @BindView(R.id.register_google)
    ImageView registerGoogle;
    @BindView(R.id.register_facebook)
    ImageView registerFacebook;
    @BindView(R.id.register_line)
    ImageView registerLine;
    @BindView(R.id.register_twitter)
    Button registerTwitter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerTab1.setSelected(true);
    }

    @OnClick({R.id.register_tab1, R.id.register_tab2,R.id.register_area_code,R.id.register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_tab1:
                registerTab1.setSelected(true);
                registerTab2.setSelected(false);
                registerTabLine1.setVisibility(View.VISIBLE);
                registerTabLine2.setVisibility(View.GONE);
                registerAreaCode.setVisibility(View.VISIBLE);
                registerAccount.setPadding(DensityUtil.dp2px(57),0,0,0);
                registerCode.setPadding(DensityUtil.dp2px(57),0,0,0);
                registerAccount.setHint("输入手机号码");
                break;
            case R.id.register_tab2:
                registerTab1.setSelected(false);
                registerTab2.setSelected(true);
                registerTabLine1.setVisibility(View.GONE);
                registerTabLine2.setVisibility(View.VISIBLE);
                registerAreaCode.setVisibility(View.GONE);
                registerAccount.setPadding(DensityUtil.dp2px(19),0,0,0);
                registerCode.setPadding(DensityUtil.dp2px(19),0,0,0);
                registerAccount.setHint("输入邮箱");
                break;
            case R.id.register_area_code:
                AreaCodeListPop pop = new AreaCodeListPop(this);
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add("+" + (78 + i));
                }
                pop.setAreas(list);
                pop.setOffsetX(DensityUtil.dp2px(-5));
                pop.setOffsetY(DensityUtil.dp2px(-15));
                pop.setAreaClickListener(area -> {
                    registerAreaCode.setText(area);
                    pop.dismiss();
                });
                pop.showPopupWindow(view);
                break;
            case R.id.register_btn:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
