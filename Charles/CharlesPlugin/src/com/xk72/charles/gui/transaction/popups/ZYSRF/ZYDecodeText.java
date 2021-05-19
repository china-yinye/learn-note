package com.xk72.charles.gui.transaction.popups.ZYSRF;

import java.awt.*;

public class ZYDecodeText extends ZYDecode{

    public final String text;

    public ZYDecodeText(String str) {
        super((Component)null);
        this.text = str;
    }

    public ZYDecodeText(String str,Component component){
        super(component);
        this.text = str;
    }

    @Override
    protected String getBody() {
        return this.text;
    }
}
