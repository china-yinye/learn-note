package com.xk72.charles.gui.transaction.popups;

import javax.swing.text.JTextComponent;

public class CKDecodeTextComponent extends CKDecode{

    private final JTextComponent component;

    public CKDecodeTextComponent(JTextComponent component){
        super(component);
        this.component = component;
    }

    @Override
    protected String getBody() {
        String selectText = this.component.getSelectedText();
        return selectText == null ? this.component.getText() : selectText;
    }
}
