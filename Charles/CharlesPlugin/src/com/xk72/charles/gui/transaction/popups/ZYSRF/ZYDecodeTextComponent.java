package com.xk72.charles.gui.transaction.popups.ZYSRF;

import javax.swing.text.JTextComponent;

public class ZYDecodeTextComponent extends ZYDecode{

    private final JTextComponent component;

    public ZYDecodeTextComponent(JTextComponent component){
        super(component);
        this.component = component;
    }

    @Override
    public String getBody(){
        String selectText = this.component.getSelectedText();
        return selectText == null ? this.component.getText() : selectText;
    }

}
