package com.sysoiev.crud;

import com.sysoiev.crud.view.CommonView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        CommonView.getInstance().run();
    }
}
