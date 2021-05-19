package com.xk72.charles.gui.transaction.popups;

import java.awt.*;

public class CKDecodeText extends CKDecode{

    private final String text;

    public CKDecodeText(String str){
        super((Component)null);
        this.text = str;
    }

    public CKDecodeText(String str,Component component){
        super(component);
        this.text = str;
    }

    @Override
    protected String getBody() {
        return this.text;
    }
}
