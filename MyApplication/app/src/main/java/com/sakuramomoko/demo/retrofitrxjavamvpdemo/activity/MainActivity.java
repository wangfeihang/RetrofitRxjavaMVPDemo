package com.sakuramomoko.demo.retrofitrxjavamvpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.sakuramomoko.demo.retrofitrxjavamvpdemo.R;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.entity.ThemeList;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.presenter.ThemeListPresenter;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.view.ThemesMvpView;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.util.FP;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ThemesMvpView {

    @BindView(R.id.tv_content)
    TextView tvContent;

    private ThemeListPresenter themeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        themeListPresenter = new ThemeListPresenter();
        themeListPresenter.attachView(this);
        themeListPresenter.getThemes();
    }

    @Override
    public void loadThemes(List<ThemeList.Theme> themes) {
        tvContent.setText(FP.size(themes) + "");
    }

    @Override
    public void showGetThemesFailedMsg(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        themeListPresenter.detachView();
        super.onDestroy();
    }
}
